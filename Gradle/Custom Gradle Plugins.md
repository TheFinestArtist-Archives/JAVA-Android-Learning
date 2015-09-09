# Custom Gradle Plugins

#### How to write Custom Gradle Plugin

## Build Scripts

#### Gradle Task
A Task represents a single atomic piece of work for a build, such as compiling some classes, creating a JAR, generating Javadoc, or publishing some archives to a repository.

#### How to run build.gradle
Gradle uses gradle command and <code id="inline">-q</code> to suppress Gradle's log messages. <code id="inline">taskName</code> for the task name.
<pre class="prettyprint">
&gt; gradle -q taskName
</pre>

#### Basic Examples
<pre class="prettyprint">
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
// The &lt;&lt; operator is simply an alias for doLast
task hello &lt;&lt; {
    println 'Hello world!'
}

// Output: Original: mY_nAmE
           Upper case: MY_NAME
task upper &lt;&lt; {
    String someString = 'mY_nAmE'
    println "Original: " + someString
    println "Upper case: " + someString.toUpperCase()
}

// Output: 0 1 2 3
task count &lt;&lt; {
    4.times { print "$it " }
}
</pre>

#### Task dependencies
You can declare tasks that depend on other tasks. (i.e. If task A is depend on task B, task B have to run before task A runs.)
<pre class="prettyprint">
// Output: Hello world!
           I'm Gradle
task hello &lt;/pre&gt;&lt; {
    println 'Hello world!'
}
task intro(dependsOn: hello) &lt;&lt; {
    println "I'm Gradle"
}

// Lazy dependsOn
task intro(dependsOn: 'hello') &lt;&lt; {
    println "I'm Gradle"
}
task hello &lt;&lt; {
    println 'Hello world!'
}
</pre>

#### Dynamic tasks
You can also use it to dynamically create tasks
<pre class="prettyprint">
// Output of gradle -q task1: I'm task number 1
// Output of gradle -q task2: I'm task number 2
4.times { counter -&gt;
    task "task$counter" &lt;&lt; {
        println "I'm task number $counter"
    }
}
</pre>

#### Manipulating existing tasks
<pre class="prettyprint">
// Output of gradle -q task0: I'm task number 2
//                            I'm task number 3
//                            I'm task number 0
4.times { counter -&gt;
    task "task$counter" &lt;&lt; {
        println "I'm task number $counter"
    }
}
task0.dependsOn task2, task3
</pre>

#### Extra task properties
You can add your own properties to a task. To add a property named myProperty, set ext.myProperty to an initial value. From that point on, the property can be read and set like a predefined task property.
<pre class="prettyprint">
// Output: myValue
task myTask {
    ext.myProperty = "myValue"
}

task printTaskProperties &lt;&lt; {
    println myTask.myProperty
}
</pre>

#### Default tasks
Gradle allows you to define one or more default tasks for your build.
<pre class="prettyprint">
// Output: Default Cleaning!
           Default Running!
defaultTasks 'clean', 'run'

task clean &lt;&lt; {
    println 'Default Cleaning!'
}

task run &lt;&lt; {
    println 'Default Running!'
}

task other &lt;&lt; {
    println "I'm not a default task!"
}
</pre>

## Writing Custom Plugins
A Gradle plugin packages up reusable pieces of build logic, which can be used across many different projects and builds. Gradle allows you to implement your own custom plugins, so you can reuse your build logic, and share it with others.

You can implement a custom plugin in any language you like, provided the implementation ends up compiled as bytecode. For the examples here, we are going to use Groovy as the implementation language. You could use Java or Scala instead, if you want.


#### Writing a simple plugin
To create a custom plugin, you need to write an implementation of Plugin. Gradle instantiates the plugin and calls the plugin instance's Plugin.apply() method when the plugin is used with a project. The project object is passed as a parameter, which the plugin can use to configure the project however it needs to. The following sample contains a greeting plugin, which adds a hello task to the project.
<pre class="prettyprint">
apply plugin: GreetingPlugin

class GreetingPlugin implements Plugin&lt;Project&gt; {
    void apply(Project project) {
        project.task('hello') &lt;&lt; {
            println "Hello from the GreetingPlugin"
        }
    }
}
</pre>

#### Getting input from the build
Most plugins need to obtain some configuration from the build script. One method for doing this is to use extension objects. The Gradle Project has an associated ExtensionContainer object that helps keep track of all the settings and properties being passed to plugins. You can capture user input by telling the extension container about your plugin. To capture input, simply add a Java Bean compliant class into the extension container's list of extensions. Groovy is a good language choice for a plugin because plain old Groovy objects contain all the getter and setter methods that a Java Bean requires.
<pre class="prettyprint">
apply plugin: GreetingPlugin

greeting.message = 'Hi from Gradle'

class GreetingPlugin implements Plugin&lt;Project&gt; {
    void apply(Project project) {
        // Add the 'greeting' extension object
        project.extensions.create("greeting", GreetingPluginExtension)
        // Add a task that uses the configuration
        project.task('hello') &lt;&lt; {
            println project.greeting.message
        }
    }
}

class GreetingPluginExtension {
    def String message = 'Hello from GreetingPlugin'
}
</pre>

In this example, GreetingPluginExtension is a plain old Groovy object with a field called message. The extension object is added to the plugin list with the name greeting. This object then becomes available as a project property with the same name as the extension object.

Oftentimes, you have several related properties you need to specify on a single plugin. Gradle adds a configuration closure block for each extension object, so you can group settings together. The following example shows you how this works.
<pre class="prettyprint">
apply plugin: GreetingPlugin

greeting {
    message = 'Hi'
    greeter = 'Gradle'
}

class GreetingPlugin implements Plugin&lt;Project&gt; {
    void apply(Project project) {
        project.extensions.create("greeting", GreetingPluginExtension)
        project.task('hello') &lt;&lt; {
            println "${project.greeting.message} from ${project.greeting.greeter}"
        }
    }
}

class GreetingPluginExtension {
    String message
    String greeter
}
</pre>

#### Working with files in custom tasks and plugins
When developing custom tasks and plugins, it's a good idea to be very flexible when accepting input configuration for file locations. To do this, you can leverage the Project.file() method to resolve values to files as late as possible.

<pre class="prettyprint">
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

task sayGreeting(dependsOn: greet) &lt;&lt; {
    println file(greetingFile).text
}

ext.greetingFile = "$buildDir/hello.txt"
</pre>

## Author
<pre class="prettyprint">
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : http://www.thefinestartist.com
</pre>
