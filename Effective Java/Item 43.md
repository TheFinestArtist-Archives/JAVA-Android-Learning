# Return empty arrays or collections, not nulls

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

**There is no reason ever to return null from an array- or collection-valued method instead of returning an empty array or collection**

<pre class="prettyprint">
// The right way to return an array from a collection
private final List&lt;Cheese&gt; cheesesInStock = ...;
private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
/**
 * @return an array containing all of the cheeses in the shop.
 */
public Cheese[] getCheeses() {
   return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
}
</pre>

<pre class="prettyprint">
// The right way to return a copy of a collection
public List&lt;Cheese&gt; getCheeseList() {
   if (cheesesInStock.isEmpty())
      return Collections.emptyList(); // Always returns same list
   else
      return new ArrayList&lt;Cheese&gt;(cheesesInStock);
}
</pre>

## Returing null
* Doing so requires extra code in the client to handle the null return value
* It is error-prone, because the programmer writing the client might forget to write the special- case code to handle a null return
* Returning null in place of an empty array also complicates the method that returns the array or collection

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
