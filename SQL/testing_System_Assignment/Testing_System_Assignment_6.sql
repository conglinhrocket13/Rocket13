use testing_system_assignment_1;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS GetFullName_inDept;
DELIMITER $$
CREATE PROCEDURE GetFullName_inDept(IN dep_name VARCHAR(50))
BEGIN
	SELECT a.AccountID, a.FullName, a.Email FROM `account` a 
    INNER JOIN department d On a.DepartmentID=d.DepartmentID
	WHERE d.DepartmentName= dep_name;
END$$
DELIMITER ;

CALL GetFullName_inDept('Marketing Department');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS GetCountAccInGroup;
DELIMITER $$
CREATE PROCEDURE GetCountAccInGroup()
BEGIN
	SELECT g.GroupName, count(1) FROM groupaccount ga
	INNER JOIN `group` g ON g.CreatorID=ga.GroupID
	GROUP BY ga.GroupID;
END$$
DELIMITER ;

CALL GetCountAccInGroup();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS GetCountTypeInMonth;
DELIMITER $$
CREATE PROCEDURE GetCountTypeInMonth()
BEGIN
	SELECT q.TypeID, COUNT(q.TypeID) FROM question q 
INNER JOIN typequestion tq ON tq.TypeID=q.TypeID
WHERE month(q.CreateDate) = month(now()) AND year(q.CreateDate) = year(now())
GROUP BY q.TypeID;
END$$
DELIMITER ;

CALL GetCountTypeInMonth();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS GetTypeIDBestInMonth;
DELIMITER $$
CREATE PROCEDURE GetTypeIDBestInMonth(OUT v_ID TINYINT)
BEGIN
	WITH CTE_CountypeID AS (
		SELECT count(q.TypeID) AS SL FROM question q
        GROUP BY q.TypeID)
	SELECT q.TypeID INTO v_ID FROM question q
    GROUP BY q.TypeID
    HAVING COUNT(q.TypeID) = (SELECT max(SL) FROM CTE_CountypeID);
END$$
DELIMITER ;

SET @ID=0;
CALL GetTypeIDBestInMonth(@ID);
SELECT @ID;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
CALL GetTypeIDBestInMonth(@ID);
SELECT * FROM typequestion WHERE TypeID=@ID;

/* Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
 chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
 chuỗi của người dùng nhập vào */
DROP PROCEDURE IF EXISTS GetGroupOrUserName;
DELIMITER $$
CREATE PROCEDURE GetGroupOrUserName(IN var_String VARCHAR(50))
BEGIN
	SELECT 	a.UserName
    FROM 	`account` a 
    WHERE 	a.UserName LIKE CONCAT('%',var_String,'%');
 
    SELECT 	g.GroupName
    FROM 	`group` g 
    WHERE 	g.GroupName LIKE CONCAT('%',var_String,'%');
END$$
DELIMITER ;
CALL GetGroupOrUserName('n');

 /* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
				trong store sẽ tự động gán:
				username sẽ giống email nhưng bỏ phần @..mail đi
				positionID: sẽ có default là developer
				departmentID: sẽ được cho vào 1 phòng chờ
				Sau đó in ra kết quả tạo thành công */
DROP PROCEDURE IF EXISTS Inset_Info_User;
DELIMITER $$
CREATE PROCEDURE Inset_Info_User(IN s_email VARCHAR(50), IN full_name VARCHAR(100))
BEGIN
	DECLARE v_username VARCHAR(50) DEFAULT SUBSTRING_INDEX(s_email,'@',1);
    DECLARE v_DepartmentID  TINYINT UNSIGNED DEFAULT 14;
	DECLARE v_PositionID TINYINT UNSIGNED DEFAULT 6;
	DECLARE v_CreateDate DATETIME DEFAULT now(); 
	INSERT INTO `account` 
		(
			Email,
			UserName,
            FullName,
            DepartmentID,
            PositionID,
            CreateDate
        )
    VALUES (
			s_email,
			v_username,
            full_name,
            v_DepartmentID,
            v_PositionID,
            v_CreateDate
		);
