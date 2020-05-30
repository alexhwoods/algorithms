function* range(start, end) {
  for (let i = start; i <= end; i++) {
    yield i;
  }
}

// function rotLeft(a, d) {
//   let arr = [];
//   for (let i = 0; i < a.length; i++) {
//     arr[i] = a[(i + d) % a.length];
//   }
//   return arr;
// }

function rotLeft(a, d) {
  const arr = []
  for (i of range(0, a.length - 1)) {
    arr[i] = a[(i + d) % a.length];
  }

  return arr
}

rotLeft([1, 2, 3, 4, 5])

