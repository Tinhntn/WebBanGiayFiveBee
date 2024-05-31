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
<script>



</script>
<body>

<H2>Bán hàng tại quầy</H2>
<br>
<div class= "container-fluid">
    <%-- Dong 1--%>
    <div class= "row" >
        <form action="/banhangtaiquay/taoHoaDon" method="post" class="col-7">
            <c:if test="${error != null}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    <strong>${error}</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <button type="submit" class="btn btn-outline-info">Tạo hóa đơn</button><br><br>
            <c:forEach var="hd" items="${listMaHoaDon}">
                <button type="button" class="btn " style="background-color: antiquewhite;text-align: center">
                    <div>  ${hd.mahoadon}
                        <a href="/banhangtaiquay/deletehdc/${hd.id}"  class="btn btn-outline-primary"
                           style="font-size: 8px; margin-left: 10px" onclick="return confirm('bạn có chắc chắn muốn hủy hóa đơn này')">X</a>
                    </div>
              </button>
            </c:forEach>
        </form>

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
        <p>danh sach san pham</p>
    </div>
    <div class ="col-5 bg-success">
        <p>col-7</p>
    </div>
</div>
</div>
</div>

</body>
</html>