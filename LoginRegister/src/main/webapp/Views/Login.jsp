<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-4">Đăng nhập</h2>

        <c:if test="${error != null}">
            <div class="alert alert-danger">
                ${error}
            </div>
        </c:if>

        <form action="login" method="post">
            <div class="form-group">
                <label for="username">Tài khoản:</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fa fa-user"></i></span>
                    </div>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Tài khoản" required>
                </div>
            </div>

            <div class="form-group">
                <label for="password">Mật khẩu:</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fa fa-lock"></i></span>
                    </div>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Mật khẩu" required>
                </div>
            </div>

            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="remember" name="remember">
                <label class="form-check-label" for="remember">Ghi nhớ tôi</label>
            </div>

            <button type="submit" class="btn btn-primary mt-3">Đăng nhập</button>
        </form>
    </div>

    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
