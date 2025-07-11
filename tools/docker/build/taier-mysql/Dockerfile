# 构建mysql 从 8.0 版本开始
FROM bitnami/mysql:8.0

# 配置mysql
ENV MYSQL_DATABASE=taier
ENV MYSQL_ROOT_PASSWORD 123456

COPY sql/init.sql /docker-entrypoint-initdb.d
COPY tools/docker/build/taier-mysql/utf8mb4.cnf /opt/bitnami/mysql/conf/utf8mb4.cnf