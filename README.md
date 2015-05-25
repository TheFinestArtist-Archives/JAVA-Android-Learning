##To Do

  * Topics for Week #1
    * Gradle
    * Android App Architecture
    * Advanced Android Libraries
    * Annotation Processors
    * Databases
    * Java Garbage Collection
  * Topics for Week #2
    * What is an ORM?
    * RecyclerView
    * Basics of NDK, JNI
    * Dalvik, ART
    * Java Bytecode & Bytecode Manipulation
  * EN/KR Blog Post for each Topic
  * Blog Post in [Markdown](http://daringfireball.net/projects/markdown/), [Markdown Cheat Sheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
  * Make more than one post for a topic if it needs
  * Translate in Korean after writing all the posts.
  * Effective JAVA
    * 2 rules per day
    * Each rule will be summarized in [Wiki](https://github.com/TheFinestArtist/Relam-JAVA-Android-Learning/wiki)

##Topics

Read the book “Effective Java” by Joshua Bloch

Get it, read it, learn it :) This is the only task that doesn’t require a blogpost, video or presentation. Just read & understand the book :)

Don’t stay stuck on this, please start other topics while you read the book.


####Android app architecture

What is Model-View-Controller (MVC) and Model-View-Presenter (MVP)? What is the difference between them and why is this sort of architecture useful on Android?

How does it effect:

  * Testing
  * App architecture
  * Are there tools/libraries that can help with implementing these architectures?
  * How does Realm fit into these kind of architectures? Are there any pitfalls?


####Advanced Android libraries

What does these libraries do and what problems do they solve? You can write one blogpost/video/presentation about each library, if you want:

  * Dagger (Dependency injection): Why is it usefull? Are there any tradeoffs?
  * Reactive programming (RxJava): What problem does RxJava solve? How does it affect your app architecture. What are the good use cases? and the bad?
  * Roboelectric: what problem does it solve? How does it work?

Does Realm work well with these kind of libraries. Are there any pitfalls?


####Databases

There a different kinds of Databases, what are the advantages/disadvantages of each?  Why should I use one over the other? What are the major options?

Types of databases:

  * Graph database
  * Relational database
  * key-value database


####What is an ORM?

Write deep introduction to the topic. What is an ORM? Why should you use one? Why shouldn’t you use one?

Provide overview of major ORM solutions, benchmarks and advantages / disadvantages


####RecyclerView

  * Context: Realm issue: https://github.com/realm/realm-java/issues/861
  * Materials:
    * http://gradlewhy.ghost.io/realm-results-with-recyclerview/
    * http://www.binpress.com/tutorial/android-l-recyclerview-and-cardview-tutorial/156
  * Questions he should be able to answer:
    * Difference between RecyclerView and ListView?
    * How does a RecyclerView work
    * What are the advantages/disadvantages?
    * Create a base adapter for RecyclerView that is usable by others. See RealmBaseAdapter as inspiration


####Gradle

Write a blogpost about what Gradle is and how it works. Should be a perfect deep introduction for a new Android developer

Gradle plugins: How do you write a Gradle plugin for Android? Why would that be useful?


####Annotation Processors

Context: we have issues like this: https://github.com/realm/realm-java/issues/694

Materials:

https://speakerdeck.com/jakewharton/annotation-processing-boilerplate-destruction-droidcon-nyc-2014

https://www.youtube.com/watch?v=dOcs-NKK-RA

Questions you should be able to answer:

What are the advantages/disadvantages?

What is possible?

What are the limitations?

How does Realm uses annotation processing?


####Java Garbage Collection

Write a deep introduction to the topic. What GC modes exist? What do other VMs offer?

Why do Java developers need to care about garbage collection?


####Basics of NDK, JNI

Write deep introduction to the topic.


####Dalvik, ART

What are Dalvik & ART? How do they work? Why do they matter to an Android developer?

Write a deep introduction for a new Android developer.


####Java Bytecote & Bytecode Manipulation

Write deep introduction to the topic.
