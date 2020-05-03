package com.app.questions;

public class IsSubsequenceLeetcode392 {
	private static boolean tabulation(String s, String t) {
		int m = t.length();
		int n = s.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for(int i = 1; i <= m; i++) {
			dp[i][0] = true;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(t.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[m][n];
	}
	
	private static boolean isSubsecRec(String s, String t, int sIndx, int tIndx) {
        if(sIndx == s.length())
            return true;
        if(tIndx == t.length())
            return false;
        if(s.charAt(sIndx) == t.charAt(tIndx))
            return isSubsecRec(s, t, sIndx + 1, tIndx + 1);
        else
            return isSubsecRec(s, t, sIndx, tIndx + 1);
    }
    
    public static boolean isSubsequence(String s, String t) {
        return isSubsecRec(s, t, 0, 0);
    }

	public static void main(String[] args) {
		String s = "pppsppuppppbsppppppppppp"
				+ "pppppppppepppppppppppqpuppp"
				+ "epppppppppppppppnpppppppcpp"
				+ "ppppppppppeppppppppppp";
		
		String t = "gggggsggggggg"
				+ "gggggggggggggg"
				+ "gggggggggggggg"
				+ "ggggggggggggggg"
				+ "ggggggggggggggg"
				+ "ggggggggggggggg"
				+ "ggggggggggggggg"
				+ "ggggggggggggggg"
				+ "ggggggggggggggggggggggggggggggg"
				+ "ggggggggggggggggggggggggggggggg"
				+ "gggggggggggggggggggggg";
		
		System.out.println(tabulation(s, t));
		
		s = "axc";
		t = "ahbgdc";
		
		System.out.println(tabulation(s, t));

	}

}
