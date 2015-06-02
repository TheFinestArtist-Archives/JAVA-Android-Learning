#Gradle Plugins

####How to write custom Gradle Plugin

##Build Scripts

####How to run build.gradle
Gradle uses gradle as command name and ```-q``` to suppress Gradle's log messages. ```taskName``` for the task name.
```
> gradle -q taskName
```

####Appetite Examples
```
task hello {
    doLast {
        println 'Hello world!'
    }
}

task upper << {
    String someString = 'mY_nAmE'
    println "Original: " + someString
    println "Upper case: " + someString.toUpperCase()
}

task count << {
    4.times { print "$it " }
}
```
