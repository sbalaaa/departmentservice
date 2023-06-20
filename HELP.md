Docker Set up:
========================
$ mvn clean install -Dmaven.test.skip=true
$ sudo docker-compose stop
$ sudo docker-compose down
$ sudo docker-compose down --remove-orphans
$ sudo docker-compose up


Docker Help:
========================

$ sudo docker container ls
$ sudo docker image ls
$ sudo docker rmi $(sudo docker images -a -q) // Use it carefully

Removing the container:
$ sudo docker container rm $(sudo docker ps -aq) // remove all the containers
$ sudo docker container rm 6c95ef1fbf05 bb2f23cdc05e 63f18c2214fe 038501e102b3
$ sudo docker container rm 6c95ef1fbf05 bb2f23cdc05e 63f18c2214fe 038501e102b3

$ sudo docker start container d0d77cf692d6


Image:
$sudo docker image rm b236342adfd3
$sudo docker images -a



Mysql Client which connect docker mysql container:
==================================================
sudo docker exec -it departmentservice_mysql-db_1 mysql -uroot -p

use springtraining;

Docker miscellaneous
====================
sudo docker run --name=[container_name] -d [image_tag_name]
sudo docker run --name=mysql-db -d mysql -e MYSQL_ROOT_PASSWORD=root -v mysql-db:/var/lib/mysql --network service-mysql
sudo docker run --name=department-api -d departmentservice_department-api -p 9080:9080 --network service-mysql



SQL:
=======================

Refer: sql.txt

Sample Payload:
===============

Refer SampleAPIRequest.txt


Curl Requests:
==============


Links:
https://stackoverflow.com/questions/56441497/docker-mysql-cant-connect-from-spring-boot-app-to-mysql-database



Run the sonar from the command line:
From Maven Side:
mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=myAuthenticationToken 
mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=b14696ba605f403ec7f1665a1af47bd8b528359d