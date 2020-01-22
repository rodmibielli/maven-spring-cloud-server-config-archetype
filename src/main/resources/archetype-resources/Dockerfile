FROM openjdk
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE ${port}
ENTRYPOINT ["java","-cp","app:app/lib/*","${package}.Application"]
