package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
}

public class EmployeeImportanceLeetcode690 {

	private static int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> empMap = new HashMap<>();
		for(Employee emp: employees) {
			empMap.put(emp.id, emp);
		}
		
		Queue<Integer> q = new LinkedList<>();
		int importance = 0;
		
		q.add(id);
		
		Set<Integer> visited = new HashSet<>();
		visited.add(id);
		
		while(!q.isEmpty()) {
			int currentId = q.poll();
			Employee currEmp = empMap.get(currentId);
			
			importance += currEmp.importance;
			
			List<Integer> subordinates = currEmp.subordinates;
			for(Integer el: subordinates) {
				if(!visited.contains(el)) {
					q.add(el);
					visited.add(el);
				}
			}
		}
		
		return importance;
	}

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		
		Employee emp1 = new Employee();
		emp1.id = 1;
		emp1.importance = 5;
		emp1.subordinates = Arrays.asList(2, 3);
		emps.add(emp1);
		
		Employee emp2 = new Employee();
		emp2.id = 2;
		emp2.importance = 3;
		emp2.subordinates = new ArrayList<>();
		emps.add(emp2);
		
		Employee emp3 = new Employee();
		emp3.id = 3;
		emp3.importance = 3;
		emp3.subordinates = new ArrayList<>();
		emps.add(emp3);
		
		int importance = getImportance(emps, 1);
		System.out.println(importance);
		
		

	}

}
