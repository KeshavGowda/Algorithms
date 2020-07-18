package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {

	public static void main(String[] args) {
		System.out.println(apartmentHunting(getMap1(), new String[] { "gym", "school", "store" }));
		System.out.println(apartmentHunting(getMap2(), new String[] { "gym", "office", "school", "store" }));
		System.out.println(apartmentHunting(getMap3(), new String[] { "gym", "pool", "school", "store" }));
	}

	public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
		List<Map<String, Integer>> distances = new ArrayList<>();
		int res = blocks.size(); 
		int maxDist = blocks.size();
		int i = 0;
		while (i < blocks.size()) {
			Map<String, Integer> block = new HashMap<>();
			for (String amn : reqs) {
				block.put(amn, 0);
				if (!blocks.get(i).get(amn)) {
					block.put(amn, getLeastDistance(i, amn, blocks));
				}
			}
			int max = block.values().stream().reduce(Integer::max).get();
			block.put("max", max);
			distances.add(block);
			i++;
		}
		for (int j = 0; j + 1 < distances.size(); j++) {
			if (distances.get(j).get("max") < maxDist) {
				res = j;
				maxDist = distances.get(j).get("max");
			}
		}
		return res;
	}

	private static int getLeastDistance(int block, String amn, List<Map<String, Boolean>> blocks) {
		int minDist = Integer.MAX_VALUE;
		int dist = 1;
		for (int i = block + 1; i < blocks.size(); i++) {
			if (!blocks.get(i).get(amn)) {
				dist++;
			} else {
				minDist = dist;
				break;
			}
		}
		dist = 1;
		for (int i = block - 1; i >= 0; i--) {
			if (!blocks.get(i).get(amn)) {
				dist++;
			} else {
				if (dist < minDist)
					minDist = dist;
				break;
			}
		}
		return minDist;
	}

	private static List<Map<String, Boolean>> getMap1() {
		List<Map<String, Boolean>> blocks = new ArrayList<>();
		Map<String, Boolean> map = new HashMap<>();
		map.put("gym", false);
		map.put("school", true);
		map.put("store", false);
		blocks.add(map);
		Map<String, Boolean> map2 = new HashMap<>();
		map2.put("gym", true);
		map2.put("school", false);
		map2.put("store", false);
		blocks.add(map2);
		Map<String, Boolean> map3 = new HashMap<>();
		map3.put("gym", true);
		map3.put("school", true);
		map3.put("store", false);
		blocks.add(map3);
		Map<String, Boolean> map4 = new HashMap<>();
		map4.put("gym", false);
		map4.put("school", true);
		map4.put("store", false);
		blocks.add(map4);
		Map<String, Boolean> map5 = new HashMap<>();
		map5.put("gym", false);
		map5.put("school", true);
		map5.put("store", true);
		blocks.add(map5);
		return blocks;
	}
	
	private static List<Map<String, Boolean>> getMap2() {
		List<Map<String, Boolean>> blocks = new ArrayList<>();
		Map<String, Boolean> map = new HashMap<>();
		map.put("gym", false);
		map.put("office", true);
		map.put("school", true);
		map.put("store", false);
		blocks.add(map);
		Map<String, Boolean> map2 = new HashMap<>();
		map2.put("gym", true);
		map2.put("office", false);
		map2.put("school", false);
		map2.put("store", false);
		blocks.add(map2);
		Map<String, Boolean> map3 = new HashMap<>();
		map3.put("gym", true);
		map3.put("office", false);
		map3.put("school", true);
		map3.put("store", false);
		blocks.add(map3);
		Map<String, Boolean> map4 = new HashMap<>();
		map4.put("gym", false);
		map4.put("office", false);
		map4.put("school", true);
		map4.put("store", false);
		blocks.add(map4);
		Map<String, Boolean> map5 = new HashMap<>();
		map5.put("gym", false);
		map5.put("office", false);
		map5.put("school", true);
		map5.put("store", true);
		blocks.add(map5);
		return blocks;
	}
	
	private static List<Map<String, Boolean>> getMap3() {
		List<Map<String, Boolean>> blocks = new ArrayList<>();
		Map<String, Boolean> map = new HashMap<>();
		map.put("gym", true);
		map.put("pool", false);
		map.put("school", true);
		map.put("store", false);
		blocks.add(map);
		Map<String, Boolean> map2 = new HashMap<>();
		map2.put("gym", false);
		map2.put("pool", false);
		map2.put("school", false);
		map2.put("store", false);
		blocks.add(map2);
		Map<String, Boolean> map3 = new HashMap<>();
		map3.put("gym", false);
		map3.put("pool", false);
		map3.put("school", true);
		map3.put("store", false);
		blocks.add(map3);
		Map<String, Boolean> map4 = new HashMap<>();
		map4.put("gym", false);
		map4.put("pool", false);
		map4.put("school", false);
		map4.put("store", false);
		blocks.add(map4);
		Map<String, Boolean> map5 = new HashMap<>();
		map5.put("gym", false);
		map5.put("pool", false);
		map5.put("school", false);
		map5.put("store", true);
		blocks.add(map5);
		Map<String, Boolean> map6 = new HashMap<>();
		map6.put("gym", true);
		map6.put("pool", false);
		map6.put("school", false);
		map6.put("store", false);
		blocks.add(map6);
		Map<String, Boolean> map7 = new HashMap<>();
		map7.put("gym", false);
		map7.put("pool", false);
		map7.put("school", false);
		map7.put("store", false);
		blocks.add(map7);
		Map<String, Boolean> map8 = new HashMap<>();
		map8.put("gym", false);
		map8.put("pool", false);
		map8.put("school", false);
		map8.put("store", false);
		blocks.add(map8);
		Map<String, Boolean> map9 = new HashMap<>();
		map9.put("gym", false);
		map9.put("pool", false);
		map9.put("school", false);
		map9.put("store", false);
		blocks.add(map9);
		Map<String, Boolean> map10 = new HashMap<>();
		map10.put("gym", false);
		map10.put("pool", false);
		map10.put("school", true);
		map10.put("store", false);
		blocks.add(map10);
		Map<String, Boolean> map11 = new HashMap<>();
		map11.put("gym", false);
		map11.put("pool", true);
		map11.put("school", false);
		map11.put("store", false);
		blocks.add(map11);
		return blocks;
	}

}
