#MVC Pattern

Model–view–controller (MVC) is a software architectural pattern for implementing user interfaces. It divides a given software application into three interconnected parts, so as to separate internal representations of information from the ways that information is presented to or accepted from the user.  

**Model**  
Stores data that is retrieved by the controller and displayed in the view. Whenever there is a change to the data it is updated by the controller.  

**View**  
Requests information from the model that it uses to generate an output representation to the user.  

**Controller**  
Send commands to the model to update the model's state (e.g., editing a document). It can also send commands to its associated view to change the view's presentation of the model (e.g., by scrolling through a document).  


##Diagram
![](http://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/MVC-Process.svg/200px-MVC-Process.svg.png)

###User -> Controller
Handles by simple event listeners.
```
fullName.addTextChangedListener(new TextWatcher() {
   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
       user.setFullName(String.valueOf(fullName.getText()));
   }
});
```

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
      setChanged();
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

###View -> User
Users can see the views from their phone screen.


##MVC in Android
Android suggests many pre-defined classes such as Activity, Fragment, Service, SharedPreference, SQLiteDatabase, ContentProvider and so on. We can match each classes into Model, View or Controller. We can assume Activity and Fragment as a View, Service as a Controller and SharedPreference, SQLiteDatabase or ContentProvider as Model.  

Here shows simple example how you can uses these component in MVC pattern. [Github](https://github.com/TheFinestArtist/MVC-Example)

```
// Model
public class User extends Observable {

    private String fullName;
    private String email;

    public void setEmail(String email) {
        this.email = email;
        updateViews();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        updateViews();
    }

    @Override
    public String toString() {
        return "FullName : " + fullName + "\nEmail : " + email;
    }

    private void updateViews() {
        setChanged();
        notifyObservers(this);
    }
}

// View
public class UserInfoTextView extends TextView implements Observer {

    public UserInfoTextView(Context context) {
        super(context, null);
    }

    public UserInfoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UserInfoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void update(Observable observable, Object data) {
        if (data instanceof User)
            setText(data.toString());
    }
}

// Controller
public class MainActivity extends AppCompatActivity {

    User user;
    UserInfoTextView userInfoTextView;
    EditText fullName;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInfoTextView = (UserInfoTextView) findViewById(R.id.userInfo);
        fullName = (EditText) findViewById(R.id.fullName);
        email = (EditText) findViewById(R.id.email);

        user  = new User();
        user.addObserver(userInfoTextView);

        fullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setFullName(String.valueOf(fullName.getText()));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setEmail(String.valueOf(email.getText()));

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
```


##Conclusion
Original MVC Pattern is not appropriate design pattern for Android in such reasons.

1. Activity and Fragment is not exactly a controller.
   * Activity and Fragment is a kind of controller which has View life cycle in it. So, some developer makes controller class for Activity or Fragment (i.e. MainController for MainActivity). Sometimes, it is useful way but mostly it is a very redundant work and makes file structure complicated and also has maintenance issue. And also exact concept for these kinds of controllers are actually called **Presenter**.

2. Letting model to update view can cause serious problems.
   * Thread Handling
      Only UIThread can update views in Android, but model usually updates in background thread.
   * Listeners
      There can be many kinds of Views subscribing or listening to one model such as ```User``` or ```Post```. It is really difficult to know which view should be updated whenever each model has been updated.

3. Views are very flexible which means they are created many times and also destroyed many times.
   * Handling listeners or observers whenever each views are created or destroyed are very complicated and also sophisticated work.

4. Each view has to implements observer. So you have to make custom views to implements observer.


##Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : https://www.thefinestartist.com
```
