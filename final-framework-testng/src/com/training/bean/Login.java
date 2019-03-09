package com.training.bean;

public class Login {
	private String firstname;
	private String lastname;
	private String email;
	private String Telephone;
	private String address1;
	private String address2;
	private String city;
	private String postcode;
	private String password;
	private String confirm;
	public Login() {
	}

	public Login(String firstname, String lastname,String email,String Telephone,String address1,String address2,String city,String postcode,String password,String confirm) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email=email;
		this.Telephone=Telephone;
		this.address1=address1;
		this.address2=address2;
		this.city=city;
		this.postcode=postcode;
		this.password=password;
		this.confirm=confirm;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String Telephone) {
		this.Telephone = Telephone;
	}
	
	public String getaddress1() {
		return address1;
	}

	public void setaddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getaddress2() {
		return address2;
	}

	public void setaddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getcity() {
		return city;
	}
	
	public void setcity(String city) {
		this.city = city;
	
	}
	
	public String getpostcode() {
		return postcode;
	}

	public void setpostcode(String postcode) {
		this.postcode = postcode;
	
	}
	
	
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getconfirm() {
		return confirm;
	}

	public void setconfirm(String confirm) {
		this.confirm = confirm;
	}
	
	


	@Override
	public String toString() {
		return "Login [fistname=" + firstname + ", lastname=" + lastname + ",email=" +email+",Telephone=" +Telephone+",address1="+address1+",address2="+address2+",city="+city+",postcode="+postcode+",password="+password+",confirm="+confirm+"]";
	}

	 


}
