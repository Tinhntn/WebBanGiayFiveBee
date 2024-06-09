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
          <h2>Thông tin hóa đơn ${hoadon.mahoadon}</h2>
        </div>

        <div class="col-8 ">
        <span>
            <c:forEach var="hd" items="${listMaHoaDon}">
                <a  href="/banhangtaiquay/detailhd/${hd.id}" methods="get" class="btn " style="background-color: antiquewhite;  ">
                   ${hd.mahoadon}
                        <a href="/banhangtaiquay/deletehdc/${hd.id}" methods="post" class="btn btn-outline-primary" style="font-size: 13px; margin-right: 20px" onclick="return confirm('bạn có chắc chắn muốn hủy hóa đơn này')">X</a>
              </a>
            </c:forEach>
                   </span>

    </div>
        <script>
            function validateFormTimKiemKhachHang() {
                const sdt = document.getElementsByName("sdt")[0].value;
                const sdtRegex = /^[0-9]{10,11}$/;

                if (!sdt) {
                    alert("Số điện thoại không được bỏ trống.");
                    return false;
                }

                if (!sdtRegex.test(sdt)) {
                    alert("Số điện thoại phải là số và có độ dài từ 10 đến 11 ký tự.");
                    return false;
                }

                return true;
            }
        </script>
        <div class ="col-4 ">

            <form action="/banhangtaiquay/findidKHbysdt/${id}" method="get" onsubmit="return validateFormTimKiemKhachHang()">
                <label>SDT khách hàng</label>
                <input type="text" name="sdt" style="width: 200px; height: 30px; margin-left: 25px" value="${sdt}">
                <button type="submit" class="btn" style="background-color: antiquewhite">Search</button>
            </form>

                <label>Tên khách hàng</label><input type="text" style="width:200px;height: 30px ;margin-left: 25px" value="${tenkh}" disabled>
            <div class="btn-group">
                <a href="/banhangtaiquay/danhsachkhachhang/${id}" class="btn" style="background-color: antiquewhite;width: 60px;height: 40px" >List</a>
                <form action="/banhangtaiquay/xoakhachhang/${hoadon.id}" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này khỏi hóa đơn?');">
                    <button type="submit" class="btn btn-outline-danger">Xóa</button>
                </form>
            </div>
            <br><br>
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
                        <form id="updateSoluongForm" action="/banhangtaiquay/updateSoLuong" method="post" onsubmit="return validateAndSubmitForm(event)">
                            <input type="hidden" id="idHoaDonChiTiet" name="id">
                            <label for="soLuong">Số lượng:</label>
                            <input type="number" id="soLuong" name="soLuong" class="form-control">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát</button>
                        <button type="submit" class="btn btn-primary" form="updateSoluongForm">Lưu</button>
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
                //lay so luong tu chitietsanpham
                var availableQuantity = document.getElementById('chitietsanpham').getAttribute('data-available-quantity');
                modal.querySelector('.modal-body #soLuong').setAttribute('data-available-soLuong', availableQuantity);
            });


            function validateAndSubmitForm(event) {
                var soluongInput = document.getElementById('soLuong');
                var soluongValue = soluongInput.value.trim();
                var errorMessage = '';
                var availableQuantity = parseInt(soluongInput.getAttribute('data-available-soLuong'));

                // Kiểm tra số lượng
                if (soluongValue == '') {
                    errorMessage = 'Không được để trống';
                } else if (isNaN(soluongValue)) {
                    errorMessage = 'Số lượng phải là số';
                } else if (parseInt(soluongValue) < 0) {
                    errorMessage = 'Không được nhập vào số âm';
                } else if ( parseInt(soluongValue) > availableQuantity) {
                    errorMessage = 'Số lượng trong kho không đủ';
                    }


                // Hiển thị lỗi nếu có và ngăn chặn gửi form
                if (errorMessage) {
                    event.preventDefault(); // Ngăn chặn gửi dữ liệu
                    alert(errorMessage);
                    return false;
                }

                return true;
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
                        <th>Thành tiền</th>
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
                            <td>${CTHoaDon.dongia}VNĐ</td>
                            <td><img src="${CTHoaDon.hinhAnh}" alt="Ảnh sản phẩm" style="width: 100px; height: 100px"></td>
                            <td>${CTHoaDon.size}</td>
                            <td>${CTHoaDon.chatLieu}</td>
                            <td>${CTHoaDon.hang}</td>
                            <td>${CTHoaDon.mauSac}</td>
                            <td>${CTHoaDon.danhMuc}</td>
                            <td>${CTHoaDon.trangthai == 1 ? 'Còn hoạt động' : 'Không hoạt động' }</td>
                            <td class="inline-button">
                                <button type="button" class="btn btn-primary d-inline-block" data-bs-toggle="modal" data-bs-target="#exampleModal" data-id="${CTHoaDon.id}">
                                    Sửa
                                </button>
                                <a href="/banhangtaiquay/deleteCTHoaDon/${CTHoaDon.id}?idctsanpham=${CTHoaDon.idchitietsanpham}"
                                   class="btn btn-outline-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này khỏi hóa đơn?');">
                                    Xóa
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        <div class="col-4" style="border: black 1px solid; text-align: center; padding: 20px;">
            <form action="/banhangtaiquay/findKhuyenMaiByMa/${id}" method="get">
                <label>Mã khuyến mại </label>
                <input type="text" style="width: 200px; height: 30px; margin-left: auto; margin-right: auto; display: block;" value="${maKM}">
                <a href="#" class="btn" style="background-color: antiquewhite; display: block; margin-top: 10px;">Seach</a>
                <br>
                <label>giá trị giảm </label>
                <input type="text" style="width: 200px; height: 30px; margin-left: auto; margin-right: auto; display: block;" value="${gtg}" disabled>
                <div class="btn-group" style="display: block; margin-top: 10px;">
                    <a href="#" class="btn" style="background-color: antiquewhite; display: inline-block;">Danh sách</a>
                    <a href="#" class="btn btn-outline-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này khỏi hóa đơn?');" style="display: inline-block; margin-left: 10px;">
                        Xóa
                    </a>
                </div>
            </form>
        </div>
        </div>
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
            <form action="/banhangtaiquay/searchctsp/${id}" method="get">
                <div>
                    <label class="form-label">Tên sản phẩm</label>
                    <input type="text" class="form-control" placeholder="Tìm kiếm theo tên" name="tenSanPham"
                           value="${keyword}"> <!-- Bind input to the keyword -->
                </div>
                <button type="submit" class="btn btn-success">Search</button>
            </form>

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
                <th scope="col">Đơn giá </th>
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
                    <td>${lst.giaBan}VNĐ</td>
                    <td>${lst.trangThai == 1 ? 'còn hoạt động' : lst.trangThai}</td>
                    <td><a href="/banhangtaiquay/showCTSPThemCTHD/${hoadon.id}/${lst.id}" class="btn" style="background-color: antiquewhite">add</a></td>
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

        <div class="col-4" style="border: black 1px solid; text-align: center;align-content: center">
            <form action="/banhangtaiquay/trutienkhachdua/${id}" method="post">

                <label>Tiền khách đưa
                    <input  type="text"  name="tienkhachdua" style="width: 300px; height: 30px; margin: 0 auto; display: block;"  value="${tienkhachdua}">
                </label>  </br>
                <button type="submit" class="btn" style="background-color: antiquewhite; margin-top: 5px">Xác nhận</button></br>

                <label>Tiền Thừa
                    <input type="text" style="width: 300px; height: 30px; margin: 0 auto; display: block;" value="${tienthua}" disabled>
                    <input type="hidden" name="thanhtien"  style="width: 300px; height: 30px; margin: 0 auto; display: block;" value="${empty tttt ? '0' : tttt}">
                </label>

                <label>Tiền hóa đơn
                    <input type="text" style="width: 300px; height: 30px; margin: 0 auto; display: block;" value="${tongtienhd}" disabled>
                </label>
                <label>Giảm
                    <input type="text"  style="width: 300px; height: 30px; margin: 0 auto; display: block;" value="${gtg}" disabled>
                </label>

</form>
                <form action="/banhangtaiquay/thanhtoan/${id}" method="post">
                <label>Tổng tiền thanh toán
                    <input type="text" name="thanhtien"  style="width: 300px; height: 30px; margin: 0 auto; display: block;" value="${empty tttt ? '0' : tttt}" readonly>
                </label>
                    <input  type="hidden"  name="tienkhachdua" style="width: 300px; height: 30px; margin: 0 auto; display: block;"  value="${tienkhachdua}">
                    <input type="hidden" name="tienthua" style="width: 300px; height: 30px; margin: 0 auto; display: block;" value="${tienthua}">
        <br>
                    <br>
                <button type="submit" class="btn btn" style="background-color: burlywood">Thanh toán tiền </button>
                    <a href="" class="btn" style="background-color: darksalmon">Chuyển khoản</a>
            </form>

    </div>


</div>

</body>
</html>