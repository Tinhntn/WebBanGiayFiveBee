<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã hóa đơn</th>
        <th scope="col">Tên nhân vien</th>
        <th scope="col">Tên khách hàng</th>
        <th scope="col">Ngày mua</th>
        <th scope="col">Thành tiền</th>
        <th scope="col">Khuyến mãi</th>
        <th scope="col">Ghi chú</th>
        <th scope="col">Ngày Tạo</th>
        <th scope="col">Ngày sửa</th>
        <th scope="col">Tổng tiền</th>
        <th scope="col">Tổng tiền giảm</th>
        <th scope="col">Trạng thái</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${lstHoaDon}" var="lstHoaDon">

            <tr>
                <td>${lstHoaDon.mahoadon}</td>
                <td>${lstHoaDon.idnhanvien}</td>
                <td>${lstHoaDon.idkhachhang}</td>
                <td>${lstHoaDon.ngaymua}</td>
                <td>${lstHoaDon.thanhtien}</td>
                <td>${lstHoaDon.idkhachhang}</td>
                <td>${lstHoaDon.ghichu}</td>
                <td>${lstHoaDon.ngaytao}</td>
                <td>${lstHoaDon.ngaysua}</td>
                <td>${lstHoaDon.tongtien}</td>
                <td>${lstHoaDon.tongtiengiam}</td>
                <td>${lstHoaDon.trangthai}</td>


            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>