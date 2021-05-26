/* Xây dựng DB Facebook Management.
Facebook đang là 1 công ty đa quốc gia với nhiều trụ sở và nhân viên trên toàn thế giới, bạn
hãy xây dựng 1 DB có tên Facebook_DB để quản lý nhân viên trên toàn thế giới cho
Facebook, với số lượng nhân viên lên đến hàng triệu người. Chúng ta sẽ quản lý về nhân viên
(Staff), quản lý về đất nước của mỗi nhân viên, ngôn ngữ chính được sử dụng tại mỗi nước
đó (National), và vị trí làm việc của nhân viên tại từng quốc gia (Office) */

-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu.
DROP DATABASE IF EXISTS Facebook;
CREATE DATABASE Facebook;
USE Facebook;

# National (National_id, National_Name, Language_Main)
DROP TABLE IF EXISTS `National`;
CREATE TABLE `National`(
National_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 National_Name VARCHAR(50) NOT NULL UNIQUE KEY,
 Language_Main VARCHAR(50) NOT NULL
);

#Office (Office_id, Street_Address, National_id)
DROP TABLE IF EXISTS Office;
CREATE TABLE Office (
Office_id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 Street_Address VARCHAR(50) NOT NULL UNIQUE KEY,
 National_id TINYINT UNSIGNED NOT NULL,
 FOREIGN KEY (National_id) REFERENCES `National`(National_id)
);

# Staff (Staff_id, First_Name, Last_Name, Email, Office_id)
DROP TABLE IF EXISTS Staff;
CREATE TABLE Staff (
Staff_id MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 First_Name VARCHAR(50) NOT NULL,
 Last_Name VARCHAR(50) NOT NULL,
 Email VARCHAR(50) NOT NULL UNIQUE KEY,
 Office_id SMALLINT UNSIGNED NOT NULL ,
 FOREIGN KEY (Office_id) REFERENCES Office(Office_id)
 );
 
-- Question 2: Thêm 10 bản ghi vào các table.
INSERT INTO `National` (National_Name,Language_Main) VALUE ('Vietnam','Vietnamese');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('England','English');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('United States','English');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('Singapore','English');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('Kenya','Kenyan_Language');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('Germany','German');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('Switzerland','English');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('Albania','Albanian_Language');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('South_Korea','South_Korean_Language');
INSERT INTO `National` (National_Name,Language_Main) VALUE ('Japan','Japanese');

INSERT INTO Office (Street_Address,National_id) VALUE ('DuyTan_HN','1');
INSERT INTO Office (Street_Address,National_id) VALUE ('CauGiay_HN','1');
INSERT INTO Office (Street_Address,National_id) VALUE ('LeThanhNghi_HN','1');
INSERT INTO Office (Street_Address,National_id) VALUE ('Street_England1','2');
INSERT INTO Office (Street_Address,National_id) VALUE ('United States_Street','3');
INSERT INTO Office (Street_Address,National_id) VALUE ('Street_England2','2');
INSERT INTO Office (Street_Address,National_id) VALUE ('Albania_Street','7');
INSERT INTO Office (Street_Address,National_id) VALUE ('Street_England3','2');
INSERT INTO Office (Street_Address,National_id) VALUE ('Seoul_Street','9');
INSERT INTO Office (Street_Address,National_id) VALUE ('Tokyo_Street','10');

INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name1','Last_Name1','email1@gmail.com.vn',1);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id)
		VALUE ('First_Name2','Last_Name2','email2@gmail.com.vn',1);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id)
		VALUE ('First_Name3','Last_Name3','email3@gmail.com.vn',2);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name4','Last_Name4','email4@gmail.com.vn',3);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name5','Last_Name5','email5@gmail.com.vn',3);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name6','Last_Name6','email6@gmail.com.vn',1);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name7','Last_Name7','email7@gmail.com.vn',4);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name8','Last_Name8','email8@gmail.com.vn',6);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name9','Last_Name9','email9@gmail.com.vn',4);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name10','Last_Name10','email10@gmail.com.vn',5);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name11','Last_Name11','email11@gmail.com.vn',5);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name12','Last_Name12','email12@gmail.com.vn',10);
INSERT INTO Staff (First_Name,Last_Name,Email,Office_id) 
		VALUE ('First_Name13','Last_Name13','email13@gmail.com.vn',9);
        
