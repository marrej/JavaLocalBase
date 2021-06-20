# JavaLocalBase
 Simple local base for java problems

https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem?h_r=next-challenge&h_v=zen

- go n*m for each to go over the matrix and find every 1
- we need to traver serecursively the every found 1, count the amount of fields visited and after each visit clear the field
    - return the sum
    - if the sum is bigger then the existing max, replace it