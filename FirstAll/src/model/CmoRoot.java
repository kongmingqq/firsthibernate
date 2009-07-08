package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "CcmMessageObject")
public class CmoRoot {
	private int statusCode; // Use static constants to implement
	private String dataType; // Type name of the Jaxb
	private Object data; // Instead of using Object type, may use abstract
							// super class to provide common behaviors.
	public CmoRoot() {}
	public CmoRoot(int statusCode,String dataType,Object data) {
		this.statusCode = statusCode;
		this.dataType = dataType;
		this.data = data;
	}
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
