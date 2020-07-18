package com.keshav.practice;

public class FileNameMatcher {
	
	public static boolean match(String a, String b) {
		return b.matches(a);
	}
	
	public static void main(String[] args) {
		boolean isMatching = match("[a-zA-Z0-9\\.]*WS.WMS.INVSYNC.ERROR.RPT.L[a-zA-Z0-9\\.]*", "DKMO.WS.WMS.INVSYNC.ERROR.RPT.L809");
		System.out.println(isMatching);
	}

}
