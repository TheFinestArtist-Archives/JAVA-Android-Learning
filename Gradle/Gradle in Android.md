#Gradle in Android

**This post is for the developers who just started using Android Studio.**

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

####Common Integration Rule
```
compile 'groupId:artifactId:version'
```

####Android Support Packages
```
// Google Play Services
compile 'com.google.android.gms:play-services:7.3.+'

// Support Libraries
compile 'com.android.support:appcompat-v7:22.+'
compile 'com.android.support:cardview-v7:22.+'
compile 'com.android.support:gridlayout-v7:22.+'
compile 'com.android.support:leanback-v17:22.+'
compile 'com.android.support:mediarouter-v7:22.+'
compile 'com.android.support:palette-v7:22.+'
compile 'com.android.support:recyclerview-v7:22.+'
compile 'com.android.support:support-annotations:22.+'
compile 'com.android.support:support-v13:22.+'
compile 'com.android.support:support-v4:22.+'
```
You can find latest Android support package version from [here](http://developer.android.com/tools/support-library/index.html)

####Realm
```
compile 'io.realm:realm-android:0.80.+'
```
You can find more ways to integrating Realm from [here](http://realm.io/docs/java/latest/#installation)

##Dynamic Versions

####Gradle follows [Ivy's version-matchers](http://ant.apache.org/ivy/history/trunk/settings/version-matchers.html)

**Exact Revision Matcher**

| Revision | Matches |
|----------|---------|
| 1.0.0    | '1.0.0' |

**Sub Revision Matcher**

| Revision | Matches                                                                 |
|----------|-------------------------------------------------------------------------|
| 1.0.+    | all revisions starting with '1.0.', like 1.0.1, 1.0.5, 1.0.a            |
| 1.1+     | all revisions starting with '1.1', like 1.1, 1.1.5, but also 1.10, 1.11 |

**Latest (Status) Matcher**

| Revision            | Matches                                           |
|---------------------|---------------------------------------------------|
| latest.integration  | all versions                                      |
| latest.milestone    | all modules having at least 'milestone' as status |
| latest.release      | all modules having at least 'release' as status   |
| latest.[any status] | all modules having at least the specified status  |

**Version Range Matcher**

| Revision  | Matches                                                        |
|-----------|----------------------------------------------------------------|
| [1.0,2.0] | all versions greater or equal to 1.0 and lower or equal to 2.0 |
| [1.0,2.0[ | all versions greater or equal to 1.0 and lower than 2.0        |
| ]1.0,2.0] | all versions greater than 1.0 and lower or equal to 2.0        |
| ]1.0,2.0[ | all versions greater than 1.0 and lower than 2.0               |
| [1.0,)    | all versions greater or equal to 1.0                           |
| ]1.0,)    | all versions greater than 1.0                                  |
| (,2.0]    | all versions lower or equal to 2.0                             |
| (,2.0[    | all versions lower than 2.0                                    |

You can find more about dynamic versions and changing modules from [here](https://docs.gradle.org/current/userguide/dependency_management.html#sub:dynamic_versions_and_changing_modules)

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
