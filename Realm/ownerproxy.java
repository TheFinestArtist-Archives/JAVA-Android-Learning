public class OwnerRealmProxy extends Owner implements RealmObjectProxy {

    private static long INDEX_NAME;
    private static long INDEX_DOGS;
    private static long INDEX_CAT;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;

    @Override public String getName() { /* ... */ }
    @Override public void setName(String value) { /* ... */ }
    @Override public RealmList<Dog> getDogs() { /* ... */ }
    @Override public void setDogs(RealmList<Dog> value) { /* ... */ }
    @Override public Cat getCat() { /* ... */ }
    @Override public void setCat(Cat value) { /* ... */ }
}
