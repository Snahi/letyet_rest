package com.snavi.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "landlords")
public class Landlord {

	// fields ///////////////////////////////////////////////////////////////////////////////////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String email;
	
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_date")
	private Timestamp birthDate;
	
	private String phone;
	
	private String about;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="avg_rating")
	private Double avgRating;
	
	@Column(name="is_email_verified")
	private boolean isEmailVerified;
	
	
	
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
