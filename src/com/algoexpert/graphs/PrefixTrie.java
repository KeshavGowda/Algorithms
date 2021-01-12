package com.algoexpert.graphs;

import java.util.HashMap;
import java.util.Map;

public class PrefixTrie {
	
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	}
	
	TrieNode root = new TrieNode();
	char endSymbol = '*';
	
	public void populatePrefixTrieFrom(String str) {
		char[] arr = str.toCharArray();
		TrieNode node = root;
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (node.children.containsKey(ch)) {
				node = node.children.get(ch);
			} else {
				node.children.put(ch, new TrieNode());
				node = node.children.get(ch);
			}
		}
		node.children.put(endSymbol, null);
	}
	
	public boolean contains(String str) {
		char[] arr = str.toCharArray();
		TrieNode node = root;
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (node.children.containsKey(ch)) {
				node = node.children.get(ch);
			} 
			if (i == arr.length - 1 && node.children.containsKey(endSymbol)) {
				return true;
			}
		}
		return false;
	}

}
