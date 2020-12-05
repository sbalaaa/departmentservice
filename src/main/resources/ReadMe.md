Sample Requests:

http://localhost:8889/api/departments - Method GET
http://localhost:8889/api/departments/1 - Method GET

New Department Creation:

Accept application/json
Content-Type application/json

http://localhost:8889/api/departments - Method POST
{
    "name": "TEST"
}


Department Updation:

http://localhost:8889/api/departments/7 - Method PUT
{"number":7,"name":"TEST"}

Department DELETION:
http://localhost:8889/api/departments/7

http://localhost:8889/api/employees - Method GET
http://localhost:8889/api/employees/1 - Method GET

New Employee Creation:

Accept application/json
Content-Type application/json

http://localhost:8889/api/employees - Method POST

{
    "firstName": "FIRST",
    "lastName": "LAST",
    "gender": "M",
    "age": 25,
    "email": "TEST@gmail.com",
    "phoneNumber": "1234567891",
    "hireDate": 1138213800000,
    "salary": 8000,
    "departmentId": {
        "number": 2,
        "name": "MATHS"
    }
}



Employee Updation: - Method PUT

{
    "employeeId": 7,
    "firstName": "FIRST-Update",
    "lastName": "LAST",
    "gender": "M",
    "age": 25,
    "email": "TEST@gmail.com",
    "phoneNumber": "1234567891",
    "hireDate": 1138213800000,
    "salary": 8000,
    "departmentId": {
        "number": 2,
        "name": "MATHS"
    }
}


Employee DELETION"
http://localhost:8889/api/employees/1 - Method GET


--------------------------- H2 Database -----------------------
http://localhost:8080/h2-console
  jdbc:h2:mem:testdb
  username: dbuser
  password: letmein

--------------------------- H2 SQL -------------------------------
CREATE TABLE PUBLIC.DEPARTMENTS (DEPARTMENT_ID BIGINT NOT NULL auto_increment, DEPARTMENT_NAME VARCHAR(40) NOT NULL, 
CONSTRAINT PK_DEPARTMENTS PRIMARY KEY (DEPARTMENT_ID));

CREATE UNIQUE INDEX PUBLIC.IDX_DEPARTMENTS ON PUBLIC.DEPARTMENTS(DEPARTMENT_ID);

CREATE TABLE PUBLIC.EMPLOYEES (EMPLOYEE_ID BIGINT NOT NULL auto_increment, FIRST_NAME VARCHAR(20) NOT NULL, LAST_NAME VARCHAR(20) NOT NULL,
 EMAIL VARCHAR(20) NOT NULL, GENDER CHAR NOT NULL, AGE BIGINT NOT NULL, PHONE_NUMBER VARCHAR(20) NOT NULL, 
 DEPARTMENT_ID_FK  BIGINT NOT NULL, HIRE_DATE DATE NOT NULL, SALARY BIGINT(20) NOT NULL,
 CONSTRAINT PK_EMPLOYEES PRIMARY KEY (EMPLOYEE_ID));

CREATE UNIQUE INDEX PUBLIC.IDX_EMPLOYEES ON PUBLIC.EMPLOYEES(EMPLOYEE_ID);

ALTER TABLE PUBLIC.EMPLOYEES ADD CONSTRAINT EMPLOYEES_FK FOREIGN KEY (DEPARTMENT_ID_FK) REFERENCES PUBLIC.DEPARTMENTS (DEPARTMENT_ID);

INSERT into DEPARTMENTS (DEPARTMENT_NAME)VALUES ('Physics');
INSERT into DEPARTMENTS (DEPARTMENT_NAME)VALUES ('CS');
INSERT INTO DEPARTMENTS (DEPARTMENT_NAME)VALUES('Chemistry');


INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('ARIVU','KUMAR','M',35,'ARIVU@gmail.com','1234567890',DATE'2006-01-26',10000,1);
INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('RANI','ASHOK','F',23,'RANI@gmail.com','1234567892',DATE'2006-01-26',8000,3);
INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('DEVI','SARAVANAN','F',23,'DEVI@gmail.com','1234567893',DATE'2006-01-26',8000,3);

--------------------------MySQL------------------------------------------
create database testdb;
use  testdb;

CREATE TABLE DEPARTMENTS (
  department_id INT NOT NULL AUTO_INCREMENT,
  department_name VARCHAR(50) DEFAULT NULL,
  hod VARCHAR(45) DEFAULT NULL,
  is_regular CHAR(1) DEFAULT NULL,
  PRIMARY KEY (department_id)
) ;


INSERT INTO DEPARTMENTS (department_name,hod,is_regular) VALUES ('Physics','Raman','R');
INSERT INTO DEPARTMENTS (department_name,hod,is_regular) VALUES ('CS','Sunil','S');
INSERT INTO DEPARTMENTS (department_name,hod,is_regular) VALUES ('Chemistry','Selvin','R');

 CREATE TABLE EMPLOYEES (
  employee_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  gender CHAR(1) NOT NULL,
  age INT NOT NULL,
  email VARCHAR(50) NOT NULL,
  phone_number VARCHAR(50) NOT NULL,
  hire_date DATE NOT NULL,
  salary INT NOT NULL,
  department_id_fk INT NOT NULL,	
  PRIMARY KEY (employee_id)
) ;

