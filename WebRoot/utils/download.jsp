<%@page language="java" contentType="application/x-msdownload"
	pageEncoding="UTF-8"
	import="java.io.File"
	import="java.net.URLEncoder"
	import="java.io.FileInputStream"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	String request_filedownload = request.getParameter("filedownload");
	System.out.println("request_filedownload:" + request_filedownload);
	request_filedownload = new String(request_filedownload.getBytes("ISO-8859-1"), "UTF-8");
	
	System.out.println("request_filedownload:" + request_filedownload);
	
	//关于文件下载时采用文件流输出的方式处理： 
	//加上response.reset()，并且所有的％>后面不要换行，包括最后一个； 

	response.reset();//可以加也可以不加 
	response.setContentType("application/x-download");

	String filedownload = request_filedownload;
	String RealPath = application.getRealPath(filedownload); //获取的物理路径 
	System.out.println("request_RealPath:" + RealPath);

	String filedisplay = "给用户提供的下载文件名";
	
	java.io.OutputStream outp = null;
	java.io.FileInputStream in = null;
	try {
		File tempFile =new File(RealPath.trim()); 
		filedisplay = tempFile.getName();
		filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);

		outp = response.getOutputStream();
		in = new FileInputStream(tempFile);

		byte[] b = new byte[1024];
		int i = 0;

		while ((i = in.read(b)) > 0) {
			outp.write(b, 0, i);
		}
		//   
		outp.flush();
		//要加以下两句话，否则会报错 
		//java.lang.IllegalStateException: getOutputStream() has already been called for //this response   
		out.clear();
		out = pageContext.pushBody();
	} catch (Exception e) {
		System.out.println("Error!");
		e.printStackTrace();
	} finally {
		if (in != null) {
			in.close();
			in = null;
		}
		//这里不能关闭   
		//if(outp != null) 
		//{ 
		//outp.close(); 
		//outp = null; 
		//} 
	}
%>