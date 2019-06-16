
***

# Build Help

javac -encoding UTF-8 MergingTables.java

java -Xmx1024m MergingTables


***

Simulate a sequence of merge operations with tables in a database.

Constraints: 1 <= n
             m <= 10^5
             0 <= r_i <= 10^4
             1 <= (dst_i, src_i) <= n

Input:  
  Line 1: n (# of tables in db) | m  (# of merge queries)
  Line 2: 0 .. r_i (# of rows in each table)
  Line 3: m lines containing dst & src tables to merge

Output: Max size of all tables after each merge operation.

***

<pre>

Case 1

Input: 
5 5
1 1 1 1 1
3 5
2 4
1 4
5 4
5 3
  
Output:
2
2
3
5
5

---

Case 2

Input:  
6 4
10 0 5 0 3 3
6 6
6 5
5 4
4 3

Output: 
10
10
10
11

---

Case 3

Input: 
4 3
1 1 1 1
2 1
3 2
1 4


Output: 
2
3
4


---

Case 4

Input: 


Output: 


</pre>

***


