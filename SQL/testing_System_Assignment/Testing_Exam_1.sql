/* Requirement 1:
Bạn đang làm việc như 1 lập trình viên quản trị database. Công ty sử dụng RDBMS
để quản lý project. 1 phần của database schema được cho như hình bên dưới.
Database có chứa 3 bảng CUSTOMER, ORDER and CAR */
CREATE DATABASE Testing_Exam1;
USE Testing_Exam1;

/* Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
				Thêm ít nhất 5 bản ghi vào table.	*/
/*CUSTOMER:
	 CustomerID	: mã khách hàng, primary key, auto increment.
	 Name			: tên của khách hàng.
	 Phone			: số điện thoại của khách hàng.
	 Email			: địa chỉ email của khách hàng.
	 Address		: địa chỉ của khách hàng.
	 Note			: tóm tắt mô tả về khách hàng*/
    
DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer(
	CustomerID 	INT PRIMARY KEY AUTO_INCREMENT,
    `Name`		VARCHAR(50) NOT NULL,
    Phone		VARCHAR(14) NOT NULL,
    Email		VARCHAR(50) UNIQUE NOT NULL,
    Address		VARCHAR(150) NOT NULL,
    Note		VARCHAR(255)
);

/* CAR:
	 CarID: mã oto, primary key.
	 Maker: tên hãng sản xuất (chỉ có thể là 3 giá trị: ‘HONDA’, ‘TOYOTA’,‘NISSAN’).
	 Model: tên của mẫu xe.
	 Year: năm sản xuất.
	 Color: màu của xe (black, white, yellow…).
	 Note: tóm tắt mô tả về xe. */
    
DROP TABLE IF EXISTS Car;
CREATE TABLE Car(
	CarID 		INT PRIMARY KEY AUTO_INCREMENT,
    Marker		ENUM('HONDA', 'TOYOTA', 'NISSAN') NOT NULL,
    Model		VARCHAR(50) NOT NULL,
    `Year`		INT NOT NULL,
    Color		VARCHAR(30) NOT NULL,
    Note		VARCHAR(255)
);

/* CAR_ORDER:
	 OrderID: mã đơn hàng, primary key, auto increment.
	 CustomerID: mã khách hàng, foreign key.
	 CarID: mã oto, foreign key.
	 Amount: số lượng oto, default value = 1.
	 SalePrice: giá bán oto.
	 OrderDate: ngày bán .
	 DeliveryDate: ngày giao hàng.
	 DeliveryAddress: địa chỉ giao hàng.
	 Status: trạng thái của đơn hàng (0: đã đặt hàng, 1: đã giao, 2: đã hủy), mặc định
	trạng thái là đã đặt hàng.
	 Note: tóm tắt mô tả về đơn hàng. */

DROP TABLE IF EXISTS Car_Order;
CREATE TABLE Car_Order(
	OrderID 			INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID			INT NOT NULL,
    CarID				INT NOT NULL,
    Amount				INT NOT NULL DEFAULT 1,
    SalePrice			INT NOT NULL,
    OrderDate			DATE NOT NULL,
    DeliveryDate		DATE,
    DeliveryAddress		VARCHAR(150) NOT NULL,
    `Status`			TINYINT DEFAULT 0 NOT NULL, -- (0: đã đặt hàng, 1: đã giao, 2: đã hủy)
    Note				VARCHAR(255),
    CONSTRAINT fk_Customer FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    CONSTRAINT fk_Car FOREIGN KEY (CarID) REFERENCES Car(CarID)
);

INSERT INTO customer (`Name`, Phone, Email, Address, Notecar) 
	VALUES	('Customer 1', '+(84)000000001', 'email1@gmail.com', 'Address1', 'Note1'),
			('Customer 2', '+(84)000000002', 'email2@gmail.com', 'Address2', 'Note2'),
            ('Customer 3', '+(84)000000003', 'email3@gmail.com', 'Address3', 'Note3'),
            ('Customer 4', '+(84)000000004', 'email4@gmail.com', 'Address4', 'Note4'),
			('Customer 5', '+(84)000000005', 'email5@gmail.com', 'Address5', 'Note5');

INSERT INTO car (Marker, Model, `Year`, Color, Note)
	VALUES 	('HONDA'	, 'HONDA-MD1'	, '2020', 'black'	, 'Note1'),
			('HONDA'	, 'HONDA-MD2'	, '2021', 'Red'		, 'Note2'),
            ('TOYOTA'	, 'TOYOTA-MD1'	, '2021', 'yellow'	, 'Note3'),
            ('NISSAN'	, 'NISSAN-MD1'	, '2021', 'black'	, 'Note4'),
            ('TOYOTA'	, 'TOYOTA-MD2'	, '2021', 'black'	, 'Note5');

