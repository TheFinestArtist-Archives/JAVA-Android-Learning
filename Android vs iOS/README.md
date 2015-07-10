##Reason why iOS is twice as much easier to implement than Android
* iOS suggest and induce developer to good application design pattern (MVC)
* Android doesn’t suggest or induce developer for any design pattern
   * Android Activity and Fragment actually make it hard to apply these patterns


* iOS design pattern is focused on front-end development and it is very simple (XIB, controller)
* Android gives similar design pattern but not as good as iOS and too complicated (Activity, FragmentActivity, AppCompatActivity, Fragment, SupportFragment)
   * Android allows developer too many customization
   * iOS allows similar customization as Android but most stuff can use without customization


* iOS has UITableViewController which is kind of ListView with adapter in it. Very classy and you will know why this class gives so many efficiency to code if you actually use it.
* Android is so mixed with ListView and more than 10~20 kinds of adapters including CursorAdpater. Whenever data type of view type is changed and you have to change your adapter kinds, you might get crazy about it.


* iOS gives better suggestion for thread based objects (Each object has  setting Atomic, Non-atomic and so on)
* Android uses Java based thread system which is too complicated
   * Sometimes UI can be actually updated even though UI updates method is not called from UI Thread. Really funny stuff and hard to find bug if it happens. (Needs to time to realize there is a code block which are running in other thread because the UI is actually running)


* Xcode gives really good tools for developing iOS App such as simulator, activity monitor (Instruments)
* Android also gives good tool but not as good as iOS and also very hard and inconvenient to use


* iOS app doesn’t need to support all the version from 4.0 or 5.0 and updated SDK deprecate many useless classes and shows better classes and user case
* Android need to support from 4.1 and also need to follow all kinds of support library and have to concern each open source project actually supports from my minimum SDK.


* iOS need to support 4 kinds (The auto-layout is under updating since iOS has now four different view supports)
* Android need to support all kinds of layouts for many many different devices
   * Android suggest to support many kinds of layout and style by changing postfix of name of values folder. Which is kind of cool way but very confusing if it gets bigger and bigger.


* Mostly iOS app is much more beautiful than Android app.
* Many mobile developer in USA are iOS developer. There are many Android developer in other country. But Apple and Google both are based on USA.


* Android is better in Build Automation System after using Gradle. Cocoa Pod has many many bugs and also breaking up these days. (Can't use Cocoa Pod if their app is support below than iOS8 because of some kind of framework from iOS)


* Mostly Android Phone has better hardware than iPhone. But Android OS is so stupid, so people usually think iPhone is way more faster than Android.


* No matter how I code Objective-C it runs beautifully or get crashed.
* No matter how I code Android it runs stupidly or have bugs which I don't know where it comes from.


* Xcode finds most of the errors in it's compile time.
* Android Studio


* Android Sliding Pager Tab
* iOS Tab


* Hardware customization from vender Android
