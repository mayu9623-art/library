# 1. ビルドステージ
FROM gradle:8-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon

# 2. 実行ステージ
FROM eclipse-temurin:17-alpine
COPY --from=build /home/gradle/src/build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]