# Avoid unnecessary use of checked exceptions

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

Checked exceptions force the programmer to deal with exceptional conditions, greatly enhancing reliability.

If the programmer using the API can do no better, an unchecked exception would be more appropriate
<pre class="prettyprint">
} catch(TheCheckedException e) {
   throw new AssertionError(); // Can't happen!
}

} catch(TheCheckedException e) {
   e.printStackTrace();        // Oh well, we lose.
   System.exit(1);
}
</pre>

One technique for turning a checked exception into an unchecked exception is to break the method that throws the exception into two methods, the first of which returns a boolean that indicates whether the exception would be thrown
<pre class="prettyprint">
// Invocation with checked exception
try {
   obj.action(args);
} catch(TheCheckedException e) {
   // Handle exceptional condition
   ...
}

// Invocation with state-testing method and unchecked exception
if (obj.actionPermitted(args)) {
   obj.action(args);
} else {
   // Handle exceptional condition
   ...
}
</pre>

In cases where the programmer knows the call will succeed or is content to let the thread terminate if the call fails,the refactoring also allows this simple calling sequence
<pre class="prettyprint">
obj.action(args);
</pre>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
