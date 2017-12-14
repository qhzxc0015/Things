<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DWR demo</title>
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath()%>/dwr/util.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/Demo.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath()%>/js/hello.js"></script>
</head>
<body style="text-align:center ">
<input type="text" name="name" value="gueter">
  <br><br>
  <input type="button" onclick="hello();" value="提交">
  <br><br>
  <span id="result" style="background: #eeffdd; padding: 10px"></span>

</body>
</html>