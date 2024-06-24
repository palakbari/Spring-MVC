package register.controller;

public class Register 
{
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private long contact;
	private String gender;
	private String course;
	private String course_subject;
	
	public Register() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(String firstname, String lastname, String email, String password, long contact, String gender,
			String course, String course_subject) 
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.gender = gender;
		this.course = course;
		this.course_subject = course_subject;
	}
	
	public String getFirstname() 
	{
		return firstname;
	}
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	
	public String getLastname() 
	{
		return lastname;
	}
	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}
	
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public long getContact() 
	{
		return contact;
	}
	public void setContact(long contact) 
	{
		this.contact = contact;
	}
	
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public String getCourse() 
	{
		return course;
	}
	public void setCourse(String course) 
	{
		this.course = course;
	}
	
	public String getCourse_subject() 
	{
		return course_subject;
	}
	public void setCourse_subject(String course_subject) 
	{
		this.course_subject = course_subject;
	}
	
}
