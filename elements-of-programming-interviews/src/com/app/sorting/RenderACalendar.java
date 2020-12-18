package com.app.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Event {
	int startTime;
	int finishTime;

	public Event(int startTime, int finishTime) {
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
}

class EndPoint {
	int startTime;
	boolean isStart;

	public EndPoint(int startTime, boolean isStart) {
		this.startTime = startTime;
		this.isStart = isStart;
	}
}

public class RenderACalendar {
	private static int findMaxSimultaneousEvents(List<Event> events) {
		List<EndPoint> endPoints = events.stream()
				.map(event -> List.of(new EndPoint(event.startTime, true), 
						new EndPoint(event.finishTime, false)))
				.flatMap(List::stream).collect(Collectors.toList());

		Collections.sort(endPoints, (e1, e2) -> {
			int cmp = e1.startTime - e2.startTime;

			if (cmp != 0)
				return cmp;

			return (e1.isStart && !e2.isStart) ? -1 : ((!e1.isStart && e2.isStart) ? 1 : 0);
		});
		
		int maxSimultaneousEvents = 0;
		int currentCount = 0;
		
		for(EndPoint endPoint: endPoints) {
			if(endPoint.isStart) {
				currentCount++;
				maxSimultaneousEvents = Integer.max(maxSimultaneousEvents, currentCount);
			} else {
				currentCount--;
			}
		}

		return maxSimultaneousEvents;
	}

	public static void main(String[] args) {
		List<Event> events = new ArrayList<>();
		events.add(new Event(1, 5));
		events.add(new Event(2, 7));
		events.add(new Event(4, 5));
		events.add(new Event(6, 10));
		events.add(new Event(8, 9));
		events.add(new Event(9, 17));
		events.add(new Event(11, 13));
		events.add(new Event(14, 15));
		events.add(new Event(12, 15));
		
		int maxCount = findMaxSimultaneousEvents(events);
		
		System.out.println(maxCount);
	}

}
