use testing_system_assignment_1;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
 SELECT		a.*,d.DepartmentName 
 FROM 		`account` a
 JOIN 		department d ON a.DepartmentID = d.DepartmentID;
 
 -- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
 SELECT 	*
 FROM 		`account`
 WHERE		CreateDate > '2012/12/20'
 ORDER BY	CreateDate;
 
 -- Question 3: Viết lệnh để lấy ra tất cả các developer
 SELECT 		a.AccountID,a.PositionID,a.FullName,a.Email,p.PositionName
 FROM 			`account` a 
 INNER JOIN 	position p On a.PositionID=p.PositionID
 WHERE 			p.PositionName = 'Dev';
 
 -- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 		d.* 
FROM		department d
INNER JOIN 	`account` a ON a.DepartmentID=d.DepartmentID
GROUP BY	d.DepartmentID
HAVING 		COUNT(a.AccountID) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT		 q.QuestionID,q.Content, COUNT(e.ExamID) AS number_of_exam
FROM		 question q 
INNER JOIN	 examquestion e ON q.QuestionID=e.QuestionID
GROUP BY	 q.QuestionID
HAVING		 COUNT(e.QuestionID) = (SELECT MAX(number_of_exam) FROM 
				(SELECT 	COUNT(ExamID) AS number_of_exam 
				FROM 		question q 
				INNER JOIN 	examquestion e ON q.QuestionID=e.QuestionID
				GROUP BY 	q.QuestionID) AS TEMP);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT 		c.*, COUNT(QuestionID) AS number_used
FROM 		categoryquestion c 
INNER JOIN	question q ON c.CategoryID = q.CategoryID
GROUP BY 	CategoryID
ORDER BY 	number_used DESC;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT		q.*, COUNT(examID) AS number_used FROM examquestion e 
INNER JOIN 	question q ON e.QuestionID = q.QuestionID
GROUP BY 	QuestionID
ORDER BY 	number_used DESC;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT 		q.QuestionID,q.Content, COUNT(a.AnswerID) AS number_of_answer 
FROM 		question q 
INNER JOIN 	answer a ON q.QuestionID=a.QuestionID
GROUP BY 	q.QuestionID
HAVING 		COUNT(a.QuestionID) = (SELECT MAX(number_of_answer) FROM 
				(SELECT 	COUNT(a.AnswerID) AS number_of_answer 
				FROM 		question q 
				INNER JOIN 	answer a ON q.QuestionID=a.QuestionID
				GROUP BY 	q.QuestionID) AS TEMP);
        
-- Question 9: Thống kê số lượng account trong mỗi group
SELECT 		g.GroupID,g.GroupName,COUNT(a.AccountID) AS number_of_account 
FROM 		`group` g,groupaccount ga 
INNER JOIN 	`account` a ON a.AccountID=ga.AccountID
WHERE 		g.GroupID = ga.GroupID
GROUP BY	 ga.GroupID
ORDER BY 	number_of_account DESC;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT 		p.*, COUNT(a.AccountID) AS number_of_acc 
FROM 		position p 
INNER JOIN 	`account` a ON a.PositionID=p.PositionID
GROUP BY 	p.PositionID
HAVING 		COUNT(a.PositionID) = (SELECT MIN(number_of_acc) FROM 
				(SELECT		COUNT(a.AccountID) AS number_of_acc 
				FROM		position p 
				INNER JOIN 	`account` a ON a.PositionID=p.PositionID
				GROUP BY	p.PositionID) AS TEMP);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 		d.*, COUNT(a.AccountID) AS number_of_account 
FROM 		department d 
INNER JOIN 	`account` a ON a.DepartmentID = d.DepartmentID
GROUP BY	 d.DepartmentID
ORDER BY 	number_of_account DESC;

/* Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
				question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … */
SELECT	 	q.QuestionID,q.TypeID,ac.FullName as Creator,q.CreateDate,a.Content as Answer
FROM		`account` ac, question q
INNER JOIN	answer a ON q.QuestionID=a.QuestionID
WHERE		ac.AccountID=q.CreatorID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 		t.*,COUNT(q.QuestionID) AS number_of_quest 
FROM 		typequestion t 
INNER JOIN 	question q ON t.TypeID=q.TypeID
GROUP BY	t.TypeID;

-- Question 14:Lấy ra group không có account nào
SELECT 		g.* 
FROM 		groupaccount g
LEFT JOIN 	`account` a ON g.AccountID=a.AccountID
WHERE 		a.AccountID IS NULL;

-- Question 16: Lấy ra question không có answer nào
SELECT 		q.* 
FROM 		question q 
LEFT JOIN 	answer a ON q.QuestionID=a.QuestionID
WHERE 		a.QuestionID IS NULL;

/* Question 17:
	a) Lấy các account thuộc nhóm thứ 1
	b) Lấy các account thuộc nhóm thứ 2
	c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau */

SELECT		 a.AccountID, a.FullName 
FROM	 	`account` a 
INNER JOIN 	groupaccount g ON a.AccountID=g.AccountID
WHERE		g.GroupID = 1
UNION
SELECT		 a.AccountID, a.FullName
FROM	 	`account` a 
INNER JOIN 	groupaccount g ON a.AccountID=g.AccountID
WHERE		g.GroupID = 2;

/* Question 18:
		a) Lấy các group có lớn hơn 5 thành viên
		b) Lấy các group có nhỏ hơn 7 thành viên
		c) Ghép 2 kết quả từ câu a) và câu b) */

SELECT		ga.GroupID,g.GroupName,COUNT(ga.AccountID) AS Num_of_Acc
FROM 		`group` g,groupaccount ga
INNER JOIN 	`account` a ON a.AccountID=ga.AccountID
WHERE		g.GroupID=ga.GroupID
GROUP BY 	ga.GroupID
HAVING 		COUNT(ga.AccountID) >5
UNION
SELECT		ga.GroupID,g.GroupName,COUNT(ga.AccountID) AS Num_of_Acc
FROM 		`group` g,groupaccount ga
INNER JOIN 	`account` a ON a.AccountID=ga.AccountID
WHERE		g.GroupID=ga.GroupID
GROUP BY 	ga.GroupID
HAVING 		COUNT(ga.AccountID) <7;