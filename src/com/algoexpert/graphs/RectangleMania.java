package com.algoexpert.graphs;

import java.util.ArrayList;
import java.util.List;

public class RectangleMania {

	public static int rectangleMania(Point[] coords) {
		int ans = 0;
		for (Point p : coords) {
			ans += findRectangle(p, coords);
		}
		return ans;
	}
	
	private static int findRectangle(Point p, Point[] coords) {
		int rect = 0;
		List<Point> upPoints = findUp(p, coords);
		for (Point q : upPoints) {
			List<Point> rightPoints = findRight(q, coords);
			for (Point r : rightPoints) {
				List<Point> downPoints = findDown(r, coords);
				for (Point s : downPoints) {
					List<Point> leftPoints = findLeft(s, coords);
					for (Point t : leftPoints) {
						if (t.x == p.x && t.y == p.y)
							rect++;
					}
				}
			}
		}
		return rect;
	}
	
	private static List<Point> findUp(Point p, Point[] coords) {
		List<Point> upPoints = new ArrayList<>();
		for (Point q : coords) {
			if (q.x == p.x && q.y == p.y)
				continue;
			else if (q.x == p.x && q.y > p.y) {
				upPoints.add(q); 
			}
		}
		return upPoints;
	}
	
	private static List<Point> findRight(Point p, Point[] coords) {
		List<Point> leftPoints = new ArrayList<>();
		for (Point q : coords) {
			if (q.x == p.x && q.y == p.y)
				continue;
			else if (q.x > p.x && q.y == p.y) {
				leftPoints.add(q); 
			}
		}
		return leftPoints;
	}
	
	private static List<Point> findDown(Point p, Point[] coords) {
		List<Point> downPoints = new ArrayList<>();
		for (Point q : coords) {
			if (q.x == p.x && q.y == p.y)
				continue;
			else if (q.x == p.x && q.y < p.y) {
				downPoints.add(q); 
			}
		}
		return downPoints;
	}

	private static List<Point> findLeft(Point p, Point[] coords) {
		List<Point> rightPoints = new ArrayList<>();
		for (Point q : coords) {
			if (q.x == p.x && q.y == p.y)
				continue;
			else if (q.x < p.x && q.y == p.y) {
				rightPoints.add(q); 
			}
		}
		return rightPoints;
	}

	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Point[] arr = new Point[6];
		arr[0] = new Point(0, 0);
		arr[1] = new Point(0, 1);
		arr[2] = new Point(1, 1);
		arr[3] = new Point(1, 0);
		arr[4] = new Point(2, 1);
		arr[5] = new Point(2, 0);
		//arr[6] = new Point(3, 1);
		//arr[7] = new Point(3, 0);
		System.out.println(rectangleMania(arr));
	}

}
