package main

import (
	"encoding/json"
	"fmt"
	"strconv"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	return addTwoNumbersWithCarry(l1, l2, 0)
}

func addTwoNumbersWithCarry(l1 *ListNode, l2 *ListNode, carry int) *ListNode {
	fmt.Println("Entering...")
	fmt.Println("l1: " + toJSON(l1))
	fmt.Println("l2: " + toJSON(l2))
	fmt.Println("carry: " + strconv.Itoa(carry))

	if l1 == nil && l2 == nil {
		if carry == 0 {
			return nil
		}

		return &ListNode{Val: carry, Next: nil}
	}

	// wow I miss optional chaining
	var left int
	var right int

	if l1 != nil {
		left = l1.Val
	}

	if l2 != nil {
		right = l2.Val
	}

	sum := left + right + carry
	fmt.Println("sum: " + strconv.Itoa(sum))

	var x1 *ListNode
	var x2 *ListNode

	if l1 != nil {
		x1 = l1.Next
	}

	if l2 != nil {
		x2 = l2.Next
	}

	return &ListNode{Val: sum % 10, Next: addTwoNumbersWithCarry(x1, x2, sum/10)}
}

func listNodeToString(l1 *ListNode) string {
	if l1 == nil {
		return ""
	}

	var num int

	if l1 != nil {
		num = l1.Val
	}

	return strconv.Itoa(num) + listNodeToString(l1.Next)
}

func toJSON(l1 *ListNode) string {
	out, _ := json.Marshal(l1)

	return string(out)
}

func main() {
	x := ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3}}}
	y := ListNode{Val: 4, Next: &ListNode{Val: 8, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3}}}}

	// 496
	z := addTwoNumbers(&x, &y)

	fmt.Println(toJSON(z))
}
