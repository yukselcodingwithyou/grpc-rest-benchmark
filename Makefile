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

local-load-test:
	jmeter -n --testfile src/test/jmeter/local-grpc.jmx
	jmeter -n --testfile src/test/jmeter/local-rest.jmx

ec2-load-test:
	jmeter -n --testfile src/test/jmeter/ec2-grpc.jmx
	jmeter -n --testfile src/test/jmeter/ec2-rest.jmx

jq:
	brew install jq
