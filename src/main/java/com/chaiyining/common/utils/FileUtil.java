package com.chaiyining.common.utils;

public class FileUtil {

	
	//给定一个文件名，返回该文件名的扩展名
	public static String getExtendName(String fileName){
		String substring = fileName.substring(fileName.lastIndexOf("."),fileName.length());
		
		
		return substring;
			
		}
	
	
	public static void main(String[] args) {
		
		System.out.println(FileUtil.getExtendName("ROOT.war"));
	}
}
