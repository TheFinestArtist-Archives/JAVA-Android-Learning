#Dagger

##Dependency
Whenever a class A uses another class or interface B, then A depends on B. A cannot carry out it's work without B, and A cannot be reused without also reusing B. In such a situation the class A is called the "dependant" and the class or interface B is called the "dependency". A dependant depends on its dependencies.

Two classes that uses each other are called "coupled". The coupling between classes can be loose or tight, or somewhere in between. The tightness of a coupling is not binary. It is not either "loose" or "tight". The degrees of tightness are continuous, not discrete. You can also characterize dependencies as "strong" or "weak". A tight coupling leads to strong dependencies, and a loose coupling leads to weak dependencies, or even no dependencies in some situations.

Dependencies, or couplings, are directional. That A depends on B doesn't mean that B also depends on A.

```java
public class Manager {
   private final Worker worker;

   public Manager(){
      worker = new Worker();
   }

   public void work() {
      // do something...
      worker.work();
      // do something...
   }
}
```
####Dependencies are dangerous
* Whenever we create an object of ClassA, object of ClassB automatically created
* We necessarily need to modify the code of the coupled module
* Hard to make test classes

##Dependency inversion
High level modules should not depend upon low-level modules. Both should depend upon abstractions.  
Abstractions should never depend upon details. Details should depend upon abstractions.
```java
public class Manager {
   private final Worker worker;

   public Manager(Worker worker){
      this.worker = worker;
   }

   public void work() {
      // do something...
      worker.work();
      // do something...
   }
}
```


##Dependency Injector
Dependency injection is a style of object configuration in which an objects fields and collaborators are set by an external entity. In other words objects are configured by an external entity. Dependency injection is an alternative to having the object configure itself.

Dependency injection is a software design pattern that implements inversion of control for software libraries. Caller delegates to an external framework the control flow of discovering and importing a service or software module specified or "injected" by the caller. Dependency injection allows a program design to follow the dependency inversion principle where modules are loosely coupled. With dependency injection, the client which uses a module or service doesn't need to know all its details, and typically the module can be replaced by another one of similar characteristics without altering the client.

It consists of passing dependencies (inject them) via constructor in order to extract the task of creating modules out from other modules. Objects are instantiated somewhere else and passed as constructor attributes when creating the current object.

##Directed Acyclic Graph
![](https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Directed_acyclic_graph_3.svg/356px-Directed_acyclic_graph_3.svg.png)  
Directed Acyclic Graph is a directed graph with no directed cycles. That is, it is formed by a collection of vertices and directed edges, each edge connecting one vertex to another, such that there is no way to start at some vertex v and follow a sequence of edges that eventually loops back to v again.

Dependency graph in programming is always directed acyclic. So Dagger is named after DAG(Directed Acyclic Graph).

##Dagger
**A fast dependency injector for Android and Java**

###Why Dagger?

###How to use?
**build.gradle**
```java
dependencies {
    // ...other dependencies
    compile 'com.squareup.dagger:dagger:1.2.+'
    provided 'com.squareup.dagger:dagger-compiler:1.2.+'
}
```

###Annotations
**@Module**

**@Provides**

**@Singleton**

**@Inject**

####ObjectGraph

