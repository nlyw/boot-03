/** 
 * <pre>项目名称:shop-02 
 * 文件名称:Menu.java 
 * 包名:com.jy.model.menu 
 * 创建日期:2020年5月9日上午10:34:48 
 * Copyright (c) 2020, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.chenjh.entity.menu;

import java.io.Serializable;
import java.util.List;

/** 
 * <pre>项目名称：shop-02    
 * 类名称：Menu    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2020年5月9日 上午10:34:48    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2020年5月9日 上午10:34:48    
 * 修改备注：       
 * @version </pre>    
 */
public class Menu implements Serializable {
	
	private int id;
	
	private String text;
	
	private String href;
	
	private boolean checked;
	
	private int pid;
	
	private List<Menu> children;
	
	//添加业务字段
	private int userID;
	
	private String type = "all";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
