package com.algoexpert.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DijkstrasAlgo {

	public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
		Set<Integer> visited = new HashSet<>();
		visited.add(start);
		int[] minDist = new int[edges.length];
		Arrays.fill(minDist, -1);
		minDist[start] = 0;
		Stack<Integer> toBeVisited = new Stack<>();
		for (int[] vertices : edges[start]) {
			toBeVisited.add(vertices[0]);
			minDist[vertices[0]] = vertices[1];
		}
		while (!toBeVisited.isEmpty()) {
			int vertex = toBeVisited.pop();
			
		}
		
		return minDist;
	}
	
	

}
