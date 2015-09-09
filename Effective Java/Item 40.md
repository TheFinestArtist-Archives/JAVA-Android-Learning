# Design method signatures carefully

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

* Choose method names carefully
* Don’t go overboard in providing convenience methods
* Avoid long parameter lists
   1. Break the method up into multiple methods
   2. Create helper classes to hold groups of parameters
   3. Combines aspects of the first two is to adapt the Builder pattern
* For parameter types, favor interfaces over classes
* Prefer two-element enum types to boolean parameters
   * <code id="inline">public enum TemperatureScale { FAHRENHEIT, CELSIUS }</code>

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
