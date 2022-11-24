# TheMe

## 🎈 팀원 소개

```
삼성 청년 SW 7기 광주 2반 자율 프로젝트 C203 - F1B4
```

|                                             [이재민](https://github.com/jmlee9707)                                             |                                              [김세진](https://github.com/4d656f77)                                              |                                           [김유완](https://github.com/Hanpark04)                                           |                                       [김지호](https://github.com/Dongmyeongleee)                                        |                                                          [최강]()                                                           | 
| :----------------------------------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------: | 
| <img src="" width="100"/> | <img src="" width ="100"/> | <img src="" width ="100"/> | <img src="" width ="100"/> | <img src="" width="100"> | 
|                                                               팀장, FE                                                               |                                                               BE, FE                                                                |                                                            BE, FE                                                            |                                                            BE, FE                                                            |                                                              BE, FE                                                               |                                                               

<br />
<br />

## 1. 프로젝트 소개

- TheMe는 테마를 주제로 이에 적합한 장소를 공유하며 모두가 만들어 가는 SNS 입니다.
- 개인이 테마를 만들어 작성하고, 이런 개인 테마가 모여 공통 테마가 만들어 집니다.
- 특정 인물이 작성한 테마(개인 테마)를 팔로우 하여 새로운 글 작성시 메인 화면에서 확인할 수 있습니다.

<br />

## 2. 기술 스택

|      Part      |                            Tech ⚙                            |
| :------------: | :----------------------------------------------------------: |
|   **Front**    | <img src="https://img.shields.io/badge/vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white"><img src="https://img.shields.io/badge/axios-0088CC?style=for-the-badge&logo=axios&logoColor=white"><img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"><img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white"><img src="https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white"><img src="https://img.shields.io/badge/firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=white"> |
|    **Back**    | <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/MYSQL-003545?style=for-the-badge&logo=MYSQL&logoColor=white"><img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"><img src="https://img.shields.io/badge/Spring DATA JPA-009639?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/Spring Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/MSA-02303A?style=for-the-badge&logoColor=white">
| **Deployment** | <img src="https://img.shields.io/badge/amazon_ec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white"><img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"><img src="https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white"><img src="https://img.shields.io/badge/nginx-009639?style=for-the-badge&logo=nginx&logoColor=white"> |


<br />

## 3. 주요기능

<br />

### 1) 로그인

- 카카오 소셜 로그인을 활용하여 로그인 합니다.

![login](./readme_asset/login.gif)

<br />

### 2) 메인화면

- 사람들에게 관심을 많이 받은 테마에서 랜덤으로 추천 테마를 추천해 줍니다.
- 팔로우 한 개인 테마의 최신 게시글을 보여줍니다.

![main](./readme_asset/main.gif)

<br />

### 3) 게시글

- 캐러셀 형태로 게시글의 사진을 볼 수 있습니다.
- 게시글의 자세한 정보(사진,올린 날자, 테마 제목, 위치)를 확인할 수 있습니다.
- 더보기를 클릭하여 댓글,댓글작성,글신고를 할 수 있습니다.

<br />

### 4) 테마목록 화면

- 전체 테마 목록을 보여줍니다
- 전체테마, 북마크된 테마를 분류하여 볼 수 있습니다.
- 인기순,최신순으로 정렬 할 수 있습니다.
- 클릭시 해당 테마의 게시글과 카카오 지도를 이용하여 위치가 표현됩니다.

![allTheme](./readme_asset/allTheme.gif)

<br />

### 5) 테마 작성

- 추천테마 목록을 보여주며 이를 이용하여 테마를 추가 할 수 있습니다.
- 검색시 입력값에 맞는 테마의 이름이 실시간으로 표현됩니다.
- 검색을 통해 기존에 등록된 테마의 개인테마를 등록할 수 있습니다.
- 검색을 통해 기존에 없는 테마일 경우 테마를 등록 할 수 있습니다.

![createTheme](./readme_asset/createTheme.gif)

<br />

### 6) 게시글 작성

- 보유하고 있는 테마를 선택하여 해당 테마에 관련된 게시글을 작성 할 수 있습니다.
- 이미지를 선택하여 미리보기로 해당 이미지를 볼 수 있습니다.
- 카카오 장소검색 api를 활용하여 해당 장소에 대한 정보를 등록 할 수 있습니다.
- 내용 작성을 통해 해당 게시글의 본문을 작성할 수 있습니다.

![createArticle](./readme_asset/createArticle.gif)

<br />

### 7) 인물 검색

- 기본값으로 현재 인기 있는 사람들을 추천해 줍니다
- 입력값에 맞는 인물의 목록이 실시간으로 표현됩니다.
- 검색시 정확한 인물이 최상단으로 표현되며, 해당 키워드를 가진 인물들이 나열됩니다.
- 인물 클릭시 해당 인물의 프로필로 이동합니다.

![searchUser](./readme_asset/searchUser.gif)

<br />

### 8) 테마 검색

- 입력값에 맞는 테마의 목록이 실시간으로 표현됩니다.
- 검색시 정확한 테마가 최상단에 표현되며, 해당 키워드를 가진 테마 몰록이 나열됩니다.
- 테마 클릭시 해당 테마로 작성된 게시글이 표현됩니다.

![searchTheme](./readme_asset/searchTheme.gif)

<br />

### 9) 프로필

- 유저의 프로필을 확인 할 수 있습니다.
- 유저의 프로필을 업데이트 할 수 있습니다.
- 해당 유저의 테마를 팔로우 한 사람을 알 수 있습니다.
- 해당 유저가 팔로우 한 테마를 알 수 있습니다.
- 해당 유저가 보유중인 개인 테마를 알 수 있습니다.

![myProfile](./readme_asset/myProfile.gif)


<br />

## 📂 4. 아키텍처

<br />

### 1) 아키텍처 구조

<br />

### 2) 프론트 파일 구조

<br />

```text
  root
    ├── public
    ├── src
    │     ├── apis                    # API 관련
    │     ├── assets                  # 미디어 파일들
    │     │      ├── images           # 이미지 파일 관련
    │     │      └── styles           # 폰트,색상
    │     │             └── fonts
    │     ├── components              # 컴포넌트
    │     │      └── common           # (공통,페이지별)
    │     ├── routers                 # 라우팅
    │     ├── utils                   # 유틸함수
    │     ├── screens                 # 페이지별
    │     └── store                   # 상태관리
    └── dist                          # 빌드 파일
          └── ...
```

<br />

### 3) 백엔드 파일 구조

<br />

- USER

```text
.
└─src
    └─main
         ├─java
         │  └─com
         │      └─web
         │          └─curation
         │              ├─config           # Spring Config 파일
         │              ├─controller       # Http 요청과 응답을 위한 클래스
         |	            ├─data
         |              |   ├─dto          # 데이터 전송 객체
         |              |   ├─entity       # JPA에서 사용할 엔티티
         |              |   └─repository   # DB에 접근하는 Interface
         │              ├─exception        # 예외처리
         │              └─service          # Repository와 DTO를 통해 DB와 controller 연결
         |
         └─resources                       # application 필요한 옵션 지정

```

- THEME

```text
.
└─src
    └─main
         ├─java
         │  └─com
         │      └─web
         │          └─curation
         │              ├─config           # Spring Config 파일
         │              ├─controller       # Http 요청과 응답을 위한 클래스
         |	            ├─data
         |              |   ├─dto          # 데이터 전송 객체
         |              |   ├─entity       # JPA에서 사용할 엔티티
         |              |   └─repository   # DB에 접근하는 Interface
         │              ├─exception        # 예외처리
         │              └─service          # Repository와 DTO를 통해 DB와 controller 연결
         |
         └─resources                       # application 필요한 옵션 지정

```
- FEED

```text
.
└─src
    └─main
         ├─java
         │  └─com
         │      └─web
         │          └─curation
         │              ├─config           # Spring Config 파일
         │              ├─controller       # Http 요청과 응답을 위한 클래스
         |	            ├─data
         |              |   ├─dto          # 데이터 전송 객체
         |              |   ├─entity       # JPA에서 사용할 엔티티
         |              |   └─repository   # DB에 접근하는 Interface
         │              ├─exception        # 예외처리
         │              └─service          # Repository와 DTO를 통해 DB와 controller 연결
         |
         └─resources                       # application 필요한 옵션 지정

```

<br />
<br />

## 📂 5. 프로젝트 관련 문서
[🎨 프로토타입, 디자인 ](https://scratch-octopus-16f.notion.site/UI-3412085ccd92446eb123a0db28ba86d2)

[📃 회의록 & 스크럼](https://scratch-octopus-16f.notion.site/09c08675b93242c28e174a6aba5261e4?v=dea8006efd4940c2a38a8c4de45d9768)

[📡 요구사항 명세서](https://scratch-octopus-16f.notion.site/3bd0fbca4e6b4e5e92b4495b8826553d)

[📋 API 명세서](https://scratch-octopus-16f.notion.site/API-fbee3ab9f0d046fbb18d67d84e961731)


