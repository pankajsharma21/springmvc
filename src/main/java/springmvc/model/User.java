package springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	/*
	 * In this type of class fields are corresponding to jsp page from which we want
	 * to take data means jis order m jsp k page ya form pe field hogi us order m he
	 * is class m hogi jis page se data lena ho uske order m so fields in this are
	 * corresponding to form contact
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private String userName;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", password=" + password + "]";
	}
	




}
