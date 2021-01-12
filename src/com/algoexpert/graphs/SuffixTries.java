package com.algoexpert.graphs;

import java.util.HashMap;
import java.util.Map;

public class SuffixTries {

	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	}

	static class SuffixTrie {
		TrieNode root = new TrieNode();
		char endSymbol = '*';

		public SuffixTrie(String str) {
			populateSuffixTrieFrom(str);
		}

		public void populateSuffixTrieFrom(String str) {
			// Write your code here.
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				TrieNode node = root;
				char c = arr[i];
				if ( ! node.children.containsKey(c)) {
					node.children.put(c, new TrieNode());
					node = node.children.get(c);
				} else {
					node = node.children.get(c);
				}
				for (int j = i + 1; j < arr.length; j++) {
					char n = arr[j];
					if ( ! node.children.containsKey(n)) {
						node.children.put(n, new TrieNode());
						node = node.children.get(n);
					} else {
						node = node.children.get(n);
					}
				}
				node.children.put(endSymbol, null);
			}
		}

		public boolean contains(String str) {
			// Write your code here.
			char[] arr = str.toCharArray();
			TrieNode node = root;
			for (int i = 0; i < arr.length; i++) {
				char c = arr[i];
				if (node.children.containsKey(c)) {
					node = node.children.get(c);
				} 
				if (i == arr.length - 1 && node.children.containsKey(endSymbol)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		SuffixTrie trie = new SuffixTrie("ttttttttt");
		System.out.println(trie.contains("vvv"));
	}

}