INSERT INTO car_order 
	(CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note)
VALUES 	(1, 1, 2, 24000, '2020/12/05', '2020/12/07'	, 'Address1', 1, 'Note1'),
		(1, 3, 1, 13000, '2021/02/04', '2021/02/09'	, 'Address1', 1, 'Note2'),
		(3, 5, 1, 13500, '2021/02/05', NULL			, 'Address3', 2, 'Note3'),
		(4, 2, 4, 60000, '2021/03/11', '2021/03/17'	, 'Address4', 1, 'Note4'),
		(5, 5, 1, 13000, '2020/05/11', NULL			, 'Address5', 0, 'Note5');

/* Question 2: Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
			mua và sắp sếp tăng dần theo số lượng oto đã mua. */
SELECT c.`Name`, COUNT(co.CarID) AS AmoutCarBought FROM customer c
LEFT JOIN car_order co ON c.CustomerID=co.CustomerID
GROUP BY c.CustomerID
ORDER BY AmoutCarBought;

/* Question 3: Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
	oto nhất trong năm nay. */
SET GLOBAL log_bin_trust_function_creators=1;
DROP FUNCTION IF EXISTS BestSaleInYear;
DELIMITER $$
CREATE FUNCTION  BestSaleInYear() RETURNS VARCHAR (10)
BEGIN
	DECLARE s_name VARCHAR(10);
    SELECT c.Marker INTO s_name FROM car c 
    INNER JOIN car_order co ON c.CarID=co.CarID
    WHERE YEAR(co.DeliveryDate)= YEAR(CURDATE()) AND co.`Status`=1
    GROUP BY Marker
    HAVING COUNT(co.OrderID)
    ORDER BY COUNT(co.OrderID) DESC
    LIMIT 1;
    RETURN s_name;
END$$
DELIMITER ;
SELECT BestSaleInYear() AS NameBestSale;

/* 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
		những năm trước. In ra số lượng bản ghi đã bị xóa. */
        
DROP PROCEDURE IF EXISTS DelOrderCancelYearBefore;
DELIMITER $$
CREATE PROCEDURE DelOrderCancelYearBefore()
BEGIN
	# Khai báo biến
    # count_order số đơn hàng bị hủy từ những năm trước thỏa mãn điều kiện xóa
    # Order_ID chứa examID để xóa 
    # lap biến tạo để lặp theo STT bản ghi có trong bảng ExamID3Year_Temp  
	#	giúp lấy OrderID của từng Record 
	DECLARE count_order TINYINT UNSIGNED DEFAULT 1;
	
    # Đếm số đơn hàng bị hủy từ những năm trước
    SELECT	COUNT(OrderID) INTO count_order FROM car_order
    WHERE 	YEAR(OrderDate)< YEAR(CURDATE()) AND `status`=2 ;
    
    # Xóa các đơn hàng bị hủy từ những năm trước
    DELETE FROM car_order WHERE 	YEAR(OrderDate)< YEAR(CURDATE()) AND `status`=2 ;
      
    # In ra số Record đã xóa
    SELECT count_order AS NumDeleted_in_Car_Order;
END$$
DELIMITER ;
CALL DelOrderCancelYearBefore();

/* Question 5: Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
	hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
	và tên hãng sản xuất. */
DROP PROCEDURE IF EXISTS InfoCustomer;
DELIMITER $$
CREATE PROCEDURE InfoCustomer(IN c_id INT)
BEGIN
	SELECT c.`Name`,co.OrderID,co.Amount,ca.Marker FROM customer c 
    INNER JOIN car_order co ON c.CustomerID=co.CustomerID
    INNER JOIN car ca ON ca.CarID=co.CarID
    WHERE c.CustomerID =c_id;
END$$
DELIMITER ;
CALL InfoCustomer(1);

/* Question 6: Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
vào database (DeliveryDate < OrderDate + 15). */
DROP TRIGGER IF EXISTS Ins_Order;
DELIMITER $$
CREATE TRIGGER Ins_Order
BEFORE INSERT ON car_order
FOR EACH ROW
BEGIN
        IF (NEW.DeliveryDate<(NEW.OrderDate + INTERVAL 15 DAY)) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Insert Because DeliveryDate is not valid';
        END IF;
END$$
DELIMITER ;
INSERT INTO car_order
(CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note) 
VALUES (1, 5, 1, 13000, '2021-05-11', '2021-05-12', 'Address1', 1, 'Note6');

