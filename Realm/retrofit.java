private static InstagramService instagramService = restAdapter.create(InstagramService.class);

public static void getTag(final Activity activity, final Class<? extends RoyalDatabase> clazz, String next) {
  instagramService.getTags("art", accessToken, next, new Callback<TagsCallback>() {
      @Override
      public void success(TagsCallback tagsCallback, Response response) {
          RoyalTransaction.save(clazz, tagsCallback.data);
          if (ScrollViewDatabase.class.equals(clazz))
              EventBus.getDefault().post(new OnScrollViewUpdateEvent(tagsCallback.pagination.next_max_tag_id, tagsCallback.data));
          if (ListViewDatabase.class.equals(clazz))
              EventBus.getDefault().post(new OnListViewUpdateEvent(tagsCallback.pagination.next_max_tag_id));
          if (RecyclerViewDatabase.class.equals(clazz))
              EventBus.getDefault().post(new OnRecyclerViewUpdateEvent(tagsCallback.pagination.next_max_tag_id));
          if (CardViewDatabase.class.equals(clazz))
              EventBus.getDefault().post(new OnCardViewUpdateEvent(tagsCallback.pagination.next_max_tag_id));
      }

      @Override
      public void failure(RetrofitError error) {
          SnackBar.alert(activity, "Please check your network status!");
      }
  });
}
