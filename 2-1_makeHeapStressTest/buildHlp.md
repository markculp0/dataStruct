
***

# Build Help

javac -encoding UTF-8 BuildHeapStressTest.java

java -Xmx1024m BuildHeapStressTest

***

Convert an array of integers into a heap using min-heap.

Constraints: 1 <= n <= 10^5, 0 <= i, j <= n-1, 0 <= a_0, a_1 ..a_n-1 <= 10^9.

Input:  
  Line 1: n integer
  Line 2: n space separated integers a_i

Output:
  Line 1: m integer, total # of swaps (0 <= m <= 4n)
  Line 2: m lines containing the swap operations i,j (0-based indices of elements to be swapped).    

***

<pre>

Case 1

Input: 
5
5 4 3 2 1
  
Output: 
3
1 4
0 1
1 3

(1:4 swap -> 5 1 3 2 4
 5:1 swap -> 1 5 3 2 4
 5:2 swap -> 1 2 3 5 4)

---

Case 2

Input:  
5
1 2 3 4 5

Output: 0

---

Case 3

Input: 
4
9 8 7 6

Output: 
3
1 3
0 1
1 3

---

Case 4

Input: 
3
3 2 1

Output: 
1
0 2

</pre>

***


