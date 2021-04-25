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

local-proto-vs-json:
	curl -X GET http://localhost:8080/b2b/result/${runs} | jq .

ec2-proto-vs-json:
	curl -X GET http://11.0.1.195:8080/b2b/result/${runs} | jq .

jq:
	brew install jq
