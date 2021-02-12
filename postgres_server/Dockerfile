FROM postgres:9.6.1

COPY table_init.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_PASSWORD pass

EXPOSE 5432
