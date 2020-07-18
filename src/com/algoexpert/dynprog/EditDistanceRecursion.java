package com.algoexpert.dynprog;

public class EditDistanceRecursion {
	
	public static void main(String[] args) {
		
	}
	
	private static void findEditDistance(char[] s1, int index1, char[] s2, int index2) {
		
		
		if (s1[index1] == s2[index2]) {
			findEditDistance(s1, ++index1, s2, ++index2);
		} else {
			//delete
			findEditDistance(s1, ++index1, s2, index2);
			
			//replace
			s1[index1] = s2[index2];
			findEditDistance(s1, ++index1, s2, ++index2);
			
			//insert
			char[] s1new = new char[s1.length + 1];
			s1new[index1] = s2[index2];
			for(int i = index1; i < s1.length; i++) {
				s1new[i] = s1[i];
			}
			findEditDistance(s1, index1, s2, ++index2);
		}
	}

}
