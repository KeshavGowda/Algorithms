package com.algoexpert.dynprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {
	
	static class ChainInfo {
		String nextStr;
		int chainLength;
		public ChainInfo() {
			nextStr = "";
			chainLength = 1;
		}
	}

	public static void main(String[] args) {
		String[] arr = new String[] {"abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"};
		List<String> strings = Arrays.asList(arr);
		System.out.println(longestStringChain(strings));
	}

	public static List<String> longestStringChain(List<String> strings) {
		List<String> soln = new ArrayList<>();
		Map<String, ChainInfo> stringMap = new HashMap<>(); 
		for (String s : strings) {
			ChainInfo c = new ChainInfo();
			stringMap.put(s, c);
		}
		strings.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String s : strings) {
			List<String> chains  = findChains(s);
			for (String chain : chains) {
				if (stringMap.containsKey(chain)) {
					ChainInfo currentString = stringMap.get(s);
					ChainInfo chainString = stringMap.get(chain);
					if (chainString.nextStr.isEmpty()) {
						currentString.nextStr = chain;
						currentString.chainLength = chainString.chainLength + 1;
					} else if (chainString.chainLength + 1 > currentString.chainLength) {
						currentString.nextStr = chain;
						currentString.chainLength = chainString.chainLength + 1;
					}
				}
			}
		}
		//find longest chain length from stringMap an display result
		return soln ;
	}
	
	private static List<String> findChains(String string) {
		List<String> chains = new ArrayList<>();
		StringBuilder sb = new StringBuilder(string);
		for (int i = 0; i < string.length(); i++) {
			sb.replace(i, i + 1, "");
			chains.add(sb.toString());
			sb = new StringBuilder(string);
		}
		return chains;
	}

}
