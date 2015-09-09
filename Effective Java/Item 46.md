# Prefer for-each loops to traditional for loops

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Prior to release 1.5
<pre class="prettyprint">
// No longer the preferred idiom to iterate over a collection!
for (Iterator i = c.iterator(); i.hasNext(); ) {
   doSomething((Element) i.next()); // (No generics before 1.5)
}

// No longer the preferred idiom to iterate over an array!
for (int i = 0; i &lt; a.length; i++) {
   doSomething(a[i]);
}
</pre>

## The for-each loop, introduced in release 1.5
<pre class="prettyprint">
// The preferred idiom for iterating over collections and arrays
for (Element e : elements) {
   doSomething(e);
}
</pre>

## Advantages over traditional for-loop
* Clarity
* Bug prevention
* No performance penalty
* lets you iterate over any object that implements the Iterable interface  
   <pre class="prettyprint">
   public interface Iterable&lt;E&gt; {
      // Returns an iterator over the elements in this iterable
      Iterator&lt;E&gt; iterator();
   }
   </pre>

## Three common situations where you can’t use a for-each loop
1. **Filtering**  
   If you need to traverse a collection and remove selected elements, then you need to use an explicit iterator so that you can call its remove method.
2. **Transforming**  
   If you need to traverse a list or array and replace some or all of the values of its elements, then you need the list iterator or array index in order to set the value of an element.
3. **Parallel iteration**  
   If you need to traverse multiple collections in parallel, then you need explicit control over the iterator or index variable, so that all it- erators or index variables can be advanced in lockstep (as demonstrated unin- tentionally in the buggy card and dice examples above).

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
