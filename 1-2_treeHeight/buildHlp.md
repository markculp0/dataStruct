
***

# Build Help

javac -encoding UTF-8 tree_height.java

java -Xmx1024m tree_height

***

Compute and output the height of a rooted tree; not necessarily a binary tree.

Constraints: 1 ??? n ??? 10^5

Input:  
  Line 1: Number of nodes
  Line 2: Integer numbers from ???1 to (n - 1), parents of nodes.

Output: Height of the tree.

***

<pre>

Case 1

Input: 
5
4 -1 4 1 1

( 4 -1 4 1 1 
  0  1 2 3 4 )

 -1-
|   |
3  -4-
  |   |
  0   2
  
Output: 3

---

Case 2

Input:  
5
-1 0 4 0 3

( -1 0 4 0 3
   0 1 2 3 4 )

-0-
| |
1 3
  |
  4
  |
  2

Output: 4

---
Case 3

Input: 

Output:

</pre>

***


