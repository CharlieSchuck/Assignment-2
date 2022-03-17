# Tasks

- [x] User is prompted to input longs n, and k
  - [x] n is in the range (2, 12) (aka, [3, 11])
  - [x] the Upper Limit on k is calculated by the floor of the nth Root of (Long.MaxValue / 2), the Lower Limit is 10
- [x] The code will go over all (x, y) pairs in the range [10, k]
- [x] It then calculates 2 possible z values (floor & ceil of nth root of x^n + y^n), creating FermatMiss objects with arguments (x, y, z, n)
  - [x] the upper limit on z is the floor of the nth Root of Long.MaxValue, ceil could potentially go over, so check to be safe
- [x] All the while, it keeps track of a "Min" FermatMiss (objects can be compared with CompareTo), and when a new min is found, it is printed out (also has a ToString)
- [x] Finally, the program pauses at the end, awaiting user input before terminating
