USE Testing_System_Assignment_1;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW sale_dpt AS
	SELECT a.*,d.DepartmentName FROM `account` a
	INNER JOIN
    Department d ON d.DepartmentID = a.DepartmentID
    WHERE d.DepartmentName='Marketing Department';
    
SELECT * FROM sale_dpt;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW max_aID AS
	SELECT 		a.FullName, COUNT(ga.GroupID) AS nuber_of_groups FROM `account` a 
    INNER JOIN	groupaccount ga ON a.AccountID=ga.AccountID
	GROUP BY	ga.AccountID
    HAVING 		COUNT(ga.AccountID)=(SELECT MAX(nuber_of_groups) 
									 FROM	(SELECT 	COUNT(ga.GroupID) AS nuber_of_groups
											 FROM 		`account` a 
											 INNER JOIN 	groupaccount ga ON a.AccountID=ga.AccountID
											 GROUP BY 	ga.AccountID) AS TEMP);
    
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi    
CREATE OR REPLACE VIEW content_long AS
	SELECT 	* 
    FROM 	question
    WHERE 	length(Content) > 30;
    
DELETE FROM content_long;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW max_aID AS
	SELECT 		d.DepartmentName, COUNT(d.DepartmentID) AS most_dept
    FROM 		`account` a 
    INNER JOIN	 department d ON a.DepartmentID=d.DepartmentID
	GROUP BY 	d.DepartmentID
    HAVING 		COUNT(a.DepartmentID)=(SELECT MAX(most_dept)
									   FROM (SELECT COUNT(a.DepartmentID) AS most_dept
											FROM `account` a 
											INNER JOIN department d ON d.DepartmentID=a.DepartmentID
											GROUP BY a.DepartmentID) AS TEMP);
 SELECT * FROM max_aID;
 
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW QofNg AS
	SELECT 		q.*,a.FullName 
    FROM 		question q
	INNER JOIN `account` a ON q.CreatorID=a.AccountID
	WHERE 		a.FullName LIKE 'Nguyễn%';
SELECT * FROM QofNg;