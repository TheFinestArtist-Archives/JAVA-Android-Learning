#Gradle in Android

##Project structure

When you make a Android project through Android Studio. Gradle script will be generated automatically. Gradle related files are located like this:
```
Project
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
│
├── app
│   └── build.gradle
│   └── proguard-rules.pro
│
├── library
│   └── build.gradle
│   └── proguard-rules.pro
│
├── build.gradle
├── gradle.properties
├── local.properties
└── settings.gradle

~/.gradle/gradle.properties
```


###setting.gradle?
###build.gradle?
###local.properties?
###gradle.properties?


##build.gradle structure?


##Integrating open sources

###Android Support Packages
```
 // Google Play Services
 compile 'com.google.android.gms:play-services:7.3.+'

 // Support Libraries
 compile 'com.android.support:appcompat-v7:22.0.+'
 compile 'com.android.support:cardview-v7:22.0.+'
 compile 'com.android.support:gridlayout-v7:22.0.+'
 compile 'com.android.support:leanback-v17:22.0.+'
 compile 'com.android.support:mediarouter-v7:22.0.+'
 compile 'com.android.support:palette-v7:22.0.+'
 compile 'com.android.support:recyclerview-v7:22.0.+'
 compile 'com.android.support:support-annotations:22.0.+'
 compile 'com.android.support:support-v13:22.0.+'
 compile 'com.android.support:support-v4:22.0.+'
```
You can find latest Android support package version from [here](http://developer.android.com/tools/support-library/index.html)

###Realm
```
compile 'io.realm:realm-android:0.80.+'
```
You can find more ways to integrating Realm from [here](http://realm.io/docs/java/latest/#installation)

###Crashlytics

##Customisation Gradle Settings
###Version Name Suffix
###https://www.youtube.com/watch?t=608&v=LCJAgPkpmR0

##What is repositories and why there is so many repositories?

##What is difference between jcenter, maven, mavenCentral, etc?

##Library Module Setting

##Testing

## Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : https://www.thefinestartist.com
```
