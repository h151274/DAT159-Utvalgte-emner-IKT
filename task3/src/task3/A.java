package task3;


public class Employee {
	 private String name;
	 private int id;
	 private int nr; 
	 

	public Employee(String name, int id, int nr) {
		    this.name = name;
		    this.id = id;
		    this.nr = nr;
		  }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public void changePhoneNumber(int nr) { 
		
	}
	
}	
	
class Manager extends Employee { 

	public Manager(String name, int id, int nr) {
	    super(name, id, nr);
	    
	  }
} 

class Engineer extends Employee{
	String field; 

	public Engineer(String name, int id,int nr, String field) {
		    super(name, id, nr);
		    this.field = field; 
		  }

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
}