END$$
DELIMITER ;
CALL Inset_Info_User('quangminh2k@gmail.com','Trương Quang Minh');

/* Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
 để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất*/
DROP PROCEDURE IF EXISTS GetLongestQuestion;
DELIMITER $$
CREATE PROCEDURE GetLongestQuestion(IN Type_Name VARCHAR(50))
BEGIN
	WITH CTE_Length AS (
		SELECT Length(q.Content) AS length_of_content
		FROM question q
		INNER JOIN typequestion t ON q.TypeID=t.TypeID
		WHERE t.TypeName = Type_Name)
	SELECT q.*, LENGTH(q.Content) AS length_of_content FROM question q
    INNER JOIN typequestion t ON q.TypeID=t.TypeID
    WHERE t.TypeName = Type_Name AND 
		LENGTH(q.Content)=(SELECT MAX(length_of_content)
							FROM CTE_Length);
END$$
DELIMITER ; 
CALL GetLongestQuestion('Essay');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS DelExam;
DELIMITER $$
CREATE PROCEDURE DelExam(IN DelID TINYINT)
BEGIN
	DELETE FROM examquestion WHERE ExamID=DelID;
	DELETE FROM exam WHERE ExamID=DelID;
END$$
DELIMITER ;
CALL DelExam(16);

/* Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
	dụng store ở câu 9 để xóa)
	Sau đó in số lượng record đã remove từ các table liên quan trong khi removing*/
    
# tạo bảng chứa ID các exam từ 3 năm trước
CREATE TABLE ExamID3Year_Temp(
	STT INT PRIMARY KEY AUTO_INCREMENT,
	ID INT,
    DelDate DATETIME DEFAULT NOW()
);

DROP PROCEDURE IF EXISTS DelExam3Year;
DELIMITER $$
CREATE PROCEDURE DelExam3Year()
BEGIN
	# Khai báo biến
    # count_exam số exam 3 năm trước thỏa mãn điều kiện xóa
    # exam_ID chứa examID để xóa 
    # lap biến tạo để lặp theo STT bản ghi có trong bảng ExamID3Year_Temp  
	#	giúp lấy examID của từng Record 
	DECLARE count_exam TINYINT UNSIGNED DEFAULT 1;
    DECLARE count_examquestion TINYINT UNSIGNED DEFAULT 1;
    DECLARE exam_ID TINYINT UNSIGNED DEFAULT 1;
    DECLARE lap TINYINT UNSIGNED DEFAULT 1;
    
    # Lấy các ExamID có ngày tạo từ 3 năm trước từ bảng exam Insert vào bảng ExamID3Year_Temp
	INSERT INTO ExamID3Year_Temp (ID)
    SELECT ExamID FROM exam 
    WHERE CreateDate < (curdate() - INTERVAL 36 MONTH);
    
    # Đếm số examquestion liên quan đến exam
    SELECT COUNT(1) INTO count_examquestion FROM examquestion
    WHERE ExamID IN (SELECT ExamID FROM ExamID3Year_Temp);
    
    # Đếm số exam từ 3 năm trước trong bảng ExamID3Year_Temp
    SELECT COUNT(1) INTO count_exam FROM ExamID3Year_Temp;
    
    # Xóa các exam từ 3 năm trước bằng store câu 9 với vòng lặp While..DO
    WHILE (lap <= count_exam) DO
		SELECT ID INTO exam_ID FROM ExamID3Year_Temp WHERE STT=lap;
		CALL DelExam(exam_ID);
        SET lap = lap +1;
    END WHILE;
    
    # Xóa dữ liệu trong bảng examid3year_temp cho lần sử dụng sau
    DELETE FROM examid3year_temp WHERE DAY(curdate())=DAY(DelDate);
    
	# Đặt AUTO_INCREMENT của bảng ExamID3Year_Temp về 1 cho lần sử dụng sau
    ALTER TABLE ExamID3Year_Temp AUTO_INCREMENT = 1;
    
    # In ra số Record đã xóa
    SELECT count_exam AS NumDeleted_in_Exam, count_examquestion AS NumDeleted_in_ExamQuestion;
END$$
DELIMITER ;
CALL DelExam3Year();    
    
/* Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
				nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
				chuyển về phòng ban default là phòng ban chờ việc */
DROP PROCEDURE IF EXISTS Del_Department;
DELIMITER $$
CREATE PROCEDURE Del_Department(IN var_String VARCHAR(50))
BEGIN
	DECLARE v_DepID TINYINT UNSIGNED DEFAULT 1;
    SELECT d.DepartmentID INTO v_DepID
		FROM department d WHERE d.DepartmentName=var_String;
        
	UPDATE `account` SET DepartmentID = 14 WHERE DepartmentID = v_DepID;
    
    DELETE FROM department WHERE DepartmentID=v_DepID;
END$$
DELIMITER ;
CALL Del_Department('Marketing');

/* Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo 
			trong năm nay*/
DROP PROCEDURE IF EXISTS CountQuestInMonth;
DELIMITER $$
CREATE PROCEDURE CountQuestInMonth()
BEGIN
		WITH EachMonthInYear AS 
		(
             SELECT 1 AS MONTH
             UNION SELECT 2 AS MONTH
             UNION SELECT 3 AS MONTH
             UNION SELECT 4 AS MONTH
             UNION SELECT 5 AS MONTH
             UNION SELECT 6 AS MONTH
             UNION SELECT 7 AS MONTH
             UNION SELECT 8 AS MONTH
             UNION SELECT 9 AS MONTH
             UNION SELECT 10 AS MONTH
             UNION SELECT 11 AS MONTH
             UNION SELECT 12 AS MONTH
        )
        SELECT EachMonthInYear.MONTH, COUNT(QuestionID) AS COUNT
		FROM EachMonthInYear
		LEFT JOIN (SELECT * FROM question Q1 WHERE year(Q1.CreateDate) = year(now())) q
        ON EachMonthInYear.MONTH = MONTH(q.CreateDate)
		GROUP BY EachMonthInYear.MONTH
		ORDER BY EachMonthInYear.MONTH ASC;
END$$
DELIMITER ;
CALL CountQuestInMonth();

/* Question 12 Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
 tháng gần đây nhất
 (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
tháng")*/
DROP PROCEDURE IF EXISTS sp_CountQuesPrevious6Month;
DELIMITER $$
CREATE PROCEDURE sp_CountQuesPrevious6Month()
BEGIN
		WITH Previous6Month AS
		(
			SELECT 	MONTH(curdate()) AS MONTH, YEAR(curdate()) AS YEAR
			UNION
			SELECT	MONTH(curdate() - INTERVAL 1 MONTH) AS MONTH,
					YEAR(curdate() - INTERVAL 1 MONTH) AS YEAR
			UNION
			SELECT 	MONTH(curdate() - INTERVAL 2 MONTH) AS MONTH,
					YEAR(curdate() - INTERVAL 2 MONTH) AS YEAR
			UNION
			SELECT 	MONTH(curdate() - INTERVAL 3 MONTH) AS MONTH,
					YEAR(curdate() - INTERVAL 3 MONTH) AS YEAR
			UNION
			SELECT 	MONTH(curdate() - INTERVAL 4 MONTH) AS MONTH,
					YEAR(curdate() - INTERVAL 4 MONTH) AS YEAR
			UNION
			SELECT 	MONTH(curdate() - INTERVAL 5 MONTH) AS MONTH,
					YEAR(curdate() - INTERVAL 5 MONTH) AS YEAR
        ) 
        SELECT Previous6Month.MONTH,Previous6Month.YEAR, CASE
							WHEN COUNT(QuestionID)=0 THEN 'không có câu hỏi nào trong tháng'
							WHEN COUNT(QuestionID)!=0 THEN COUNT(QuestionID) 
							END AS  SL
		FROM Previous6Month
		LEFT JOIN (SELECT * FROM question Q1 WHERE Q1.CreateDate > (curdate() - INTERVAL 6 MONTH)
					AND CreateDate <= curdate()) q
        ON Previous6Month.MONTH = MONTH(q.CreateDate)
		GROUP BY Previous6Month.MONTH;
END$$
DELIMITER ;
CALL sp_CountQuesPrevious6Month();