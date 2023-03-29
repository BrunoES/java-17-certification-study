package com.topics.topic1.javatime;

import java.time.LocalTime;

public class LocalTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime timeNow = LocalTime.now();
		System.out.println(timeNow);
		// of
		System.out.println(LocalTime.of(15, 10, 5, 1));
	}

}
