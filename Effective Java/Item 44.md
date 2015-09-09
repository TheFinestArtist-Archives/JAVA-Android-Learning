# Write doc comments for all exposed API elements

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

Javadoc generates API documentation automatically from source code with specially formatted documentation comments, more commonly known as doc comments  
The Javadoc utility translates doc comments into HTML  
[How to write doc comments](http://www.oracle.com/technetwork/articles/java/index-137868.html)


<pre class="prettyprint">
/**
 * Returns the element at the specified position in this list. *
 * <p>This method is <i>not</i> guaranteed to run in constant
 * time. In some implementations it may run in time proportional * to the element position.
 *
 * @param index index of element to return; must be
 * non-negative and less than the size of this list
 * @return the element at the specified position in this list
 * @throws IndexOutOfBoundsException if the index is out of range
 *         ({@code index &lt; 0 || index &gt;= this.size()})
 */
E get(int index);
</pre>

* The doc comment for a method should describe succinctly the contract between the method and its client
   * Contract should say what the method does rather than how it does its job
* The doc comment should enumerate all of the method’s preconditions, which are the things that have to be true in order for a client to invoke it, and its postconditions
* Methods should document any side effects
* To describe a method’s contract fully, the doc comment should have an <code id="inline">@param</code> tag for every parameter, an <code id="inline">@return</code> tag unless the method has a void return type, and an <code id="inline">@throws</code> tag for every exception thrown by the method, whether checked or unchecked
   * <code id="inline">@param</code> tag or <code id="inline">@return</code> tag should be a noun phrase describing the value represented by the parameter or return value
   * <code id="inline">@throws</code> tag should consist of the word “if,” followed by a clause describing the conditions under which the exception is thrown
   * <code id="inline">@param</code>, <code id="inline">@return</code>, or <code id="inline">@throws</code> tag is not terminated by a period

**Javadoc {@code} tag**
* Eliminates the need to escape HTML meta characters

**Javadoc {@literal} tag**
* Like the {@code} tag, except that it doesn’t render the text in code font

**Summary description**
* The first “sentence” of each doc comment (as defined below) becomes the summary description of the element
* No two members or constructors in a class or interface should have the same summary description
* For methods and constructors, the summary description should be a full verb phrase (including any object) describing the action performed by the method
   <pre class="prettyprint">
   ArrayList(int initialCapacity) — Constructs an empty list with the spec- ified initial capacity.
   Collection.size() — Returns the number of elements in this collection.
   </pre>
* For classes, interfaces, and fields, the summary description should be a noun phrase describing the thing represented by an instance of the class or interface or by the field itself
   <pre class="prettyprint">
   TimerTask — A task that can be scheduled for one-time or repeated execution by a Timer.
   Math.PI — The double value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter.
   </pre>

**Generic type or method**  
Be sure to document all type parameters
<pre class="prettyprint">
/**
 * An object that maps keys to values. A map cannot contain * duplicate keys; each key can map to at most one value.
 *
 * (Remainder omitted)
 *
 * @param &lt;K&gt; the type of keys maintained by this map
 * @param &lt;V&gt; the type of mapped values
 */
public interface Map&lt;K, V&gt; { ... // Remainder omitted
}
</pre>

**Enum type**  
Be sure to document the constants
<pre class="prettyprint">
/**
 * An instrument section of a symphony orchestra.
 */
public enum OrchestraSection {
   /** Woodwinds, such as flute, clarinet, and oboe. */
   WOODWIND,
   /** Brass instruments, such as french horn and trumpet. */
   BRASS,
   /** Percussion instruments, such as timpani and cymbals */
   PERCUSSION,
   /** Stringed instruments, such as violin and cello. */
   STRING;
}
</pre>

**Annotation type**  
Be sure to document any members
<pre class="prettyprint">
/**
 * Indicates that the annotated method is a test method that
 * must throw the designated exception to succeed.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
   /**
    * The exception that the annotated test method must throw
    * in order to pass. (The test is permitted to throw any
    * subtype of the type described by this class object.)
    */
   Class&lt;? extends Exception&gt; value();
}
</pre>

## Caveat
* As of release 1.5, package-level doc comments should be placed in a file called <code id="inline">package-info.java</code>
* Whether or not a class is thread-safe, you should document its thread-safety level
* If a class is serializable, you should document its serialized form
* Javadoc has the ability to “inherit” method comments
   * You can also inherit parts of doc comments from supertypes using the {@inheritDoc} tag
* A simple way to reduce the likelihood of errors in documentation comments is to run the HTML files generated by Javadoc through an HTML validity checker
* While it is necessary to provide documentation comments for all exported API elements, it is not always sufficient. For complex APIs consisting of multiple interrelated classes, it is often necessary to supplement the documentation comments with an external document describing the overall architecture of the API

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
