/**
 * 2015-6-23
 *WebSpiderDemo1
 *Main.java
 */    
package com.main;    
import java.util.ArrayList;

import com.object.GetContent;
import com.spider.Spider;

/**
 * @author zy
 *
 */
public class Main {

	/**2015-6-23
	 *main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**  
		 * 2015-6-23  
		 * @author zy  
		 */
		//定义即将访问的链接
		String url="http://www.guokr.com/ask/hottest/";
		//访问链接并获取页面内容
		String result=Spider.SendGet(url);
		//用正则匹配图片的src内容
		ArrayList<GetContent> imgSrc=Spider.RegexString(result);
		//打印结果
		System.out.println(imgSrc);
	}
	/**     
	 * @author zy  
	 * @version   
	 * 2015-6-23 下午2:14:40   
	 */

}
