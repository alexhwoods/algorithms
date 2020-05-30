fun reverse(x: Int): Int {
    var int = x
    var sum = 0

    while (int != 0) {
        val digit = (int % 10)
        
        val newSum = 10*sum.toLong() + digit.toLong()
        check(newSum > Integer.MIN_VALUE && newSum < Integer.MAX_VALUE) {
            "Integer overflowed, input too large"
        }

        sum = newSum.toInt()
        int /= 10
    }

    return sum
}

fun main() {
  println("hello")
}