package com.fastcampus.ch2;

public class PrivaateMethodCall {
	public static void main(String[] args) throws Exception {
		Hello hello = new Hello();
//		hello.main();
		
		
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
	}
}
