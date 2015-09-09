# Use marker interfaces to define types

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

A **marker interface** is an interface that contains no method declarations, but merely designates (or “marks”) a class that implements the interface as having some property. For example, consider the Serializable interface.

## Advantages Marker interfaces
1. Marker interfaces define a type that is implemented by instances of the marked class; marker annotations do not.
2. Marker interfaces can be targeted more precisely.


## Advantages of Marker annotations
1. It is possible to add more information to an annotation type after it is already in use
2. Marker annotations are part of the larger annotation facility

## When to use?
1. You must use an annotation if the marker applies to any program element other than a class or interface
2. If you want to define a type that does not have any new methods associated with it, a marker interface is the way to go.
3. If you want to mark program elements other than classes and interfaces, to allow for the possibility of adding more information to the marker in the future, or to fit the marker into a framework that already makes heavy use of annotation types, then a marker annotation is the correct choice.

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
