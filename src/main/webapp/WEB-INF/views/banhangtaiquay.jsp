<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- CSS Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- JavaScript Bootstrap (với Popper.js) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script><!-- Thay đổi đường dẫn tới tệp CSS và JavaScript tùy thuộc vào cấu trúc thư mục của bạn -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script><script src="/path/to/bootstrap.bundle.min.js"></script>

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
        <div class="col-8 ">
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


            <button type="submit" class="btn btn-outline-info">Tạo hóa đơn</button>
        </form>

        </div>
        <div class ="col-4 ">
          <h2>Thông tin hóa đơn</h2>
        </div>

        <div class="col-8 ">
        <span>
            <c:forEach var="hd" items="${listMaHoaDon}">
                <a  href="/banhangtaiquay/detailhd/${hd.id}" methods="get" class="btn " style="background-color: antiquewhite;  ">
                   ${hd.mahoadon}
                        <a href="/banhangtaiquay/deletehdc/${hd.id}" methods="post" class="btn btn-outline-primary"
                           style="font-size: 13px; margin-right: 20px" onclick="return confirm('bạn có chắc chắn muốn hủy hóa đơn này')">X</a>
              </a>
            </c:forEach>
                   </span>

    </div>

        <div class ="col-4 ">

            <div>Khách hàng <input type="text"  value="${hoadon.mahoadon}"></div>
            <div>Khách hàng <input type="text"  value="${hoadon.id}"></div>
        </div>
    </div>
        <hr>
        <!-- modal update hoadonchitie -->


        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Số lượng</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="updateSoluongForm" action="/banhangtaiquay/updateSoLuong" method="post">
                            <input type="hidden" id="idHoaDonChiTiet" name="id">
                            <label for="soLuong">Số lượng:</label>
                            <input type="number" id="soLuong" name="soLuong" class="form-control">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát</button>
                        <button type="submit" class="btn btn-primary" form="updateSoluongForm" onclick="validateForm()">Lưu</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal script -->
        <script>
            var exampleModal = document.getElementById('exampleModal');
            exampleModal.addEventListener('show.bs.modal', function (event) {
                var button = event.relatedTarget;
                var id = button.getAttribute('data-id');
                var modal = this;
                modal.querySelector('.modal-body #idHoaDonChiTiet').value = id; // Gán giá trị ID vào input ẩn
                modal.querySelector('.modal-body #soLuong').value = ''; // Xóa giá trị cũ nếu có
            });
            var soluongInput = document.getElementById('soLuong');
            var errorMessage = '';
            function validateForm() {
                var soluongValue = soluongInput.value.trim();

                // Tiyakin na hindi naka-blank ang input
                if (soluongValue == '') {
                    errorMessage = 'Không được để trống';
                }  if (isNaN(soluongValue)) {
                    errorMessage = 'Số lượng phải là số';
                } if (soluongValue<0){
                    errorMessage='Không được nhập vào số âm';
                }
                else {
                    // Tiyakin na ang kantidad ay hindi naka-negative at hindi higit sa available quantity
                    var availableQuantity = parseInt(soluongInput.getAttribute('data-available-soLuong'));
                    if (parseInt(soluongValue) <= 0 || parseInt(soluongValue) > availableQuantity) {
                        errorMessage = 'Số lượng trong kho không đủ';
                    }
                }
                // I-display ang error message kung mayroon
                document.getElementById('updateSoluongForm').addEventListener('submit', function(event) {
                    if (errorMessage) {
                        event.preventDefault(); // Ngăn chặn gửi dữ liệu
                        alert(errorMessage);
                        errorMessage = '';
                    }
                });
            }
        </script>

        <div class="row">
            <div class="col-8">
                <!-- Hiển thị danh sách giỏ hàng ở đây -->
                <h3>Giỏ hàng</h3>
                <table class="table table-header">
                    <thead>
                    <tr>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th>Hình ảnh</th>
                        <th>Size</th>
                        <th>Hãng</th>
                        <th>Chất liệu</th>
                        <th>Màu sắc</th>
                        <th>Danh mục</th>
                        <th>Trạng thái</th>
                        <th>Chức năng</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${chiTietHoaDonList}" var="CTHoaDon">
                        <tr>
                            <td>${CTHoaDon.tenSanPham}</td>
                            <td>${CTHoaDon.soluong}</td>
                            <td>${CTHoaDon.dongia}</td>
                            <td>Hình ảnh</td>
                            <td>${CTHoaDon.size}</td>
                            <td>${CTHoaDon.chatLieu}</td>
                            <td>${CTHoaDon.hang}</td>
                            <td>${CTHoaDon.mauSac}</td>
                            <td>${CTHoaDon.danhMuc}</td>
                            <td>${CTHoaDon.trangthai == 1 ? 'Còn hoạt động' : 'Không hoạt động' }</td>
                            <td>
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-id="${CTHoaDon.idHoaDon} ">
                                    Update
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
            <div class="col-4 bg-success">
                <p>col-7</p>
            </div>
        </div>
        </div>


</div>
<hr>

<%-- Dong 3 danh sach san pham--%>
<div class="row">
    <div class="col-8 bg-white">
        <%-- Hien thi danh sach san pham o day --%>
        <h2>Danh sách sản phẩm</h2>
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
                <th scope="col">Chức năng</th>
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
                    <td><img src="${lst.hinhAnh}" alt="Image" style="width:80px;height:50px;"/></td>
                    <td>${lst.soLuong}</td>
                    <td>${empty lst.moTa ? "trống" : lst.moTa}</td>
                    <td>${lst.trangThai == 1 ? 'còn hoạt động' : lst.trangThai}</td>
                    <td><a href="" class="btn" style="background-color: antiquewhite">add</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            <div class="pagination">
                <!-- Link to the previous page -->
                <button type="button" class="btn btn-primary" ${currentPage == 0 ? 'disabled' : ''}
                        onclick="window.location.href='/banhangtaiquay/hienthi?page=${currentPage - 1}'">
                    <<
                </button>

                <!-- Links to individual pages -->
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <button type="button" class="btn btn-dark ${i == currentPage ? 'current-page' : ''}"
                            onclick="window.location.href='/banhangtaiquay/hienthi?page=${i}'">${i + 1}</button>
                </c:forEach>

                <!-- Link to the next page -->
                <button type="button" class="btn btn-primary" ${currentPage == totalPages - 1 ? 'disabled' : ''}
                        onclick="window.location.href='/banhangtaiquay/hienthi?page=${currentPage + 1}'">
                    >>
                </button>
            </div>


    </div>
    <div class="col-4 bg-success">
        <p>col-7</p>
    </div>
</div>
</div>
</div>

</body>
</html>