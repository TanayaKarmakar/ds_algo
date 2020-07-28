package com.app.problems.gfg.dp.sample;

import java.util.HashMap;
import java.util.Map;

class Area {
	int x;
	int y;

	public Area(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ChoiceOfArea {
	private static int maxSurvivalMemo(Map<String, Integer> memo, int a, int b, int last, Area x, Area y, Area z) {
		if (a <= 0 || b <= 0)
			return 0;
		String key = a + "-" + b;
		if (!memo.containsKey(key)) {
			int val = 0;
			int option1 = 0;
			int option2 = 0;
			switch (last) {
			case 1:
				option1 = 1 + maxSurvivalMemo(memo, a + y.x, b + y.y, 2, x, y, z);
				option2 = 1 + maxSurvivalMemo(memo, a + z.x, b + z.y, 3, x, y, z);
				break;
			case 2:
				option1 = 1 + maxSurvivalMemo(memo, a + x.x, b + x.y, 1, x, y, z);
				option2 = 1 + maxSurvivalMemo(memo, a + z.x, b + z.y, 3, x, y, z);
				break;
			case 3:
				option1 = 1 + maxSurvivalMemo(memo, a + x.x, b + x.y, 1, x, y, z);
				option2 = 1 + maxSurvivalMemo(memo, a + z.x, b + z.y, 2, x, y, z);
				break;
			}
			val = Integer.max(option1, option2);
			memo.put(key, val);
		}
		return memo.get(key);
	}

	private static int findMaxSurvival(int a, int b, Area x, Area y, Area z) {
		Map<String, Integer> memo = new HashMap<>();
		int option1 = maxSurvivalMemo(memo, a + x.x, b + x.y, 1, x, y, z);
		int option2 = maxSurvivalMemo(memo, a + y.x, b + y.y, 2, x, y, z);
		int option3 = maxSurvivalMemo(memo, a + z.x, b + z.y, 3, x, y, z);
		return Integer.max(option1, Integer.max(option2, option3));
	}

	public static void main(String[] args) {
		int a = 20;
		int b = 8;
		Area x = new Area(3, 2);
		Area y = new Area(-5, -10);
		Area z = new Area(-20, 5);
		
		int ans = findMaxSurvival(a, b, x, y, z);
		
		System.out.println(ans);
	}

}
