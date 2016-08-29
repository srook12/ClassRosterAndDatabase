package ssa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student implements Comparable<Student> {
	
	public String id;
	public String firstName;
	public String lastName;
	public String eyeColor;
	public int monthsEmployed;
	
	private static List<Student> classRoster = new ArrayList<Student>();
	private static Map<String, Student> classRosterMap = new HashMap<String, Student>();
		
	public static final String BLUE_EYES = "Blue";
	public static final String BROWN_EYES = "Brown"; 
	public static final String OTHER_EYES = "Other";
	
	
	public Student() {
		// Load the students into the ArrayList
		// Exactly what people put into Slack!
		classRoster.add(new Student("001122", "Michael", "Claire", "Purple", 12));
		classRoster.add(new Student("001212", "Stephen", "Rook", "Brown", 11));
		classRoster.add(new Student("474143", "Jonathan", "Stafford", "Brown", 13));
		classRoster.add(new Student("005295", "Kyle", "Deen", "Blue", 2));
		classRoster.add(new Student("004400", "Kevin", "Tran", "Red", 12));
		classRoster.add(new Student("132617", "Reuben", "Turner", "Brown", 12));
		classRoster.add(new Student("306700", "Li", "Lui", "Brown", 12));
		classRoster.add(new Student("215296", "Joshua", "Franey", "Other", 27));
		classRoster.add(new Student("523420", "Gabriel", "Hamilton", "Black", 10));
		classRoster.add(new Student("004014", "Aisha", "Covington", "Brown", 10));
		classRoster.add(new Student("006789", "Arun", "Soma", "Brown", 2));
		classRoster.add(new Student("009999", "Steve", "Ellwood", "Other", 2));
		classRoster.add(new Student("343769", "Shaquil", "Timmons", "Brown", 11));
		classRoster.add(new Student("001449", "Karen", "Reiter", "Blue", 10));
		classRoster.add(new Student("267252", "Dax", "Richards", "Brown", 12));
		classRoster.add(new Student("229949", "Mike", "Sykes", "Brown", 13));
		classRoster.add(new Student("772223", "Daniel", "Kiros", "Brown", 3));
		classRoster.add(new Student("004444", "Peter", "Choi", "Brown", 2));
		classRoster.add(new Student("005255", "Joe", "Hill", "Brown", 13));
		classRoster.add(new Student("008888", "Evan", "Tizard", "Brown", 12));
	}
	
	public Student(String id, String firstName, String lastName, String eyeColor, 
			int monthsEmployed) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		setEyeColor(eyeColor);
		this.monthsEmployed = monthsEmployed;
	}
	
	// Sanitize the eye color
	public void setEyeColor(String eyeColor) {
		switch (eyeColor) {
			case BLUE_EYES:
			case BROWN_EYES: 
				this.eyeColor = eyeColor;
				break;
			default:
				this.eyeColor = OTHER_EYES;
		}
	}
	
	@Override
	public int compareTo(Student anotherStudent) {
		return (this.firstName).compareTo(anotherStudent.firstName); 
	}
	
	public void printClassRoster() {

		printPartII();
		System.out.println();
		printPartIII();		
	}
	
	public void printPartII() {
		Collections.sort(classRoster);
		System.out.println("Student Class Roster (Part II)\n");
		
		print();
	}
	
	public void printPartIII() {
		// Populate the HashMap
		for(Student student : classRoster) {
			classRosterMap.put(student.id, student);
		}
		
		classRoster.clear();
		
		List<String> keyList = sortedKeyList(classRosterMap.keySet());
				
		int myIdIndex = keyList.indexOf("001212");
				
		if(myIdIndex == 0) {
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex)));
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex+1)));
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex+2)));
		} else if(myIdIndex == keyList.size() - 1) {
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex-2)));
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex-1)));
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex)));
		} else {
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex-1)));
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex)));
			classRoster.add(classRosterMap.get(keyList.get(myIdIndex+1)));
		}
		
		System.out.println("Student Class Roster (Part III)\n");
		print();
	}
	
	public List<String> sortedKeyList(Set<String> keys) {
		List<String> keyList = new ArrayList<String>();
		
		for(String key : keys) {
			keyList.add(key);
		}
		Collections.sort(keyList);
		
		return keyList;
	}
	
	public void print() {
		System.out.print(String.format("%-7s   ", "Empl Id"));
		System.out.print(String.format("%-16s   ", "First name"));  
		System.out.print(String.format("%-16s   ", "Last name"));
		System.out.print(String.format("%-9s   ", "Eye color"));
		System.out.print(String.format("%-13s", "Months at SSA"));
		
		System.out.println();
		
		System.out.print(String.format("%-7s   ", "======="));  
		System.out.print(String.format("%-16s   ", "================"));
		System.out.print(String.format("%-16s   ", "================"));
		System.out.print(String.format("%-9s   ", "========="));
		System.out.print(String.format("%-13s", "============="));
		
		System.out.println();
		for(Student student : classRoster) {
			System.out.print(String.format("%-7s   ", student.id));
			System.out.print(String.format("%-16s   ", student.firstName));
			System.out.print(String.format("%-16s   ", student.lastName));
			System.out.print(String.format("%-9s   ", student.eyeColor));
			System.out.println(String.format("%7d", student.monthsEmployed));
		}
	}
}
