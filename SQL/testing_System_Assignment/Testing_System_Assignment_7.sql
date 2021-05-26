use testing_system_assignment_1;

/* Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
			trước 1 năm trước */
DROP TRIGGER IF EXISTS Ins_Group;
DELIMITER $$
	CREATE TRIGGER Ins_Group
    BEFORE INSERT ON `group`
    FOR EACH ROW
	BEGIN
        IF NEW.CreateDate < (curdate() - INTERVAL 1 YEAR) THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Insert Because CreateDate is not valid';
        END IF;
	END$$
DELIMITER ;

INSERT INTO `group`	(		GroupName		,CreatorID	,	CreateDate) 
VALUES 				('Nhóm tối 06/05/2015'	,			1,	'2020/03/06');

/* Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
 department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
 "Sale" cannot add more user" */
DROP TRIGGER IF EXISTS Not_SalesIn;
DELIMITER $$
	CREATE TRIGGER Not_SalesIn
    BEFORE INSERT ON `account`
    FOR EACH ROW
	BEGIN
		DECLARE ID TINYINT DEFAULT 1;
        SELECT DepartmentID INTO ID FROM department WHERE DepartmentName ='Sales';
        
        IF NEW.DepartmentID = ID THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        END IF;
	END$$
DELIMITER ;
INSERT INTO `account` 
		(
			Email, UserName, FullName, DepartmentID, PositionID, CreateDate
        )
    VALUES ('accountemail@gmai.com', 'hoangkhanh', 'Hoàng Văn Khánh', 7,13,now());
    
    
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS MaxAccIn_Group;
DELIMITER $$
	CREATE TRIGGER MaxAccIn_Group
    BEFORE INSERT ON groupaccount
    FOR EACH ROW
	BEGIN
		DECLARE Num TINYINT DEFAULT 1;
        
        SELECT 		COUNT(AccountID) INTO Num
		FROM 		groupaccount 
		WHERE 		GroupID = NEW.GroupID;

        IF Num >= 5 THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Insert Because This Group was Full Member';
        END IF;
	END$$
DELIMITER ;

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS MaxQuestIn_Exam;
DELIMITER $$
	CREATE TRIGGER MaxQuestIn_Exam
    BEFORE INSERT ON examquestion
    FOR EACH ROW
	BEGIN
		DECLARE Num TINYINT DEFAULT 1;
        
        SELECT 		COUNT(QuestionID) INTO Num
		FROM 		examquestion 
		WHERE 		ExamIDGroupID = NEW.ExamID
		GROUP BY	ExamID;
        
        IF Num > 10 THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Insert Because This Exam Was Full Question';
        END IF;
	END$$
DELIMITER ;
/* Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
		 admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
		 còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
		 tin liên quan tới user đó*/
DROP TRIGGER IF EXISTS Del_Acc;
DELIMITER $$
	CREATE TRIGGER Del_Acc
    BEFORE DELETE ON `account`
    FOR EACH ROW
	BEGIN
		DECLARE s_email VARCHAR(50);
        SELECT a.Email INTO s_email FROM `account` a WHERE a.AccountID=OLD.AccountID;
        IF s_email='admin@gmail.com' THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Del This Account';
        END IF;
	END$$
DELIMITER ;
DELETE FROM `account` a WHERE a.AccountID=15;

/* Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
		 Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
		 vào departmentID thì sẽ được phân vào phòng ban "waiting Department" */
DROP TRIGGER IF EXISTS Auto_InWaitingRoom;
DELIMITER $$
CREATE TRIGGER Auto_InWaitingRoom
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	DECLARE ID TINYINT DEFAULT 1;
	SELECT DepartmentID INTO ID FROM department WHERE DepartmentName ='Waiting Room';
    IF (NEW.DepartmentID IS NULL) THEN 
		SET NEW.DepartmentID=ID;
	END IF;
