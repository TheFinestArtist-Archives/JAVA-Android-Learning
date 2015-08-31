public class ChatRecyclerAdapter extends RecyclerView.Adapter<ChatRecyclerAdapter.ViewHolder> {

    List<User> users;

    public ChatRecyclerAdapter() { /*...*/ }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int getItemCount() { return users == null ? 0 : users.size(); }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         User user = users.get(position);
         /*...*/
    }
}
