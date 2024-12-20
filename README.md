

# Quản Lý Bài Viết Sử Dụng Spring Boot

## Giới thiệu

Ứng dụng web quản lý bài viết sử dụng Spring Boot, Spring MVC và Spring Data. Cơ sở dữ liệu bao gồm hai bảng `Post` và `Category` có quan hệ 1-nhiều.

## Tính năng

1. Hiển thị danh sách bài viết.

![image](https://github.com/user-attachments/assets/579cd818-9c64-4a5f-ba71-adc36676aad7)


2. Xem chi tiết bài viết.

![image](https://github.com/user-attachments/assets/0ad2a7c5-1760-4f3f-b83e-819657033960)

   
3. Thêm mới bài viết.

![image](https://github.com/user-attachments/assets/0ee819d1-1e41-4d98-a18f-67fc02514622)


4. Chỉnh sửa bài viết.

![image](https://github.com/user-attachments/assets/3534c630-801c-42df-a739-28e46ee4995c)


5. Xóa bài viết.

## Cơ sở dữ liệu

### Bảng `Category`
- `id` (INT, AUTO_INCREMENT, PRIMARY KEY)
- `name` (VARCHAR 255, NOT NULL)

### Bảng `Post`
- `id` (INT, AUTO_INCREMENT, PRIMARY KEY)
- `title` (VARCHAR 255, NOT NULL)
- `content` (TEXT, NOT NULL)
- `author` (VARCHAR 100, NOT NULL)
- `category_id` (INT, FOREIGN KEY REFERENCES `Category(id)`)

### Dữ liệu mẫu
Bảng `Category`:
- `1, "Technology"`
- `2, "Health"`
- `3, "Education"`

Bảng `Post`:
- `1, "Post 1", "Content of Post 1", "Author 1", 1`
- `2, "Post 2", "Content of Post 2", "Author 2", 2`

## Cài đặt

### Yêu cầu
- Java 17 hoặc cao hơn.
- Maven 3.6+.
- IDE hỗ trợ Spring Boot (IntelliJ IDEA hoặc Eclipse).
- CSDL MariaDB hoặc H2.

### Cách chạy dự án

1. Clone repository:
   ```bash
   git clone <repository-url>
   ```

2. Nhập project vào IDE.

3. Cấu hình CSDL trong tệp `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/HoTenSVDB
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. Chạy file `SpringBootApplication` trong package chính.

5. Mở trình duyệt và truy cập [http://localhost:8080/posts](http://localhost:8080/posts).

## Các package trong dự án

1. **entity**: Chứa các class biểu diễn cơ sở dữ liệu (`Post`, `Category`).
2. **dao**: Chứa repository tương tác với CSDL.
3. **service**: Xử lý logic nghiệp vụ.
4. **controller**: Xử lý request HTTP và điều hướng view.
5. **templates**: Chứa các file HTML giao diện người dùng.
6. **static**: Chứa các file CSS.

## Thư viện sử dụng
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Thymeleaf
- MariaDB Driver
- Spring Boot Starter Validation


