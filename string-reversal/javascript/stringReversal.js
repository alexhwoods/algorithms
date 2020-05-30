const str = "alex"

const x = str
  .split('')
  .reduce((arr, c) => c.concat(arr), [])

console.log(x)