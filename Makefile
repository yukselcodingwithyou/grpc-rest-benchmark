runs = 10

compile:
	mvn compile
clean:
	mvn clean
install:
	mvn clean install
test:
	mvn clean test
run:
	mvn spring-boot:run

get:
	curl -X GET http://localhost:8080/b2b/result/${runs} | jq .

post:
	curl -X POST http://localhost:8080/b2b/result/${runs} | jq .

jq:
	brew install jq
