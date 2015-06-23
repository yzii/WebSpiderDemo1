/**
 * 2015-6-23
 *WebSpiderDemo1
 *GetContent.java
 */    
package com.object;    

import java.util.ArrayList;
    
/**
 * @author zy
 *
 */
public class GetContent {
	/**     
	 * @author zy  
	 * @version   
	 * 2015-6-23 下午3:20:45   
	 */
	 public String title;// 问题
	 public String contentUrl;// 网页链接 
	 public ArrayList<String> content;// 存储所有回答的数组
	 // 构造方法初始化数据
	 public GetContent() {
		 title = "";  
		 contentUrl = "";  
		 content = new ArrayList<String>();
	}
	 @Override 
	 public String toString() {
		 return "title：" + title + "\n url：" + contentUrl + "\n content：" + content + "\n";
	}
}
