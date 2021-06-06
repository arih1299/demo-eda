mvn spring-boot:run

or

mvn clean package
docker build -t campaign-restful .
docker run  --network=solace-net --name=campaign-restful campaign-restful  

make sure network is the same with the BFF

or use docker compose in main directory (up one)