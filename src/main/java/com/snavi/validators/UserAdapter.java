package com.snavi.validators;

import java.sql.Timestamp;

import com.snavi.entities.Landlord;
import com.snavi.entities.Tenant;


/**
 * Class used in UserDataValidator. It's necessary so that UserDataValidator can work on a single object
 * without necessity to check whether it validates Tenant, Landlord or any other user that could be added in
 * the future.
 */
public class UserAdapter {
	
	// fields ///////////////////////////////////////////////////////////////////////////////////////////////
	private int id;
	private String email;		
	private String password;	
	private String firstName;
	private String lastName;
	private Timestamp birthDate;
	private String phone;
	private String about;
	private boolean isVerified;
	private String university;
	private Double avgRating;
	private boolean isEmailVerified;
	
	
	
	// constructors /////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public UserAdapter(Tenant tenant)
	{
		id 				= tenant.getId();
		email 			= tenant.getEmail();
		password 		= tenant.getPassword();
		firstName 		= tenant.getFirstName();
		lastName 		= tenant.getLastName();
		birthDate 		= tenant.getBirthDate();
		phone 			= tenant.getPhone();
		about 			= tenant.getAbout();
		isVerified 		= tenant.isVerified();
		university 		= tenant.getUniversity();
		avgRating 		= tenant.getAvgRating();
		isEmailVerified = tenant.isEmailVerified();
	}
	
	
	
	public UserAdapter(Landlord landlord)
	{
		id 				= landlord.getId();
		email 			= landlord.getEmail();
		password 		= landlord.getPassword();
		firstName 		= landlord.getFirstName();
		lastName 		= landlord.getLastName();
		birthDate 		= landlord.getBirthDate();
		phone 			= landlord.getPhone();
		about 			= landlord.getAbout();
		isVerified 		= landlord.isVerified();
		university 		= "";
		avgRating 		= landlord.getAvgRating();
		isEmailVerified = landlord.isEmailVerified();
	}
	
	
	
	// getters & setters ////////////////////////////////////////////////////////////////////////////////////

	
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
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

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public Timestamp getBirthDate() 
	{
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) 
	{
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getAbout() 
	{
		return about;
	}

	public void setAbout(String about) 
	{
		this.about = about;
	}

	public boolean isVerified() 
	{
		return isVerified;
	}

	public void setVerified(boolean isVerified) 
	{
		this.isVerified = isVerified;
	}

	public String getUniversity() 
	{
		return university;
	}

	public void setUniversity(String university) 
	{
		this.university = university;
	}

	public Double getAvgRating() 
	{
		return avgRating;
	}

	public void setAvgRating(Double avgRating) 
	{
		this.avgRating = avgRating;
	}

	public boolean isEmailVerified() 
	{
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) 
	{
		this.isEmailVerified = isEmailVerified;
	}
}
