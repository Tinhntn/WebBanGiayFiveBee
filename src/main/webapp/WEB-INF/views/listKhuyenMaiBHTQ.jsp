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

<div class="container-fluid">

    <h1>Danh Sách Khách Hàng</h1>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã khuyến mại</th>
            <th scope="col">Tên khuyến mại</th>
            <th scope="col">Giá trị</th>
            <th scope="col">Điều kiện giảm</th>
            <th scope="col">Ngày bắt đầu</th>
            <th scope="col">Ngày kết thúc</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKhuyenMai}" var="khuyenMai">
            <tr>
                <td>${khuyenMai.makhuyenmai}</td>
                <td>${khuyenMai.tenkhuyenmai}</td>
                <td>${khuyenMai.giatri}</td>
                <td>${khuyenMai.dieukiengiam}</td>
                <td>${khuyenMai.ngaybatdau}</td>
                <td>${khuyenMai.ngayketthuc}</td>
                <td>${khuyenMai.soluong}</td>
                <td>${khuyenMai.trangthai == 1 ? 'còn hoạt động' : 'không hoạt động'}</td>
                <td>
                    <form action="/banhangtaiquay/addkhuyenmaivaohd/${id}/${khuyenMai.id}" method="post">
                        <Button class="btn" style="background-color: antiquewhite">add</Button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">
        <!-- Link to the previous page -->
        <button type="button" class="btn btn-primary" ${currentPage == 0 ? 'disabled' : ''}
                onclick="window.location.href='/banhangtaiquay/danhsachkhachhang?page=${currentPage - 1}'">
            <<
        </button>

        <!-- Links to individual pages -->
        <%--        <c:forEach var="i" begin="0" end="${totalPages - 0}">--%>
        <%--            <button type="button" class="btn btn-dark ${i == currentPage ? 'current-page' : ''}"--%>
        <%--                    onclick="window.location.href='/banhangtaiquay/danhsachkhachhang?page=${i}'">${i + 1}</button>--%>
        <%--        </c:forEach>--%>

        <!-- Link to the next page -->
        <button type="button" class="btn btn-primary" ${currentPage == totalPages - 1 ? 'disabled' : ''}
                onclick="window.location.href='/banhangtaiquay/danhsachkhachhang?page=${currentPage + 1}'">
            >>
        </button>
    </div>

</div>

</div>


</body>
</html>