# 1. 자바 실행 환경(JDK) 기반 이미지 선택
FROM eclipse-temurin:17-jdk-jammy
# 2. 빌드된 jar 파일을 컨테이너 내부로 복사
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# 3. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]