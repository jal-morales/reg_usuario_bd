FROM openjdk:21-ea-24-oracle

WORKDIR /app
COPY target/registro_usuario-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_D6H1JBABITACQEY4 /app/oracle_wallet
EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]