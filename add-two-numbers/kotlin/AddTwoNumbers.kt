fun addTwoNodes(x: ListNode?, y: ListNode?, carry: Int): ListNode? {
    if (x == null && y == null && carry == 0) {
        return null
    }
    
    val sum = (x?.num ?: 0) + (y?.num ?: 0) + carry
    
    return ListNode(sum % 10, addTwoNodes(x?.next, y?.next, sum / 10))
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
    return addTwoNodes(l1, l2, 0)!!
}
