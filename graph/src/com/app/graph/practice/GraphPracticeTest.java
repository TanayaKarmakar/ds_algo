package com.app.graph.practice;

import java.util.stream.IntStream;

public class GraphPracticeTest {

	public static void main(String[] args) {
		GraphPractice gp = new GraphPractice();
		int nVertices = 5;
		IntStream.range(1, nVertices + 1).forEach(item -> {
			gp.addVertex(String.valueOf(item));;
		});
		
		gp.addEdge("1", "2");
		gp.addEdge("1", "3");
		gp.addEdge("1", "4");
		gp.addEdge("2", "3");
		gp.addEdge("3", "5");
		gp.addEdge("4", "5");
		
		gp.displayGraph();

	}

}
