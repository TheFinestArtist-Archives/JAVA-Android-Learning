# Refer to objects by their interfaces

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

If appropriate interface types exist, then parameters, return values, variables, and fields should all be declared using interface types.

<pre class="prettyprint">
// Good - uses interface as type
List&lt;Subscriber&gt; subscribers = new ArrayList&lt;Subscriber&gt;();
List&lt;Subscriber&gt; subscribers = new Vector&lt;Subscriber&gt;();

// Bad - uses class as type!
Vector&lt;Subscriber&gt; subscribers = new Vector&lt;Subscriber&gt;();
</pre>

## Advantages
* If you get into the habit of using interfaces as types, your program will be much more flexible.
* Declaring the field with the interface type “keeps you honest.”

## No appropriate interface to refer
1. It is entirely appropriate to refer to an object by a class rather than an interface if no appropriate interface exists.
2. If an object belongs to such a class-based framework, it is preferable to refer to it by the relevant base class, which is typically abstract, rather than by its implementation class.
3. There is no appropriate interface type is that of classes that implement an interface but provide extra methods not found in the interface.


* If you depend on any special properties of an implementation, document these requirements where you declare the variable.

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
