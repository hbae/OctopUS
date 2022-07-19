- 스프링 의존성 주입에는 필드 주입, 수정자 주입, 생성자 주입이 있다.

# 필드 주입(Field Injection)

---

- @Autowired 어노테이션을 붙이면 자동으로 의존성 주입이 된다.

```java
@Controller
public class HomeController{
	@Autowired
	private MemberService memberService;
}
```

### 단점

- 외부에서 접근이 불가능하기 때문에 필드의 객체를 수정할 수 없다.
- 반드시 DI 프레임워크가 존재해야 하기 때문에 바로 클래스를 인스턴스화 시킬 수 없어 테스트에 용이하지 않다. (강한 결합)
- final을 선언할 수 없기 때문에 객체가 변할 수 있다. (불변성 x)

---

# 수정자 주입(Setter Injection)

---

- Setter 메서드에 @Autowired 어노테이션을 붙여 의존 관계를 주입하는 방식
- Bean 생성이 끝난 후 Setter 메서드를 호출하여 주입

```java
@Controller
public class HomeController{
	private MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService){
		this.memberService = memberService;
	}
}
```

### 단점

- @Autowired로 주입할 대상이 없을 경우 오류(NPE) 발생
- **선택, 변경의 가능성이 있는 의존 관계**에서 주로 사용하지만, 의존 관계를 변경하는 일은 드물다.

# 생성자 주입(Constructor Injection)

---

- 생성자에 @Autowired 어노테이션을 붙여 의존 관계를 주입한다.
- 단일 생성자일 경우 @Autowired 생략 가능

```java
@Controller
public class HomeController{
	private MemberService memberService;

	@Autowired
	public HomeController(MemberService memberService){
		this.memberService = memberService;
	}
}
```

### 장점

- 객체 생성 시 최초 1회 호출되는 것이 보장되기 때문에 final 키워드를 사용할 수 있다. → 불변성 O, 값을 설정하지 않으면 컴파일 시점에서 잡아주기 때문에 NPE이 발생하지 않는다.
- @RequiredArgsConstructor 롬북 사용시 생성자 조차도 작성할 필요가 없다.
- 특정 프레임워크에 의존하지 않아 순수 자바로 단위 테스트를 작성할 수 있어 테스트에 용이
- 필드 주입과 수정자 주입은 빈이 생성된 후에 참조를 하기 때문에 순환 참조 에러가 발생할 수 있지만 생성자 주입은 BeanCurrentlyInCreationException이 발생하여 순환 참조 에러를 방지
