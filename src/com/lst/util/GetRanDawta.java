package com.lst.util;

import java.util.Random;

public class GetRanDawta {
	
	
	
	public static String getRanName(int len){

 
		String base = "abcdefghijklmnopqrstuvwxyz";     
		Random random = new Random();        
		StringBuffer sb = new StringBuffer();     
		for (int i = 0; i < len; i++) {     
			int number = random.nextInt(base.length());     
			sb.append(base.charAt(number));     
		}     
		return sb.toString();     
	} 



	public static double getDecimal(int forlen,int belen){
		
		String base = "0123456789";     
		Random random = new Random();        
		StringBuffer sb = new StringBuffer();     
		for (int i = 0; i < forlen; i++) {     
			int number = random.nextInt(base.length());     
			sb.append(base.charAt(number));     
		}
		if(belen>0)
			sb.append('.');
		for (int i = 0; i < belen; i++) {
			
			int number = random.nextInt(base.length());     
			sb.append(base.charAt(number));     
		}
		return Double.parseDouble(sb.toString());   
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		//做一件东西有核心技巧和辅助技巧
		System.out.print(getRanName(5));
		
		

	}

}
