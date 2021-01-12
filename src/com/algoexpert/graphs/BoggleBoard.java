package com.algoexpert.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BoggleBoard {

	public static List<String> boggleBoard(char[][] board, String[] words) {
		Set<String> soln = new HashSet<>();
		PrefixTrie pt = new PrefixTrie();
		for (String s : words) {
			pt.populatePrefixTrieFrom(s);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean[][] visited = new boolean[board.length][board[0].length];
				Set<String> present = findWords(board, pt, i, j, "", visited);
				soln.addAll(present);
			}
		}
		return new ArrayList<String>(soln);
	}

	private static Set<String> findWords(char[][] board, PrefixTrie pt, int x, int y, String runningCurrent,
			boolean[][] visited) {
		Set<String> present = new HashSet<>();
		if (visited[x][y] != true) {
			String current = Character.toString(board[x][y]);
			runningCurrent += current;
			if (pt.contains(current)) {
				present.add(current);
			}
			if (pt.contains(runningCurrent)) {
				present.add(runningCurrent);
			}
			if (pt.containsPrefix(runningCurrent)) {
				visited[x][y] = true;
				Set<String> found = new HashSet<>();
				if (x + 1 < board.length)
					found.addAll(findWords(board, pt, x + 1, y, runningCurrent, visited));
				if (y + 1 < board[0].length && x + 1 < board.length)
					found.addAll(findWords(board, pt, x + 1, y + 1, runningCurrent, visited));
				if (y + 1 < board[0].length)
					found.addAll(findWords(board, pt, x, y + 1, runningCurrent, visited));
				if (y + 1 < board[0].length && x - 1 >= 0)
					found.addAll(findWords(board, pt, x - 1, y + 1, runningCurrent, visited));
				if (x - 1 >= 0)
					found.addAll(findWords(board, pt, x - 1, y, runningCurrent, visited));
				if (y - 1 >= 0 && x - 1 >= 0)
					found.addAll(findWords(board, pt, x - 1, y - 1, runningCurrent, visited));
				if (y - 1 >= 0)
					found.addAll(findWords(board, pt, x, y - 1, runningCurrent, visited));
				if (y - 1 >= 0 && x + 1 < board.length)
					found.addAll(findWords(board, pt, x + 1, y - 1, runningCurrent, visited));
				if (found.isEmpty())
					visited[x][y] = false;
				else
					present.addAll(found);
			}
		}

		return present;
	}

	static class PrefixTrie {

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

		public boolean containsPrefix(String str) {
			char[] arr = str.toCharArray();
			TrieNode node = root;
			for (int i = 0; i < arr.length; i++) {
				char ch = arr[i];
				if (node.children.containsKey(ch)) {
					node = node.children.get(ch);
				} else {
					return false;
				}
				if (i == arr.length - 1 && !node.children.containsKey(endSymbol)) {
					return true;
				}
			}
			return false;
		}

	}

	public static void main(String[] args) {
		String[] words = new String[] { "this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED",
				"NOTRE-PEATED" };
		char[][] arr = new char[9][];
		arr[0] = new char[] {'t', 'h', 'i', 's', 'i', 's', 'a'};
		arr[1] = new char[] {'s', 'i', 'm', 'p', 'l', 'e', 'x'};
		arr[2] = new char[] {'b', 'x', 'x', 'x', 'x', 'e', 'b'};
		arr[3] = new char[] {'x', 'o', 'g', 'g', 'l', 'x', 'o'};
		arr[4] = new char[] {'x', 'x', 'x', 'D', 'T', 'r', 'a'};
		arr[5] = new char[] {'R', 'E', 'P', 'E', 'A', 'd', 'x'};
		arr[6] = new char[] {'x', 'x', 'x', 'x', 'x', 'x', 'x'};
		arr[7] = new char[] {'N', 'O', 'T', 'R', 'E', '-', 'P'};
		arr[8] = new char[] {'x', 'x', 'D', 'E', 'T', 'A', 'E'};
		System.out.println(boggleBoard(arr, words));
	}

}
