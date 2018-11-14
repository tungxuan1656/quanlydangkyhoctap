CREATE DATABASE QUANLYDANGKYHOCTAP
GO

-- Mặc định trong SQL khi tạo bảng sẽ có 1 hàng null
-- dùng lệnh này để bỏ qua hàng đó khi truy vấn
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- Tạo bảng SinhVien
CREATE TABLE SinhVien
( 
	-- CLUSTERED để xác định mssv làm chỉ mục trong bảng
	-- tức là các bản ghi được sắp xếp theo mssv
	mssv nvarchar(20) NOT NULL,
	tensv nvarchar(50) NOT NULL,
	ngaysinh date NOT NULL,
	khoa nvarchar(10) NOT NULL,
	lop nvarchar(50) NOT NULL,
	thanhpho nvarchar(50) NOT NULL,
	CONSTRAINT PK_SinhVien PRIMARY KEY CLUSTERED (mssv ASC)
)
GO

CREATE TABLE LopHoc
(
	malop nvarchar(20) NOT NULL,
	mahp nvarchar(20) NOT NULL,
	tenhp nvarchar(50) NOT NULL, 
	tinchi int NOT NULL,
	tiet nvarchar(20) NOT NULL,
	thu nvarchar(20) NOT NULL,
	phonghoc nvarchar(20) NOT NULL,
	CONSTRAINT PK_LopHoc PRIMARY KEY CLUSTERED (malop ASC)
)
GO

-- Tạo bảng DangKy
CREATE TABLE DangKy
(
	mssv nvarchar(20) NOT NULL,
	malop nvarchar(20) NOT NULL
)
GO

-- Tạo khóa ngoại, DangKy.mssv là khóa ngoại của SinhVien.mssv
ALTER TABLE DangKy ADD CONSTRAINT FK_DangKy_SinhVien 
FOREIGN KEY (mssv) REFERENCES SinhVien(mssv)
ON UPDATE CASCADE
ON DELETE CASCADE
GO

-- Tạo khóa ngoại, DangKy.malop là khóa ngoại của LopHoc.mssv
ALTER TABLE DangKy ADD CONSTRAINT FK_DangKy_LopHoc
FOREIGN KEY (malop) REFERENCES LopHoc(malop)
ON UPDATE CASCADE
ON DELETE CASCADE
GO

