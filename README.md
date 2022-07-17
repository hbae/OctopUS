# Vue.js ES6 Vuex로 간단한 Todo 웹앱 만들어보기

### 구현사항 정리
- 할 일 추가 기능
- 할 일 목록 표시 기능
- 할 일 완료 기능
- 할 일 삭제 기능
- 할 일 모두 삭제 기능

<img src="/src/convert2.gif">



## Vuex
### Vuex란?
- 복잡한 애플리케이션의 컴포넌트들을 효율적으로 관리하는 Vuex 라이브러리
- React의 Flux 패턴에서 기인함

### 왜 Vuex?

#### Flux Pattern
<br>
<img src="/src/Flux.png" >
<br><br>

#### Vuex를 왜 쓰는지를 알려면 우선 Flux패턴에 대한 이해가 필요

- Flux 패턴이란 MVC 패턴의 복잡한 데이터 흐름 문제를 해결하는 개발 패턴(Unidirectional Data Flow)
- action : 화면에서 발생하는 이벤트 또는 사용자의 입력
- dispatcher : 데이터를 변경하는 방법, 메서드
- model : 화면에 표시할 데이터
- view : 사용자에게 비춰지는 화면

#### MVC vs Flux
- MVC 패턴의 문제점 : 기능 추가 및 변경에 따라 생기는 문제점을 예측할 수가 없음 (예시 : 페이스북 채팅 화면), 앱이 복잡해지면서 생기는 업데이트 루프
- Flux패턴의 단방향 데이터 흐름 : 데이터의 흐름이 여러 갈래로 나뉘지 않고 단방향으로만 처리

<br>
<img src="/src/complex_mvc.png" width="700px" height="300px">
<br><br>
<br>
<img src="/src/flux2.png">
<br><br>



#### Vuex가 왜 필요할까?
- 복잡한 애플리케이션에서 컴포넌트의 개수가 많아지면 컴포넌트 간에 데이터 전달이 어려워진다.
- 이걸 단순히 이벤트 버스로 해결하려면, 어디서 이벤트를 보냈는지 혹은 어디서 이벤트를 받았는지 알기 어려움(컴포넌트 간 데이터 전달이 명시적이지 않음)

#### Vuex로 해결 가능한 문제
- MVC 패턴에서 발생하는 구조적 오류
- 컴포넌트간 데이터 전달 명시
- 여러 개의 컴포넌트에서 같은 데이터를 업데이트 할 때 동기화 문제

#### Vuex 컨셉
- State : 컴포넌트 간에 공유하는 데이터(data)
- View : 데이터를 표시하는 화면(template)
- Action : 사용자의 입력에 따라 데이터를 변경(methods)

<img src="/src/statepattern.png" width="500px" height="500px">

#### Vuex 구조
#### 컴포넌트 -> 비동기 로직 -> 동기 로직 -> 상태
#### Actions(비동기로 백엔드에서 데이터를 받아옴, 데이터를 변경할 수 있는 mutations를 콜)
#### Mutations(동기적 로직 처리, state 변경할 수 있음)
<img src="/src/vuexconcept.png">

#### 참고한 사이트
- Favicon(https://www.favicon-generator.org/)
- Vue Transition(https://kr.vuejs.org/v2/guide/transitions.html)
- Vue Modal(https://kr.vuejs.org/v2/examples/modal.html)
- FontAwesome(https://fontawesome.com/)
