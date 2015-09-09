# Groovy

#### Basic [Syntax](http://www.groovy-lang.org/syntax.html) and [Semantics](http://www.groovy-lang.org/semantics.html) of Groovy

## Difference with JAVA

   1. Default imports
   <pre class="prettyprint">
   import java.io.*
   import java.lang.*
   import java.math.BigDecimal
   import java.math.BigInteger
   import java.net.*
   import java.util.*
   import groovy.lang.*
   import groovy.util.*
   </pre>

   2. Multi-Methods
   In Groovy, the methods which will be invoked are chosen at runtime.
   <pre class="prettyprint">
   int method(String arg) {
      return 1;
   }
   int method(Object arg) {
      return 2;
   }
   Object o = "Object";
   // result will be 1 in Groovy, 2 in Java
   int result = method(o);
   </pre>

   3. Array initializers
   In Groovy, the { …​ } block is reserved for closures.
   <pre class="prettyprint">
   // Cannot create array literals with this syntax:
   int[] array = { 1, 2, 3}
   int[] array = [1,2,3]
   </pre>

   4. Static Inner classes
   <pre class="prettyprint">
   class A {
      static class B {}
   }

   new A.B()
   </pre>

   5. Anonymous Inner Classes
   <pre class="prettyprint">
   import java.util.concurrent.CountDownLatch
   import java.util.concurrent.TimeUnit

   CountDownLatch called = new CountDownLatch(1)

   Timer timer = new Timer()
      timer.schedule(new TimerTask() {
      void run() {
         called.countDown()
      }
   }, 0)

   assert called.await(10, TimeUnit.SECONDS)
   </pre>

   6. Lambdas
   <pre class="prettyprint">
   // Java 8 Lambda support
   Runnable run = () -&gt; System.out.println("Run");
   list.forEach(System.out::println);

   // Groovy Lambda support
   Runnable run = { println 'run' }
   list.each { println it } // or list.each(this.&println)
   </pre>

   7. Behavior of <code id="inline">==</code>
   In Java <code id="inline">==</code> means equality of primitive types or identity for objects.  
   In Groovy <code id="inline">==</code> translates to <code id="inline">a.compareTo(b)==0</code>, iff they are Comparable, and <code id="inline">a.equals(b)</code> otherwise. To check for identity, there is is. E.g. a.is(b).

