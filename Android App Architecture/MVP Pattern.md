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
```
fullName.addTextChangedListener(new TextWatcher() {
   @Override
   public void onTextChanged(CharSequence s, int start, int before, int count) {
       user.setFullName(String.valueOf(fullName.getText()));
   }
});
```

###Presenter -> View
Sim

###Model -> Presenter
###Presenter -> Model

##MVP in Android
Developer usually uses Activity or Fragment as a presenter but here shows a better way to  an Android Application with same feature as the example in MVC Pattern. [Github](https://github.com/TheFinestArtist/MVP-Example)
```
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

##Tools & Libraries
Otto (Eventbus)

Main Design Pattern in iOS
Best fit in Android also

Show specific pattern with network/service


##MVP in iOS/OSX

Apple also suggests to follow [MVC Pattern](https://developer.apple.com/library/mac/documentation/General/Conceptual/DevPedia-CocoaCore/MVC.html) which is actually MVP Pattern, to their iOS/OSX developers.  

![](https://developer.apple.com/library/mac/documentation/General/Conceptual/DevPedia-CocoaCore/Art/model_view_controller.jpg)


##Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : https://www.thefinestartist.com
```
