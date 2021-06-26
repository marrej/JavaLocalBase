# JavaLocalBase
 Simple local base for java problems


- Count of Smaller Numbers After Self
    - 
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3792/

nums = [5,2,6,1]
counts = [2,1,1,0]

numbers can occur multiple time so can not use Set -> rather need a sorted set (best insert sort on a set)

[1,6,2,5] -> go throught the nums in reversed order and at each point
- find the position in the sorted list where the actual number will go
- the position we pushed the number in is the amount of predecesors
- insert the actual number in the list, continue
- adjust the position by checking the possible same number input  input : 1 sortedList: [1,1,1,1,1], the result still has to be 0;

insert sort -> logN

over all elements -> n

overall time **O(n\*m\* logN)** -> worst case O(n^2) -> in case of  input 1 array [1,1,1,1,1,1,1]

overall space **n - list, n - result**
