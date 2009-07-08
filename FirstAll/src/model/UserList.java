package model;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType 
public class UserList {
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
