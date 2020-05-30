function swap(arr, x, y) {
    const array = Array(...arr)
    const temp = array[x]
    array[x] = array[y]
    array[y] = temp

    return array
}

// Complete the minimumBribes function below.
function minimumBribes(q) {
    let count = 0
    let invalid = false

    let arr = Array(...q)

    for (let i = arr.length; i > 0; i--) {
        if (i == arr[i - 1]) {
            // no bribe occurred, the right marker is
            // in the right place
        } else if (i == arr[i - 2]) {
            // one bribe occurred
            // undo it
            arr = swap(arr, i - 1, i - 2)
            count++
        } else if (i == arr[i - 3]) {
            // two bribes occurred
            // undo them
            arr = swap(arr, i - 2, i - 3)
            arr = swap(arr, i - 1, i - 2)
            count += 2
        } else {
            // person originally in position i
            // committed more than 2 bribes
            invalid = true
        }
    }

    if (invalid) console.log("Too chaotic")
    else console.log(count)
}

minimumBribes([2, 1, 5, 3, 4])
