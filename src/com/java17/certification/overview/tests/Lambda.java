package com.java17.certification.overview.tests;

@FunctionalInterface  //It is optional  
interface Drawable{  
    public void draw(String x, String y);  
}  

public class Lambda {
	public static void main(String[] args) {
		 Drawable d = (var x, var y)-> {  
            System.out.println("Drawing");  
        };  
		//d.draw();
	}
}