#Gradle with Android

####Understanding how Gradle works with Android

##Module?
Android Studio is build on IntelliJ IDEA which supports module-based project structure. There is new keyword called "Module" in Android Studio. [Intellij defines module as:](https://www.jetbrains.com/idea/features/project_configuration.html)
> Module is a separate logical part of a project that incorporates your working sources, libraries, reference to target Java SDK, etc. It can be compiled, run or debugged as a standalone entity.

##Project structure

When you make a Android project through Android Studio. Gradle script will be generated automatically. Gradle related files are located like this:
```
Project
├── settings.gradle
├── build.gradle
├── app
│   └── build.gradle
├── libraries
│   └── lib1
│       └── build.gradle
│   └── lib2
│       └── build.gradle
│
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
└── gradle.properties

~/.gradle/gradle.properties
```

####gradle.properties?
`gradle.properties` is a Gradle settings in project folder and `~/.gradle/gradle.properties` is a Gradle settings in Gradle user home.  
You can set password or gradle settings in both files, but gradle.properties in project folder will be shared with your collaborators.
```
mavenUser=admin
mavenPassword=admin123
```
```
org.gradle.jvmargs=-Xmx8192m -XX:MaxPermSize=2048m -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8
org.gradle.parallel=true
org.gradle.daemon=true
```

####setting.gradle?
To define a multi-project build, you need to create a settings file. The settings file lives in the root directory of the source tree, and specifies which projects to include in the build. It must be called settings.gradle. For this example, we are using a simple hierarchical layout.
```
Project
├── settings.gradle
├── app
└── libraries
    └── lib1
    └── lib2
```
settings.gradle
```java
include "app"
include "libraries:lib1"
include "libraries:lib2"
```

####Top-level build.gradle?
Top-level build file where you can add configuration options common to all sub-projects/modules

####build.gradle for each module?
Build file for each module  
In most cases, you only need to edit the build files at the module level


##build.gradle structure?
```java
// This adds Android-specific build tasks to the top-level build tasks and makes the android {...} element available to specify Android-specific build options.
apply plugin: 'com.android.application'

// configures all the Android-specific build options
android {
   // the compilation target
   compileSdkVersion 19
   // what version of the build tools to use
   buildToolsVersion "19.0.0"

   // element configures core settings and entries in the manifest file
   defaultConfig {
      minSdkVersion 8
      targetSdkVersion 19
      versionCode 1
      versionName "1.0"
   }

   // how to build and package your app. By default, the build system defines two build types: debug and release
   buildTypes {
      release {
         minifyEnabled true
         proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
      }
   }
}

// the dependencies for this module
dependencies {
   // Module dependency
   compile project(":lib")

   // Remote binary dependency
   compile 'com.android.support:appcompat-v7:19.0.1'

   // Local binary dependency
   compile fileTree(dir: 'libs', include: ['*.jar'])
}
```


##Integrating open sources

####Common Integration Rule
```java
compile 'groupId:artifactId:version'
```

####Android Support Packages
```java
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
You can find latest Android support package version from [here](http://developer.android.com/tools/support-library/features.html)

####Realm
```java
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

*By default, Gradle caches dynamic versions for 24 hours*  
You can find more about dynamic versions and changing modules from [here](https://docs.gradle.org/current/userguide/dependency_management.html#sub:dynamic_versions_and_changing_modules)


##Customisation Gradle Settings

####Multiple Java Folders & Resource Folders
You can create multiple Java folders and multiple resource folders. It is very useful if you want to manage different type of sources or resources in different folders.
```java
// module build.gradle
android {
   sourceSets {
      main {
         java.srcDirs = ['src/main/java', 'src/main/java-realm']
         res.srcDirs = ['src/main/res', 'src/main/res-icons', 'src/main/res-mipmaps']
      }
   }
}
```

####Basic Customization
You can create your own groovy method and customize build setting with your method.
```java
// module build.gradle
def getVersionCode() {
   def code = ...
   return code
}

android {
   defaultConfig {
     versionCode getVersionCode()
     versionName "1.0"

     minSdkVersion 15
     targetSdkVersion 22
   }
}
```

####Build Type Configurations
You can set custom build types in gradle such as 'beta' and if you build your project in 'beta' version, Gradle will automatically add 'src/beta' folder for building it. You can set API keys for each build types. You can also make different signing configurations for each build type or you can use other build types signing configurations. You can make debuggable release version simply by setting gradle options.
```java
// module build.gradle
android {
   signingConfigs {
      debug {
         storeFile file("debug.keystore")
         storePassword "android"
         keyAlias "androiddebugkey"
         keyPassword "android"
      }
      release {
         storeFile file("release.keystore")
      }
   }
   buildTypes {
      beta {
         versionNameSuffix "-BETA"
         applicationIdSuffix ".beta"
         signingConfig signingConfigs.debug
      }
      debug {
         versionNameSuffix "-DEBUG"
         applicationIdSuffix ".debug"
      }
      debugRelease {
         debuggable true
         versionNameSuffix "-DEBUG-RELEASE"
         applicationIdSuffix ".debug.release"
         signingConfig signingConfigs.debug
      }
      release {
         minifyEnabled true
         proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
      }
   }
   sourceSets.debugRelease.setRoot('src/main')
}
```
Source Folders
```
Project
└── app
    ├── src
    │   └── main
    │   └── beta
    │   └── debug
    │   └── release
    └── build.gradle
    └── proguard-rules.pro
```
Codes in each build type folder will be compiled automatically for each build type. (i.e. if current buid type is release, the codes in app/src/release folder will be compiled with codes in app/src/main)

####Build Type Dependencies
You can use different compile options for each build types.
```java
android {
   ...
}

dependencies {
   // We are updating Realm and testing newly-released version of Realm.
   compile 'io.realm:realm-android:0.80.3'
   betaCompile 'io.realm:realm-android:0.80.3'
   debugCompile 'io.realm:realm-android:0.80.3'
   releaseCompile 'io.realm:realm-android:0.80.0'

   // We are using robolectric for testing projects
   instrumentTestCompile "org.robolectric:robolectric:3.0"
}
```

##Product Flavors
A product flavor defines a customized version of the application build by the project. A single project can have different flavors which change the generated application.

####Build Variants
In fact, the output of a project can only be the cross product of the Build Type and, if applicable, the Product Flavor. This is call a build variant.
*You can set your build variant for each module in Android Studio. There is a button to open build variant window on the left side of Android Studio.*

####Product Flavor Groups
In some case it is useful to be able to have several dimensions of flavors such as 'abi' and 'version'

```java
android {
   flavorGroups 'version', 'abi'
   productFlavors {
      free {
         flavorGroup 'version'
      }
      paid {
         flavorGroup 'version'
      }
      arm {
         flavorGroup 'abi'
      }
      x86 {
         flavorGroup 'abi'
      }
      mips {
         flavorGroup 'abi'
      }
   }
}
```
There is two flavorGroups ('version', 'abi') and 'version' has 2 productFlavors and 'abi' has 3 productFlavors. Assume we have 2 kinds of build types ('debug', 'release'). We will have 2 ('version') * 3 ('abi') * 2 ('build types') = 12 kinds of build variants.

|      |      | debug           | release           |
|------|------|-----------------|-------------------|
| free | arm  | free-arm-debug  | free-arm-release  |
| free | x86  | free-x86-debug  | free-x86-release  |
| free | mips | free-mips-debug | free-mips-release |
| paid | arm  | paid-arm-debug  | paid-arm-release  |
| paid | x86  | paid-x86-debug  | paid-x86-release  |
| paid | mips | paid-mips-debug | paid-mips-release |

##Combining sources
Assume we are building a application with **'debug'** build type and **'mips'** as 'abi' productFlavors and **'free'** as 'version' productFlavors.

####Source code
Combine all source codes in each folders to build
```
src/debug/java
src/free/java
src/mips/java
src/main/java
```

####Resources
**Overriding mechanisms**
```
src/debug/res (top)
src/free/res
src/mips/res
src/main/res (base)
```

####Signing configuration
**Priority Order**
```
android.buildTypes.debug.signingConfig (top)
android.productFlavors.free.signingConfig
android.productFlavors.mips.signingConfig
android.defaultConfig.signingConfig (base)
```

####Package Name
**Overriding mechanisms + Suffix**
```
android.productFlavors.free.packageName (top)
android.productFlavors.mips.packageName
android.defaultConfig.packageName
src/main/AndroidMenifest.xml (base)

+ android.buildTypes.debug.applicationIdSuffix
```

####Testing
Source Sets
```
src/androidTest
src/androidTestFree
src/androidTestMips
```

Dependencies
```java
dependencies {
   androidTestCompile "org.robolectric:robolectric:3.0"
   androidTestFreeCompile "org.robolectric:robolectric:3.0"
   androidTestMipsCompile "org.robolectric:robolectric:3.0"
}
```

##Using Java 7

With Android KitKat (buildToolsVersion 19) you can use the diamond operator, multi-catch, strings in switches, try with resources, etc. To do this, add the following to your build file:
```java
android {
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_7
        targetCompatibility JavaVersion.VERSION_1_7
    }
}
```

## Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : https://www.thefinestartist.com
```

####Tested Version
```
Android Studio: 1.2.11
Gradle: 1.2.2
```
