
# [O] - 01. 인텔리제이로 스프링 부트 시작하기 
# [O] - 02. 스프링 부트에서 테스트 코드를 작성하자
# [O] - 03. 스프링 부트에서 JPA로 데이터베이스 다뤄보자
# [O] - 04. 머스테치로 화면 구성하기
# [O] - 05. 스프링 시큐리티와 OAuth 2.0으로 로그인 기능 구현하기
# [O] - 06. AWS 서버 환경을 만들어보자 - AWS EC2
# [O] - 07. AWS에 데이터베이스 환경을 만들어보자 - AWS RDS
# [O] - 08. EC2 서버에 프로젝트를 배포해 보자
# [x] - 09. 코드가 푸시되면 자동으로 배포해 보자 - Travis CI 배포 자동화
# [x] - 10. 24시간 365일 중단 없는 서비스를 만들자
# [x] - 11. 1인 개발 시 도움이 될 구조와 조언들

# ISSUE
### Step. 06
-> EC2에서 ./gradlew test 실행시 테스트 코드서 오류 발생

com.jojoldu.book.springboot.domain.posts.PostsRepositoryTest > select_posts FAILED
    java.lang.IllegalStateException
        Caused by: org.springframework.beans.factory.BeanDefinitionStoreException
            Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException

com.jojoldu.book.springboot.domain.posts.PostsRepositoryTest > BaseTimeEntity_enroll FAILED
    java.lang.IllegalStateException
        Caused by: org.springframework.beans.factory.BeanDefinitionStoreException
            Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException

com.jojoldu.book.springboot.web.IndexControllerTest > mainpaging_loading FAILED
    java.lang.IllegalStateException
        Caused by: org.springframework.beans.factory.BeanDefinitionStoreException
            Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException

com.jojoldu.book.springboot.web.HelloControllerTest > helloDto_return FAILED
    java.lang.IllegalStateException
        Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException
            Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException

com.jojoldu.book.springboot.web.HelloControllerTest > hello_return FAILED
    java.lang.IllegalStateException
        Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException
            Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException

com.jojoldu.book.springboot.web.PostsApiControllerTest > Posts_?깅줉?쒕떎 FAILED
    java.lang.IllegalStateException
        Caused by: org.springframework.beans.factory.BeanDefinitionStoreException
            Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException

com.jojoldu.book.springboot.web.PostsApiControllerTest > Posts_?섏젙?쒕떎 FAILED
    java.lang.IllegalStateException
        Caused by: org.springframework.beans.factory.BeanDefinitionStoreException
            Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException

### <> test code 제외 빌드
-> './gradlew clean bootJar'

### git 모든 cashe 삭제 후 재 push (저장소 초기화)
-> './gradlew test' 성공
1. git bash 실행
2. git rm -r . --cached
3. git status
4. git add --all
5. git commit -m "apply gitignore"
6. git push origin master

### H2 DB entity 자동 DDL 안되는 현상
-> JDBC URL 변경 : jdbc:h2:mem:testdb
