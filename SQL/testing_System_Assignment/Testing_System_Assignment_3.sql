use testing_system_assignment_1;

-- Question 1: Thêm ít nhất 10 record vào mỗi table
# nhập vào bảng department
INSERT INTO department
(
	DepartmentName
) VALUES
	('Manager'),
	('Sales'),
	(N'Hành chính'),
    ('Security'),
    (N'Phát triển'),
    (N'Tài vụ'),
    (N'Kế hoạch'),
    (N'Đào tạo');

# nhập vào bảng position
INSERT INTO position
(
	PositionName
) VALUES
	('Manager'),
    ('Accounting'),
    ('Marketing'),
    (N'Bảo vệ'),
    ('Employees'),
    ('Telesale'),
    ('Cashier'),
    ('Trainer');
    
# nhập vào bảng account
INSERT INTO `account`
(
	Email,
    UserName,
    FullName,
    DepartmentID,
    PositionID,
    CreateDate
) VALUES
	('traingoan@yahoo.com'		,'notbadtoday'		,N'Nguyễn Văn Thìn'			,9,11,'2019/09/19'),
    ('maido_97@gmail.com'		,'maido97'			,N'Đỗ Thị Mai'				,7,13,'2020/03/06'),
	('bichngocmay3@gmail.com'	,'bichngocmay3'		,N'Nguyễn Thị Bích Ngọc'	,11,14,'2019/03/03'),
    ('trongcon@gmail.com'		,'quoctrong2'		,N'Lê Quốc Trọng'			,12,12,'2019/09/03'),
    ('hathoatt@gmail.com'		,'thoavanha'		,N'Hà Văn Thỏa'				,6,8,'2019/02/28'),
    ('khangngoc@gmail.com'		,'khangngoc'		,N'Lý Ngọc Khang'			,13,15,'2019/03/24'),
    ('damanhngocc@gmail.com'	,'damngocanh'		,N'Đàm Ngọc Ánh'			,2,9,'2020/11/05');
    
# nhập vào bảng group
INSERT INTO `group`
(
	GroupName,
    CreatorID,
    CreateDate
) VALUES
	(N'Nhóm 6'		,9,'2020/04/25'),
    (N'Nhóm bảy'	,10,'2019/11/21'),
    (N'Nhóm bát'	,7,'2020/07/08'),
    (N'Thông cửu'	,11,'2020/11/08'),
    (N'Nhóm thập'	,12,'2020/12/10'),
    (N'Nhóm 11'		,4,'2020/07/25'),
    (N'Nhóm mười 2'	,8,'2019/12/13'),
    (N'Nhóm 10 ba'	,6,'2020/02/14'); 
    
# nhập vào bảng groupaccount
INSERT INTO groupaccount
(
	GroupID,
    AccountID,
    JoinDate
) VALUES
	(6,9,'2020/04/25'),
    (6,11,'2020/04/26'),
    (7,10,'2019/11/21'),
    (8,7,'2020/07/08'),
    (9,11,'2020/11/08'),
    (10,12,'2020/12/10'),
    (10,4,'2019/12/12'),
    (11,4,'2020/07/25'),
    (12,8,'2019/12/13'),
    (13,6,'2020/02/14');

# nhập vào bảng question
INSERT INTO question
(
	Content,
    CategoryID,
    TypeID,
    CreatorID,
    CreateDate
) VALUES
	('Câu hỏi số 6'				,1,1,5,'2021/05/04'),
    ('Câu hỏi số 7'				,2,2,9,'2021/05/04'),
    ('Câu hỏi số tám'			,3,1,7,'2021/05/04'),
    ('Câu hỏi số chín'			,4,2,11,'2021/05/05'),
    ('Câu hỏi số mười'			,5,1,5,'2021/05/05'),
    ('Câu hỏi số mười một'		,1,1,6,'2021/05/05'),
    ('Câu hỏi số 12'			,2,2,8,'2021/05/05'),
    ('Câu hỏi số 13'			,3,1,10,'2021/05/05'),
    ('Câu hỏi số 14'			,4,2,12,'2021/05/05');
    
