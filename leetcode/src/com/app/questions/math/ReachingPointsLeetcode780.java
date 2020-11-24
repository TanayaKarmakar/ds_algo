package com.app.questions.math;

import java.util.LinkedList;
import java.util.Queue;

public class ReachingPointsLeetcode780 {
	private static boolean reachingPoints(int sx, int sy, int tx, int ty) {
		if (sx == tx)
			return (ty - sy) > 0 && (ty - sy) % sx == 0;
		if (sy == ty)
			return (tx - sx) > 0 && (tx - sx) % sy == 0;
		return helper(sx, sy, tx, ty);
	}

	private static boolean helper(int sx, int sy, int tx, int ty) {
		if (sx == tx && sy == ty)
			return true;
		if (sx > tx || sy > ty)
			return false;
		boolean option1 = helper(sx, sy, tx - ty, ty);
		boolean option2 = helper(sx, sy, tx, ty - tx);
		return option1 || option2;
	}

	public static void main(String[] args) {
//		35
//		13
//		455955547
//		420098884
		int sx = 35;
		int sy = 13;
		int tx = 455955547;
		int ty = 420098884;

		System.out.println(reachingPoints(sx, sy, tx, ty));

	}

}
