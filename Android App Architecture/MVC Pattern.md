#MVC Pattern

Model–view–controller (MVC) is a software architectural pattern for implementing user interfaces. It divides a given software application into three interconnected parts, so as to separate internal representations of information from the ways that information is presented to or accepted from the user.

**Controller**  
Send commands to the model to update the model's state (e.g., editing a document). It can also send commands to its associated view to change the view's presentation of the model (e.g., by scrolling through a document).  

**Model**  
Stores data that is retrieved by the controller and displayed in the view. Whenever there is a change to the data it is updated by the controller.  

**View**  
Requests information from the model that it uses to generate an output representation to the user.  


##Interactions
![](http://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/MVC-Process.svg/200px-MVC-Process.svg.png)

###Controller -> Model
Whenever user interaction occurs, controller will take care if this. It will receives these interactions by callbacks such as ```OnClicked()``` or ```OnTextUpdated()```. And if these interactions is related to updating model, controller also takes care of it. It will update the data by calling setters such as ```user.setEmail("contact@thefinestartist.com")```.

###Model -> View
Model and View uses **Observer Pattern**. There is two kind of class helping this relation. One is Observer and another is Observable. As you can see from it's naming, Observer is a kind of callback and Observable is a class which every model should extends and notify to their observer whenever the data has been changed.  

Here shows simple Java code of Observer and Observable.
```
public interface Observer {
   void update(Observable o, Object object);
}

public class Observable {

   // Constructor
   public Observable() {...}

   public synchronized void addObserver(Observer o) {...}
   public synchronized void deleteObserver(Observer o) {...}

   public void notifyObservers() {...}
   public void notifyObservers(Object arg) {...}
}
```

Theoretically every model should extends Observable like this
```
public class User extends Observable {

   private String email;

   public void setEmail(String email) {
      this.email = email;
      notifyObservers(this);
   }
}
```

And the view will add their Observer to related models and receives updates from it.
```
public class EmailTextView implements Observer {

   // implements methods
   void update(Observable o, Object object) {
      setText(((User)object).getEmail());
   }
}
```

##MVC in Android
Android suggests many pre-defined classes such as Activity, Fragment, Service, SharedPreference, SQLiteDatabase, ContentProvider and so on. We can match each classes into Model, View or Controller. We can assume Activity and Fragment as a View, Service as a Controller and SharedPreference, SQLiteDatabase or ContentProvider as Model.  
Here shows simple example how you can uses these component in MVC pattern.

```
asdf
```

##MVC with Realm
How does Realm fit into these kind of architectures?
No

Are there any pitfalls?
How are we going to set Observer to the RealmObjects?

##Testing
Testing

##Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : https://www.thefinestartist.com
```
