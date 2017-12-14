function hello(){
	var name = dwr.util.getValue("name");
	  Demo.hello(name,function(data) {
	    dwr.util.setValue("result", data);
	  });
}	  
	  