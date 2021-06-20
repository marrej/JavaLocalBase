# JavaLocalBase
 Simple local base for java problems

https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen


- if sum of modulo-1 is found exit immediately and return

- go through the array creating intermediaate sum % modulo
- at every stage look if there are any prefixes alread created that would be bigger than the actual prefix (but the minimum of them eg. 8 input [9,10,11] would return 9)
- we try to find the minimal one, so if actual i and lowerbound j i - j = 1 => modulo - 1, this is the biggest subarray.
  - why? because it means that the sum of elements that were added in between the j and i must ammount to modulo - 1 so the highest possible value, because
  - eg. j: 7, i: 6, modulo 9, means that in order for the i to be 6, we had to add some x + modulo - 1 to get to this value.
    - the smaller the gap between the i and j, the closer we are to the maximum