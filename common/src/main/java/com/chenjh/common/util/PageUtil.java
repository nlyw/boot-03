/** 
 * <pre>项目名称:common 
 * 文件名称:PageUtil.java 
 * 包名:com.jy.common.util 
 * 创建日期:2020年6月17日下午5:56:16 
 * Copyright (c) 2020, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.chenjh.common.util;

/** 
 * <pre>项目名称：common    
 * 类名称：PageUtil    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2020年6月17日 下午5:56:16    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2020年6月17日 下午5:56:16    
 * 修改备注：       
 * @version </pre>    
 */
public class PageUtil {
	
	//页码
	private int page = 10;
	
	//每页条数
	private int rows = 50;

	private int limit = 50;

	//总条数
	private int total;
	
	//总页数
	private int pages;
	
	//开始位置
	private int start;
	
	//结束位置
	private int end;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void startPage() {
		//计算
		pages = pages % rows == 0 ? pages / rows : pages / rows + 1;
		end = page * rows;
		start = (page - 1) * rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
