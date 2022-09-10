## 프로젝트 구조(Multi Module) ##

### App Module ###
- App 모듈은 프로젝트에 필요한 모든 모듈의 의존성을 갖는 모듈입니다.
- Fragment Navigation을 관리합니다.

### Feature Module ###
- Feature Module은 크게 Search/TopNews/Category/Bookmark Module로 구성되어 있습니다.
- 각 모듈은 서로 참조하지 않으며, Shared_Module과 의존성을 갖습니다. 


### Shared_Feature Module ###
- Feature 모듈에서 공통적으로 사용되는 모듈로 구성되어져 있습니다. 
- 각 Shared_Feature 모듈은 참조할 수 있지만, 순환참조는 불가능합니다.

![image](https://user-images.githubusercontent.com/45396949/189475063-1107cc97-05ca-41de-ad2b-72f96633cad4.png)

## 아키텍처 구조 ##
각 feature 모듈은 Clean Architecture 구조로 구성되어 있습니다. 

### Presentation ###
- UI와 관련된 파일들이 저장되는 패키지로 Activity/Fragment/ViewModel 등으로 구성됩니다.

### Domain ###
- 비지니스 영역과 데이터 영역에서 사용되는 로직을 제공하는 패키지로 interface 및 entity로 구성됩니다. 
- uaseCase 
  - 사용자 Action에 의해 수행될 로직을 인터페이스로 정의한 패키지입니다.
- Repository
  - Model과 상호작용하여 Data를 처리하기 위한 인터페이스를 정의한 패키지입니다.
- Entity
  - 비지니스 모델로 실제 UI에 적용되는 Model 패키지입니다. 프로젝트에서는 entity부분을 Shared_Feature로 구성하였기 때문에 Domain에는 포함되어 있지 않습니다.

### Data ###
- Domain에서 정의한 UseCase 및 Repository 인터페이스를 구현한 클래스들로 이뤄진 패키지입니다.

- uaseCase 
  - Domain에서 정의된 UseCase interface를 구현한 패키지입니다.
- Repository
  - Domain에서 정의된 Repository interface를 구현한 패키지입니다.
- Model
  - API에서 제공하는 Model을 정의한 패키지입니다. 
  - Mapper를 통해 UseCase의 Entity로 변환합니다. 
- Network
  - Network처리를 위한 API Interface를 정의하며, 사용법을 제공합니다.
- DI
  - DI는 의존성을 주입하기 위한 Module로 구성된 패키지이며, Hilt 라이브러리를 이용하여 구성했습니다.
  - UseCaseModule을 제공하여 Presentation에서 UsecCaseImpl를 주입받을 수 있는 방법을 제공합니다. 
  - RepositoryModule을 제공하여 UseCase에서 RepositoryImpl를 주입받을 수 있는 방법을 제공합니다.
  - NetworkModule을 통해 Retrofit에서 사용할 ApiService를 구성하고 이 ApiService를 통해 Network통신을 위한 방법을 제공합니다.  

![image](https://user-images.githubusercontent.com/45396949/189476059-54e3a481-6b94-4200-9080-1721fe341257.png)

## Feature ##


### 검색하기 ###
- 키워드를 검색하면 해당 키워드를 포함한 기사를 검색할 수 있습니다.
- Paging3 라이브러리를 이용하여 page단위로 뉴스들을 불러옵니다.
- 검색내용이 없는 경우, 안내문구를 통해 없음을 나타냅니다.
- 에러가 발생한 경우, 안내문구를 통해 없음을 나타냅니다.
- 기사내용을 클릭할 수 있으며, 세부 기사내용을 볼 수 있으며 북마크를 통해 저장이 가능합니다.

| 검색 | 검색없음 | 검색에러(네트워크 연결x) |
| --- | ---- | ---- |
| ![검색하기](https://user-images.githubusercontent.com/45396949/189478014-e39b871c-f025-4870-ad86-57be1eb37c8f.gif) | ![검색없음](https://user-images.githubusercontent.com/45396949/189478671-eb32d8b2-7b36-43d6-bbeb-1abe8e963c0e.gif) | ![검색에러](https://user-images.githubusercontent.com/45396949/189478673-25b76b20-a3f8-41da-bb3f-9a5515101a42.gif) |



### 탑뉴스 ###
- 미국의 탑뉴스를 기본적으로 표시합니다.
- Paging3 라이브러리를 이용하여 page단위로 뉴스들을 불러옵니다.
- 클릭하여 세부 기사내용을 볼 수 있습니다.

| 탑뉴스 | 재시도 |
| :---: | :---: |
| ![탑뉴스](https://user-images.githubusercontent.com/45396949/189478120-99330bdd-c6f1-4b7b-9785-ecd8455a6128.gif) | ![탑뉴스 재시도](https://user-images.githubusercontent.com/45396949/189478780-b0e36f35-76f1-4fa2-b2c2-1b2710948ed9.gif) |




### 카테고리 ###
- 기사 카테고리를 보여줍니다.
- 카테고리를 클릭하면 관련 뉴스를 볼 수 있습니다.
- 관련된 기사는 paging3를 적용했기 때문에 page단위로 불러옵니다.
- 기사를 클릭하여 세부 내용을 볼 수 있습니다. 
- 에러가 발생한 경우, 안내 문구와 "다시시도" 기능을 통해 다시 page를 불러 올 수 있습니다.

![카테고리](https://user-images.githubusercontent.com/45396949/189478176-821a7a50-2797-4944-92f4-410143287fa5.gif)

### 북마크 ###
- 북마크가 표시된 기사를 모아놓은 화면입니다.
- Room 라이브러리를 이용하여 로컬 캐싱처리했습니다.
- Room 라이블리에서 제공하는 Flow를 활용하여 비동기 스트림으로 추가 및 삭제 시, UI를 업데이트 시키도록 만들었습니다. 
- 저장한 북마크 뉴스가 없다면 기본 문구가 표시됩니다.

![북마크](https://user-images.githubusercontent.com/45396949/189478237-acc5dba8-7f93-4c2d-b084-f290020b595a.gif)
