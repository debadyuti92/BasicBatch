package com.dyuti.Batch.Model;

public class Employee {

	String id;
    String firstName;
    String lastName;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return getId()+" "+getFirstName()+" "+getLastName();
    }
    
	
}
