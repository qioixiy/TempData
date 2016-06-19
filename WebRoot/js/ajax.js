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
			alert("指纹采集失败");
			img.style.visibility = 'hidden';
		}
	}
}
function callBack_ExportPackage() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		alert(result);
		if (result != "") {
			if (result == "fail") {
				alert("导出失败");
			} else {
				window.open(result);
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
	
	var FileController = "http://localhost:8080/TempData/UploadFile"; // 接收上传文件的后台地址 

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
		ajax_request("http://localhost:8080/TempData/", "importPackage", "&file_path=" + ret);
	};

	xmlHttpRequest.send(form);
	alert("开始上传文件");
}

function test() {
	alert("test");
}