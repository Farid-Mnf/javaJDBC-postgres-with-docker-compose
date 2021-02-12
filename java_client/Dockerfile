FROM  openjdk

WORKDIR /app

COPY postgres-driver.jar /app/
COPY Main.java /app/
COPY input_data.txt /app/

RUN javac -cp ".:postgres-driver.jar" Main.java

CMD java -cp ".:postgres-driver.jar" Main

EXPOSE 8050
