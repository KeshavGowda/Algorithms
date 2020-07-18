package com.algoexpert.dynprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DiskStacking {

	public static void main(String[] args) {
		List<Integer[]> ans = diskStacking(test1());
		for(Integer[] arr : ans) {
			System.out.println(arr[0] + "," + arr[1] + "," + arr[2]);
		}
	}

	public static List<Integer[]> diskStacking(List<Integer[]> disks) {
		int[] heights = new int[disks.size()];
		int[] diskUsed = new int[disks.size()];
		Arrays.fill(diskUsed, -1);
		// sort by height
		sortByHeight(disks);
		for (int i = 0; i < disks.size(); i++) {
			heights[i] = disks.get(i)[2];
			for (int j = 0; j < i; j++) {
				if (disks.get(j)[0] < disks.get(i)[0] && disks.get(j)[1] < disks.get(i)[1]
						&& disks.get(j)[2] < disks.get(i)[2]) {
					if (heights[j] + disks.get(i)[2] > heights[i]) {
						heights[i] = heights[j] + disks.get(i)[2];
						diskUsed[i] = j;
					}
				}
			}
		}
		List<Integer[]> ans = new ArrayList<>();
		int max = 0;
		int maxIndex = -1;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] > max) {
				max = heights[i];
				maxIndex = i;
			}
		}
		int j = maxIndex;
		while (j != -1) {
			ans.add(0, disks.get(j));
			j = diskUsed[j];
		}
		return ans;
	}

	private static void sortByHeight(List<Integer[]> disks) {
		disks.sort(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[2].compareTo(o2[2]);
			}
		});
	}
	
	private static List<Integer[]> test1() {
		List<Integer[]> arr = new ArrayList<>();
		arr.add(new Integer[] { 2, 1, 2 });
		arr.add(new Integer[] { 3, 2, 5 });
		arr.add(new Integer[] { 2, 2, 8 });
		arr.add(new Integer[] { 2, 3, 4 });
		arr.add(new Integer[] { 2, 2, 1 });
		arr.add(new Integer[] { 4, 4, 5 });
		return arr;
	}

}
