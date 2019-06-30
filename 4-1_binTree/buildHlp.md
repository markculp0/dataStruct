
***

# Build Help

javac -encoding UTF-8 tree_orders.java

java -Xmx1024m tree_orders

***

Build and output a rooted binary tree with in-order, pre-order and post-order traversals.

**Constraints:** 

  *  1 <= n < 10^5
  *  0 <= key <= 10^9
  * -1 <= left or right <= n - 1

**Input:**  

  * Line 1: n = number of vertices
  * Line 2: n lines containing information 
          about the vertices from 0 to n-1.
          Formatted 3 per line as: 
            key value | left index | right index
            ( 0 index = root | -1 index = no child )

**Output:**

  * Line 1: Keys from an in-order traversal
  * Line 2: Keys from an pre-order traversal
  * Line 3: Keys from an post-order traversal

***

<pre>

Case 1

Input:
5
4 1 2
2 3 4
5 -1 -1
1 -1 -1
3 -1 -1

   4
   |
  --- 
 |   |
 2   5
 |
---
| |
1 3


Output:
1 2 3 4 5
4 2 1 3 5
1 3 2 5 4

---

Case 2

Input:  
10
0 7 2       | 0
10 -1 -1    | 1
20 -1 6     | 2
30 8 9      | 3
40 3 -1     | 4
50 -1 -1    | 5
60 1 -1     | 6
70 5 4      | 7
80 -1 -1    | 8
90 -1 -1    | 9

           0
           |
      -----------
      |          |
     70          20
     |           |
   -----       -----
  |     |      |   |
 50     40     x   60
        |          |
      ----       -----
     |    |      |   |
    30    x     10   x
     |
    ---
   |   |  
  80   90

Output:
50 70 80 30 90 40 0 20 10 60
0 70 50 40 30 80 90 20 60 10
50 80 90 30 40 70 10 60 20 0

---

Case 3

Input: 


Output: 


---

Case 4

Input: 


Output: 


Case 5

Input: 



</pre>

***


