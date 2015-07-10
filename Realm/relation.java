public class Email extends RealmObject {
    private String address;
    private boolean active;
}

// Many to One
public class Contact extends RealmObject {
    private Email email;
}

// Many to Many
public class Contact extends RealmObject {
    private RealmList<Email> emails;
}
