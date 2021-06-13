DROP DATABASE IF EXISTS ProjectDB;
CREATE DATABASE ProjectDB;
USE ProjectDB;

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccID		INT AUTO_INCREMENT PRIMARY KEY,
	FullName	VARCHAR(30) NOT NULL,
    Email		VARCHAR(50) UNIQUE NOT NULL,
    `Password`	VARCHAR(18) NOT NULL,
    ExpInYear 	INT UNSIGNED,
    ProSkill	ENUM("Dev", "Test", "Java", "SQL"), 
    `Type`		ENUM("Manager", "Employee") NOT NULL 
);

DROP TABLE IF EXISTS Project;
CREATE TABLE Project(
	ProID		INT AUTO_INCREMENT PRIMARY KEY,
	ProjectName	VARCHAR(100) NOT NULL,
    TeamSize 	INT UNSIGNED
);

DROP TABLE IF EXISTS ProjectAccount;
CREATE TABLE ProjectAccount(
	ProID	INT UNSIGNED,
    AccID	INT UNSIGNED,
    PRIMARY KEY(ProID,AccID)
);

INSERT INTO `account` ( FullName, Email, `Password`, ExpInYear, ProSkill, `Type`) 
VALUES 	('account1', 'email1@gmail.com', 'Acc1000', 	   6, 	'Dev',  'Manager'),
		('account2', 'email2@gmail.com', 'Acc2000', 	   4, 	'Dev', 'Manager'),
        ('account3', 'email3@gmail.com', 'Acc3000', 	null, 	 null,  'Employee');

INSERT INTO project (ProjectName, TeamSize) 
VALUES 	('project1', 15),
		('project2', 10),
        ('prọject3', 20);
        
INSERT INTO projectaccount(ProID, AccID)
VALUES	(1,1),
		(1,3),
        (2,2),
        (3,1),
        (3,2),
        (3,3);

