Better if

1. Thread independent RealmObject
2. No Transactions
3. Observer
4. No RealmObject//RLMObject
5. Better with Auto Migration

Current Realm API is too database.

This API is like an ORM.
Need some adapter thing to make new API customizable.


Picasso v/s Freso v/s Glide

####Feedback
0. 한국어로 Realm 발음이 어렵고 관련 내용을 Realm이라는 Keyword 흔해서 검색이 다소 불편함
1. 팀이 말한 내용: 고급 개발자들은 잘 적등해서 사용하는데, 중급/초급 개발자들이 이해해서 사용하기가 까다롭다. (Learning Curve가 있음)
2. RLMObject//RealmObject의 sub-class의 sub-class를 만들지 못해 사용이 어렵다.
3. nil//null의 정보가 저장이 되지않아 일일이 NSNull 또는 ""의 데이터를 저장해야하는 불편함이 있다.
4. 데이터가 없으면 아무런 데이터가 저장이 안되게끔 혹은 nil//null이 저장되게끔 (3번이랑 이어지는 내용)
5. Realm Notification 또는 Realm Listener를 실제로 Practical하게 사용하기가 불편하다.
   * 어떤 부분의 데이터가 바뀌었는지 알 수 없음
   * 현재 뷰에서 필요하지 않은 데이터가 바뀌어도 Noti//Listener가 작동함
   * One to One Relation이 있는 경우 (e.g. Owner - Pet) Pet이 삭제가 되는경우, Pet이라는 data가 삭제가 되어서 Noti가 한번 오고, Owner에서 Pet과의 연결에 대한 데이터가 삭제되면서 Owner가 업데이트되고, 이로인해 Noti가 또 한번 더 날아옴
   * 각 View Controller//Activity/Fragment가 필요한 부분에 대한 노티인지를 알 수 있게 도와주는 API가 제공이 되던가 혹은 각 뷰에서 사용하는 데이터에 대한 Noti를 주던가 하는게 필요함
6. Realm에 Query 자체가 기본적으로 Paging을 제공하지 않는다
7. RLMObject//RealmObject에서 default가 설정이 되지 않은 attribute에 아무런 데이터를 저장하지 않는 경우 error가 생기는데, 아이폰에서 이 경우 Stack Trace가 매우 힘들다. 어떤 Attribute인지 찾는데 한참 걸렸음 (Try Catch로 에러를 컨트롤하는 방식)
8. 서버에서 int등의 데이터를 보내줄때 json에서 { age : 27 } 이런 식이 아니라 { age : "27" } 이런식으로 보내주는 경우가 있는데 Realm에서 이를 자동으로 int로 바꿔주지 않아서 일일이 찾아서 바꿔주어야 하는 어려움이 있다.
9. Android의 경우 getter//setter 외의 method를 만들수없어 customizable validation등을 처리하기가 까다롭다.
10. Feed를 보여주는 TableView
   * RLMResult를 Query로 가지고 올때 한번에 모든 Post를 다 가지고 오는데 속도//메모리 면에서 문제가 없는지 걱정
   * Paging이 안되서 RLMResult에서 원하는 부분만큼 잘라서 Data를 NSArray에 넣어서 보여줌
   * 이 경우 Feed의 Post하나가 삭제가 되면, NSArray에 들어있는 Post중 하나가 invalidate이 되고, TableView를 reload하는 경우 이렇게 invalidate이 된 data를 따로 처리해 줘야된다. (Cell개수도 다시 설정해야하고 등등..)
   * 서버에서 더 많은 포스트를 fetch해오는 경우 Realm Notification이 쓸데없이 많이 Noti가 날아옴
   * 이런 case (feed view//refresh//delete post//add post//fetch more feeds)가 정말 많을거 같은데 이런 부분을 seemless하게 처리하는 Example이 있으면 좋을듯 하다
11. Server와 연동이 없는 앱의 경우 Local에서만 DB를 사용하는데 id과 같은 primary key가 자동으로 increment되는 기능이 필요하다. 안그런 경우 현재 시간을 long value로 바꿔서 사용해야되거나 따로 id를 increment해주는 logic 등을 직접 만들어야된다
