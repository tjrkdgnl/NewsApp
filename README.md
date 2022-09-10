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


