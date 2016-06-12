package com.xxx.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {

	public static void unzip(String zipFilePath, String destDir) {
		System.setProperty("sun.zip.encoding", System.getProperty("sun.jnu.encoding")); // ��ֹ�ļ�����������ʱ����
		// System.out.println(System.getProperty("sun.zip.encoding")); //ZIP���뷽ʽ
		// System.out.println(System.getProperty("sun.jnu.encoding"));
		// //��ǰ�ļ����뷽ʽ
		// System.out.println(System.getProperty("file.encoding"));
		// //����ǵ�ǰ�ļ����ݱ��뷽ʽ

		File dir = new File(destDir);
		// create output directory if it doesn't exist
		if (!dir.exists())
			dir.mkdirs();
		FileInputStream fis;
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(zipFilePath);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(destDir + File.separator + fileName);
				// System.out.println("Unzipping to " +
				// newFile.getAbsolutePath());
				// create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				// close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			// close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String zipFilePath = "C:\\Users\\zxyuan\\Desktop\\dll.zip";

		String destDir = "C:\\Users\\zxyuan\\Desktop\\dll_zip";

		UnZip.unzip(zipFilePath, destDir);
	}

}