package com.app.uf;

import java.util.Scanner;

public class PercolationStats {
	private int nGridSize;
	private int nTestCases;
	private double mean;
	private double stddev;
	private double confidenceLo;
	private double confidenceHi;
	
	public PercolationStats(int nGridSize, int nTestCases) {
		if(nGridSize <=0 || nTestCases <= 0)
			throw new IllegalArgumentException("Invalid arguments");
		this.nGridSize = nGridSize;
		this.nTestCases = nTestCases;
		this.initSimulation();
	}
	
	private void initSimulation() {
		
	}
	
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputText = scanner.nextLine();
		String[] inputArr = inputText.split(" ");
		int nGridSize = Integer.parseInt(inputArr[0].trim());
		int nTestCases = Integer.parseInt(inputArr[1].trim());
		
		PercolationStats pStats = new PercolationStats(nGridSize, nTestCases);
		
		scanner.close();

	}

}
