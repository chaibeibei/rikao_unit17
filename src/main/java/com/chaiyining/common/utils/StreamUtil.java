package com.chaiyining.common.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class StreamUtil {

	
	//批量关闭流，参数能传入无限个
	public static void closeAll(Closeable ... io){
	
		for (Closeable closeable : io) {
			
			if(closeable !=null) {
				try {
					closeable.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("已关闭");
		}
	
	
	//传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	public static String readTextFile(File file){
		
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true),"UTF-8");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 String result = "";
	        try{
	            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
	            String s = null;
	            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
	                result = result + "\n" +s;
	            }
	            StreamUtil.closeAll(br); 
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return result;
	    }
		
		
	//传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。
	public static String readFile(File txtFile){
		String readTextFile = StreamUtil.readTextFile(txtFile);
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(txtFile);
			StreamUtil.closeAll(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return readTextFile;
		
		}
	

	public static void main(String[] args) {
		
		String readTextFile = StreamUtil.readTextFile(new File("C:\\Users\\ASUS\\Desktop\\qwe.txt"));
		System.out.println(readTextFile);
		
		 
	}
}