ALTER TABLE EMPLOYEES ADD FOREIGN KEY (department_id_fk) REFERENCES DEPARTMENTS(department_id);



INSERT INTO EMPLOYEES(first_name,last_name,gender,age,email,phone_number,hire_date,salary,department_id_fk)
	    VALUES('ARIVU','KUMAR','M',35,'ARIVU@gmail.com','1234567890','2006-01-26',10000,1);
INSERT INTO EMPLOYEES(first_name,last_name,gender,age,email,phone_number,hire_date,salary,department_id_fk)
	    VALUES('RANI','ASHOK','F',23,'RANI@gmail.com','1234567892','2006-01-26',8000,3);
INSERT INTO EMPLOYEES(first_name,last_name,gender,age,email,phone_number,hire_date,salary,department_id_fk)
	    VALUES('DEVI','SARAVANAN','F',23,'DEVI@gmail.com','1234567893','2006-01-26',8000,3);
INSERT INTO EMPLOYEES(first_name,last_name,gender,age,email,phone_number,hire_date,salary,department_id_fk)
	    VALUES('DURAI','NAVEEN','M',23,'DURAI@gmail.com','1234567894','2006-01-26',8000,3);
INSERT INTO EMPLOYEES(first_name,last_name,gender,age,email,phone_number,hire_date,salary,department_id_fk)
	    VALUES('KESAVAN','MUTHU','M',23,'KESAVAN@gmail.com','1234567895','2006-01-26',8000,2);


--------------------------- DERBY REFERENCE --------------------------------
PATH C:\Program Files\Java\jdk1.8.0_25\db\bin
DERBY_HOME C:\Program Files\Java\jdk1.8.0_25\db
 
Go to Your Prefered Location using command line:
 
To start the Derby Database Server:
 
cd D:\balachandar\Database\school (Your location)
java -jar "%DERBY_HOME%\lib\derbyrun.jar" server start
 
 
To open client console:
cd D:\balachandar\Database\school (Your location)
>ij
>CONNECT 'jdbc:derby://localhost:1527/testdb;create=true;user=root;password=root'; (First time)
>CONNECT 'jdbc:derby://localhost:1527/testdb;user=root;password=root';(Subsequent Time)
'jdbc:derby://localhost:1527/training;user=root;password=root';

>CONNECT 'jdbc:derby://localhost:1527/testdb;user=root;password=root';(Subsequent Time)


-------------------------------------------------------------------------------------

DERBY  SQL :


CREATE TABLE  DEPARTMENTS (
  DEPARTMENT_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  DEPARTMENT_NAME VARCHAR(30) NOT NULL,
  CREATED_BY VARCHAR(20)
);
 
 
CREATE TABLE  EMPLOYEES (
  EMPLOYEE_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  FIRST_NAME VARCHAR(20) NOT NULL,
  LAST_NAME VARCHAR(20) NOT NULL,
  EMAIL VARCHAR(20) NOT NULL,
  GENDER CHAR  NOT NULL,
  AGE INTEGER NOT NULL,
  PHONE_NUMBER VARCHAR(20) NOT NULL,
  DEPARTMENT_ID_FK INTEGER NOT NULL,
  HIRE_DATE DATE NOT NULL,
  SALARY INTEGER NOT NULL,	
  CREATED_BY VARCHAR(20)
);
 
ALTER TABLE DEPARTMENTS ADD PRIMARY KEY(DEPARTMENT_ID);
ALTER TABLE EMPLOYEES ADD PRIMARY KEY(EMPLOYEE_ID);
 
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (DEPARTMENT_ID_FK) REFERENCES DEPARTMENTS(DEPARTMENT_ID);
 
SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM DEPARTMENTS;
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPARTMENT_ID_FK  FROM EMPLOYEES;
 
 
INSERT into DEPARTMENTS (DEPARTMENT_NAME)VALUES ('Physics');
INSERT into DEPARTMENTS (DEPARTMENT_NAME)VALUES ('CS');
INSERT INTO DEPARTMENTS (DEPARTMENT_NAME)VALUES('Chemistry');



INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('ARIVU','KUMAR','M',35,'sample0@gmail.com','1234567890',DATE('2006-01-26'),10000,1);
INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('BABU','RAMU','M',25,'sample1@gmail.com','1234567891',DATE('2006-01-26'),8000,2);
INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('RANI','ASHOK','F',23,'sample2@gmail.com','1234567892',DATE('2006-01-26'),8000,3);
INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('DEVI','SARAVANAN','F',23,'sample3@gmail.com','1234567893',DATE('2006-01-26'),8000,3);
INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('DURAI','NAVEEN','M',23,'sample4@gmail.com','1234567894',DATE('2006-01-26'),8000,3);
INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,GENDER,AGE,EMAIL,PHONE_NUMBER,HIRE_DATE,SALARY,DEPARTMENT_ID_FK)
	    VALUES('KESAVAN','MUTHU','M',23,'sample5@gmail.com','1234567895',DATE('2006-01-26'),8000,3);
	    
	    
-------------------------------------------------------------------------------------

java -jar -Dspring.profiles.active=mysql target/departmentservice.jar
java -jar target/departmentservice.jar

mvn -Dspring.profiles.active=mysql spring-boot:run
mvn -Dspring.profiles.active=mysql spring-boot:run

http://192.168.187.1:8888/api/employees
http://localhost:8888/api/employees
