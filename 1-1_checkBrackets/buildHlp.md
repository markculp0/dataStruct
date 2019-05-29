
***

# Build Help

javac -encoding UTF-8 check_brackets.java

java -Xmx1024m check_brackets

***

Constraints: 
    1 <= Length of S <= 105

Input:  
    One string S of big and small latin letters, digits, punctuation     marks and brackets from the set []{}().

Output: 
    if brackets match : Success
    if not : 1-based index of 1st unmatched opening bracket,
             or, if none, unmatched closing bracket.

***

<pre>

Case 1

Input: []

Output: Success

---

Case 2

Input:  {}[]

Output: Success

---

Case 3

Input: {

Output: 1

</pre>

***


