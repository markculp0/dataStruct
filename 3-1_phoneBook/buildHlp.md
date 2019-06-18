
***

# Build Help

javac -encoding UTF-8 PhoneBook.java

java -Xmx1024m PhoneBook


***

Implement a simple phone book manager.  Use the direct addressing scheme.

Constraints: 1 <= n <= 10^5
             Ea phone # <= 7 digits
             Ea name <= 15 chars (no spaces)

Input:  
  Line 1: n (# of queries) 
  Line 2: n queries ( 1 per line)

Output: The result of each find query.  Name corresponding to phone #, or "not found."  (1 result per line in order of queries)

***

<pre>

Case 1

Input: 
12
add 911 police
add 76213 Mom
add 17239 Bob
find 76213
find 910
find 911
del 910
del 911
find 911
find 76213
add 76213 daddy
find 76213
  
Output:
Mom
not found
police
not found
Mom
daddy

---

Case 2

Input:  
8
find 3839442
add 123456 me
add 0 granny
find 0
find 123456
del 0
del 0
find 0

Output: 
not found
granny
me
not found

---

Case 3

Input: 



Output: 


---

Case 4

Input: 


Output: 


</pre>

***


