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

<div class="container">

    <h1 class="text-center my-4">SẢN PHẨM BÁN CHẠY</h1>
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-2 mb-4" style="margin-right: 100px">
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="${product.hinhAnh}" alt="${product.tenSanPham}">
                        <div class="card-body">
                            <h5 class="card-title">${product.tenSanPham}</h5>
                            <p class="card-text">Giá bán: ${product.giaBan} VND</p>
                            <a href="/banhangonline/detailCTSPOnline/${product.id}" class="btn btn-primary">Xem chi tiết</a>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="text-center mb-4">
        <a href="/banhangonline/viewsanpham?viewAll=${!viewAll}" class="btn btn-secondary">
            ${viewAll ? 'Hiển thị sản phẩm bán chạy' : 'Xem tất cả'}
        </a>
    </div>
</div>

<div class="pagination">
    <!-- Link to the previous page -->
    <button type="button" class="btn btn-primary" ${currentPage == 0 ? 'disabled' : ''}
            onclick="window.location.href='/banhangtaiquay/taoHoaDon?page=${currentPage - 1}'">
        <<
    </button>

    <!-- Links to individual pages -->
<%--    <c:forEach var="i" begin="0" end="${totalPages - 1}">--%>
<%--        <button type="button" class="btn btn-dark ${i == currentPage ? 'current-page' : ''}"--%>
<%--                onclick="window.location.href='/banhangtaiquay/taoHoaDon?page=${i}'">${i + 1}</button>--%>
<%--    </c:forEach>--%>

    <!-- Link to the next page -->
    <button type="button" class="btn btn-primary" ${currentPage == totalPages - 1 ? 'disabled' : ''}
            onclick="window.location.href='/banhangtaiquay/taoHoaDon?page=${currentPage + 1}'">
        >>
    </button>
</div>
</div>

</div>

</body>
</html>