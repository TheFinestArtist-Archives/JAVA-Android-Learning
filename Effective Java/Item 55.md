# Optimize judiciously

#### From <u>[Effective Java 2/e](https://books.google.co.kr/books/about/Effective_Java.html?id=ka2VUBqHiWkC&hl=en)</u> by <u>[Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch)</u>

>More computing sins are committed in the name of efficiency (without neces- sarily achieving it) than for any other single reason—including blind stupidity. —William A. Wulf

>We should forget about small efficiencies, say about 97% of the time: prema- ture optimization is the root of all evil. —Donald E. Knuth


>We follow two rules in the matter of optimization:  
   Rule 1. Don’t do it.  
   Rule 2 (for experts only). Don’t do it yet—that is, not until you have a
   perfectly clear and unoptimized solution.  
—M. A. Jackson


1. Strive to write good programs rather than fast ones
2. Strive to avoid design decisions that limit performance
3. Consider the performance consequences of your API design decisions
4. It is a very bad idea to warp an API to achieve good performance
   * generally the case that good API design is consistent with good performance
5. Measure performance before and after each attempted optimization

#### Posted by <u>[The Finest Artist](http://thefinestartist.com)
