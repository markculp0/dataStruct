
***

# Build Help

javac -encoding UTF-8 is_bst.java

java -Xmx1024m is_bst

***

Test whether a given tree is a valid Binary Search Tree.

**Constraints:** 

  *  1 <= n < 10^5
  *  -2^31 <= key <= 2^31 - 1
  * -1 <= left or right <= n - 1

**Input:**  

  * Line 1: n = number of vertices
  * Line 2: n lines containing information 
          about the vertices from 0 to n-1.
          Formatted 3 per line as: 
            key value | left index | right index
            ( 0 index = root | -1 index = no child )

**Output:**

  * If is a BST:      CORRECT
  * If is not a BST:  INCORRECT

***

<pre>

Case 1

Input:
3
2 1 2
1 -1 -1
3 -1 -1

   2
   |
  --- 
 |   |
 1   3

Output: CORRECT

---

Case 2

Input: 
3
1 1 2
2 -1 -1
3 -1 -1

   1
   |
  --- 
 |   |
 2   3

Output:  INCORRECT

---

Case 3

Input: 0

Output: CORRECT

---

Case 4

Input: 
5
1 -1 1
2 -1 2
3 -1 3
4 -1 4
5 -1 -1

1
 \
  2
   \
    3
     \
      4
       \
        5

Output: CORRECT

---

Case 5

Input: 
7
4 1 2
2 3 4
6 5 6
1 -1 -1
3 -1 -1
5 -1 -1
7 -1 -1

   4
   |
  --- 
 |   |
 2   6
 |   |
--- ---
| | | |
1 3 5 7 

Output: CORRECT

</pre>

***


