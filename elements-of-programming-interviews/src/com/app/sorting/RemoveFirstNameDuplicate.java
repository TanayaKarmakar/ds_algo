package com.app.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Name {
	String firstName;
	String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
}

class NameComparator implements Comparator<Name> {

	@Override
	public int compare(Name o1, Name o2) {
		int cmp = o1.firstName.compareTo(o2.firstName);
		if (cmp == 0)
			return o1.lastName.compareTo(o2.lastName);
		return cmp;
	}
}

public class RemoveFirstNameDuplicate {
	private static void removeFirstNameDuplicate(List<Name> names) {
		Collections.sort(names, new NameComparator());

		int writeIndx = 0;

		for (int i = 1; i < names.size(); i++) {
			if (!names.get(writeIndx).firstName.equals(names.get(i).firstName)) {
				names.set(++writeIndx, names.get(i));
			}
		}

		
		names.subList(++writeIndx, names.size()).clear();
	}

	public static void main(String[] args) {
		List<Name> names = new ArrayList<>();
		names.add(new Name("Ian", "Bothan"));
		names.add(new Name("David", "Gower"));
		names.add(new Name("Ian", "Bell"));
		names.add(new Name("Ian", "Chappell"));
		
		removeFirstNameDuplicate(names);
		
		for(Name name: names) {
			System.out.println(name);
		}

	}

}
