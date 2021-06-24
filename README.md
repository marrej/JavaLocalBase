# JavaLocalBase
 Simple local base for java problems

https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3790/

- do a depth first search with maximum of maxMove steps
    - we will need to pass in the current count of the steps
    - if we get to the edge and go out, return a 1, otherwise return a 0
    - at every point where we add things together we should do the modulo 1000000009 -> the original - modulo, return to be added + restOfModulo