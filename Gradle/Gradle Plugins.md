#Gradle Plugins

####How to write custom Gradle Plugin

##Build Scripts

####Gradle Task
A Task represents a single atomic piece of work for a build, such as compiling some classes, creating a JAR, generating Javadoc, or publishing some archives to a repository.

####How to run build.gradle
Gradle uses gradle command and ```-q``` to suppress Gradle's log messages. ```taskName``` for the task name.
```
> gradle -q taskName
```

####Basic Examples
```
// Output: Hello world!
task hello {
    doLast {
        println 'Hello world!'
    }
}

// Output: Hello world!
hello.doLast {
    println "Hello world!"
}

// Output: Hello world!
// The << operator is simply an alias for doLast
task hello << {
    println 'Hello world!'
}

// Output: Original: mY_nAmE
           Upper case: MY_NAME
task upper << {
    String someString = 'mY_nAmE'
    println "Original: " + someString
    println "Upper case: " + someString.toUpperCase()
}

// Output: 0 1 2 3
task count << {
    4.times { print "$it " }
}
```

####Task dependencies
You can declare tasks that depend on other tasks. (i.e. If task A is depend on task B, task B have to run before task A runs.)
```
// Output: Hello world!
           I'm Gradle
task hello << {
    println 'Hello world!'
}
task intro(dependsOn: hello) << {
    println "I'm Gradle"
}

// Lazy dependsOn
task intro(dependsOn: 'hello') << {
    println "I'm Gradle"
}
task hello << {
    println 'Hello world!'
}
```

####Dynamic tasks
You can also use it to dynamically create tasks
```
// Output of gradle -q task1: I'm task number 1
// Output of gradle -q task2: I'm task number 2
4.times { counter ->
    task "task$counter" << {
        println "I'm task number $counter"
    }
}
```

####Manipulating existing tasks
```
// Output of gradle -q task0: I'm task number 2
//                            I'm task number 3
//                            I'm task number 0
4.times { counter ->
    task "task$counter" << {
        println "I'm task number $counter"
    }
}
task0.dependsOn task2, task3
```

####Extra task properties
You can add your own properties to a task. To add a property named myProperty, set ext.myProperty to an initial value. From that point on, the property can be read and set like a predefined task property.
```
// Output: myValue
task myTask {
    ext.myProperty = "myValue"
}

task printTaskProperties << {
    println myTask.myProperty
}
```

####Default tasks
Gradle allows you to define one or more default tasks for your build.
```
// Output: Default Cleaning!
           Default Running!
defaultTasks 'clean', 'run'

task clean << {
    println 'Default Cleaning!'
}

task run << {
    println 'Default Running!'
}

task other << {
    println "I'm not a default task!"
}
```

##Writing Custom Plugins

####Writing a simple plugin
To create a custom plugin, you need to write an implementation of Plugin. Gradle instantiates the plugin and calls the plugin instance's Plugin.apply() method when the plugin is used with a project. The project object is passed as a parameter, which the plugin can use to configure the project however it needs to. The following sample contains a greeting plugin, which adds a hello task to the project.
```
apply plugin: GreetingPlugin

class GreetingPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('hello') << {
            println "Hello from the GreetingPlugin"
        }
    }
}
```

####Getting input from the build
Most plugins need to obtain some configuration from the build script. One method for doing this is to use extension objects. The Gradle Project has an associated ExtensionContainer object that helps keep track of all the settings and properties being passed to plugins. You can capture user input by telling the extension container about your plugin. To capture input, simply add a Java Bean compliant class into the extension container's list of extensions. Groovy is a good language choice for a plugin because plain old Groovy objects contain all the getter and setter methods that a Java Bean requires.
```
apply plugin: GreetingPlugin

greeting.message = 'Hi from Gradle'

class GreetingPlugin implements Plugin<Project> {
    void apply(Project project) {
        // Add the 'greeting' extension object
        project.extensions.create("greeting", GreetingPluginExtension)
        // Add a task that uses the configuration
        project.task('hello') << {
            println project.greeting.message
        }
    }
}

class GreetingPluginExtension {
    def String message = 'Hello from GreetingPlugin'
}
```

In this example, GreetingPluginExtension is a plain old Groovy object with a field called message. The extension object is added to the plugin list with the name greeting. This object then becomes available as a project property with the same name as the extension object.

Oftentimes, you have several related properties you need to specify on a single plugin. Gradle adds a configuration closure block for each extension object, so you can group settings together. The following example shows you how this works.
```
apply plugin: GreetingPlugin

greeting {
    message = 'Hi'
    greeter = 'Gradle'
}

class GreetingPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("greeting", GreetingPluginExtension)
        project.task('hello') << {
            println "${project.greeting.message} from ${project.greeting.greeter}"
        }
    }
}

class GreetingPluginExtension {
    String message
    String greeter
}
```

####Working with files in custom tasks and plugins
When developing custom tasks and plugins, it's a good idea to be very flexible when accepting input configuration for file locations. To do this, you can leverage the Project.file() method to resolve values to files as late as possible.

```
class GreetingToFileTask extends DefaultTask {

    def destination

    File getDestination() {
        project.file(destination)
    }

    @TaskAction
    def greet() {
        def file = getDestination()
        file.parentFile.mkdirs()
        file.write "Hello!"
    }
}

task greet(type: GreetingToFileTask) {
    destination = { project.greetingFile }
}

task sayGreeting(dependsOn: greet) << {
    println file(greetingFile).text
}

ext.greetingFile = "$buildDir/hello.txt"
```


## Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : https://www.thefinestartist.com
```
