CREATE DATABASE usermanagement DEFAULT CHARACTER SET utf8;

USE usermanagement;

CREATE TABLE user(id SERIAL,login_id varchar(255) UNIQUE NOT NULL,name varchar(255)NOT NULL,
					birth_date DATE NOT NULL,password varchar(255)NOT NULL,
					create_date DATETIME NOT NULL,update_date DATETIME NOT NULL);

INSERT INTO user(login_id,name,birth_date,password,create_date,update_date)
 VALUES('admin','ä«óùé“',19991231,'pass',20180514,20180514);

INSERT INTO user()
 VALUES();

SELECT * FROM user WHERE login_id = 'y' AND name LIKE %óR% ;
 OR TO_DATE('','YYYY/MM/DD') <= birth_date and birth_date <= TO_DATE('','YYYY/MM/DD');

DROP DATABASE usermanagement;

DROP TABLE

DELETE FROM user WHERE id = 25;


INSERT INTO user (login_id,name,birth_date,password,create_date,update_date )
 VALUES('1','1','1000-01-01','1',now(),now());
 
 UPDATE user SET name ='kk' ,birth_date ='20180502',password ='kk' ,update_date =now() WHERE id = 9;
 
 SELECT * FROM user WHERE birth_date BETWEEN '2017-02-01' AND '2018-06-01';
 (TO_DATE('2017/1/1','YYYY/MM/DD') 
 <= birth_date and birth_date <= TO_DATE('2018/12/12','YYYY/MM/DD'));
