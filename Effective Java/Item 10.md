# Always override toString

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* providing a good toString implementation makes your class much more pleasant to use
* When practical, the toString method should return all of the interesting information contained in the object
* Whether or not you decide to specify the format, you should clearly document your intentions

<pre class="prettyprint">
   /**
    * Returns the string representation of this phone number.
    * The string consists of fourteen characters whose format
    * is "(XXX) YYY-ZZZZ", where XXX is the area code, YYY is
    * the prefix, and ZZZZ is the line number.  (Each of the
    * capital letters represents a single decimal digit.)
    *
    * If any of the three parts of this phone number is too small
    * to fill up its field, the field is padded with leading zeros.
    * For example, if the value of the line number is 123, the last * four characters of the string representation will be "0123". *
    * Note that there is a single space separating the closing
    * parenthesis after the area code from the first digit of the * prefix.
    */
   @Override public String toString() {
       return String.format("(%03d) %03d-%04d",
                            areaCode, prefix, lineNumber);
   }
</pre>

* provide programmatic access to all of the information contained in the value returned by toString

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
