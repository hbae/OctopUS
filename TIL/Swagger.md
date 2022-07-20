[Swagger API DOC 구축부터 실행까지](https://velog.io/@dkatlf900/swagger)

[[Swagger UI] Annotation 설명](https://velog.io/@gillog/Swagger-UI-Annotation-%EC%84%A4%EB%AA%85)

## Swagger?

- 간단한 설정으로 프로젝트의 API 목록을 **웹에서 확인 및 테스트**할 수 있게 해주는 Library
- Swagger를 사용하면 Controller에 정의되어 있는 모든 URL을 확인할 수 있다.
- API 목록 뿐 아니라 API의 명세 및 설명도 볼 수 있으며, 또한 API를 직접 테스트해볼 수 있다.
- Swagger를 사용하여 BackEnd 개발자가 문서 API를 만들면 FrontEnd 개발자는 해당 문서를 참조하여 데이터 처리

## SpringBoot에 Swagger 적용하기

### 1. Gradle 의존성 추가

[https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter](https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter)

```java
implementation 'io.springfox:springfox-boot-starter:3.0.0'
```

### 2. 호환 이슈 해결을 위해 yml에 설정 추가

```
/*****************************applications.yml****************************/

#swagger2
spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
```

### 3. Swagger 설정 Class 생성

```java
/**************SwaggerConfig.java********************/
package jpabook.jpashop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) // 대상 패키지 설정 //현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
                .paths(PathSelectors.any()) // apis중에서 어떤 경로로 된 API를 보여줄지 필터링   //any는 모두 보여준다.
                .build()
                //.groupName("API 1.0.0") // group별 명칭을 주어야 한다.
                //.pathMapping("/")
                .apiInfo(apiInfo());
                //.useDefaultResponseMessages(false); // 400,404,500 .. 표기를 ui에서 삭제한다.
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api_test 프로젝트")
                .description("API 호출 테스트용도.")
                .version("1.0.0")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build()
                ;
    }
}
```

### 4. Controller 어노테이션 추가

```
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@Api(tags = "test API")
@RequiredArgsConstructor
public class testController {

    @PostMapping(value = "/hello")
    @ApiOperation(value = "hello test", notes="hello를 테스트해본다.")
    @ApiResponses({
            @ApiResponse(code=404, message="주소 오류"),
            @ApiResponse(code=500, message="서버 에러")
    })
    public void hello() {

    }

}
```

### 5. 실행

[http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/#/test%20API)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/28a43492-07a1-4ad1-b96c-927dce0e38ac/Untitled.png)

## Swagger Annotation

| Annotation | Description |
| --- | --- |
| @Api | Controller에 대한 Title 명칭 부여 |
| @ApiOperation | Controller 안의 method의 설명 추가 |
| @ApiParam | DTO의 필드들에 대한 설명 추가  |
| @ApiResponse | 해당 Method의 응답에 대한 설명 |
| @ApiModelProperty | DTO 필드에 대한 예제 데이터 추가 |
| @ApiImplicitParam | API Method 호출에 필요한 Parameter들의 설명 추가 |
