package com.topics.wrapperclasses;

public class CustomWrapper {  
	private int i;  
	
	CustomWrapper(){}  
	
	CustomWrapper(int i){  
		this.i=i;  
	}  
	
	public int getValue(){  
		return i;  
	}  
	
	public void setValue(int i){  
		this.i=i;  
	}  
	
	@Override  
	public String toString() {  
	  return Integer.toString(i);  
	}  
}  