-- Question 3: Bạn hãy lấy dữ liệu của tất cả nhân viên đang làm việc tại Vietnam.
SELECT s.First_Name, s.Email, o.Street_Address, n.National_Name 
FROM Staff s
INNER JOIN Office o ON s.Office_id = o.Office_id
INNER JOIN `national` n ON n.National_id = o.National_id
WHERE n.National_Name ='Vietnam';

-- Question 4: Lấy ra ID, FullName, Email, National của mỗi nhân viên.
SELECT s.Staff_id, CONCAT(s.First_Name,' ',s.Last_Name) AS FullName,s.Email,n.National_Name 
FROM Staff s
INNER JOIN Office o ON s.Office_id = o.Office_id
INNER JOIN `national` n ON n.National_id = o.National_id
ORDER BY s.Staff_id;

-- Question 5: Lấy ra tên nước mà nhân viên có Email: "daonq@viettel.com.vn" đang làm việc.
SELECT n.National_Name, s.Email FROM Staff s
JOIN Office o ON s.Office_id = o.Office_id
JOIN `National` n ON o.National_id = n.National_id
WHERE s.Email = 'daonq@viettel.com.vn';

/* Question 6: Bạn hãy tìm xem trên hệ thống có quốc gia nào có thông tin trên hệ thống nhưng
không có nhân viên nào đang làm việc. */
WITH cte_tpm_tb_officeID AS (
SELECT DISTINCT o.National_id FROM office o
INNER JOIN (SELECT DISTINCT s.Office_id FROM staff s) t ON o.Office_id = t.Office_id
)
SELECT n.* FROM cte_tpm_tb_officeID c
RIGHT JOIN `national` n ON c.National_id = n.National_id
WHERE c.National_id IS NULL ;

/* Question 7: Thống kê xem trên thế giới có bao nhiêu quốc gia mà FB đang hoạt động sử dụng
tiếng Anh làm ngôn ngữ chính. */
SELECT count(1) FROM `national`  WHERE Language_Main = 'English';

/* Question 8: Viết lệnh để lấy ra thông tin nhân viên có tên (First_Name) có 10 ký tự, bắt đầu bằng
chữ N và kết thúc bằng chữ C. */
SELECT * FROM staff WHERE First_Name LIKE 'N________c';

/* Question 9: Bạn hãy tìm trên hệ thống xem có nhân viên nào đang làm việc nhưng do nhập khi
nhập liệu bị lỗi mà nhân viên đó vẫn chưa cho thông tin về trụ sở làm việc(Office).*/
SELECT * FROM staff WHERE Office_id IS NULL;

/* Question 10: Nhân viên có mã ID =9 hiện tại đã nghỉ việc, bạn hãy xóa thông tin của nhân viên
này trên hệ thống. */
DELETE FROM `Staff` WHERE Staff_id = 9;
    
/* Question 11: FB vì 1 lý do nào đó không còn muốn hoạt động tại Australia nữa, và Mark
Zuckerberg muốn bạn xóa tất cả các thông tin trên hệ thống liên quan đến quốc gia này. Hãy
tạo 1 Procedure có đầu vào là tên quốc gia cần xóa thông tin để làm việc này và gửi lại cho
anh ấy. */
DROP PROCEDURE IF EXISTS SP_DelNation;
DELIMITER $$
CREATE PROCEDURE SP_DelNation(IN na_name VARCHAR(50))
BEGIN
	DECLARE na_id TINYINT;
    SELECT National_id INTO na_id FROM `national` WHERE National_Name=na_name;
    DELETE FROM staff s WHERE s.Office_id IN 
					(SELECT o.Office_id FROM office o WHERE o.National_id = na_id);
	DELETE FROM office o WHERE o.National_id = na_id;
	DELETE FROM `national` n WHERE n.National_id = na_id;
 
END $$
CALL SP_DelNation('Japan');

/* Question 12: Mark muốn biết xem hiện tại đang có bao nhiêu nhân viên trên toàn thế giới đang
làm việc cho anh ấy, hãy viết cho anh ấy 1 Function để a ấy có thể lấy dữ liệu này 1 cách
nhanh chóng.*/
SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS fc_SumOfStaff;
DELIMITER $$
CREATE FUNCTION fc_SumOfStaff() RETURNS MEDIUMINT
BEGIN
DECLARE sum MEDIUMINT;
 SELECT COUNT(1) INTO sum FROM staff;
