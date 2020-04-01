package com.app.dp1.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RoyAndCoins {
	private static int[] startPos;
	private static int[] endPos;
	private static int[] numCoinsBox;
	private static int[] revNumCoinsBox;

	private static void processBoxes(int n) {
		numCoinsBox[1] = startPos[1];
		numCoinsBox[2] = startPos[2] + startPos[1] - endPos[1];

		// calculates each box contains how many coins
		for (int i = 3; i <= n; i++) {
			numCoinsBox[i] = startPos[i] - endPos[i - 1] + numCoinsBox[i - 1];
		}

		// calculates how many boxes contains i number of coins
		for (int i = 1; i <= n; i++) {
			int k = numCoinsBox[i];
			revNumCoinsBox[k]++;
		}
		
		for(int i = n - 2; i >= 1; i--) {
			revNumCoinsBox[i] += revNumCoinsBox[i + 1];
		}
	}

	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		FastReader rd = new FastReader();
		int numBoxes = rd.nextInt();
		startPos = new int[numBoxes + 1];
		endPos = new int[numBoxes + 1];
		numCoinsBox = new int[numBoxes + 1];
		revNumCoinsBox = new int[numBoxes + 1];

		int nDays = rd.nextInt();
		while (nDays > 0) {
			int start = rd.nextInt();
			int end = rd.nextInt();
			startPos[start]++;
			endPos[end]++;

			nDays--;
		}
		processBoxes(numBoxes);
		
		int nQueries = rd.nextInt();
		while(nQueries > 0) {
			int number = rd.nextInt();
			System.out.println(revNumCoinsBox[number]);
			nQueries--;
		}
		//scanner.close();
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

}
