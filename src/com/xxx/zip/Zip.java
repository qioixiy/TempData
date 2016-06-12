package com.xxx.zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class Zip {
	static final int BUFFER = 8192;

	public Zip() {

	}

	private static void compress(File file, ZipOutputStream out, String basedir) {
		/* �ж���Ŀ¼�����ļ� */
		if (file.isDirectory()) {
			// System.out.println("ѹ����" + basedir + file.getName());
			compressDirectory(file, out, basedir);
		} else {
			// System.out.println("ѹ����" + basedir + file.getName());
			compressFile(file, out, basedir);
		}
	}

	/** ѹ��һ��Ŀ¼ */
	private static void compressDirectory(File dir, ZipOutputStream out, String basedir) {
		if (!dir.exists())
			return;

		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			/* �ݹ� */
			compress(files[i], out, basedir + dir.getName() + "/");
		}
	}

	/** ѹ��һ���ļ� */
	private static void compressFile(File file, ZipOutputStream out, String basedir) {
		if (!file.exists()) {
			return;
		}
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			ZipEntry entry = new ZipEntry(basedir + file.getName());
			out.putNextEntry(entry);
			int count;
			byte data[] = new byte[BUFFER];
			while ((count = bis.read(data, 0, BUFFER)) != -1) {
				out.write(data, 0, count);
			}
			bis.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void zip(String srcPathName, String zipFileName) {
		File file = new File(srcPathName);
		File zipFile = new File(zipFileName);
		if (!file.exists())
			throw new RuntimeException(srcPathName + "�����ڣ�");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
			CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream, new CRC32());
			ZipOutputStream out = new ZipOutputStream(cos);
			out.setEncoding(System.getProperty("sun.jnu.encoding"));// �����ļ������뷽ʽ
			String basedir = "";
			compress(file, out, basedir);
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		Zip.zip("C:\\Users\\zxyuan\\Desktop\\dll", "C:\\Users\\zxyuan\\Desktop\\dll.zip");
	}
}