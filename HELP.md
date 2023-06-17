Docker Set up:
========================
$ mvn clean install -Dmaven.test.skip=true
$ sudo docker-compose stop
$ sudo docker-compose down
$ sudo docker-compose up


Docker Help:
========================

$ sudo docker container ls
$ sudo docker image ls
$ sudo docker rmi $(sudo docker images -a -q)

$sudo docker rmi -f eaac0d79a695

$sudo docker images -a



Mysql Client which connect docker mysql container:
==================================================
sudo docker exec -it departmentservice-mysql-db-1 mysql -uroot -p

use springtraining;


SQL:
=======================

Refer: sql.txt

Sample Payload:
===============

Refer SampleAPIRequest.txt


Curl Requests:
==============



