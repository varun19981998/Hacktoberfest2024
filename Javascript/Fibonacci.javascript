const N = parseInt(prompt('Enter the number of terms: '));
let fn1 = 0, fn2 = 1, nextFibonacci;

console.log('Fibonacci Series upto N terms is:');

for (let i = 1; i <= N; i++) {
   console.log(fn1);
   nextFibonacci = fn1 + fn2;
   fn1 = fn2;
   fn2 = nextFibonacci;
}
