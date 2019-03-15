package com.cignex.controller;

public class TA {
	public static void main(String[] args) {
		String[] a= {"a","b","sdsds","sdsds"};
		System.out.println("start time  "+System.currentTimeMillis());
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println("end time  "+System.currentTimeMillis());
	}
}
