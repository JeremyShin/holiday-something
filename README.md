## holiday-something brand mall
Holiday Something(홀리데이썸띵) 쇼핑몰 구축 repository입니다.

## Tech/framework used
- Language: JDK 1.8
- Application Framework: Spring Boot 2.0
- Database: MySQL, JPA(Java Persistence API)
- Deployment: Docker, AWS(EC2, RDS)
- Front-End: React.js (향후 SEO를 위해 next.js 등을 적용하여 Server-Side Rendering 구현 예정. 현재는 모든 React component가 Client-Side Rendering)
- IDE: IntelliJ
- Build Automation Tool: Maven

## Code style
- IntelliJ Java Google Style을 적용
  - commit하기 전 'IntelliJ 좌측 Explorer > 프로젝트 폴더 우클릭 > Reformat Code' 적용 하기
- Java 코딩 컨벤션 ([참조 링크](http://kwangshin.pe.kr/blog/java-code-conventions-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9-%EA%B7%9C%EC%B9%99/))
  - 필요한 경우 클래스, 메소드 등에 Javadoc comment를 붙여준다. [관련 링크](https://idratherbewriting.com/java-javadoc-tags)를 참조한다.
- HTML
  - HTML element에 inline으로 CSS 속성을 주는 것은 지양하고, 외부 CSS 파일로 분리한다.
  - HTML 파일 내에 긴 JS 코드를 두는 것은 지양하고, 외부 JS 파일로 분리한다.
  
### Layer별 접미어
- Controller : **Controller.java*
- Service Interface : **Service.java*
- Service Implement : **ServiceImpl.java*
- Repository : *(Domain이름)Repository.java*

### Layer별 메소드 이름
- Repository
  - JPA를 따름
- Service
  - Create : `add`
  - Retrieve : `get`
  - Update : `modify`
  - Destroy : `remove`
- Controller
  - TBD
  
