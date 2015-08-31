
int itemCount = 0;

public void onEvent(OnRecyclerViewUpdateEvent event) {
  swipeRefreshLayout.setRefreshing(false);
  if (event.isFailed())
      return;

  next = event.getNext();

  if (itemCount < adapter.getItemCount())
      adapter.notifyItemRangeInserted(itemCount, adapter.getItemCount() - itemCount);
  else
      adapter.notifyItemRangeRemoved(itemCount, itemCount - adapter.getItemCount());

  itemCount = adapter.getItemCount();
}
