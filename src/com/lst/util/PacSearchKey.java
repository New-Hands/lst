package com.lst.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PacSearchKey {
	
	
	public static String [] packey(String key){
		
		Pattern pattern=Pattern.compile("\\s+");
		
			Matcher m=pattern.matcher(key);
			String res=m.replaceAll("#");
			String []arr=res.split("#");
			
			if(arr[0].equals("")){
				String []Arr=new String[arr.length-1];
				
				for(int i=0;i<arr.length-1;i++)
				{
					Arr[i]=arr[i+1];
				}
				
				return Arr;
			}
			
		return arr;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String []list=PacSearchKey.packey("   dff   jidf   llk  ");
		int i=1; 
		for(String a:list){
			
			System.out.println(i+":"+a+"k");
			i++;
		}

	}

}