# nhập vào bảng exam
INSERT INTO exam
(
	`Code`,
    Title,
    CategoryID,
    Duration,
    CreatorID,
    CreateDate
) VALUES
    ('MS6'	,'Mã đề thi 6'				,3,45,8,'2021/05/04'),
    ('MS7'	,'Mã đề thi 7'				,4,45,7,'2021/05/04'),
    ('MS8'	,'Mã đề thi 8'				,5,90,5,'2021/05/05'),
    ('MS9'	,'Mã đề thi 9'				,1,90,10,'2021/05/05'),
    ('MS10'	,'Mã đề thi 10'				,2,90,11,'2021/05/05'),
    ('MS11'	,'Mã đề thi 11'				,3,45,3,'2021/05/05'),
    ('MS12'	,'Mã đề thi 12'				,4,45,10,'2021/05/05'),
    ('MS13'	,'Mã đề thi 13'				,5,90,5,'2021/05/05'),
	('MS14'	,'Mã đề thi 4'				,1,90,9,'2021/05/05'),
    ('MS15'	,'Mã đề thi 5'				,2,90,9,'2021/05/05');

# nhập vào bảng examquestion
INSERT INTO examquestion
(
	ExamID,
	QuestionID
) VALUES
	(6,10),
    (7,11),
    (8,7),
    (8,12),
    (9,9),
    (10,1),
    (11,8),
    (11,13),
    (12,6),
    (13,14);
    
# nhập vào bảng answer
INSERT INTO answer
(
    Content,
    QuestionID,
    IsCorrect
) VALUES
	('Đáp án câu 6'			,6,1),
    ('Đáp án câu 7'			,7,1),
    ('Đáp án câu 8'			,8,1),
    ('Đáp án câu 9'			,9,1),
    ('Đáp án câu 10'		,10,1),
    ('Đáp án câu 11'		,11,1),
    ('Đáp án câu 12'		,12,1),
    ('Đáp án câu 13'		,13,1),
    ('Đáp án câu 14'		,14,1),
    ('Đáp án câu 14-2'		,14,1),
    ('Đáp án câu 14-3'		,14,1),
	('Đáp án câu 14-4'		,14,1);
    
-- Question 2: lấy ra tất cả các phòng ban
SELECT * FROM department;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT 	departmentID 
FROM 	department 
WHERE	DepartmentName ='Sales';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT	 *
FROM 	 `account`
WHERE
		LENGTH(FullName) = (SELECT  MAX(LENGTH(FullName)) FROM `account`);

/* Question 5: Lấy ra thông tin account có full name dài nhất 
				và thuộc phòng ban có id = 3 */
SELECT	 *
FROM 	 `account`
WHERE
		LENGTH(FullName) = (SELECT  MAX(LENGTH(FullName))
							FROM 	`account` 
							WHERE	 DepartmentID='3');
                            
-- Question 6: Lấy ra tên group đã tạo trước ngày 20/12/2019
SELECT 	GroupID, GroupName, CreateDate
FROM	`group`
WHERE	CreateDate < '2019/12/20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID 
FROM answer
GROUP BY QuestionID
HAVING COUNT(AnswerID)>=4;

/* Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút 
				và được tạo trước ngày 05/05/2021 */
SELECT `Code`,Duration,CreateDate
FROM exam
WHERE Duration >= 60 AND CreateDate < '2021/05/05';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT *
FROM `group`
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT 	COUNT(1)
FROM 	`account`
WHERE 	DepartmentID=2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT AccountID,FullName
FROM `account`
WHERE FullName LIKE 'D%o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM exam
WHERE CreateDate < '2019/12/20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM question
WHERE Content like 'câu hỏi%';

/* Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" 
				và email thành loc.nguyenba@vti.com.vn */
UPDATE `account` 
SET 
	FullName = 'Nguyễn Bá Lộc',
    Email = 'loc.nguyenba@vti.com.vn'
WHERE
    AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE groupaccount
SET 
	GroupID = 4
WHERE
    AccountID = 5;