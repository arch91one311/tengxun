# 使用官方的 OpenJDK 8 镜像作为基础镜像
FROM openjdk:8-jre

# 将应用程序的 JAR 文件复制到容器中
COPY ../gateway-bootstrap-1.0-SNAPSHOT.jar /app/gateway-bootstrap-1.0-SNAPSHOT.jar

# 将 config、lib、logs 目录复制到容器中
COPY ../config /app/config
COPY ../lib /app/lib
COPY ../logs /app/logs

# 设置工作目录
WORKDIR /app

# 暴露应用程序使用的端口
EXPOSE 9009

# 运行 JAR 文件
CMD ["java", "-jar", "/app/gateway-bootstrap-1.0-SNAPSHOT.jar"]
