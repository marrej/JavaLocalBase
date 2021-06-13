# JavaLocalBase
 Simple local base for java problems

https://www.hackerrank.com/challenges/bigger-is-greater/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

Lexicographic order means that aaab < aaba . The sooner the bigger letter the higher the lexi number

What we had to do is to find the lowest switch we could do. so for example

**dkhc**

We needed to find the place where we could just do a lowest point switch
so here
**d < k**
there is no other option

then we needed to find in the rest of the string a letter that could be swapped with this one
**khc**

**d < k & d < h** and the last one wins
So we can do the switch

**hkdc**

but this would mean that we did not optimize for the lowest increase

8 11 4 3

but this could be optimized by soriting the rest of the characters after the starter

8 3 4 11

and this would be the lowest string

hcdk