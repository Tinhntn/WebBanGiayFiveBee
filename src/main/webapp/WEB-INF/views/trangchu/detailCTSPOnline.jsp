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
    <%--    <link rel="stylesheet" type="text/css" href="./styles/main.css">--%>
</head>
<body>

<div class="container bg-Info">

    <div class="row mt-5">
<%--        <form action="/banhangonline/detailCTSPOnline/${detailCTSPCustom.id}">--%>
       <div class="col-6">
          <img src="${detailCTSPCustom.hinhAnh}" class="mt-4" alt="${detailCTSPCustom.tenSanPham}">
       </div>
        <div class="col-6">
            <label class="mt-4">${detailCTSPCustom.tenSanPham}</label><br><br>
            <label>${detailCTSPCustom.giaBan} VND</label><br><br>
            <span style="padding-right: 10px">Màu sắc:</span>
            <a title="XÁM" style="padding-right: 10px">
                <img src="/img/iconxam.png" style="width: 20px; height: 20px">
            </a>
            <a title="Đen">
                <img src="/img/iconden.png" style="width: 24px; height: 24px">
            </a><br><br>

            <div class="">
                <span>Size:</span>
                <a name="40" style="border: 2px solid red">40</a>
                <a name="41" >41</a>
                <a name="42" >42</a>
                <a name="43" >43</a>
                <a name="44" >44</a>
            </div><br><br>


    <div class="mb-4">
        <a href="#" class="btn btn-secondary">
            Đặt hàng
        </a>
        <a href="#" class="btn btn-secondary">
            Giỏ hàng
        </a>
    </div>
        </div>
<%--    </form>--%>


    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        const sizeLinks = document.querySelectorAll("a[name^='4']"); // Lấy tất cả các phần tử có name bắt đầu bằng "4"
        sizeLinks.forEach(function(link) {
            link.addEventListener("click", function() {
                // Xóa viền đỏ của tất cả các phần tử
                sizeLinks.forEach(function(sizeLink) {
                    sizeLink.style.border = "none";
                });
                // Thêm viền cho phần tử được nhấn
                this.style.border = "2px solid red"; // Thay "blue" bằng màu bạn muốn
            });
        });
    });
</script>


</body>
</html>