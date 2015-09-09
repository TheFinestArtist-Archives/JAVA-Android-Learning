# Adhere to generally accepted naming conventions

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* The Java platform has a well-established set of naming conventions, many of which are contained in The Java Language Specification  

## Typographical

<table id="markdown-table">
   <tr>
      <th>Identifier Type</th>
      <th>Examples</th>
   </tr>
   <tr>
      <td>Package</td>
      <td>com.google.inject, org.joda.time.format</td>
   </tr>
   <tr>
      <td>Class or Interface</td>
      <td>Timer, FutureTask, LinkedHashMap, HttpServlet</td>
   </tr>
   <tr>
      <td>Method or Field</td>
      <td>remove, ensureCapacity, getCrc</td>
   </tr>
   <tr>
      <td>Constant Field</td>
      <td>MIN_VALUE, NEGATIVE_INFINITY</td>
   </tr>
   <tr>
      <td>Local Variable</td>
      <td>i, xref, houseNumber</td>
   </tr>
   <tr>
      <td>Type Parameter</td>
      <td>T, E, K, V, X, T1, T2</td>
   </tr>
</table>

## Grammatical
* Classes, including enum types, are generally named with a singular noun or noun phrase
   <pre class="prettyprint">
   Timer
   BufferedWriter
   ChessPiece
   </pre>

* Interfaces are named like classes
   <pre class="prettyprint">
   Collection
   Comparator
   Runnable
   Iterable
   Accessible
   </pre>

* Because annotation types have so many uses, no part of speech predominates
   <pre class="prettyprint">
   BindingAnnotation
   Inject
   ImplementedBy
   Singleton
   </pre>

* Methods that perform some action are generally named with a verb or verb phrase
   <pre class="prettyprint">
   append
   drawImage
   </pre>

* Methods that return a boolean value usually have names that begin with the word is or has
   <pre class="prettyprint">
   isDigit
   isProbablePrime
   isEmpty
   isEnabled
   hasSiblings
   </pre>

* Methods that return a non-boolean function or attribute of the object on which they’re invoked are usually named with a noun, a noun phrase, or a verb phrase beginning with the verb get
   <pre class="prettyprint">
   size
   hashCode
   getTime
   </pre>

* The form beginning with get is mandatory if the class containing the method is a Bean
   <pre class="prettyprint">
   getAttribute
   setAttribute
   </pre>

* A few method names deserve special mention. Methods that convert the type of an object, returning an independent object of a different type, are often called toType
   <pre class="prettyprint">
   toString
   toArray
   </pre>

* Methods that return a view (Item 5) whose type differs from that of the receiving object are often called asType
   <pre class="prettyprint">
   asList
   </pre>

* Methods that return a primitive with the same value as the object on which they’re invoked are often called typeValue
   <pre class="prettyprint">
   valueOf
   of
   getInstance
   newInstance
   getType
   newType
   </pre>

* Grammatical conventions for field names are less well established and less important than those for class, interface, and method names, as well-designed APIs contain few if any exposed fields

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
