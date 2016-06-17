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
		if (result != "") {
			window.open(result);
		} else {
			alert("导出失败");
		}
	}
}

function callBack_ImportPackage() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result != "") {
			window.open(result);
		} else {
			alert("导入失败");
		}
	}
}

function callBack_saveRcData() {
	if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var result = xmlHttpRequest.responseText;
		if (result != "") {
			;
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
		url = url + "?" + paramer;
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
}

function test() {
	alert("test");
}