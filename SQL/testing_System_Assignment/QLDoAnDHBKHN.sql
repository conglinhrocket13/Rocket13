CREATE DATABASE QL_DoAn;
USE QL_DoAn;

/* Để quản lý đồ án tốt nghiệp của các sinh viên, trường ĐHBKHN đang cần xây dựng 1 cơ sở
dữ liệu MySQL để quản lý tập trung, bạn hãy giúp trường làm việc này. Hãy xây dựng 1 DB
có tên QL_DoAn có các bảng dữ liệu như bên dưới (trường có dấu gạch chân là
PrimaryKey):

Trường học vị: nhận các giá trị là Ths, Ts, PGS, GS, … */
# Tạo bảng giảng viên: GiangVien(Id_GV, Ten_GV, Tuoi, HocVi)
CREATE TABLE GiangVien(
	ID_GV 	INT PRIMARY KEY AUTO_INCREMENT,
    Ten_GV 	VARCHAR(50) NOT NULL,
    Tuoi	TINYINT NOT NULL,
    Hocvi 	VARCHAR(20) NOT NULL
);

# Tạo bảng sinh viên: SinhVien(Id_SV, Tên_SV, NamSinh, QueQuan)

CREATE TABLE SinhVien(
	ID_SV 	INT PRIMARY KEY AUTO_INCREMENT,
    Ten_SV 	VARCHAR(50) NOT NULL,
    NamSinh	INT NOT NULL,
    QueQuan VARCHAR(100) NOT NULL
);

# Tạo bảng đề tài: DeTai(Id_DeTai, Ten_DeTai)
CREATE TABLE DeTai(
	ID_DeTai 	INT PRIMARY KEY AUTO_INCREMENT,
    Ten_DeTai 	VARCHAR(100) NOT NULL
);
# Tạo bảng hướng dẫn: HuongDan(Id, Id_SV, Id_DeTai, Id_GV, Diem)
CREATE TABLE HuongDan(
	ID 			INT PRIMARY KEY AUTO_INCREMENT,
    ID_SV 		INT NOT NULL,
    ID_DeTai	INT NOT NULL,
    ID_GV		INT NOT NULL,
    Diem		TINYINT
);
/* Question 1:  Tạo table với các ràng buộc và kiểu dữ liệu
				Thêm ít nhất 10 bản ghi vào table:*/
ALTER TABLE HuongDan
ADD CONSTRAINT fk_IDSV FOREIGN KEY (ID_SV) REFERENCES SinhVien(ID_SV);
ALTER TABLE HuongDan
ADD CONSTRAINT fk_IDGV FOREIGN KEY (ID_GV) REFERENCES GiangVien(ID_GV);
ALTER TABLE HuongDan
ADD CONSTRAINT fk_ID_DeTai FOREIGN KEY (ID_DeTai) REFERENCES DeTai(ID_DeTai);

INSERT INTO sinhvien (
			Ten_SV		,NamSinh		,QueQuan
		)
VALUES 	('Sinh Viên 1'	,1999 			,'Hà Nội'),
		('Sinh Viên 2'	,1997 			,'Hà Nội'),
        ('Sinh Viên 3'	,1997 			,'Nam Định'),
		('Sinh Viên 4'	,1994 			,'Bắc Ninh'),
        ('Sinh Viên 5'	,1999 			,'Hòa Bình'),
		('Sinh Viên 6'	,2000			,'Lạng Sơn'),
        ('Sinh Viên 7'	,1998 			,'Hà Nam'),
		('Sinh Viên 8'	,2002 			,'Bắc Giang'),
        ('Sinh Viên 9'	,1996 			,'Thái Nguyên'),
		('Sinh Viên 10'	,2001 			,'Bắc Giang');

INSERT INTO giangvien (
			Ten_GV			,Tuoi			,Hocvi
		)
VALUES 	('Giảng Viên 1'		,33 			,'Ths'),
		('Giảng Viên 2'		,40 			,'PGS'),
        ('Giảng Viên 3'		,35 			,'Ts'),
		('Giảng Viên 4'		,31				,'GV'),
        ('Giảng Viên 5'		,45 			,'GS'),
		('Giảng Viên 6'		,32				,'Ths'),
        ('Giảng Viên 7'		,33				,'Ths'),
		('Giảng Viên 8'		,30 			,'GV'),
        ('Giảng Viên 9'		,33				,'Ths'),
		('Giảng Viên 10'	,31 			,'GV');

