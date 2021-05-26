DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

CREATE TABLE Department (
	DepartmentID		INT PRIMARY KEY AUTO_INCREMENT,
    DepartmentName 		VARCHAR(50)
);

CREATE TABLE Position (
	PositionID 			INT PRIMARY KEY AUTO_INCREMENT,
    PositionName 		VARCHAR(50)
);

CREATE TABLE `Account` (
	AccountID 			INT PRIMARY KEY AUTO_INCREMENT,
    Email				VARCHAR(100),
    UserName			VARCHAR(50),
    FullName			VARCHAR(50),
    DepartmentID		INT,
    PositionID 			INT,
    CreateDate			DATE
);

CREATE TABLE `GROUP` (
	GroupID 			INT PRIMARY KEY AUTO_INCREMENT,
    GroupName			VARCHAR(50),
    CreatorID			INT,
    CreateDate			DATE
);

CREATE TABLE GroupAccount (
	GroupID 			INT,
    AccountID 			INT,
    JoinDate			DATE
);

CREATE TABLE TypeQuestion (
	TypeID				INT PRIMARY KEY AUTO_INCREMENT,
	TypeName			VARCHAR(20)
);

CREATE TABLE CategoryQuestion (
	CategoryID			INT PRIMARY KEY AUTO_INCREMENT,
    CategoryName		VARCHAR(20)
);

CREATE TABLE Question (
	QuestionID 			INT PRIMARY KEY AUTO_INCREMENT,
    Content				VARCHAR(255),
    CategoryID			INT,
    TypeID				INT,
    CreatorID			INT,
    CreateDate			DATE
);

CREATE TABLE Answer (
	AnswerID 			INT PRIMARY KEY AUTO_INCREMENT,
    Content				VARCHAR(255),
    QuestionID 			INT,
    IsCorrect			BOOLEAN -- 1 - True ; 0 - False
);

CREATE TABLE Exam (
	ExamID				INT PRIMARY KEY AUTO_INCREMENT,
    `Code`				VARCHAR(10),
    Title				VARCHAR(50),
    CategoryID			INT,
    Duration			INT,
    CreatorID			INT,
    CreateDate			DATE
);

CREATE TABLE ExamQuestion (
	ExamID				INT,
    QuestionID 			INT
);