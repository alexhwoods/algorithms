fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    return Array(a.size) { i -> a.get((i + d) % a.size) }
}
