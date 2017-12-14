<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基于Hadoop的分布式搜索</title>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript">
function cl(){
	var xmlHttp;
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//alert(xmlHttp);
	//xmlHttp.open("post", "Ajax");
	xmlHttp.open("get", "Ajax?keywords=123");
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			alert(xmlHttp.responseText);
		}
	};
	//xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencodee");
	//xmlHttp.send("keywords="+keywords+"&page="+page);
	xmlHttp.send(null);
}
</script>
<style type="text/css">
 .pagination ul{list-style:none}
 .pagination li{float:left;width:30px;}
</style>
</head>
<body>
  <div>
	<em>基于Hadoop的分布式搜索系统:</em>
	<input id="keywords" name="term"  type="text" size="50" size="50" style="width:500px;height:30px;font-size:22px;"> 
	<input type="submit" value="搜索" style="width:100px;height:35px;font-size:22px;color:green;">
   </div>
   <button id="click1" onclick="cl();">1</button>
   
   <form action="Ajax" method="post">
   <div class="pagination">
   </div>
	</form>
</body>
</html>