INSERT INTO detai (
			Ten_DeTai
		)
VALUES	('Đề Tài 1'),
		('Đề Tài 2'),
        ('Đề Tài 3'),
		('Đề Tài 4'),
        ('Đề Tài 5'),
		('Đề Tài 6'),
        ('Đề Tài 7'),
		('Đề Tài 8'),
        ('Đề Tài 9'),
		('Đề Tài 10');
        
INSERT INTO huongdan (
			ID_SV	,ID_DeTai	,ID_GV	,Diem
		)
VALUES 	(	1		,1 		,1			,7),
		(	2		,2 		,2			,8),
		(	3		,3 		,3			,6),
		(	4		,4 		,4			,9),
        (	5		,5 		,1			,7),
		(	6		,6 		,6			,8),
		(	7		,7 		,7			,8),
		(	8		,8 		,6			,8),
        (	9		,9 		,9			,5),
		(	10		,10 	,10			,4);

# Question 2. Viết lệnh để:


-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT * FROM SinhVien 
WHERE ID_SV IN (SELECT ID_SV FROM huongdan WHERE ID_Detai IS NULL) 
	OR ID_SV NOT IN (SELECT ID_SV FROM huongdan);

SELECT * FROM sinhVien sv 
LEFT JOIN huongdan hd ON sv.ID_SV=hd.ID_SV 
WHERE ID_Detai IS NULL OR sv.ID_SV NOT IN (SELECT ID_SV FROM huongdan);

-- b) Lấy ra số sinh viên làm đề tài ‘DeTai 6' 
SELECT COUNT(ID_SV) AS SL FROM huongdan 
WHERE ID_DeTai = (SELECT ID_DeTai FROM detai WHERE Ten_DeTai='Đề Tài 6');

/* Question 3: Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
	mã số, họ tên và tên đề tài
	(Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có") */
CREATE OR REPLACE VIEW SinhVienInfo AS
	SELECT DISTINCT sv.ID_SV, sv.Ten_SV, CASE
			WHEN (hd.ID_DeTai IS NULL ) THEN "Chưa có"
            WHEN hd.ID_DeTai !=0 THEN dt.Ten_DeTai
            END AS	Ten_DeTai
	FROM detai dt,	sinhvien sv
    JOIN huongdan hd ON sv.ID_SV=hd.ID_SV
    WHERE dt.ID_DeTai= hd.ID_DeTai OR (hd.ID_DeTai IS NULL)
    ORDER BY sv.ID_SV asc;
    
SELECT * FROM SinhVienInfo;

/* Question 4: Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1950
thì hiện ra thông báo "Moi ban kiem tra lai nam sinh" */
DROP TRIGGER IF EXISTS Ins_Group;
DELIMITER $$
	CREATE TRIGGER Ins_SinhVien
    BEFORE INSERT ON sinhvien
    FOR EACH ROW
	BEGIN
        IF NEW.NamSinh <= 1950 THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Moi ban kiem tra lai nam sinh';
        END IF;
	END$$
DELIMITER ;
INSERT INTO sinhvien (Ten_SV, NamSinh, QueQuan) 
VALUES ('Sinh Viên 11', 1949, 'Cao Bằng');

/* Question 5: Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi */
ALTER TABLE HuongDan
DROP CONSTRAINT fk_IDSV;
ALTER TABLE HuongDan
ADD CONSTRAINT fk_IDSV FOREIGN KEY (ID_SV) REFERENCES SinhVien(ID_SV) ON DELETE CASCADE;

/* Question 6: Viết 1 Procedure để khi nhập vào tên của sinh viên thì sẽ thực hiện 
				xóa toàn bộ thông tin liên quan của sinh viên trên hệ thống; */
DROP PROCEDURE IF EXISTS DeleteSV;
DELIMITER $$
CREATE PROCEDURE DeleteSV(IN ten Varchar(50))
BEGIN
	DECLARE id INT;
    SELECT ID_SV INTO id FROM sinhvien WHERE Ten_SV LIKE ten;
    DELETE FROM sinhvien WHERE ID_SV=id;
    DELETE FROM huongdan WHERE ID_SV=id;
END$$
DELIMITER ;
CALL DeleteSV('Sinh Viên 11');