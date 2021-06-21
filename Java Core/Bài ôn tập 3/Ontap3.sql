-- create database
DROP DATABASE IF EXISTS Ontap3;
CREATE DATABASE Ontap3;
USE Ontap3;

-- create table: User
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` (
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 11 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
	`fullName` 		NVARCHAR(50) NOT NULL,
    `Role`			ENUM('USER', 'ADMIN')
);

-- create table: Manager
DROP TABLE IF EXISTS 	`Manager`;
CREATE TABLE IF NOT EXISTS `Manager` ( 	
	id 				SMALLINT UNSIGNED NOT NULL,
	`expInYear` 	SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY (id) REFERENCES `User`(id)
);

-- create table: Employee
DROP TABLE IF EXISTS 	`Employee`;
CREATE TABLE IF NOT EXISTS `Employee` ( 	
	id 				SMALLINT UNSIGNED NOT NULL,
    proSkill 		ENUM('DEV', 'TEST', 'JAVA', 'SQL') NOT NULL,
    FOREIGN KEY (id) REFERENCES `User`(id)
);

-- create table: Project
DROP TABLE IF EXISTS 	`Project`;
CREATE TABLE IF NOT EXISTS `Project` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Project_Name 	VARCHAR(50) NOT NULL,
	`teamSize`	 	SMALLINT UNSIGNED # Trigger TODO...
);

-- create table: Project & User
DROP TABLE IF EXISTS 	`ProjectAndUser`;
CREATE TABLE IF NOT EXISTS `ProjectAndUser` ( 	
	projectId 		SMALLINT UNSIGNED NOT NULL,
	userId	 		SMALLINT UNSIGNED NOT NULL,
    `Role`			ENUM ('MANAGER', 'EMPLOYEE'),
    FOREIGN KEY (projectId) REFERENCES `Project`(id),
    FOREIGN KEY (userId) REFERENCES `User`(id),
    PRIMARY KEY (projectId, userId)
);

-- Note: Manager của Project không liên quan gì tới Project Manager

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data User
INSERT INTO `User` 	(`email`,						`password`,		`fullName`,					`Role`)
VALUE				('admin@gmail.com',				'Admin123',		'admin',					'ADMIN'), 
					('daonq@viettel.com.vn',		'Admin123',		'daonq',					'ADMIN'), 
					('user1@vti.com',				'123456A',		'User 1',					'USER'), 
					('user2@vti.com',				'123456A',		'User 2',					'USER'), 
					('user3@vti.com',				'123456A',		'User 3',					'USER'), 
					('user4@vti.com',				'123456A',		'User 4',					'USER'),
					('user5@gmail.com', 			'123456A',		'User 5',					'USER'),
					('user6@gmail.com', 			'123456A',		'User 6',					'USER'),
					('user7@gmail.com', 			'123456A',		'User 7',					'USER'),
					('user8@gmail.com', 			'123456A',		'User 8',					'USER'),
					('user9@gmail.com', 			'123456A',  	'User 9',					'USER'),
					('user10@gmail.com', 			'123456A',		'User 10',					'USER'),
					('user11@gmail.com', 			'123456A',		'User 11',					'USER'),
					('user12@gmail.com', 			'123456A',		'User 12',					'USER'),
					('user13@gmail.com', 			'123456A',		'User 13',					'USER'),
					('user14@gmail.com', 			'123456A',		'User 14',					'USER'),
					('user15@gmail.com', 			'123456A',		'User 15',					'USER');

-- Add data Manager
INSERT INTO Manager (id,	`expInYear`	)
VALUE				(3,			1		), 
					(5,			2		), 
					(7,			3		), 
					(9,			5		), 
					(11,		7		), 
					(13,		8		), 
					(15,		9		), 
					(17,		10		);

-- Add data Employee
INSERT INTO Employee 	(id,	`proSkill`	)
VALUE					(2,			'DEV'	), 
						(4,			'DEV'	), 
						(6,			'TEST'	), 
						(8,			'TEST'	), 
						(10,		'JAVA'	), 
						(12,		'DEV'	), 
						(14,		'JAVA'	), 
						(16,		'SQL'	);
                        
-- Add data Project
INSERT INTO Project 	(`Project_Name`,	 `teamSize`	)
VALUE					('Project_Name_1',			3		), 
						('Project_Name_2',			3		), 
                        ('Project_Name_3',			2		), 
                        ('Project_Name_4',			4		), 
                        ('Project_Name_5',			8		);
                        
-- Add data `ProjectAndUser`
INSERT INTO `ProjectAndUser` 	(projectId	,	`userId`,	`Role`		)
VALUE							(1			,		1	,	'MANAGER'	), 
								(1			,		2	,	'EMPLOYEE'	), 
								(1			,		3	,	'EMPLOYEE'	), 
								(2			,		4	,	'EMPLOYEE'	), 
								(2			,		5	,	'MANAGER'	), 
								(2			,		6	,	'EMPLOYEE'	), 
								(3			,		7	,	'EMPLOYEE'	), 
								(3			,		8	,	'MANAGER'	);