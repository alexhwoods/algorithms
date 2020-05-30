package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	var nums []int

	for _, element := range os.Args[1:] {
		num, _ := strconv.Atoi(element)
		nums = append(nums, num)
	}

	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}

// naive, O(n^2)
func twoSumNaive(nums []int, target int) []int {

	for i := 0; i < len(nums); i++ {
		fmt.Println("nums[i]: " + strconv.Itoa(nums[i]))

		for j := i; j < len(nums); j++ {
			fmt.Println("j: " + strconv.Itoa(j))
			if nums[i]+nums[j] == target {
				return []int{i, j}
			}
		}
	}

	return []int{}
}

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)

	// in first pass, store m[target - nums[i]] = index
	for i := 0; i < len(nums); i++ {
		m[nums[i]] = i
	}

	// in second pass, get target - nums[i], and see
	// if that number exists in the map. If it does,
	// return an array with that number and the
	// current index
	for i := 0; i < len(nums); i++ {
		diff := target - nums[i]
		indexOfDiff := m[diff]
		numAtIndexOfDiff := nums[indexOfDiff]

		if nums[i]+numAtIndexOfDiff == target && i != indexOfDiff {
			return []int{i, m[diff]}
		}
	}

	return []int{}
}
