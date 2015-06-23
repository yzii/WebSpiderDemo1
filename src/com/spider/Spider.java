/**
 * 2015-6-23
 *WebSpiderDemo1
 *Spider.java
 */    
package com.spider;    

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.object.GetContent;
    
/**
 * @author zy
 *
 */
public class Spider {
	/**     
	 * @author zy  
	 * @version   
	 * 2015-6-23 下午3:13:21   
	 */
	 public static String SendGet(String url) {
		 // 定义一个字符串用来存储网页内容  
		 String result = "";  
		 // 定义一个缓冲字符输入流  
		 BufferedReader in = null;  
		 try {   
			 	// 将string转成url对象   
			 	URL realUrl = new URL(url);   
			 	// 初始化一个链接到那个url的连接  
			 	URLConnection connection = realUrl.openConnection();   
			 	// 开始实际的连接   
			 	connection.connect();
			 	// 初始化 BufferedReader输入流来读取URL的响应   
			 	in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			 	// 用来临时存储抓取到的每一行的数据  
			 	String line;   
			 	while ((line = in.readLine()) != null) {    
			 		// 遍历抓取到的每一行并将其存储到result里面    
			 		result += line;   
				}
			 } catch (Exception e) {   
					System.out.println("发送GET请求出现异常！" + e);   
					e.printStackTrace();  
			   }  
		 	  // 使用finally来关闭输入流  
		 	 finally {   
		 			try {    
		 					if (in != null) {     
		 						in.close();
		 					}
		 				} catch (Exception e2) {    
		 					e2.printStackTrace();
		 				}
		 			}
		 return result;
	 		}
	 public static ArrayList<GetContent>  RegexString(String getcontent) {  
		 // 预定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		 ArrayList<GetContent> results=new ArrayList<GetContent>();
		 // 匹配标题 
		 Pattern pattern = Pattern.compile("<h2><a target.+?>(.+?)<");  
		 Matcher matcher = pattern.matcher(getcontent); 
		 // 用来匹配url，也就是问题的链接  
		 Pattern urlPattern = Pattern.compile("<h2><a target.+?href=\"(.+?)\"");  
		 Matcher urlMatcher = urlPattern.matcher(getcontent);
		 //标题和链接均要匹配
		 boolean isFind=matcher.find()&&urlMatcher.find();

		 //使用循环将句子中所有的kelvin找出并替换再将内容夹道sb中
		 while(isFind) {
			 //创建一个实例
			 GetContent getContent=new GetContent();
			 getContent.title=matcher.group(1);
			 getContent.contentUrl="http://www.guokr.com"+urlMatcher.group(1);
			 //添加成功匹配的结果
			 results.add(getContent);
			 //继续查找下一个匹配对象
			 isFind=matcher.find()&&urlMatcher.find(); 
		}  
		 return results;
	 }	
}
