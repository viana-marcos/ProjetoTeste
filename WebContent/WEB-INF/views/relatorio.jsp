<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatório de Processamento</title>
</head>
<body>


<div align="center">

  <h1>Relatório de Processamento</h1>

  <table border="5">
        <tr>
            <th style="padding-right:20px">Data </th>
            <th style="padding-right:20px">Loja </th>
            <th style="padding-right:20px">PDV </th>
            <th style="padding-right:20px"> Status </th>
        </tr>
        
        <c:forEach items="${processamentos}" var="processamento">
        <tr>
            <td>${processamento.data}</td>
            <td>${processamento.loja}</td>
            <td>${processamento.pdv}</td>
            <td>${processamento.status}</td>
        </tr>        
      
        </c:forEach>
    </table>
  
</div>   

</body>
</html>