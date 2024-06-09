<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- CSS Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- JavaScript Bootstrap (với Popper.js) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Thay đổi đường dẫn tới tệp CSS và JavaScript tùy thuộc vào cấu trúc thư mục của bạn -->
<link href="/path/to/bootstrap.min.css" rel="stylesheet">
<script src="/path/to/bootstrap.bundle.min.js"></script>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./styles/main.css">
</head>


<body>

<H2>Thông tin chi tiết sản phẩm</H2>
<br>
<div class="container-fluid" style="padding-left: 40%" >

    <div style="border : burlywood 3px solid ;width: 500px;height: 500px;border-radius: 50px; padding-left: 40px;align-content: center">
        <form action="/banhangtaiquay/addCTHD/${CTSPCustomBHTQ.id}" method="post" class="product-details-form">
            <H3>Thông tin chi tiết sản phẩm</H3>
            <input type="hidden" name="idhd" value="${idhd}">
            <hr>
            <label style=""><h3>Tên sản phẩm: ${CTSPCustomBHTQ.tenSanPham}</h3></label><br>
            <label><h4>Size: ${CTSPCustomBHTQ.tenSize}</h4></label><br>
            <label><h4>Hãng: ${CTSPCustomBHTQ.tenHang}</h4></label><br>
            <label><h4>Danh Mục: ${CTSPCustomBHTQ.tenDanhMuc}</h4></label><br>
            <label><h4>Chất Liệu: ${CTSPCustomBHTQ.tenChatLieu}</h4></label><br>
            <label><h4>Giá bán: ${CTSPCustomBHTQ.giaBan} VND</h4></label><br>
            <label><h4>Số lượng còn lại: <label style="font-size: 30px;color: firebrick">${CTSPCustomBHTQ.soLuong} sản phẩm </label></h4></label><br><br>
            <label><h4>Nhập số lượng bạn muốn thêm</h4>
                <input type="number" style="width: 350px;height: 30px" name="soluong">
                <button type="submit" class="btn" style="background-color: antiquewhite">Add</button>
            </label><br>
        </form>
    </div>
</div>




</body>
</html>