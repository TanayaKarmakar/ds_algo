package com.app.questions;

public class IsSubsequenceLeetcode392 {
	private static boolean tabulation(String s, String t) {
		int n = s.length();
		int m = t.length();
		int i = 0;
		int j = 0;
		int count = 0;
		while (i < n && j < m) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				count++;
			}
			j++;
		}
		return count == s.length();
	}

	private static boolean isSubsecRec(String s, String t, int sIndx, int tIndx) {
		if (sIndx == s.length())
			return true;
		if (tIndx == t.length())
			return false;
		if (s.charAt(sIndx) == t.charAt(tIndx))
			return isSubsecRec(s, t, sIndx + 1, tIndx + 1);
		else
			return isSubsecRec(s, t, sIndx, tIndx + 1);
	}

	public static boolean isSubsequence(String s, String t) {
		return isSubsecRec(s, t, 0, 0);
	}

	public static void main(String[] args) {
		String s = "pppsppuppppbsppppppppppp" + "pppppppppepppppppppppqpuppp" + "epppppppppppppppnpppppppcpp"
				+ "ppppppppppeppppppppppp";

		String t = "gggggsggggggg" + "gggggggggggggg" + "gggggggggggggg" + "ggggggggggggggg" + "ggggggggggggggg"
				+ "ggggggggggggggg" + "ggggggggggggggg" + "ggggggggggggggg" + "ggggggggggggggggggggggggggggggg"
				+ "ggggggggggggggggggggggggggggggg" + "gggggggggggggggggggggg";

		System.out.println(tabulation(s, t));

		s = "axc";
		t = "ahbgdc";

		System.out.println(tabulation(s, t));

	}

}