## Syntax

   1. Comments

   <pre class="prettyprint">
   // a standalone single line comment
   println "hello" // a comment till the end of the line

   /* a standalone multiline comment
      spanning two lines */
   println "hello" /* a multiline comment starting
                      at the end of a statement */
   println 1 /* one */ + 2 /* two */
   </pre>

   2. Identifiers

      * Normal Identifiers
      Identifiers start with a letter, a dollar or an underscore. They cannot start with a number.

      <pre class="prettyprint">
      // valid identifiers
      def name
      def item3
      def with_underscore
      def $dollarStart

      // invalid identifiers
      def 3tier
      def a+b
      def a#b
      </pre>

      * Quoted identifiers

   3. Strings  
   java.lang.String is plain String object and groovy.lang.GString is [interpolated strings](http://en.wikipedia.org/wiki/String_interpolation).

      * Single quoted string
      Single quoted strings are plain java.lang.String and don’t support interpolation.
      <pre class="prettyprint">
      'a single quoted string'
      </pre>

      * String concatenation
      <pre class="prettyprint">
      assert 'ab' == 'a' + 'b'
      </pre>

      * Triple single quoted string
      Triple single quoted strings are for multiline.
      <pre class="prettyprint">
      def startingAndEndingWithANewline = '''
      line one
      line two
      line three
      '''
      </pre>

      * Double quoted string
      Double quoted strings are plain java.lang.String if there’s no interpolated expression, but are groovy.lang.GString instances if interpolation is present.
      <pre class="prettyprint">
      "a double quoted string"
      </pre>

      * String interpolation
      Any Groovy expression can be interpolated in all string literals, apart from single and triple single quoted strings. Interpolation is the act of replacing a placeholder in the string with its value upon evaluation of the string. The placeholder expressions are surrounded by ${} or prefixed with $ for dotted expressions. The expression value inside the placeholder is evaluated to its string representation when the GString is passed to a method taking a String as argument by calling toString() on that expression.

      <pre class="prettyprint">
      def name = 'Guillaume' // a plain string
      def greeting = "Hello ${name}"
      assert greeting.toString() == 'Hello Guillaume'

      def sum = "The sum of 2 and 3 equals ${2 + 3}"
      assert sum.toString() == 'The sum of 2 and 3 equals 5'

      def person = [name: 'Guillaume', age: 36]
      assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'
      </pre>

      * Triple double quoted string
      Triple double quoted strings behave like double quoted strings, with the addition that they are multiline, like the triple single quoted strings.

      <pre class="prettyprint">
      def name = 'Groovy'
      def template = """
          Dear Mr ${name},

          You're the winner of the lottery!

          Yours sincerly,

          Dave
      """

      assert template.toString().contains('Groovy')
      </pre>

   4. Lists  
   Groovy uses a comma-separated list of values, surrounded by square brackets.  
   Groovy lists are plain JDK <code id="inline">.util.List</code>.  
   The concrete list implementation used when defining list literals are <code id="inline">.util.ArrayList</code> by default.
   <pre class="prettyprint">
   def numbers = [1, 2, 3]

   // list is an instance of Java’s java.util.List interface
   assert numbers instanceof List  
   // size of the list can be queried with the size() method
   assert numbers.size() == 3

   // list contains a number, a string and a boolean value
   def heterogeneous = [1, "a", true]

   def arrayList = [1, 2, 3]
   assert arrayList instanceof java.util.ArrayList

   def linkedList = [2, 3, 4] as LinkedList
   assert linkedList instanceof java.util.LinkedList

   LinkedList otherLinked = [3, 4, 5]
   assert otherLinked instanceof java.util.LinkedList
   </pre>

   You can access elements of the list with the [] subscript operator (both for reading and setting values).  
   <pre class="prettyprint">
   def letters = ['a', 'b', 'c', 'd']

   assert letters[0] == 'a'
   assert letters[1] == 'b'

   assert letters[-1] == 'd'
   assert letters[-2] == 'c'

   letters[2] = 'C'
   assert letters[2] == 'C'

   // Use the &lt;&lt; leftShift operator to append an element at the end of the list
   letters &lt;&lt; 'e'
   assert letters[ 4] == 'e'
   assert letters[-1] == 'e'

   assert letters[1, 3] == ['b', 'd']
   assert letters[2..4] == ['C', 'd', 'e']
   </pre>

   5. Arrays  
   Groovy reuses the list notation for arrays, but to make such literals arrays, you need to explicitely define the type of the array through coercion or type declaration.
   <pre class="prettyprint">
   String[] arrStr = ['Ananas', 'Banana', 'Kiwi']  

   assert arrStr instanceof String[]
   assert !(arrStr instanceof List)

   def numArr = [1, 2, 3] as int[]

   assert numArr instanceof int[]
   assert numArr.size() == 3
   </pre>

   6. Maps  
   Maps associate keys to values, separating keys and values with colons, and each key/value pairs with commas, and the whole keys and values surrounded by square brackets.
   <pre class="prettyprint">
   def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

   assert colors['red'] == '#FF0000'
   assert colors.green  == '#00FF00'

   colors['pink'] = '#FF00FF'
   colors.yellow  = '#FFFF00'

   assert colors.pink == '#FF00FF'
   assert colors['yellow'] == '#FFFF00'

   assert colors instanceof java.util.LinkedHashMap
   </pre>

## Semantics
   1. Variable definition  
   Variables can be defined using either their type (like String) or by using the keyword def
   <pre class="prettyprint">
   String x
   def o
   </pre>

   2. Variable assignment
   <pre class="prettyprint">
   x = 1
   x = new java.util.Date()
   x = -3.1499392
   x = false
   x = "Hi"

   def (a, b, c) = [10, 20, 'foo']
   assert a == 10 && b == 20 && c == 'foo'

   def (int i, String j) = [10, 'foo']
   assert i == 10 && j == 'foo'
   </pre>

   3. If/Else
   <pre class="prettyprint">
   if ( ... ) {
       ...
   } else if (...) {
       ...
   } else {
       ...
   }
   </pre>

   4. Switch/Case
   <pre class="prettyprint">
   def x = 1.23
   def result = ""

   switch ( x ) {
       case "foo":
           result = "found foo"
       case "bar":
           result += "bar"
       case [4, 5, 6, 'inList']:
           result = "list"
           break
       case 12..30:
           result = "range"
           break
       case Integer:
           result = "integer"
           break
       case Number:
           result = "number"
           break
       default:
           result = "default"
   }

   assert result == "number"
   </pre>

   5. For in loop
   <pre class="prettyprint">
   // iterate over a range
   def x = 0
   for ( i in 0..9 ) {
       x += i
   }
   assert x == 45

   // iterate over a list
   x = 0
   for ( i in [0, 1, 2, 3, 4] ) {
       x += i
   }
   assert x == 10

   // iterate over an array
   def array = (0..4).toArray()
   x = 0
   for ( i in array ) {
       x += i
   }
   assert x == 10

   // iterate over a map
   def map = ['abc':1, 'def':2, 'xyz':3]
   x = 0
   for ( e in map ) {
       x += e.value
   }
   assert x == 6

   // iterate over values in a map
   x = 0
   for ( v in map.values() ) {
       x += v
   }
   assert x == 6

   // iterate over the characters in a string
   def text = "abc"
   def list = []
   for (c in text) {
       list.add(c)
   }
   assert list == ["a", "b", "c"]
   </pre>

## Author
<pre class="prettyprint">
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : http://www.thefinestartist.com
</pre>
