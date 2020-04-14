package com.app.greedy.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Worker implements Comparable<Worker> {
	int arrivalTime;
	int cost;
	int speed;
	float speedCostRatio;
	
	
	@Override
	public int compareTo(Worker o) {
		if(this.arrivalTime < o.arrivalTime)
			return -1;
		else if(this.arrivalTime > o.arrivalTime)
			return 1;
		else {
			if(this.speed < o.speed)
				return 1;
			else if(this.speed > o.speed)
				return -1;
			else {
				return this.cost - o.cost;
			}
		}
	}		
}

public class FractionalKnapsack {
	
	private static int getMaxCost(List<Worker> workers, long totalArea) {
		Collections.sort(workers);
		Worker currentWorker = workers.get(0);
		double totalCost = currentWorker.cost;
		totalArea -= currentWorker.speed;
		
		for(int i = 1; i < workers.size(); i++) {
			Worker worker = workers.get(i);
			if(worker.speed > currentWorker.speed) {
				if(totalArea > 0) {
					totalCost += worker.cost;
					totalArea -= worker.speed;
					currentWorker = worker;
				} else {
					break;
				}
			}
		}
		return (int)totalCost;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nWorkers = scanner.nextInt();
		long totalArea = scanner.nextLong();
		List<Worker> workers = new ArrayList<>();
		int i = 0;
		while(i < nWorkers) {
			Worker worker = new Worker();
			worker.arrivalTime = scanner.nextInt();
			worker.cost = scanner.nextInt();
			worker.speed = scanner.nextInt();
			
			worker.speedCostRatio = worker.cost / worker.speed;
			workers.add(worker);
			i++;
		}
		int maxCost = getMaxCost(workers, totalArea);
		System.out.println(maxCost);
		scanner.close();

	}

}
