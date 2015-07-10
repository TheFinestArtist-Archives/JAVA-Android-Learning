#MVP Pattern
Model–view–presenter (MVP) is a derivation of the model–view–controller (MVC) architectural pattern, and is used mostly for building user interfaces.

**Presenter**  
In MVP the presenter assumes the functionality of the "middle-man". In MVP, all presentation logic is pushed to the presenter.  

**Controller v/s Presenter**  
* Controller
   * Listens to user action
   * Updates model and model updates view
* Presenter
   * Listens to user action and model updates
   * Updates model and view


##Diagram
![](http://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Model_View_Presenter_GUI_Design_Pattern.png/220px-Model_View_Presenter_GUI_Design_Pattern.png)

###View -> Presenter
This part is redundant with `User -> Controller` in MVC Pattern. Presenter handles users action by UI event listeners.
```java
fullName.addTextChangedListener(new TextWatcher() {
   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
      user.setFullName(String.valueOf(fullName.getText()));
   }
});
```

###Presenter -> View
Simply by calling methods to update views such as `setText()` or `setBackgroundColor()`.

###Model -> Presenter
Usually model is updated by calling network service Apis. Whenever data has been retrieved from server, you can notify model has been changed to Presenter by callbacks such as `OnDataRecieved()`.

###Presenter -> Model
This part is redundant with `Controller -> Model` in MVC Pattern. Presenter handles users user actions is related to updating model, controller also takes care of it. It will update the data by calling setters such as `user.setEmail("contact@thefinestartist.com")`.


##MVP in Android
Developer usually uses Activity or Fragment as a presenter but here shows a better way to distinguish between View and Presenter more strictly by making presenter class for each Activity and Fragment. This way Activity and Fragment only handles actions from User and updating views, therefore Activity and Fragment can concentrate on more Front-End work and Presenter actually handles other works except Front-End. This is an Android Application with same feature as the example in MVC Pattern. [Github](https://github.com/TheFinestArtist/MVP-Example)
```java
// Model
public class User {

   private String fullName;
   private String email;

   public void setEmail(String email) {
      this.email = email;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   @Override
   public String toString() {
      return "FullName : " + fullName + "\nEmail : " + email;
   }
}

// View
public class MainActivity extends AppCompatActivity implements MainPresenter.View {

   MainPresenter mainPresenter;

   TextView userInfoTextView;
   EditText fullName;
   EditText email;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      mainPresenter = new MainPresenter(this);

      userInfoTextView = (TextView) findViewById(R.id.userInfo);
      fullName = (EditText) findViewById(R.id.fullName);
      email = (EditText) findViewById(R.id.email);

      fullName.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {
         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
            mainPresenter.updateFullName(s.toString());
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
            mainPresenter.updateEmail(s.toString());
         }

         @Override
         public void afterTextChanged(Editable s) {
         }
      });
   }

   @Override
   public void updateUserInfoTextView(String info) {
   userInfoTextView.setText(info);
   }
}

// Presenter
public class MainPresenter {

   User user;
   View view;

   public MainPresenter(View view) {
      this.view = view;
      user  = new User();
   }

   public void updateFullName(String fullName) {
      user.setFullName(fullName);
      view.updateUserInfoTextView(user.toString());
   }

   public void updateEmail(String email) {
      user.setEmail(email);
      view.updateUserInfoTextView(user.toString());
   }

   public interface View {
      void updateUserInfoTextView(String info);
   }
}
```


##Other Android Examples follows MVP Pattern
https://github.com/antoniolg/androidmvp
https://github.com/pedrovgs/EffectiveAndroidUI


##MVP in iOS/OSX
Apple also suggests to follow [MVC Pattern](https://developer.apple.com/library/mac/documentation/General/Conceptual/DevPedia-CocoaCore/MVC.html) which is actually MVP Pattern, to their iOS/OSX developers.  

![](https://developer.apple.com/library/mac/documentation/General/Conceptual/DevPedia-CocoaCore/Art/model_view_controller.jpg)


##Tools for MVP Pattern
* Dagger
* RxJava//Otto

##Tests
Designing structure more like object-oriented makes it easy to test. MVP pattern also helps you test your android application much easier. [Here](https://github.com/TheFinestArtist/Robolectric-Example) shows example to use Robolectric and Mockito to test current MVP model example.


##Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : http://www.thefinestartist.com
```
