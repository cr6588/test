<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
    <form action="j_spring_security_check" method="POST">
        <table>
            <tbody>
                <tr>
                    <td>用户:</td>
                    <td><input type="text" name="'j_username'"></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input type="password" name="'j_password'"></td>
                </tr>
                <tr>
                    <td><input name="reset" type="reset"></td>
                    <td><input name="submit" type="submit"></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>