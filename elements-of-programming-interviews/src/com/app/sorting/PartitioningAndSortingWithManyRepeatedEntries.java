package com.app.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return this.name + " - " + this.age;
	}
}

public class PartitioningAndSortingWithManyRepeatedEntries {

	private static void groupByAge(List<Person> persons) {
		Map<Integer, Integer> ageCount = new HashMap<>();
		Map<Integer, Integer> ageOffset = new HashMap<>();

		for (Person person : persons) {
			ageCount.put(person.age, ageCount.getOrDefault(person.age, 0) + 1);
		}

		int offSet = 0;
		for (Map.Entry<Integer, Integer> entry : ageCount.entrySet()) {
			ageOffset.put(entry.getKey(), offSet);
			offSet += entry.getValue();
		}

		while (ageOffset.size() > 0) {
			Map.Entry<Integer, Integer> entry = ageOffset.entrySet().iterator().next();

			int toAge = persons.get(entry.getValue()).age;
			int toValue = ageOffset.get(toAge);

			Collections.swap(persons, entry.getValue(), toValue);
			
			int count = ageCount.get(toAge) - 1;
			ageCount.put(toAge, count);
			
			if(count > 0) {
				ageOffset.put(toAge, ageOffset.get(toAge) + 1);
			} else {
				ageOffset.remove(toAge);
			}
		}
	}

	public static void main(String[] args) {
		List<Person> persons = List.of(new Person("Greg", 14), new Person("John", 12), 
				new Person("Andy", 11), new Person("Jim", 13), new Person("Phil", 12), 
				new Person("Bob", 13), new Person("Chip", 13), new Person("Tim", 14));
		
		List<Person> newPersons = new ArrayList<>(persons);
		
		groupByAge(newPersons);
		
		System.out.println(newPersons);
	}

}
