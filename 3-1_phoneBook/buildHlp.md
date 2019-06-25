
***

# Build Help

javac -encoding UTF-8 PhoneBook.java

java -Xmx1024m PhoneBook

***

Implement a simple phone book manager.  Use the direct addressing scheme.

Constraints: 1 <= n <= 10^5
             Ea phone # <= 7  (10^7 digit )
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
6
add 123 bob
add 234 tim
find 123
del 123
add 234 tom
find 234

Output: 
bob 
tom

---

Case 4

Input: 
20
add 1 bob
add 222222 jim
add 9999999 rex
find 1
find 222222
del 1
del 1
find 9999999
find 1
find 2
add 11111 zork
add 555 sid
add 666 tim
find 11111
find 555
find 2
add 555 sue
find 666
find 555
find 222222


Output: 
bob
jim
rex
not found
not found
zork
sid
not found
tim
sue

Case 5

Input: 



</pre>

***


