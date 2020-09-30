package task3;

public class Main {
	public static void main(String args[]) { 
		
		Employee i = new Employee("Eivin", 9, 45434565); 
		Manager m = new Manager("Knut", 12, 98875647); 
		Engineer e = new Engineer("Bente", 65, 89897868, "Computer Engineer"); 
		
		System.out.println(i.getId()); 
		System.out.println(e.getField());
		
		
	}

}
