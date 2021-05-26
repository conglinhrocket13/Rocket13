use testing_System_Assignment_1;

ALTER TABLE `account` ADD UNIQUE KEY (Email);
ALTER TABLE groupaccount
	ADD PRIMARY KEY (GroupID, AccountID);
ALTER TABLE examquestion
	ADD PRIMARY KEY (ExamID, QuestionID);
    
ALTER TABLE `account`
	ADD CONSTRAINT fk_DepID FOREIGN KEY (DepartmentID) REFERENCES department (DepartmentID) ON DELETE CASCADE;
ALTER TABLE `account`
	ADD CONSTRAINT fk_PosID FOREIGN KEY (PositionID) REFERENCES position (PositionID) ON DELETE CASCADE;
ALTER TABLE `group`
	ADD CONSTRAINT fk_GroupID FOREIGN KEY (GroupID) REFERENCES groupaccount (GroupID) ON DELETE CASCADE;    
ALTER TABLE groupaccount
	ADD CONSTRAINT fk_GaAccID FOREIGN KEY (AccountID) REFERENCES `account` (AccountID) ON DELETE CASCADE;
ALTER TABLE question
	ADD CONSTRAINT fk_TypeID FOREIGN KEY (TypeID) REFERENCES typequestion (TypeID) ON DELETE CASCADE;
ALTER TABLE question
	ADD CONSTRAINT fk_CategoryID FOREIGN KEY (CategoryID) REFERENCES categoryquestion (CategoryID) ON DELETE CASCADE;
ALTER TABLE exam
	ADD CONSTRAINT fk_ExamCategoryID FOREIGN KEY (CategoryID) REFERENCES categoryquestion (CategoryID) ON DELETE CASCADE;
ALTER TABLE examquestion
	ADD CONSTRAINT fk_ExamID FOREIGN KEY (ExamID) REFERENCES exam (ExamID) ON DELETE CASCADE;
ALTER TABLE examquestion
	ADD CONSTRAINT fk_QuestID FOREIGN KEY (QuestionID) REFERENCES question (QuestionID) ON DELETE CASCADE;
ALTER TABLE answer
	ADD CONSTRAINT fk_AnswerQID FOREIGN KEY (QuestionID) REFERENCES question (QuestionID) ON DELETE CASCADE;
    
INSERT INTO department
(
	DepartmentName
) VALUES
	(N'Nhân sự'),
	(N'Kế toán'),
    ('Marketing'),
    (N'Chăm sóc khách hàng'),
    ('IT');

INSERT INTO position
(
	PositionName
) VALUES
	('Personnel manager'),
    ('Accounting manager'),
    ('Marketing manager'),
    ('Customer care staff'),
    ('QC'),
    ('Dev'),
    ('Tester');
    
INSERT INTO `account`
(
	Email,
    UserName,
    FullName,
    DepartmentID,
    PositionID,
    CreateDate
) VALUES
	('nguyendong@yahoo.com'		,'nvdong89'		,N'Nguyễn Văn Đông'			,1,1,'2019/06/15'),
    ('duonghoai@yahoo.com'		,'hoailovely2'	,N'Dương Thị Thu Hoài'		,2,2,'2020/10/06'),
	('quynhmap@gmail.com'		,'quynhmap99'	,N'Hoàng Văn Quỳnh'			,3,3,'2020/03/01'),
    ('duyenkitty@gmail.com'		,'duyenorion'	,N'Nguyễn Thị Duyên'		,4,4,'2019/09/03'),
    ('tuannguyen@gmail.com'		,'NVT1997'		,N'Nguyễn Văn Tuấn'			,5,5,'2019/08/22');
    
INSERT INTO `group`
(
	GroupName,
    CreatorID,
    CreateDate
) VALUES
	(N'Nhóm phát triển sản phẩm'		,3,'2020/07/25'),
    (N'Nhóm đào tạo nhân viên'			,1,'2019/10/01'),
    (N'Nhóm báo thưởng-phạt'			,1,'2020/01/03'),
    (N'Thông báo lỗi'					,5,'2020/11/08'),
    (N'Nhóm chém gió'					,4,'2019/12/10');
    
INSERT INTO groupaccount
(
	GroupID,
    AccountID,
    JoinDate
) VALUES
	(1,3,'2020/07/25'),
    (1,1,'2020/07/25'),
    (2,1,'2019/10/01'),
    (3,1,'2020/01/03'),
    (4,5,'2020/11/08'),
    (5,4,'2019/12/10');
    
INSERT INTO categoryquestion
(
	CategoryName
) VALUES
	('Java'),
    ('.Net'),
    ('SQL'),
    ('PHP'),
    ('C#'),
    ('HTML');

INSERT INTO typequestion
(
	TypeName
) VALUES
	('Essay'),
    ('Multiple-Choice');

INSERT INTO question
(
	Content,
    CategoryID,
    TypeID,
    CreatorID,
    CreateDate
) VALUES
	('Câu hỏi số 1'				,1,1,5,'2021/05/04'),
    ('Câu hỏi số 2'				,2,2,1,'2021/05/04'),
    ('Câu hỏi số 3'				,3,1,3,'2021/05/04'),
    ('Câu hỏi số 4'				,4,2,1,'2021/05/04'),
    ('Câu hỏi số 5'				,5,1,5,'2021/05/04');

INSERT INTO exam
(
	`Code`,
    Title,
    CategoryID,
    Duration,
    CreatorID,
    CreateDate
) VALUES
	('MS1'	,'Mã đề thi 1'				,1,90,5,'2021/05/04'),
    ('MS2'	,'Mã đề thi 2'				,2,90,1,'2021/05/04'),
    ('MS3'	,'Mã đề thi 3'				,3,45,3,'2021/05/04'),
    ('MS4'	,'Mã đề thi 4'				,4,45,1,'2021/05/04'),
    ('MS5'	,'Mã đề thi 5'				,5,90,5,'2021/05/04');

INSERT INTO examquestion
(
	ExamID,
	QuestionID
) VALUES
	(1,1),
    (1,2),
    (2,5),
    (2,4),
    (3,1),
    (4,3),
    (5,2),
    (5,1);
    
INSERT INTO answer
(
	AnswerID,
    Content,
    QuestionID,
    IsCorrect
) VALUES
	('Đáp án câu 1'			,1,'TRUE'),
    ('Đáp án câu 2'			,2,'TRUE'),
    ('Đáp án câu 3'			,3,'TRUE'),
    ('Đáp án câu 4'			,4,'TRUE'),
    ('Đáp án câu 5'			,5,'TRUE');