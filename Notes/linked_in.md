## 17. Letter Combinations of a Phone Number

Each digit maps to letters. I use backtracking: starting from the first digit,   
I try every mapped letter, append it to the current string, recurse to the next digit,   
and when I reach the end, I add the built string to the result.   
If the input is empty, I return an empty list.
