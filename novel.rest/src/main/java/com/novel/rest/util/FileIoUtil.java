package com.novel.rest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * 
 * 进行文件的输入输出操作
 * 
 * @author liuguanghui
 *
 */
public class FileIoUtil {

	/**
	 * 得到新文件名
	 * 
	 * @param oldFileName
	 * @return
	 */
	public static String getFileNewName(String oldFileName) {
		long millis = System.currentTimeMillis();
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		String newName = str + oldFileName.substring(oldFileName.lastIndexOf("."));
		return newName;
	}

	
	
	
	/**
	 * 在上传文件的同时得到文件字符的大小
	 * 
	 * @param is
	 *            文件输入流
	 * @param savePath
	 *            目标文件路径
	 * @param charSet
	 *            文件编码格式
	 * @return
	 */
	public static boolean uploadFile(String is, String savePath,String bookName, String charSet) {
		OutputStreamWriter writer = null;
		try {
			new File(savePath).mkdirs();
			if (charSet == null || "".equals(charSet)) {
				writer = new OutputStreamWriter(new FileOutputStream(savePath+"/"+bookName));
			} else {
				writer = new OutputStreamWriter(new FileOutputStream(savePath+"/"+bookName), charSet);
			}
				writer.write(is );
				writer.flush();
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				if(writer != null){
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return false;
		}  
	
	
	/**
	 * 在上传文件的同时得到文件字符的大小
	 * 
	 * @param is
	 *            文件输入流
	 * @param outpath
	 *            目标文件路径
	 * @param charSet
	 *            文件编码格式
	 * @return
	 */
	public static long uploadFile(InputStream is, String outpath, String charSet) {
		InputStreamReader reader = null;
		OutputStreamWriter writer = null;
		try {

			char[] buf = new char[1024];
			if (charSet == null || "".equals(charSet)) {
				reader = new InputStreamReader(is);
				writer = new OutputStreamWriter(new FileOutputStream(outpath));
			} else {
				reader = new InputStreamReader(is, charSet);
				writer = new OutputStreamWriter(new FileOutputStream(outpath), charSet);
			}

			long size = 0;
			int readCount = 0;
			while (-1 != (readCount = reader.read(buf))) {
				size += readCount;
				writer.write(buf, 0, readCount);
			}
			return size;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return 0L;
	}
	
	
	public static void fileRemove(String filePath ) {
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
		
	}

	public static String readFile(String string ,String codingSet) {
		InputStreamReader reader = null;
		try {
			
			char[] buf = new char[1024];
			if (codingSet == null || "".equals(codingSet)) {
				reader = new InputStreamReader(new FileInputStream(string));			
				} else {
				reader = new InputStreamReader(new FileInputStream(string) , codingSet);
			}
			int readCount = 0;
			String str = "";
			while((readCount =reader.read(buf))>0){
				str += new String(buf, 0, readCount);
			}
			
			str = str.replace("  " ,"&nbsp;&nbsp;").replace("\n" ,"<br />");
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
