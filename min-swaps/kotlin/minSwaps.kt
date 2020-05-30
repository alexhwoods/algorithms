import kotlin.collections.*


fun minimumSwaps(arr: Array<Int>): Int {
    val visited = hashMapOf<Int, Boolean>()
    val graph = buildGraph(arr)

    var minNumSwaps = 0

    println(graph)

    arr.mapIndexed { index, _ ->
        val workingIndex = index + 1
        if (visited.get(workingIndex) != true) {
            minNumSwaps += visitAndCountCycle(graph, workingIndex, workingIndex, visited, 0)
        }
    }

    return minNumSwaps
}

fun buildGraph(arr: Array<Int>): HashMap<Int, Int> {
    val graph = HashMap<Int, Int>()
    arr.forEachIndexed { index, value -> graph.put(index + 1, value) }

    return graph
}

fun visitAndCountCycle(map: HashMap<Int, Int>, currentNode: Int?, start: Int, visited: HashMap<Int, Boolean>, runningLength: Int): Int {
    val nextNode = map.get(currentNode)
    visited.put(nextNode!!, true)

    if (nextNode == start) {
        return runningLength // the length of the cycle is runningLength + 1, but the num swaps needed is length of cycle - 1
    } else {
        return visitAndCountCycle(map, nextNode, start, visited, runningLength + 1)
    }
}


fun main() {
//    val arr = arrayOf(3, 7, 6, 9, 1, 8, 10, 4, 2, 5)
//    println(buildCycle(arr))
    println(minimumSwaps(arrayOf(3, 2, 1)))
    println(minimumSwaps(arrayOf(3, 7, 6, 9, 1, 8, 10, 4, 2, 5)))
    println(minimumSwaps(arrayOf(2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19)))
}
