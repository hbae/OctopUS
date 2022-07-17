# Vue.js -2

### Vue Event & Component

------

###### Vue Life Cycle

- Instance Life Cycle Hooks
  - 각 Vue 인스턴스는 생성될 때 일련의 초기화 단계 거침
    - 데이터 관찰 설정 필요한 경우
    - 템플릿 컴파일 하는 경우
    - 인스턴스를 DOM에 마운트 하는 경우
    - 데이터 변경되어 DOM 업데이트 하는 경우
  - 초기화 단계에서 사용자 정의 로직 실행 가능한 Life Cycle Hooks 호출
  - 크게 4개 파트( 생성, 부착, 갱신, 소멸 )로 나뉨
  - 모든 Life Cycle Hooks는 자동으로 this 컨텍스트를 인스턴스에 바인딩
    - 따라서 데이터, 계산된 메소드에 접근 가능
    - 화살표 함수를 사용한 메소드 정의 X
  - ![스크린샷 2022-07-17 오후 9.57.51](/Users/soomi/Library/Application Support/typora-user-images/스크린샷 2022-07-17 오후 9.57.51.png)

###### Vue Instance Option

- Vue Method
  - Vue Instance는 생성 관련된 데이터 및 메서드 정의 가능
  - Method 안에 data를 this.데이터이름 으로 접근
- Vue Filters
  - Vue는 텍스트 형식화를 적용할 수 있는 필터 지원
  - Filter 이용하여 표현식에 새로운 결과 형식 적용
  - {{ 이중 중괄호 }} 또는 v-bind 속성에서 사용 가능
  - 자바스크립트 표현식 마지막에 | 와 추가해야 함
  - 체이닝 가능
- Vue computed
  - 특정 데이터의 변경사항을 실시간으로 처리 가능
  - 캐싱 이용하여 데이터 변경 없을 경우 캐싱된 데이터 반환
  - Setter 와 Getter 를 직접 지정할 수 있음
  - 작성은 메서드 형태지만, 뷰에서 프록시 처리하여 property처럼 사용
  - 화살표 함수 사용 X
- Vue watch
  - Vue Instance의 특정 property가 변경될 때 실행할 콜백 함수 설정
  - 데이터 감시
  - 화살표 함수 사용 X

###### Vue Event Handling

- Vue Event
  - Listening to Event
  - Method Event Handlers
  - Methods in inline Handlers
  - Event Modifiers
  - Key Modifiers

###### Vue Bindings

- ref
  - 엘리먼트 또는 자식 컴포넌트에 대한 참조를 등록하는 데 사용
- $refs
  - ref 속성이 등록된 자식 컴포넌트와 DOM 엘리먼트 객체
  - 템플릿이나 계산된 속성에서 사용X
- Class Bindings
  - 데이터 바인딩은 엘리먼트의 클래스 목록과 인라인 스타일 조작 위해 일반적으로 사용됨
  - v-bind 사용하여 처리 가능
  - 문자열 이외 객체 또는 배열 이용 가능
- Form Input Bindings
  - v-model 디렉티브 사용하여 form input과 textarea 앨리먼트에 양방향 데이터 바인딩 생성 가능
  - v-model은 모든 form 엘리먼트의 초기 value와 checked, selected 속성을 무시함