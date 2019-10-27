package com.app.graph;

import java.util.Comparator;

import com.app.graph.WeightedGraph.Neighbor;

public class EdgeWeightComparator implements Comparator<Neighbor<?>> {

	@Override
	public int compare(Neighbor<?> n1, Neighbor<?> n2) {
		if(n1.getWeight() == n2.getWeight())
			return 0;
		else if(n1.getWeight() < n2.getWeight())
			return -1;
		else
			return 1;
	}

}
