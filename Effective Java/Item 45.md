# Minimize the scope of local variables

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## Advantages
* Increase the readability
* Increate the maintainability
* Reduce the likelihood of error

## Technique
* The most powerful technique for minimizing the scope of a local variable is to declare it where it is first used
* Nearly every local variable declaration should contain an initializer
* Loops present a special opportunity to minimize the scope of variables (prefer for loops to while loops)
   <pre class="prettyprint">
   // Preferred idiom for iterating over a collection
   for (Element e : c) {
      doSomething(e);
   }

   // No for-each loop or generics before release 1.5
   for (Iterator i = c.iterator(); i.hasNext(); ) {
      doSomething((Element) i.next());
   }
   </pre>
   
* Keep methods small and focused

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
