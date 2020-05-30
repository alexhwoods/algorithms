
import kotlin.collections.*

fun swap(arr: Array<Int>, x: Int, y: Int) {
    val pair = Pair(arr[x], arr[y])
    arr[x] = pair.second
    arr[y] = pair.first
}

fun minimumBribes(q: Array<Int>): Unit {
    var count = 0
    var invalid = false

    val arr = q.copyOf()

    for (i in arr.size downTo 1 step 1) {
        println("i: $i")
        val temp = arr[i - 1]
        println("arr[i - 1]: $temp")
        println("arr: ${arr.joinToString()}")
        if (i == arr[i - 1]) {
            println("no bribe occurred")
            // no bribe occurred, the right marker is
            // in the right place
        } else if (i > 1 && i == arr[i - 2]) {
            println("one bribe occurred")
            // one bribe occurred
            // undo it
            swap(arr, i - 1, i - 2)
            count++
        } else if (i > 2 && i == arr[i - 3]) {
            println("two bribes occurred")
            // two bribes occurred
            // undo them
            swap(arr, i - 2, i - 3)
            swap(arr, i - 1, i - 2)
            count += 2
        } else {
            // person originally in position i
            // committed more than 2 bribes
            invalid = true
        }
        
        println("\n")
    }

    if (invalid) println("Too chaotic")
    else println(count)
}

fun main() {
    minimumBribes(arrayOf(1, 2, 5, 3, 7, 8, 6, 4))
}


