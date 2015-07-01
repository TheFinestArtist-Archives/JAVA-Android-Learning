#RecyclerView
This post shows three examples of implementing a simple feed view which has "Swipe to Refresh" and "Load More" features using a fake paging feed API with three different view types:ScrollView, ListView, RecyclerView. And also shows further example of using CardView with RecyclerView.

##ScrollView
Sub-class of FrameLayout

####Methods to know
addView(View child)
scrollTo(int x, int y)
smoothScrollTo(int x, int y)

sv.scrollTo(0, sv.getBottom());

scrollView.fullScroll(View.FOCUS_UP);
scrollView.fullScroll(View.FOCUS_DOWN);

android:scrollbars="none"
android:scrollbars="vertical"
android:scrollbars="horizontal"

android:scrollbarStyle="insideOverlay"
android:scrollbarStyle="insideInset"
android:scrollbarStyle="outsideOverlay"
android:scrollbarStyle="outsideInset"

android:scrollbarSize="15dp"

scrollView.getViewTreeObserver().addOnScrollChangedListener(this);

####Example with Realm
```java
public class ScrollViewFragment extends Fragment implements ViewTreeObserver.OnScrollChangedListener, SwipeRefreshLayout_.OnRefreshListener {

    Realm realm;

    ScrollView scrollView;
    LinearLayout linearLayout;
    SwipeRefreshLayout_ swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        realm = Realm.getInstance(new RealmConfiguration.Builder(getActivity()).name("ScrollView.realm").build());

        View view = inflater.inflate(R.layout.fragment_scrollview, null);
        scrollView = (ScrollView) view.findViewById(R.id.scrollView);
        linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        swipeRefreshLayout = (SwipeRefreshLayout_) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.realm_red, R.color.realm_blue);

        swipeRefreshLayout.setOnRefreshListener(this);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(this);

        onRefresh();
        return view;
    }

    /**
     * OnScrollChangedListener
     */
    private static final int THRESHOLD = 800;

    @Override
    public void onScrollChanged() {
        if (!swipeRefreshLayout.isRefreshing() && linearLayout.getHeight() <= scrollView.getScrollY() + scrollView.getHeight() + THRESHOLD) {
            loadMoreData();
        }
    }

    private int page;

    private void loadMoreData() {
        swipeRefreshLayout.setRefreshing(true);
        Api.getFeed(page++, new Api.OnResponseListener<List<Post>>() {
            @Override
            public void onResponseRetrieved(List<Post> posts, Exception e) {
                swipeRefreshLayout.setRefreshing(false);

                realm.beginTransaction();
                realm.copyToRealm(posts);
                realm.commitTransaction();

                for (Post post : posts)
                    addItem(post);
            }
        });
    }

    /**
     * OnRefreshListener
     */
    @Override
    public void onRefresh() {
        realm.beginTransaction();
        realm.clear(Post.class);
        realm.commitTransaction();

        clearItems();

        page = 0;
        loadMoreData();
    }

    /**
     * LinearLayout
     */
    private void clearItems() {
        linearLayout.removeAllViews();
    }

    private void addItem(Post post) {
        View view = LayoutInflater.from(getActivity()).inflate(android.R.layout.simple_list_item_2, null);
        TextView title = (TextView) view.findViewById(android.R.id.text1);
        TextView message = (TextView) view.findViewById(android.R.id.text2);
        title.setText(post.getTitle());
        message.setText(post.getMessage());
        linearLayout.addView(view);
    }
}
```

##ListView
android:divider="@color/divider"
android:dividerHeight="0.5dp"

addHeaderView(View v) // Note: This method could only be called before setting the adapter with setAdapter(ListAdapter) for API below KITKAT
removeHeaderView(View v)

addFooterView(View v) // Note: This method could only be called before setting the adapter with setAdapter(ListAdapter) for API below KITKAT
removeFooterView(View v)

setAdapter(ListAdapter adapter)

####Methods to know

####Libraries to know

####Example with Realm


##RecyclerView

####Pros vs Cons
**Pros**
* Successor of ListView
* Flexible to design different kind of views
* Animation Support
* ViewHolder Pattern
* Data update
* Better open source library for RecyclerView is provided

RecyclerView is more advanced and flexible and efficient version of ListView.
RecyclerView ViewGroup in an container for larger data set of views that can be recycled and scrolled very efficiently.
RecyclerView can be used for larger datasets to be rendered on the UI like a list.
RecyclerView provides maximum flexibility to design different kind of views

**Cons**
* No trivial change needed to migrate ListView to RecyclerView

####Methods to know

####Libraries to know

####Example with Realm

##CardView

####Methods to know

####Libraries to know

####Example with Realm
