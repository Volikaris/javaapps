package main;

public class User {

	String login, pass, name, surname;
	int age;
	
	public User(String login, String pass, String name, String surname, int age) {
		this.login = login;
		this.pass = pass;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public String getUserData() {
		String all = login + " : " + pass + " : " + name + " : " + surname + " : " + age;
		return all;
	}

	public String getLogin() {
		return login;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}
	
}
