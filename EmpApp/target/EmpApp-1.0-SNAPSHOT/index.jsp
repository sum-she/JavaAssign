<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
<h1>Employee</h1>

<%--servlet /employee--%>
<%--implements print by id--%>
<form action="${pageContext.request.contextPath}/employee?ac"  method="post" name="searchEmp">
    <table>
        <tr><td>Id: <label><input name="Id" type="text"/></label></td></tr>
        <tr><td>Name: <label>
            <input name="Name" type="text"/>
        </label></td></tr>
        <tr><td>Age: <label>
            <input name="Age" type="text"/>
        </label></td></tr>
        <tr><td>Work place: <label>
            <select name="Work_Place" style="width:150px">
                <option>Home</option>
                <option>Outside</option>
            </select>
        </label></td></tr>
        <tr><td>Daily Income: <label>
        <input name="Daily_Income" type="text"/>
    </label></td></tr>
    </table>
    <input type="submit" value="enter"/>
</form>

<h1>Add New Employee</h1>
<form action="${pageContext.request.contextPath}/SaveServlet" method="post">
    <table>
        <tr><td>Id: <label><input name="Id" type="text"/></label></td></tr>
                <tr><td>Name: <label><input name="Name" type="text"/></label></td></tr>
                <tr><td>Age: <label><input name="Age" type="text"/></label></td></tr>
                <tr><td>Work place: <label>
                    <select name="Work_Place" style="width:150px">
                        <option>Home</option>
                        <option>Outside</option>
                    </select>
                </label></td></tr>
                <tr><td>Daily Income: <label><input name="Daily_Income" type="text"/></label></td></tr>
        <tr><td colspan="2">
    <input type="Submit" value="Enter" /></td></tr>
    </table>
</form>
<br/>

<%--<a href="${pageContext.request.contextPath}/employee">view employees</a>--%>
<a href="${pageContext.request.contextPath}/ViewServlet">view employees</a>
<%--<a href="${pageContext.request.contextPath}/DeleteServlet"--%>
</body>
</html>