RETURN sum;
END $$
SELECT fc_SumOfStaff() AS SUM;

/* Question 13: Để thuận tiện cho việc quản trị Mark muốn số lượng nhân viên tại mỗi quốc gia chỉ
tối đa 10.000 người. Bạn hãy tạo trigger cho table Staff chỉ cho phép insert mỗi quốc gia có
tối đa 10.000 nhân viên giúp anh ấy (có thể cấu hình số lượng nhân viên nhỏ hơn vd 11 nhân
viên để Test). */
DROP TRIGGER IF EXISTS TrG_CheckToAddStaffToNational;
DELIMITER $$
CREATE TRIGGER TrG_CheckToAddStaffToNational
 BEFORE INSERT ON `staff`
 FOR EACH ROW
 BEGIN
	DECLARE National_id TINYINT;
	DECLARE count_Staff TINYINT;
	SELECT o.National_id INTO National_id FROM office o WHERE o.Office_id = NEW.Office_id;
	SELECT count(1) INTO count_Staff FROM staff s
	INNER JOIN office o ON o.Office_id = s.Office_id
	INNER JOIN `national` n ON n.National_id = o.National_id
	WHERE n.National_id= National_id;
	IF (count_Staff >10) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Cant add more Staff to this Country';
END IF;
 END$$
DELIMITER ;

/* Question 14: Bạn hãy viết 1 Procedure để lấy ra tên trụ sở mà có số lượng nhân viên đang làm
việc nhiều nhất. */
DROP PROCEDURE IF EXISTS SP_GetMaxStaffFromOffice;
DELIMITER $$
CREATE PROCEDURE SP_GetMaxStaffFromOffice()
BEGIN
	WITH CTE_GetCountStaff_id AS (
		SELECT s.Office_id, count(s.Staff_id) AS SL FROM `Staff` s
		GROUP BY s.Office_id
	)
	SELECT o.Office_id , o.Street_Address, o.National_id, count(s.Staff_id) AS SL 
    FROM `Staff` s INNER JOIN `Office` o ON o.Office_id = s.Office_id
	GROUP BY s.Office_id
	HAVING count(s.Office_id) = (SELECT max(SL) FROM CTE_GetCountStaff_id);
END $$
CALL SP_GetMaxStaffFromOffice();

/* Question 15: Bạn hãy viết 1 Function để khi nhập vào thông tin Email của nhân viên thì sẽ trả ra
thông tin đầy đủ của nhân viên đó.*/
SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS fc_GetInfoStaffByEmail;
DELIMITER $$
CREATE FUNCTION fc_GetInfoStaffByEmail(mail VARCHAR(100)) RETURNS VARCHAR (100)
BEGIN
	DECLARE fullname VARCHAR(100);
	SELECT CONCAT(First_Name,' ',Last_Name) INTO FullName
    FROM staff WHERE Email=mail;
RETURN fullname;
END $$
DELIMITER;
SELECT fc_GetInfoStaffByEmail('email1@gmail.com.vn') AS FullName;

/* Question 16: Bạn hãy viết 1 Trigger để khi thực hiện cập nhật thông tin về trụ sở làm việc của
nhân viên đó thì hệ thống sẽ tự động lưu lại trụ sở cũ của nhân viên vào 1 bảng khác có tên
Log_Office để Mark có thể xem lại khi cần thiết. */
DROP TABLE IF EXISTS Log_Office;
CREATE TABLE Log_Office (
	Id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR(50) NOT NULL,
	Office_id_Old SMALLINT UNSIGNED NOT NULL,
	ChangeDate DATETIME
);
DROP TRIGGER IF EXISTS TrG_AfUpdateOfficeID;
DELIMITER $$
CREATE TRIGGER TrG_AfUpdateOfficeID
 AFTER UPDATE ON staff
 FOR EACH ROW
 BEGIN
 INSERT INTO log_office (`Email`, `Office_id_Old`, `ChangeDate`)
		VALUES ( OLD.Email, OLD.Office_id,now());
 END$$
DELIMITER ;

