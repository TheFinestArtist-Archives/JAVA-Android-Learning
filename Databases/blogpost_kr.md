저를 포함해 많은 모바일 및 웹 개발자 분들이 Database에 대해 기본적인 이해 없이 개발을 하고 계신듯 합니다. 물론, 컴퓨터 관련 학과를 졸업하셨다면 학교에서 Database라는 수업을 수강하셨겠지만, 수업에서 알려주는 부분을 실무에 그대로 적용하기엔 한계가 있고, UI/UX 개발이 더 중요한 모바일 및 웹 위주로 개발을 하다보면, Database나 Network 처럼 상대적으로 코어한 부분의 이론을 잊어버리게 되는 경우가 많습니다. 그래서 간략하게나마 Database는 뭔지, 세상에는 어떠한 종류의 Database들이 있는지 등에 대해 정리해 보고자 합니다.


시작하기 앞서 Database에서 사용하는 용어들을 하나씩 정리해보도록 하겠습니다.

**Database**
Database란 "유의미한 Data들이 정리되어 있는 모임"이라고 할 수 있습니다. 단순한 Data들의 모임이 아닌, 실제로 의미가 있는 Data들이 특정한 구조로 정리된 모임입니다. 이런 특정한 구조는 Database 종류에 따라 다른데 이는 뒷부분에서 자세히 다루도록 하겠습니다.


**Database Management System(DBMS)**
Database Management System(DBMS)란 대량의 데이터를 저장하고 있는 Database를 관리하는 시스템으로, Data를 최대한 효율적이고, 신뢰성이 있고, 편리하게 그리고 많은 유저가 동시에 접속해도 문제 없게 끔 설계되어 있습니다.


Database는 기본적으로 다음 4가지의 규칙을 따라야 합니다. 약자로 ACID라고 부르는데 각각 Atomicity, Consistency, Isolation, Durability의 의미를 가지고 있습니다.
