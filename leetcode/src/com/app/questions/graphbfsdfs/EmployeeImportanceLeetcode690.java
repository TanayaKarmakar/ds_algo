package com.app.questions.graphbfsdfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
};

public class EmployeeImportanceLeetcode690 {
	private static Map<Integer, Employee> createMap(List<Employee> employees) {
		Map<Integer, Employee> map = new HashMap<>();
		for(Employee emp: employees) {
			map.put(emp.id, emp);
		}
		
		return map;
	}

	private static int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = createMap(employees);
		
		Queue<Employee> q = new LinkedList<>();
		
		int total = 0;
		q.add(map.get(id));
		
		while(!q.isEmpty()) {
			Employee currEmp = q.poll();
			
			total += currEmp.importance;
			
			List<Integer> subordinates = currEmp.subordinates;
			
			for(Integer el: subordinates) {
				q.add(map.get(el));
			}
		}
		
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
