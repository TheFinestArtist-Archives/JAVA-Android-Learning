#Introduction to Gradle

**This post is for the developers who just started using Gradle.**


###Build automation?
[Build automation](http://en.wikipedia.org/wiki/Build_automation) is the act of scripting or automating a wide variety of tasks that software developers do in their day-to-day activities including things like:

   * compiling computer source code into binary code
   * packaging binary code
   * running automated tests
   * deploying to production systems
   * creating documentation and/or release notes

###Gradle?

   * [Gradle](https://gradle.org/) is a build automation tool that combines [Ant](http://en.wikipedia.org/wiki/Apache_Ant)'s power and flexibility with [Maven](http://en.wikipedia.org/wiki/Apache_Maven)'s build life cycle and dependency management conventions into a more effective way to build.
   * Gradle has it's own [domain-specific language (DSL)](http://en.wikipedia.org/wiki/Domain-specific_language) based on [Groovy](http://groovy-lang.org/) instead of the more traditional XML form of declaring the project configuration.
   * Google adopted Gradle as the default build tool for the Android OS.
￼

###Why Gradle? (Gradle v/s Maven v/s Ant)

Build automation tool are consists of two main parts: configuration and build. Configuration is static information about the build such as build scripts and build is dynamic action.
   * Gradle uses Groovy DSL for it's configuration and Groovy language for customizing it's build.
   * Maven is focused on configuration, hard to customize.
   * Ant is focused on build, hard to configure.

####Gradle build scripts
   * Gradle build scripts tend to be much shorter and clearer than those written for Maven or Ant.
      * Gradle (build.gradle)
      ```
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
      ```

      * Maven (pom.xml)
      ```
      <!--[pom.xml]-->
      <project xmlns="http://maven.apache.org/POM/4.0.0"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                 http://maven.apache.org/maven-v4_0_0.xsd">
         <modelVersion>4.0.0</modelVersion>
         <groupId>com.technologyconversations</groupId>
         <artifactId>java-build-tools</artifactId>
         <packaging>jar</packaging>
         <version>1.0</version>
         <dependencies>
            <dependency>
               <groupId>junit</groupId>
               <artifactId>junit</artifactId>
               <version>4.11</version>
            </dependency>
            <dependency>
               <groupId>org.hamcrest</groupId>
               <artifactId>hamcrest-all</artifactId>
               <version>1.3</version>
            </dependency>
         </dependencies>
         <build>
            <plugins>
               <plugin>
                  <groupId>org.apache.maven.plugins</groupId>
                  <artifactId>maven-compiler-plugin</artifactId>
                  <version>2.3.2</version>
               </plugin>
            </plugins>
         </build>
      </project>
      ```
      * Ant (build.xml) with Ivy (ivy.xml)
      ```
      <!--[ivy.xml]-->
      <ivy-module version="2.0">
         <info organisation="org.apache" module="java-build-tools"/>
         <dependencies>
            <dependency org="junit" name="junit" rev="4.11"/>
            <dependency org="org.hamcrest" name="hamcrest-all" rev="1.3"/>
         </dependencies>
      </ivy-module>

      <!--[build.xml]-->
      <project xmlns:ivy="antlib:org.apache.ivy.ant" name="java-build-tools" default="jar">

         <property name="src.dir" value="src"/>
         <property name="build.dir" value="build"/>
         <property name="classes.dir" value="${build.dir}/classes"/>
         <property name="jar.dir" value="${build.dir}/jar"/>
         <property name="lib.dir" value="lib" />
         <path id="lib.path.id">
            <fileset dir="${lib.dir}" />
         </path>

         <target name="resolve">
            <ivy:retrieve />
         </target>

         <target name="clean">
            <delete dir="${build.dir}"/>
         </target>

         <target name="compile" depends="resolve">
            <mkdir dir="${classes.dir}"/>
            <javac srcdir="${src.dir}" destdir="${classes.dir}" classpathref="lib.path.id"/>
         </target>

         <target name="jar" depends="compile">
            <mkdir dir="${jar.dir}"/>
            <jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}"/>
         </target>
      </project>
      ```

###What is Gradle Wrapper?

###How is the folder structured?

###What is setting.gradle, build.gradle, local.properties, gradle.properties?

###How the build.gradle structured?

###Integrating some open sources?
####Android Support Packages
####Realm
####Crashlytics

###Customisation Gradle Settings
####Version Name Suffix
####https://www.youtube.com/watch?t=608&v=LCJAgPkpmR0

###What is repositories and why there is so many repositories?

###What is difference between jcenter, maven, mavenCentral, etc?

###Library Module Setting

###Testing

### Test Version
    Android Studio Version: 1.2.11
    Gradle Version: 1.2.2

### Author
    FullName : Leonardo Taehwan Kim
    Username : The Finest Artist
    Email    : contact@thefinestartist.com
    Website  : https://www.thefinestartist.com
