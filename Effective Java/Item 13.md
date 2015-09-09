# Minimize the accessibility of classes and members

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

## [Information Hiding](http://en.wikipedia.org/wiki/Information_hiding) or [Encapsulation](goo.gl/Asgxp4)
> Principle of segregation of the design decisions in a computer program that are most likely to change, thus protecting other parts of the program from extensive modification if the design decision is changed. The protection involves providing a stable interface which protects the remainder of the program from the implementation (the details that are most likely to change).

* Decouples the modules that comprise a system, allowing them to be developed, tested, optimized, used, understood, and modified in isolation
* Speeds up system development because modules can be developed in parallel
* Eases the burden of maintenance because modules can be understood more quickly and debugged with little fear of harming other modules
* Enables effective performance tuning: once a system is complete and profiling has determined which modules are causing performance problems

## Public Class
* Instance fields should never be public:
   * Impossible to take any action when the field is modified
   * Mostly private
   * Sometimes package-private
   * Protected fields is part of the class’s exported API and must be supported forever
   * Classes with public mutable fields are not thread-safe

## Public static final fields
<pre class="prettyprint">
// Exception
public static final String CLASS_NAME = "Point";

// Potential security hole!
public static final Thing[] VALUES =  { ... };

// Alternative #1: Private array and add a public immutable list
private static final Thing[] PRIVATE_VALUES = { ... };
public static final List&lt;Thing&gt; VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

// Alternative #2: Private array and add a public method that returns a copy of a private array
private static final Thing[] PRIVATE_VALUES = { ... };
public static final Thing[] values() {
   return PRIVATE_VALUES.clone();
}
</pre>

## Conclusion
* Always reduce accessibility as much as possible
* Prevent any stray classes, interfaces, or members from becoming a part of the API
* Except immutable public static final fields, public classes should have no public fields

## Access Levels
<table id="markdown-table">
   <tr>
      <th>Modifier</th>
      <th>Class</th>
      <th>Package</th>
      <th>Subclass</th>
      <th>World</th>
   </tr>
   <tr>
      <td>public</td>
      <td>Y</td>
      <td>Y</td>
      <td>Y</td>
      <td>Y</td>
   </tr>
   <tr>
      <td>protected</td>
      <td>Y</td>
      <td>Y</td>
      <td>Y</td>
      <td>N</td>
   </tr>
   <tr>
      <td>no modifier</td>
      <td>Y</td>
      <td>Y</td>
      <td>N</td>
      <td>N</td>
   </tr>
   <tr>
      <td>private</td>
      <td>Y</td>
      <td>N</td>
      <td>N</td>
      <td>N</td>
   </tr>
</table>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
