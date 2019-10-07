# Objectives

  * Write tests to accomplish MC/DC coverage
  * Implement a stateless PBT framework
  * Implement a stateful PBT framework
  * Generate by hand static type proof certificates for simple programs

# Reading

See the following in the [lecture notes](https://bitbucket.org/byucs329/byu-cs-329-lecture-notes/src/master/):

  * [whitebox.md](https://bitbucket.org/byucs329/byu-cs-329-lecture-notes/src/master/whitebox/white-box.md)
  * [Property based testing](https://bitbucket.org/byucs329/byu-cs-329-lecture-notes/src/master/property-based-testing/)
  * [type-checking](https://bitbucket.org/byucs329/byu-cs-329-lecture-notes/src/master/type-checking.md)

# Problems

## MC/DC Coverage

1) **(15 points)** Write a minimal number of testes to achieve MC/DC coverage for `edu.byu.cs329.mcdc.McDcTest.f`. Justify the final set of tests in the comments.

2) **(15 points)** Write a minimal number of tests to achieve MC/DC coverage for `edu.byu.cs329.mcdc.MergeSortMcDcTest.sort`. Justify the final set of tests in the comments.

## Stateless PBT

For each of the following classes, implement functions that generate input for test cases and write the properties that should be tested. Run the tests as **parameterized tests in JUnit 5**. **Report and fix** any errors you find. Consider any of the following for creating tests with random input:

  * Assert any ensures from the specification on the output (post-conditions holds)
  * Check for runtime exceptions (it did something unexpected)
  * Assert a point-wise equivalence to some *gold-standard* implementation (compare with a perfect oracle)
  * Check for algebraic properties (e.g. inverse, etc.)
   
Grading is based on the diversity of tests generated with the above techniques.

3) **(15 points)** [Binary search](https://en.wikipedia.org/wiki/Binary_search_algorithm): *O(ln n)* search for sorted array. The source is located in *homework-support/src/test/java/pbt/BinarySearchTest*. 

4) **(15 points)** [Merge sort](https://en.wikipedia.org/wiki/Merge_sort): *O(n ln n)* algorithm to sort an input array. The source is located in *homework-support/src/test/java/pbt/MergeSortTest*.

## Stateful PBT

5) **(20 points)** This problem is to test an implementation of a hash table which uses [separate chaining](https://en.wikipedia.org/wiki/Hash_table) with linked lists. As discussed in class, a point-wise comparison with an oracle is one possible way to test. Another approach is to compare two objects created with different but equivalent statements. In pseudo code it goes as follows assuming that `command1` and `command2` are different be equivalent statements:

```java
prefix = randomActions();
suffix = randomActions();

TestObject T1 = new TestObject();
TestObject T2 = new TestObject();

output1 = perform(T1, prefix) + perform(T1, command1) + perform(T1, suffix);
output2 = perform(T2, prefix) + perform(T2, command2) + perform(T2, suffix);

equals(T1, T2) && equals(output1, output2);
```

An example of equivalent, but different, statements is

```
put(Ka,Va), put(Kb,Vb) <==> put(Kb,Vb), put(Ka, Va) iff Ka != Kb
```

These statements are equivalent in that `(Ka,Va)` and `(Kb,Vb)` are in the hash table no matter which set of statements are run.

Remember that it is also possible to have an error in the implementation of the property rather than the class under test! 

## Type Checking

For each of the below, the proof certificate for each problem should be in the form of a tree in a file in the same directory as this *README*. Name each file by the problem number. Scanning a paper-pencil solution is fine (and preferred). Assume the existence of the environment that does the right thing. 

4) **(10 points)** Write by hand a type proof for `edu.byu.cs329.hashtable.LlHashTable.equals`.  

5) **(10 points)** Write by hand a type proof for `edu.byu.cs329.hastable.LlHashTable.remove`. 
