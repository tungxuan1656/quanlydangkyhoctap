## Hướng Dẫn Sử Dụng

# Phần mềm Quản lý đăng ký học tập

Gồm có 3 thư mục:  
- __released__: bản phát hành kèm file dữ liệu đầu vào  
- __database__: bao gồm database dùng để attach hoặc file _QueryQLDKHT.spl_ để chạy Query trong SQL Server  
- __source code__: chứa source code, phần mềm sử dụng java swing

## Cài đặt  
1. Tạo Database với SQL Server:  
- Cách 1: Mở SQL Server, open file _Query_QLDKHT.sql_, sau đó chạy Query  
- Cách 2: Attach database đã có sẵn. Hướng dẫn attach: Chuột phải vào _database_ -> chọn _Attach_ -> chọn file _QUANLYDANGKYHOCTAP.mdf_   
2. Mở file databaselogin.txt và thay thế 3 dòng dữ liệu:  
- Dòng 1: user đăng nhập SQL server (thường là sa)  
- Dòng 2: password của user đó  
- Dòng 3: tên database vừa tạo (QUANLYDANGKYHOCTAP)  
Lưu file lại

## Hướng dẫn sử dụng phần mềm: (file _quanlydangkyhoctap.jar_)  

Phần mềm gồm 3 tab:  
1. Tab __Sinh Viên__: Chứa thông tin các sinh viên  
- Thêm SV: Khi thêm sinh viên phải điền đầy đủ các thông tin của sv đó, ngày sinh điền theo định dạng dd/MM/yyyy (ví dụ: 10/10/1998)  
- Xóa SV: Xóa sv theo MSSV đã nhập trong trường nhập  
- Tìm kiếm: Cung cấp chức năng tìm kiếm phối hợp nhiều thông tin, bao gồm có _MSSV, Họ tên, Khóa, Lớp, Thành Phố_, sinh viên được tìm thấy khi mà thông tin của sv đó có chứa chuỗi là các chuỗi trong các trường nhập  
2. Tab __Lớp Học__: Chứa thông tin các lớp học được mở  
- Thêm Lớp: Khi thêm lớp phải điền đầy đủ các thông tin trong trường nhập  
- Xóa Lớp: Xóa lớp theo mã lớp  
- Tìm kiếm: Cung cấp chức năng tìm kiếm phối hợp các trường thông tin _Mã lớp, Tên HP, Mã HP_  
3. Tab __Đăng Ký__: Chứa thông tin về các lớp mà sinh viên đã đăng ký  
- ĐK mới: Thêm đk mới dựa vào MSSV và mã lớp  
- Xóa ĐK: bắt buộc phải có MSSV và mã lớp  
- Tìm kiếm: Tìm kiếm theo MSSV hoặc Mã lớp hoặc cả 2  

***
_14/11/2018_