/* Question 17: FB đang vướng vào 1 đạo luật hạn chế hoạt động, FB chỉ có thể hoạt động tối đa
trên 100 quốc gia trên thế giới, hãy tạo Trigger để ngăn người nhập liệu nhập vào quốc gia
thứ 101 (bạn có thể sử dụng số nước nhỏ hơn để Test VD 11 nước). */
DROP TRIGGER IF EXISTS TrG_BfInsertNational;
DELIMITER $$
CREATE TRIGGER TrG_BfInsertNational
BEFORE INSERT ON `national`
FOR EACH ROW
BEGIN
	DECLARE count_National TINYINT;
	SELECT count(1) INTO count_National FROM `national`;
	IF (count_National >100) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Cant add more National to this Table';
END IF;
 END$$
DELIMITER ;

-- Question 18: Thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân viên đang làm việc.
SELECT n.National_Name, count(1) FROM `Staff` s
INNER JOIN `office` o ON s.Office_id = o.Office_id
INNER JOIN `national` n ON n.National_id = o.National_id
GROUP BY n.National_Name ;

/* Question 19: Viết Procedure để thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân
viên đang làm việc, với đầu vào là tên nước.*/
DROP PROCEDURE IF EXISTS SP_NumOfStaffFromNational;
DELIMITER $$
CREATE PROCEDURE SP_NumOfStaffFromNational(IN National_Name VARCHAR(50) )
BEGIN
	SELECT n.National_Name, count(1) FROM `Staff` s
	INNER JOIN `office` o ON s.Office_id = o.Office_id
	INNER JOIN `national` n ON n.National_id = o.National_id
	WHERE n.National_Name =National_Name;
END $$
CALL SP_NumOfStaffFromNational('Vietnam');

/* Question 20: Thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu employee đang
làm việc.*/
SELECT o.Street_Address, n.National_Name, count(1) FROM `Staff` s
INNER JOIN `office` o ON s.Office_id = o.Office_id
INNER JOIN `national` n ON n.National_id = o.National_id
GROUP BY o.Office_id;

/* Question 21: Viết Procedure để thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu
employee đang làm việc đầu vào là ID của trụ sở. */
DROP PROCEDURE IF EXISTS SP_GetNumOfStaffFromOfficeID;
DELIMITER $$
CREATE PROCEDURE SP_GetNumOfStaffFromOfficeID(IN Office_id SMALLINT )
BEGIN
	SELECT o.Street_Address, n.National_Name, count(1) FROM `Staff` s
	INNER JOIN `office` o ON s.Office_id = o.Office_id
	INNER JOIN `national` n ON n.National_id = o.National_id
	WHERE s.Office_id = Office_id;
END $$
CALL SP_GetNumOfStaffFromOfficeID(1);

-- Question 22: Viết Procedure để lấy ra tên quốc gia đang có nhiều nhân viên nhất.
DROP PROCEDURE IF EXISTS SP_GetMaxOfStaffFromNation;
DELIMITER $$
CREATE PROCEDURE SP_GetMaxOfStaffFromNation()
BEGIN
	WITH CTE_National_Count AS (
		SELECT n.National_Name, count(1) AS SL FROM `Staff` s
		INNER JOIN `office` o ON s.Office_id = o.Office_id
		INNER JOIN `national` n ON n.National_id = o.National_id
		GROUP BY n.National_Name )
	SELECT * FROM CTE_National_Count 
    WHERE SL = (SELECT MAX(SL) FROM CTE_National_Count);
END $$
CALL SP_GetMaxOfStaffFromNation();
-- Question 23: Thống kê mỗi country có bao nhiêu employee đang làm việc.
SELECT n.National_Name, count(1) FROM `Staff` s
INNER JOIN `office` o ON s.Office_id = o.Office_id
INNER JOIN `national` n ON n.National_id = o.National_id
GROUP BY n.National_Name;

/* Question 24: Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm
việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ chuyển về Null*/
ALTER TABLE Staff DROP CONSTRAINt `staff_ibfk_1`;
ALTER TABLE Staff MODIFY COLUMN Office_id SMALLINT UNSIGNED;
ALTER TABLE Staff ADD CONSTRAINT fk_Staff_Office FOREIGN KEY (Office_id) 
								REFERENCES Office(Office_id) ON DELETE SET NULL;

/* Question 25: Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm
việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ bị xóa hết. */
ALTER TABLE Staff DROP CONSTRAINt fk_Staff_Office;
ALTER TABLE Staff ADD CONSTRAINT fk_Staff_Office FOREIGN KEY (Office_id) 
								REFERENCES Office(Office_id) ON DELETE CASCADE;