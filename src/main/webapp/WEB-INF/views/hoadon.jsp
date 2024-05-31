<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<H2>Bán hàng tại quầy</H2>
<br>
<div class= "container-fluid">
    <%-- Dong 1--%>
    <div class= "row">
        <div class ="col-7 bg-primary">
            <p>Tao hoa don cho</p>

        </div>
        <div class ="col-5 bg-success">
            <p>Chi tiet thanh toan</p>
        </div>
    </div>

    <%-- Dong 2 --%>
    <div class= "row">
        <div class ="col-7 bg-secondary">
            <%-- Hien thi danh sach gio hang ow day --%>
            <p>Danhh sachs gio hang</p>
        </div>
        <div class ="col-5 bg-success">
            <p>col-7</p>
        </div>
    </div>
</div>


<%-- Dong 3 --%>
<div class= "row">
    <div class ="col-7 bg-Warning">
        <%-- Hien thi danh sach san pham o day --%>
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
                        <td>${lstHoaDon.tennhanvien}</td>
                        <td>${lstHoaDon.tenkhachhang}</td>
                        <td>${lstHoaDon.ngaymua}</td>
                        <td>${lstHoaDon.thanhtien}</td>
                        <td>${lstHoaDon.giatri}</td>
                        <td>${lstHoaDon.ghichu}</td>
                        <td>${lstHoaDon.ngaytao}</td>
                        <td>${lstHoaDon.ngaysua}</td>
                        <td>${lstHoaDon.tongtien}</td>
                        <td>${lstHoaDon.tongtiengiam}</td>
                        <td>${lstHoaDon.trangthai}</td>
                        <td>${lstHoaDon.tienkhachdua}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
    <div class ="col-5 bg-success">
        <p>col-7</p>
    </div>
</div>
</div>
</div>

</body>
</html>
