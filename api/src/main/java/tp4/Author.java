package tp4;

import java.io.Serializable;

public class Author implements Serializable {
	
	private final String name;
	private final String surname;
	
	public Author(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	@Override
	public String toString() {
		return "Author{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}
}
