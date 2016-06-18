package com.xxx.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class UnZip {
	public static void unZip(String zipFileName, String destDir) {
		File unzipFile = new File(zipFileName);
		if (destDir == null || destDir.trim().length() == 0) {
			destDir = unzipFile.getParent();
		}

		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(unzipFile, "GBK");
			Enumeration entries = zipFile.getEntries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				File destFile = new File(destDir, entry.getName());

				if (entry.isDirectory()) {// 是目录，则创建之
					destFile.mkdirs();
				} else {// 是文件
					// 如果指定文件的父目录不存在,则创建之.
					File parent = destFile.getParentFile();
					if (parent != null && !parent.exists()) {
						parent.mkdirs();
					}

					// 执行解压
					InputStream inputStream = zipFile.getInputStream(entry);
					FileOutputStream fileOut = new FileOutputStream(destFile);
					byte[] buf = new byte[1024];
					int readedBytes;
					while ((readedBytes = inputStream.read(buf)) > 0) {
						fileOut.write(buf, 0, readedBytes);
					}
					fileOut.close();
					inputStream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (zipFile != null) {
					zipFile.close();
				}
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		String inFile = "C:\\Users\\zxyuan\\Desktop\\dll.zip";
		String dir = "C:\\Users\\zxyuan\\Desktop\\dll";
		unZip(inFile, dir);
	}
}