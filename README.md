# JavaLocalBase
 Simple local base for java problems

https://www.hackerrank.com/challenges/sherlock-and-array/problem?h_r=next-challenge&h_v=zen

two pointers -> one at the beggining and one at the end

move the pointers unless there can not be element to which neither will go 
**eg. [2 2] , left pointer to 0 from -1. the right pointer can not move because there would not be at least the 1 as a gap**

move the left pointer
move the right pointer unless the sum on the right side is equal or bigger then left
then increase left again
last step should be to validate if by shifting the middle element it would not rebalance the -> not sure if that is needed
