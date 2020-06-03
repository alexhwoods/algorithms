package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(maxSubstring("abcabcbb"))
	fmt.Println(maxSubstring("bbbbb"))
	fmt.Println(maxSubstring("pwwkew"))
	fmt.Println(maxSubstring("abba"))
}

func maxSubstring(s string) int {
	m := make(map[string]int)
	max := 0
	lastRepeat := -1

	arr := strings.Split(s, "")

	// set the last occurrence of each char to -1
	for _, value := range arr {
		m[value] = -1
	}

	for index, value := range arr {
		lastOccurence := m[value]
		if lastOccurence != -1 {
			lastRepeat = Max(lastRepeat, lastOccurence)
		}

		max = Max(max, index-lastRepeat)
		m[value] = index
	}

	return max
}

// Max returns the max of two ints
func Max(x, y int) int {
	if x < y {
		return y
	}

	return x
}
