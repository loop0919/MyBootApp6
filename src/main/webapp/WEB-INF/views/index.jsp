<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Index Page</h1>
        <p>this is a sample page for Spring Boot!</p>
        <p>${msg}</p>
        <form method="post" action="/post">
            <table>
                <tr><td>ID:</td><td><input type="text" name="id" /></td></tr>
                <tr><td>タイトル:</td><td><input type="text" name="title" /></td></tr>
                <tr><td>著者:</td><td><input type="text" name="writer" /></td></tr>
                <tr><td>出版社:</td><td><input type="text" name="publisher" /></td></tr>
                <tr><td>価格:</td><td><input type="text" name="price" /></td></tr>
                <tr><td></td><td><input type="submit" /></td></tr>
            </table>
        </form>
    </body>
</html>
