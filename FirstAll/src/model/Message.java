package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Message {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
