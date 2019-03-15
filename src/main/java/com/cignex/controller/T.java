package com.cignex.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class T {

	public static void main(String[] args) {
		List<String> s=new ArrayList<String>();
		s.add("pinal");
		s.add("sdsd");
		s.add("narayan");
		s.add("dad");
		
		System.out.println("start time  "+System.currentTimeMillis());
		s.forEach(i->System.out.println(s));
		System.out.println("end time  "+System.currentTimeMillis());
	}
}
