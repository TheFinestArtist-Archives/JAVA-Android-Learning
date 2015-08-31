public class ListViewAdapter extends RealmBaseAdapter<Post> implements ListAdapter {

    public ListViewAdapter(Context context, RealmResults<Post> realmResults) {
        super(context, realmResults, true);
    }

    static class ViewHolder {

         ViewHolder(View view) { /*...*/ }

         public void setPost(Post post) { /*...*/ }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        /* ViewHolder Inflating */
        Post post = realmResults.get(position);
        viewHolder.setPost(post);
        return convertView;
    }
}
