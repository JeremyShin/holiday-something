## holiday-something brand mall
Holiday Something(홀리데이썸띵) 쇼핑몰 구축 repository입니다.

## Tech/framework used
- Language: JDK 1.8
- Application Framework: Spring Boot 2.0
- Database: MySQL, JPA(Java Persistence API)
- Deployment: Docker, AWS(EC2, RDS)
- Front-End: React
- IDE: IntelliJ
- Build Automation Tool: Maven

## Code style
- IntelliJ Java Google Style을 적용
  - commit하기 전 'IntelliJ 좌측 Explorer > 프로젝트 폴더 우클릭 > Reformat Code' 적용 하기
- Java 코딩 컨벤션 ([참조 링크](http://kwangshin.pe.kr/blog/java-code-conventions-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9-%EA%B7%9C%EC%B9%99/))
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

---
 
## Motivation
A short description of the motivation behind the creation and maintenance of the project. This should explain **why** the project exists.

## Build status
Build status of continus integration i.e. travis, appveyor etc. Ex. -

[![Build Status](https://travis-ci.org/akashnimare/foco.svg?branch=master)](https://travis-ci.org/akashnimare/foco)
[![Windows Build Status](https://ci.appveyor.com/api/projects/status/github/akashnimare/foco?branch=master&svg=true)](https://ci.appveyor.com/project/akashnimare/foco/branch/master)

## Screenshots
Include logo/demo screenshot etc.

## Features
What makes your project stand out?

## Code Example
Show what the library does as concisely as possible, developers should be able to figure out **how** your project solves their problem by looking at the code example. Make sure the API you are showing off is obvious, and that your code is short and concise.

## Installation
Provide step by step series of examples and explanations about how to get a development env running.

## API Reference
Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests
Describe and show how to run the tests with code examples.

## How to use?
If people like your project they’ll want to learn how they can use it. To do so include step by step guide to use your project.

## Contribute
Let people know how they can contribute into your project. A [contributing guideline](https://github.com/zulip/zulip-electron/blob/master/CONTRIBUTING.md) will be a big plus.

## Credits
Give proper credits. This could be a link to any repo which inspired you to build this project, any blogposts or links to people who contrbuted in this project.

#### Anything else that seems useful

## License
A short snippet describing the license (MIT, Apache etc)

MIT © [Yourname]()
