# Design and document for inheritance or else prohibit it

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

1. Class must document its self-use of overridable methods
   <pre class="prettyprint">
   public boolean remove(Object o)

      Removes a single instance of the specified element from this collection, if it
      is present (optional operation). More formally, removes an element e such
      that (o==null ? e==null : o.equals(e)), if the collection contains one or
      more such elements. Returns true if the collection contained the specified
      element (or equivalently, if the collection changed as a result of the call).

      This implementation iterates over the collection looking for the specified el-
      ement. If it finds the element, it removes the element from the collection us-
      ing the iterator’s remove method. Note that this implementation throws an
      UnsupportedOperationException if the iterator returned by this collec-
      tion’s iterator method does not implement the remove method.
   </pre>
2. Class may have to provide hooks into its internal workings in the form of judi- ciously chosen protected methods
3. The only way to test a class designed for inheritance is to write subclasses
4. Constructors must not invoke overridable methods
5. Neither clone nor readObject may invoke an overridable method, directly or indirectly

* prohibit subclassing in classes that are not designed and documented to be safely subclassed

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
