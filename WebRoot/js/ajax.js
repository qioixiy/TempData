var xmlHttpRequest;

// 创建xmlhttp请求对象
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) { // Mozilla
		xmlHttpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE
		try {
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				;
			}
		}
	}
}

// default
function callBack_default() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		result = xmlHttpRequest.responseText;

		if (result == 1) {
			alert("success");
		} else {
			alert("failed");
		}
	}
}

function callBack_captureFrame() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result != 'filed') {
			var src = result;
			
			img = document.getElementById('captureBmp');
			img.src = "";
			img.style.visibility = 'visible';
			img.src = src;
		} else {
			alert("指纹采集失败,请检查采集设备连接正确");
			img.style.visibility = 'hidden';
		}
	}
}
function callBack_ExportPackage() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		alert(result);
		var str = decodeURIComponent(result);
		alert(str);
		if (result != "") {
			if (result == "fail") {
				alert("导出失败");
			} else {
				window.open(encodeURIComponent(str));
			}
		} else {
			alert("导出失败");
		}
	}
}

function callBack_ImportPackage() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result == "success") {
			alert("导入成功");
			window.location = "http://localhost:8080/FPC/files/MyCustomerDataView.jsp";
		} else {
			alert("导入失败,err code " +result);
		}
	}
}

function callBack_saveRcData() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result != "") {
			alert("保存成功");;
		} else {
			alert("保存失败");
		}
	}
}

function callBack_login() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result == "success") {
			window.location = "http://localhost:8080/FPC/index.jsp";
		} else if (result == "fail_username") {
			alert("没有用户名");
		} else if (result == "fail_password") {
			alert("密码不对");
		} else {
			alert("登陆失败");
		}
	}
}
function callBack_add_user() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result == "success") {
			window.location = "http://localhost:8080/FPC/files/MyListAccount.jsp";
		} else if (result == "fail_username") {
			alert("用户名已经存在");
		} else if (result == "fail_uid") {
			alert("用户Id已经存在");
		} else {
			alert("失败");
		}
	}
}
function callBack_update_userinfo() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result == "success") {
			alert("修改成功");
			window.location = "http://localhost:8080/FPC/files/MyListAccount.jsp";
		} else if (result == "fail_username") {
			alert("用户名已经存在");
		} else if (result == "fail_uid") {
			alert("用户Id已经存在");
		} else {
			alert("失败");
		}
	}
}

function callBack_del_user() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result == "success") {
			alert("删除成功");
			window.location = "http://localhost:8080/FPC/files/MyListAccount.jsp";
		} else {
			alert("删除失败");
		}
	}
}

function callBack_add_customer() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result == "success") {
			alert("添加成功");
			window.location = "http://localhost:8080/FPC/files/MyCustomerInfo.jsp";
		} else {
			alert("添加失败");
		}
	}
}
function callBack_del_customer() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result == "success") {
			alert("删除成功");
			window.location = "http://localhost:8080/FPC/files/MyCustomerInfo.jsp";
		} else {
			alert("删除失败");
		}
	}
}
//提交ajax请求
function ajax_request(server, param1, param2) {
	//alert("param1:" + param1 + ",param2:" + param2);
	
	createXMLHttpRequest();

	var url = server+ "/ajax";
	
	var paramer = "subFunc=" + param1 + param2;

	var method = null;
	var use_get = true;
	if (use_get) {
		url = url + "?" + paramer + "&now=" + new Date().getTime();
		paramer = null;
		method = "GET";
	} else {
		method = "POST";
	}
	xmlHttpRequest.open(method, url, true);
	xmlHttpRequest.onreadystatechange = callBack_default;
	if (param1 === "captureFrame") {
		xmlHttpRequest.onreadystatechange = callBack_captureFrame;
	} else if (param1 == "exportPackage") {
		xmlHttpRequest.onreadystatechange = callBack_ExportPackage;
	} else if (param1 == "importPackage") {
		xmlHttpRequest.onreadystatechange = callBack_ImportPackage;
	} else if (param1 == "saveRcData") {
		xmlHttpRequest.onreadystatechange = callBack_saveRcData;
	} else if (param1 == "login") {
		xmlHttpRequest.onreadystatechange = callBack_login;
	} else if (param1 == "add_user"){
		xmlHttpRequest.onreadystatechange = callBack_add_user;
	} else if (param1 == "update_userinfo"){
		xmlHttpRequest.onreadystatechange = callBack_update_userinfo;
	} else if (param1 == "del_user"){
		xmlHttpRequest.onreadystatechange = callBack_del_user;
	} else if (param1== "add_customer"){
		xmlHttpRequest.onreadystatechange = callBack_add_customer;
	} else if (param1 == "del_customer"){
		xmlHttpRequest.onreadystatechange = callBack_del_customer;
	} else {
		alert("不支持子功能");
		return;
	}
	xmlHttpRequest.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");

	xmlHttpRequest.send(paramer);// 发送请求;
	//alert(url);
	
	if (param1 == "exportPackage") {
		alert("开始导出数据");
	}
}

function callBack_FinInterSelectChange() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		//alert(result);
		var urls = result.split("|");
		//alert(urls);
		if (result != "") {
			document.getElementById("FinBmpL").src = urls[0];
			document.getElementById("FinBmpR").src = urls[1];
			document.getElementById("FinBmpC").src = urls[2];
		} else {
			alert("失败");
		}
	}
}

function url_request(url) {
	//alert(url);
	
	createXMLHttpRequest();

	var method = null;
	var use_get = true;
	if (use_get) {
		paramer = null;
		method = "GET";
	} else {
		method = "POST";
	}
	xmlHttpRequest.open(method, url, true);
	xmlHttpRequest.onreadystatechange = callBack_FinInterSelectChange;
	xmlHttpRequest.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");

	xmlHttpRequest.send(paramer);// 发送请求;
	//alert(url);
}

function UpladFile() {

	var fileObj = document.getElementById("file").files[0]; // 获取文件对象
	
	if (fileObj == undefined){
		alert("请选择上传的文件");
		return;
	}
	
	var FileController = "http://localhost:8080/FPC/UploadFile"; // 接收上传文件的后台地址 

	// FormData 对象
	var form = new FormData();
	form.append("author", "author"); // 可以增加表单数据
	form.append("file", fileObj); // 文件对象

	// XMLHttpRequest 对象
	createXMLHttpRequest();
	xmlHttpRequest.open("post", FileController, true);

	xmlHttpRequest.onload = function() {
		alert("上传文件完成");
		//alert(window.location);
		alert(xmlHttpRequest.responseText + ",upload success, need import");
		var ret = xmlHttpRequest.responseText;
		ajax_request("http://localhost:8080/FPC/", "importPackage", "&file_path=" + ret);
	};

	xmlHttpRequest.send(form);
	alert("开始上传文件");
}

function test() {
	alert("test");
}