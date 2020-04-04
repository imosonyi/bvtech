FROM mysql

ENV MYSQL_RANDOM_ROOT_PASSWORD yes

ADD ./setup.sql /docker-entrypoint-initdb.d/
