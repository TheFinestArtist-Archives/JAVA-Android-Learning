public class Owner extends RealmObject {

    private String name;
    private RealmList<Dog> dogs;
    private Cat cat;

    public Cat getCat() { /* ... */ }
    public void setCat(Cat cat) { /* ... */ }
    public RealmList<Dog> getDogs() { /* ... */ }
    public void setDogs(RealmList<Dog> dogs) { /* ... */ }
    public String getName() { /* ... */ }
    public void setName(String name) { /* ... */ }
}
