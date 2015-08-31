public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    RealmResults<Post> realmResults;

    public RecyclerViewAdapter(Realm realm, int layoutRes) {
        this.realmResults = realm.where(Post.class).findAll();
    }     @Override 

    public int getItemCount() {         return realmResults.size();     }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = realmResults.get(position);
        // do something...
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }
}
