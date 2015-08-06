public class RealmList<E extends RealmObject> extends AbstractList<E> {

    private final boolean managedMode;
    private Class<E> clazz;
    private LinkView view;
    private Realm realm;
    private List<E> nonManagedList;

    public RealmList() { /* ... */ }
    public RealmList(E... objects) { /* ... */ }

    RealmList(Class<E> clazz, LinkView view, Realm realm) { /* ... */ }
    @Override public void add(int location, E object) { /* ... */ }
    @Override public boolean add(E object) { /* ... */ }
    @Override public E set(int location, E object) { /* ... */ }

    private E copyToRealmIfNeeded(E object) { /* ... */ }
    public void move(int oldPos, int newPos) { /* ... */ }
    @Override public void clear() { /* ... */ }
    @Override public E remove(int location) { /* ... */ }
    @Override public E get(int location) { /* ... */ }
    public E first() { /* ... */ }
    public E last() { /* ... */ }

    @Override public int size() { /* ... */ }
    public RealmQuery<E> where() { /* ... */ }
    private void checkValidObject(E object) { /* ... */ }
    private void checkIndex(int location) { /* ... */ }

    @Override public String toString() { /* ... */ }
}
