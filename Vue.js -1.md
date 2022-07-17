# Vue.js -1

### Vue 소개

---

- 사용자 인터페이스 만들기 위한 progressive framework
- 현대적 도구 / 지원하는 라이브러리와 함께 사용하면 정교한 SPA(Single Page Application) 완벽히 지원
- 특징 3가지
  - 접근성, 유연성, 고성능



###### MVVM Pattern

- Model + View + ViewModel
- Application Logic을 UI로부터 분리하기 위해 설계한 디자인 패턴
- Model
  - 순수 자바 스크립트 객체 (데이터 담으려고 사용)
- View
  - 웹페이지의 DOM (HTML)
- ViewModel
  - Vue 역할
  - VIew와 Model 사이에서 Data와 DOM에 관련된 일 처리



###### Vue Instance

<script>
  const app = new Vue({
    // Option
  })
</script>

- Options 객체를 전달해야 함

###### 	el

- Vue instance에 연결할 기존 DOM 엘리먼트 지정

- CSS selector / HTML element 작성

- new를 이용한 생성에만 사용

  <di v id="app">
  </div>

  <script>
    const app = new Vue({
      el: '#app'
    })
  </script>

- data

- Methods

- template

- Template Syntax

  - 렌더링 된 DOM을 기본으로 인스턴스 데이터에 선언적으로 바인딩 가능한 HTML 기반 템플릿 구문 사용
  - 보간법, 디렉티브

- 보간법

  - {{ }}
  - 데이터 객체 속성 값으로 대체됨
  - 해당 값이 변경되면 갱신
  - V-once : 업데이트 되지 않는 일회성 보간 수행
  - 일반 텍스트로 해석
  - 실제 HTML 출력 : v-html 사용

- Directive

  - v 접두사가 있는 특수 속성
  - 단일 자바스크립트 표현식이 됨
  - 역할: 표현식 값 변경 시 사이드 이펙트를 반응적으로 DOM에 적용

- v-text

  - textContent Update
  - 일부 갱신 {{ }}

- v-bind

  - Html 요소 속성에 Vue 상태 데이터를 값으로 할당

  - object 형태로 사용하면 값이 true인 키가 class 바인딩 값으로 할당됨
  - 약어 :

- v-model

  - form 요소의 input 엘리먼트 / 컴포넌트에 양방향 바인딩 처리
  - .lazy
  - .number
  - .trim
  - form 엘리먼트 초기 'value'와 'cheked', 'selected' 속성 무시

- v-show

  - 조건에 따라 엘리먼트를 화면에 표시
  - 항상 렌더링되고 DOM에 남아있음
  - 단순히 엘리먼트에 display CSS 속성을 토글하는 것
  - 조건 바뀌면 트랜지션 호출
  - `<h1 v-show="ok"> Hello! </h1>`

- Directive (v-if, v-else-if, v-else)

  - 표현식 값의 참 거짓을 기반으로 엘리먼트를 조건부 렌더링 함
  - 엘리먼트 및 포함된 디렉티브 / 컴포넌트는 토글하는 동안 삭제되고 다시 작성됨
  - `<template>` 엘리먼트 이용해 v-if 사용 가능, 최종 결과에는 `<template>`엘리먼트는 포함 안 됨

- Directive (v-for)

  - 원본 데이터 기반으로 엘리먼트 / 템플릿 블록을 여러 번 렌더링
  - 디렉티브 값은 반복되는 현재 엘리먼트에 대한 별칭 제공 위해 *alias in expression* 사용

- Directive (v-on)

  - 엘리먼트에 이벤트 리스너 연결
  - 이벤트 유형은 전달 인자로 표시
  - 약어 제공 @

- Directive (v-cloak)

  - Vue instance 준비될 때까지 Mustache 바인딩 숨길 때 사용
  - CSS 규칙과 사용
  - Vue Instance 준비되면 v-cloak 제거됨

