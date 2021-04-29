runs = 10
testfile = testfile

compile:
	mvn compile

clean:
	mvn clean

install:
	mvn clean install

test:
	mvn clean test

load-test:
	jmeter --testfile ${testfile}

run:
	mvn spring-boot:run

proto-vs-json:
	curl -X GET http://localhost:8080/b2b/result/${runs}
