# Introduction to Gradle

#### Basic introduction about Gradle

## Build automation?
[Build automation](http://en.wikipedia.org/wiki/Build_automation) is the act of scripting or automating a wide variety of tasks that software developers do in their day-to-day activities including things like:

   * compiling computer source code into binary code
   * packaging binary code
   * running automated tests
   * deploying to production systems
   * creating documentation and/or release notes


## Gradle?

   * [Gradle](https://gradle.org/) is a build automation tool that combines [Ant](http://en.wikipedia.org/wiki/Apache_Ant)'s power and flexibility with [Maven](http://en.wikipedia.org/wiki/Apache_Maven)'s build life cycle and dependency management conventions into a more effective way to build.
   * Gradle has it's own [domain-specific language (DSL)](http://en.wikipedia.org/wiki/Domain-specific_language) based on [Groovy](http://groovy-lang.org/) instead of the more traditional XML form of declaring the project configuration.
   * Google adopted Gradle as the default build tool for the Android OS.
￼

## Why Gradle? (Gradle v/s Maven v/s Ant)

Build automation tool are consists of two main parts: configuration and build. Configuration is static information about the build such as build scripts and build is dynamic part which actual action happens.
   * Gradle uses Groovy DSL for it's configuration and Groovy language for customizing it's build.
   * Maven is focused on configuration, hard to customize.
   * Ant is focused on build, hard to configure.

**Gradle build scripts tend to be much shorter and clearer** than those written for Maven or Ant.

   * Gradle (build.gradle)
   <pre class="prettyprint">
   // build.gradle
   apply plugin: 'java'
   apply plugin: 'checkstyle'
   apply plugin: 'findbugs'
   apply plugin: 'pmd'

   version = '1.0'

   repositories {
       mavenCentral()
   }

   dependencies {
       testCompile group: 'junit', name: 'junit', version: '4.11'
       testCompile group: 'org.hamcrest', name: 'hamcrest-all', version: '1.3'
   }
   </pre>

   * Maven (pom.xml)
   <pre class="prettyprint">
   &lt;!--[pom.xml]--&gt;
   &lt;project xmlns="http://maven.apache.org/POM/4.0.0"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
              http://maven.apache.org/maven-v4_0_0.xsd"&gt;
      &lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;
      &lt;groupId&gt;com.technologyconversations&lt;/groupId&gt;
      &lt;artifactId&gt;java-build-tools&lt;/artifactId&gt;
      &lt;packaging&gt;jar&lt;/packaging&gt;
      &lt;version&gt;1.0&lt;/version&gt;
      &lt;dependencies&gt;
         &lt;dependency&gt;
            &lt;groupId&gt;junit&lt;/groupId&gt;
            &lt;artifactId&gt;junit&lt;/artifactId&gt;
            &lt;version&gt;4.11&lt;/version&gt;
         &lt;/dependency&gt;
         &lt;dependency&gt;
            &lt;groupId&gt;org.hamcrest&lt;/groupId&gt;
            &lt;artifactId&gt;hamcrest-all&lt;/artifactId&gt;
            &lt;version&gt;1.3&lt;/version&gt;
         &lt;/dependency&gt;
      &lt;/dependencies&gt;
      &lt;build&gt;
         &lt;plugins&gt;
            &lt;plugin&gt;
               &lt;groupId&gt;org.apache.maven.plugins&lt;/groupId&gt;
               &lt;artifactId&gt;maven-compiler-plugin&lt;/artifactId&gt;
               &lt;version&gt;2.3.2&lt;/version&gt;
            &lt;/plugin&gt;
         &lt;/plugins&gt;
      &lt;/build&gt;
   &lt;/project&gt;
   </pre>

   * Ant (build.xml) with Ivy (ivy.xml)
   <pre class="prettyprint">
   &lt;!--[ivy.xml]--&gt;
   &lt;ivy-module version="2.0"&gt;
      &lt;info organisation="org.apache" module="java-build-tools"/&gt;
      &lt;dependencies&gt;
         &lt;dependency org="junit" name="junit" rev="4.11"/&gt;
         &lt;dependency org="org.hamcrest" name="hamcrest-all" rev="1.3"/&gt;
      &lt;/dependencies&gt;
   &lt;/ivy-module&gt;

   &lt;!--[build.xml]--&gt;
   &lt;project xmlns:ivy="antlib:org.apache.ivy.ant" name="java-build-tools" default="jar"&gt;

      &lt;property name="src.dir" value="src"/&gt;
      &lt;property name="build.dir" value="build"/&gt;
      &lt;property name="classes.dir" value="${build.dir}/classes"/&gt;
      &lt;property name="jar.dir" value="${build.dir}/jar"/&gt;
      &lt;property name="lib.dir" value="lib" /&gt;
      &lt;path id="lib.path.id"&gt;
         &lt;fileset dir="${lib.dir}" /&gt;
      &lt;/path&gt;

      &lt;target name="resolve"&gt;
         &lt;ivy:retrieve /&gt;
      &lt;/target&gt;

      &lt;target name="clean"&gt;
         &lt;delete dir="${build.dir}"/&gt;
      &lt;/target&gt;

      &lt;target name="compile" depends="resolve"&gt;
         &lt;mkdir dir="${classes.dir}"/&gt;
         &lt;javac srcdir="${src.dir}" destdir="${classes.dir}" classpathref="lib.path.id"/&gt;
      &lt;/target&gt;

      &lt;target name="jar" depends="compile"&gt;
         &lt;mkdir dir="${jar.dir}"/&gt;
         &lt;jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}"/&gt;
      &lt;/target&gt;
   &lt;/project&gt;
   </pre>

**[Gradle's compelling features](http://www.drdobbs.com/jvm/why-build-your-java-projects-with-gradle/240168608)**

   * Expensive build language and deep API
   * Gradle is Groovy
   * Flexible conventions
   * Robust and powerful dependency management
   * Scalable builds
   * Effortless extendibility
   * Integration with other build tool
   * Community-driven and company-backend


## How to install Gradle?
   * https://docs.gradle.org/current/userguide/installation.html
      1. Download 'Complete distribution' or 'Binary only distribution' from http://gradle.org/downloads/ and unpack it.
      2. Create an environment variable GRADLE_HOME where your 'gradle-x.x' is located.
      3. Add GRADLE_HOME/bin to your PATH environment variable.
      4. Verify if Gradle set up properly with simple command <code id="inline">gradle -v</code>.

*Gradle is shipped in Android Studio. No external installation is required if you are using Android Studio.*


## Groovy?
It's hard to discuss Gradle without Groovy language. [Groovy](goo.gl/rQ0WkW) is object-oriented programming language and also is a dynamic language and scripting language for JAVA platform. Gradle choose Groovy for it's language because of two main [reasons](https://docs.gradle.org/current/userguide/overview.html#sec:why_groovy):
   * The advantages of an internal DSL
   * Groovy is similar with JAVA
      * Highest transparency and lowest learning curve especially for developers who are familiar with JAVA

## Gradle Wrapper?
[Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) is the preferred way of starting a Gradle build. The wrapper is a batch script on Windows, and a shell script for other operating systems. When you start a Gradle build via the wrapper, Gradle will be automatically downloaded and used to run the build.

## Author
<pre class="prettyprint">
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : http://www.thefinestartist.com
</pre>
