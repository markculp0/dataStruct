
***

# Build Help

javac -encoding UTF-8 HashChains.java

java -Xmx1024m HashChains

***

Implement a polynomial hash table with lists chaining.

Constraints: 1 <= N <= 10^5
              N/5 <= m <= N
              Strings w at most 15 chars

Input:  
  Line 1: m = number of buckets
  Line 2: N = number of queries on following lines
  Line 3: N queries, 1 per line

Output: The result of each Find and Check query. (1 result per line in order of queries). Blank line when check called on empty chain.

***

<pre>

Case 1

Input:
5
12
add world
add HellO
check 4
find World
find world
del world
check 4
del HellO
add luck
add GooD
check 2
del good

Output:
HellO world
no
yes
HellO
GooD luck

---

Case 2

Input:  
4
8
add test
add test
find test
del test
find test
find Test
add Test
find Test

Output: 
yes
no
no
yes

---

Case 3

Input: 
3
12
check 0
find help
add help
add del
add add
find add
find del
del del
find del
check 0
check 1
check 2

Output: 

no
yes
yes
no

add help

---

Case 4

Input: 


Output: 


Case 5

Input: 



</pre>

***


