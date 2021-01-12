package com.algoexpert.strings;

public class CaesarCipher {
	
	public static void main(String[] args) {
		System.out.println(caesarCypherEncryptor("abc", 52));
	}

	public static String caesarCypherEncryptor(String str, int key) {
		int start = 'a';
		int end = 'z';
		char[] arr = str.toCharArray();
		char[] res = new char[arr.length];
		key = key % 26;
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			val += key;
			if (val > end)
				val = (start - 1) + (val % end);
			res[i] = (char)val;
		}
		return new String(res);
	}

}
