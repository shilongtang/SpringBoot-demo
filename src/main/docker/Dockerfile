#1.java:8 jdk版本
#2.demo-master.jar jar包名称
#3.ADD demo-master.jar  demo-master.jar拷贝jar到容器
#4.ENTRYPOINT 执行jar文件
FROM java:8
VOLUME /tmp
ADD demo-0.0.1-SNAPSHOT.jar /demo-master.jar
RUN sh -c 'touch /demo-master.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo-master.jar"]