package streams;

import java.util.*;

public class Student {
	private long id;
	private String name;
	private int age;
	private String group;
	private int grant;
	private List<Grade> grades;
	

	Student(long id, String name, int age, String group, int grant, List<Grade> grades){
		this.id = id;
		this.name = name;
		this.age = age;
		this.group = group;
		this.grant = grant;
		this.grades = grades;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getGrant() {
		return grant;
	}

	public void setGrant(int grant) {
		this.grant = grant;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
}