END$$
DELIMITER ;
INSERT INTO `account` 
		(
			Email, UserName, FullName, PositionID, CreateDate
        )
    VALUES ('tam8@gmai.com', 'uongductam','Uông Đức Tâm',13,now());

/* Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
			question, trong đó có tối đa 2 đáp án đúng. */
DROP TRIGGER IF EXISTS Quest_Condition;
DELIMITER $$
CREATE TRIGGER Quest_Condition
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
	DECLARE a TINYINT DEFAULT 1;
    DECLARE b TINYINT DEFAULT 1;
    
	SELECT COUNT(IsCorrect) INTO a
    FROM answer
	WHERE IsCorrect=1 AND QuestionID=NEW.QuestionID;
    
	SELECT COUNT(AnswerID) INTO b
	FROM answer
    WHERE QuestionID=NEW.QuestionID;
    
    IF (a>4) OR (b>2) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'This Question Has 4 Answer OR 2 Correct Answer';
    END IF;
END$$
DELIMITER ;
DELETE FROM exam WHERE ExamID=16;

/* Question 8: Viết trigger sửa lại dữ liệu cho đúng:
		 Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
		 Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database */
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS NotDel_Exam_2dayago;
DELIMITER $$
	CREATE TRIGGER NotDel_Exam_2dayago
    BEFORE DELETE ON exam
    FOR EACH ROW
	BEGIN
		DECLARE s_CreDate DATE;
        SELECT CreateDate INTO s_CreDate FROM exam WHERE ExamID=OLD.ExamID;
        IF s_CreDate >= (curdate() - INTERVAL 2 DAY) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Del This Exam';
        END IF;
	END$$
DELIMITER ;

/* Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
		question khi question đó chưa nằm trong exam nào */
DROP TRIGGER IF EXISTS NotDel_QuestionInExam;
DELIMITER $$
	CREATE TRIGGER NotDel_QuestionInExam
    BEFORE DELETE ON question
    FOR EACH ROW
	BEGIN
		DECLARE num TINYINT;
        SELECT COUNT(1) INTO num FROM question
		WHERE OLD.QuestionID IN (SELECT QuestionID FROM examquestion);
        
        IF num>0 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Del! This Question was in an exam';
        END IF;
	END$$
DELIMITER ;
DELETE FROM question WHERE QuestionID=9;

DROP TRIGGER IF EXISTS NotUpdate_QuestionInExam;
DELIMITER $$
	CREATE TRIGGER NotUpdate_QuestionInExam
    BEFORE UPDATE ON question
    FOR EACH ROW
	BEGIN
		DECLARE num TINYINT;
        SELECT COUNT(1) INTO num FROM question
		WHERE NEW.QuestionID IN (SELECT QuestionID FROM examquestion);
        
        IF num>0 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Update! This Question was in an exam';
        END IF;
	END$$
DELIMITER ;

/* Question 12: Lấy ra thông tin exam trong đó:
		Duration <= 30 thì sẽ đổi thành giá trị "Short time"
		30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
		Duration > 60 thì sẽ đổi thành giá trị "Long time" */

SELECT e.ExamID, e.Code, e.Title , CASE 
				WHEN Duration <= 30 THEN 'Short time'
                WHEN Duration <= 60 THEN 'Medium time'
				ELSE 'Longtime'
				END AS Duration
FROM exam e;

/* Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
		là the_number_user_amount và mang giá trị được quy định như sau:
		Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
		Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
		Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher */
/*Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
		không có user thì sẽ thay đổi giá trị 0 thành "Không có User" */
SELECT d.DepartmentName, CASE
			WHEN COUNT(d.DepartmentID)=0 THEN "Không có User"
            WHEN COUNT(d.DepartmentID)!=0 THEN COUNT(d.DepartmentID) 
            END AS num_of_acc
FROM department d LEFT JOIN `account` a ON d.DepartmentID=a.DepartmentID
GROUP BY d.DepartmentID;