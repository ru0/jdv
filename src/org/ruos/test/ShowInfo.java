package org.ruos.test;

import java.io.Serializable;

public class ShowInfo implements Serializable{
	
	private String userName;

	ShowInfo(){
		System.out.println("constructor fun");
	}
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void showName(){
		System.out.println(this.userName);
	}
}
