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
<script>



</script>
<body>

<H2>Bán hàng tại quầy</H2>
<br>
<div class="container-fluid">


    <%-- Dong 1--%>

    <div class= "row" >
        <form action="/banhangtaiquay/taoHoaDon" method="post" class="col-7">
            <c:if test="${error != null}">
                <div id="errorAlert" class="alert alert-warning alert-dismissible fade show" role="alert">
                    <strong>${error}</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <script type="text/javascript">
                // Sau 5 giây, ẩn thông báo lỗi
                setTimeout(function() {
                    var errorAlert = document.getElementById('errorAlert');
                    if (errorAlert) {
                        errorAlert.classList.add('fade');
                        errorAlert.style.display = 'none';
                    }
                }, 5000); // 5000 milliseconds = 5 giây
            </script>


            <button type="submit" class="btn btn-outline-info">Tạo hóa đơn</button><br><br>
            <c:forEach var="hd" items="${listMaHoaDon}">
                <button type="button" class="btn " style="background-color: antiquewhite;text-align: center">
                    <div>  ${hd.mahoadon}
                        <a href="/banhangtaiquay/deletehdc/${hd.id}" methods="post" class="btn btn-outline-primary"
                           style="font-size: 8px; margin-left: 10px" onclick="return confirm('bạn có chắc chắn muốn hủy hóa đơn này')">X</a>

                    </div>
              </button>
            </c:forEach>
        </form>

        <div class ="col-5 bg-success">
        </div>
    </div>
        <hr>


    <%-- Dong 2 chi tiet hoa don--%>
    <div class="row">
        <div class="col-7 ">
            <%-- Hien thi danh sach gio hang ow day --%>
            <p>Danhh sachs gio hang</p>
        </div>
        <div class="col-5 bg-success">
            <p>col-7</p>
        </div>
    </div>
</div>
<hr>

<%-- Dong 3 danh sach san pham--%>
<div class="row">
    <div class="col-7 bg-white">
        <%-- Hien thi danh sach san pham o day --%>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">Hãng</th>
                <th scope="col">Size</th>
                <th scope="col">Danh mục</th>
                <th scope="col">Chất liệu</th>
                <th scope="col">Màu sắc</th>
                <th scope="col">QR</th>
                <th scope="col">Hình ảnh</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Trạng thái</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${CTSP}" var="lst">
                <tr>
                    <td>${lst.tenSanPham}</td>
                    <td>${lst.tenHang}</td>
                    <td>${lst.tenSize}</td>
                    <td>${lst.tenDanhMuc}</td>
                    <td>${lst.tenChatLieu}</td>
                    <td>${lst.tenMauSac}</td>

                    <td>${lst.QR}</td>
                    <td><img src="${lst.hinhAnh}" alt="Image" style="width:100px;height:100px;"/></td>
                    <td>${lst.soLuong}</td>
                    <td>${lst.moTa}</td>
                    <td>${lst.trangThai == 1 ? 'còn hoạt động' : lst.trangThai}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            <div class="pagination">
                <!-- Link to the previous page -->
                <button type="button" class="btn btn-primary" ${currentPage == 0 ? 'disabled' : ''}
                        onclick="window.location.href='/banhangtaiquay/taoHoaDon?page=${currentPage - 1}'">
                  <<
                </button>

                <!-- Links to individual pages -->
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <button type="button" class="btn btn-dark ${i == currentPage ? 'current-page' : ''}"
                            onclick="window.location.href='/banhangtaiquay/taoHoaDon?page=${i}'">${i + 1}</button>
                </c:forEach>

                <!-- Link to the next page -->
                <button type="button" class="btn btn-primary" ${currentPage == totalPages - 1 ? 'disabled' : ''}
                        onclick="window.location.href='/banhangtaiquay/taoHoaDon?page=${currentPage + 1}'">
                    >>
                </button>
            </div>


    </div>
    <div class="col-5 bg-success">
        <p>col-7</p>
    </div>
</div>
</div>
</div>

</body>
</html>