###Example
*You can find whole source code from [here](https://github.com/TheFinestArtist/Dagger1-Example)*  

**NetworkModule**
```java
public class OkHttpClient {
    @Inject public OkHttpClient() {}
}

public class TwitterApi {
    private final OkHttpClient okHttpClient;

    @Inject public TwitterApi(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void post(String userane, String message) {...}

    public List<Tweet> load(String username, int amount) {...}
}

@Module(
        library = true
)
public class NetworkModule {

    @Provides @Singleton public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides @Singleton public TwitterApi provideTwitterApi(OkHttpClient okHttpClient) {
        return new TwitterApi(okHttpClient);
    }
}
```

**TwitterModule**
```java
public class Tweeter {

    private final TwitterApi twitterApi;
    private final String username;

    @Inject
    public Tweeter(TwitterApi twitterApi, String username) {
        this.twitterApi = twitterApi;
        this.username = username;
    }

    public void tweet(String message) {
        twitterApi.post(username, message);
    }
}

public class Timeline {

    private final TwitterApi twitterApi;
    private final String username;

    @Inject public Timeline(TwitterApi twitterApi, String username) {
        this.twitterApi = twitterApi;
        this.username = username;
    }

    public List<Tweet> get() {...}

    public void loadMore(int amount) {...}
}

@Module(
        library = true,
        injects = {
                MainActivity.class
        }
)
public class TwitterModule {

    private final String username;

    public TwitterModule(String username) {
        this.username = username;
    }

    @Provides @Singleton Tweeter provideTwitter(TwitterApi twitterApi) {
        return new Tweeter(twitterApi, username);
    }

    @Provides @Singleton Timeline provideTimeline(TwitterApi twitterApi) {
        return new Timeline(twitterApi, username);
    }
}
```

**ObjectGraph**
```java
public class BaseApplication extends Application {

    private ObjectGraph objectGraph;

    @Override public void onCreate(){
        super.onCreate();
        objectGraph = ObjectGraph.create(new NetworkModule());
    }

    public ObjectGraph getObjectGraph(){
        return objectGraph;
    }
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject Tweeter tweeter;
    @Inject Timeline timeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...do something
        BaseApplication app = (BaseApplication) getApplication();
        ObjectGraph og = app.getObjectGraph();
        og.plus(new TwitterModule("TheFinestArtist")).inject(this);
        tweeter.tweet("Hello");
    }

    @Override
    public void onClick(View v) {
        timeline.loadMore(20);
        // ...do something
    }
}
```


##Dagger2

###Annotations
**@Component**
**@Subcomponent**

####Lazy

###How to use?
**Top-level build.gradle**
```java
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.2.3'
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.4'
    }
}

allprojects {
    repositories {
        // ...other repositories
        maven{
            url 'https://oss.sonatype.org/content/repositories/snapshots/'
        }
    }
}
```
**build.gradle**
```java
apply plugin: 'com.neenbedankt.android-apt'

dependencies {
    compile 'com.google.dagger:dagger:2.+'
    apt "com.google.dagger:dagger-compiler:2.+"
    provided 'javax.annotation:jsr250-api:1.0'
}
```

###Example
*You can find whole source code from [here](https://github.com/TheFinestArtist/Dagger2-Example)*  

**NetworkModule**
```java
public class OkHttpClient {
    @Inject public OkHttpClient() {}
}

public class TwitterApi {

    private final OkHttpClient okHttpClient;

    @Inject public TwitterApi(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void post(String userane, String message) {...}

    public List<Tweet> load(String username, int amount) {...}
}

@Module
public class NetworkModule {

    @Provides @Singleton public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides @Singleton public TwitterApi provoideTwitterApi(OkHttpClient okHttpClient) {
        return new TwitterApi(okHttpClient);
    }
}
```
**TwitterModule**
```java
public class Tweeter {

    private final TwitterApi twitterApi;
    private final String username;

    @Inject public Tweeter(TwitterApi twitterApi, String username) {
        this.twitterApi = twitterApi;
        this.username = username;
    }

    public void tweet(String message) {
        twitterApi.post(username, message);
    }
}

public class Timeline {

   private final TwitterApi twitterApi;
   private final String username;

   @Inject public Timeline(TwitterApi twitterApi, String username) {
      this.twitterApi = twitterApi;
      this.username = username;
   }

   public List<Tweet> get() {...}

   public void loadMore(int amount) {...}
}

@Module
public class TwitterModule {

    private final String username;

    public TwitterModule(String username) {
        this.username = username;
    }

    @Provides @Singleton Tweeter provideTwitter(TwitterApi twitterApi) {
        return new Tweeter(twitterApi, username);
    }

    @Provides @Singleton Timeline provideTimeline(TwitterApi twitterApi) {
        return new Timeline(twitterApi, username);
    }
}
```
**TwitterComponent**
```java
@Singleton @Component(modules = {TwitterModule.class})
public interface TwitterComponent {
    Tweeter tweeter();
    Timeline timeline();
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Tweeter tweeter;
    Timeline timeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...do something
        TwitterComponent twitterComponent = DaggerTwitterComponent.builder()
                .twitterModule(new TwitterModule("TheFinestArtist"))
                .build();

        tweeter = twitterComponent.tweeter();
        timeline = twitterComponent.timeline();

        tweeter.tweet("Hello");
    }

    @Override
    public void onClick(View v) {
        timeline.loadMore(20);
        // ...do something
    }
}
```

##Any tradeoffs?

##Dagger with Realm

## Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : https://www.thefinestartist.com
```
