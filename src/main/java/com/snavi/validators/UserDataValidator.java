package com.snavi.validators;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snavi.controllers.StatusCodes;
import com.snavi.entities.Landlord;
import com.snavi.entities.Tenant;
import com.snavi.repositories.LandlordDAO;
import com.snavi.repositories.TenantDAO;

@Component
public class UserDataValidator {
	
	// CONST ////////////////////////////////////////////////////////////////////////////////////////////////
	public static final int MAX_EMAIL_LEN 		= 254;
	public static final int MIN_FIRST_NAME_LEN 	= 2;
	public static final int MAX_FIRST_NAME_LEN 	= 60;
	public static final int MIN_LAST_NAME_LEN 	= 2;
	public static final int MAX_LAST_NAME_LEN 	= 60;
	public static final int MIN_PASSWORD_LEN	= 6;
	public static final int MAX_PASSWORD_LEN	= 60;
	public static final int MIN_PHONE_LEN		= 5;
	public static final int MAX_PHONE_LEN		= 20;
	
	
	
	// fields ///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private TenantDAO tenantDAO;
	@Autowired
	private LandlordDAO landlordDAO;
	
	
	
	// methods //////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public int validateUser(Tenant user)
	{
		if (!isEmailValid(user.getEmail()))
			return StatusCodes.WRONG_EMAIL;
		if (!isEmailUnique(user.getEmail()))
			return StatusCodes.NON_UNQ_EMAIL;
		if (!isFirstNameValid(user.getFirstName()))
			return StatusCodes.WRONG_FIRST_NAME;
		if (!isLastNameValid(user.getLastName()))
			return StatusCodes.WRONG_LAST_NAME;
		if (!isPasswordValid(user.getPassword()))
			return StatusCodes.WRONG_PASSWORD;
		if (!isBirthDateValid(user.getBirthDate()))
			return StatusCodes.WRONG_BIRTH_DATE;
		if (!isPhoneValid(user.getPhone()))
			return StatusCodes.WRONG_PHONE;
		if (!isUniversityValid(user.getUniversity()))
			return StatusCodes.WRONG_UNIVERSITY;
		
		return StatusCodes.SUCCESS_USER_CREATION;
	}
	
	
	
	public int validateUser(Landlord user)
	{
		if (!isEmailValid(user.getEmail()))
			return StatusCodes.WRONG_EMAIL;
		if (!isEmailUnique(user.getEmail()))
			return StatusCodes.NON_UNQ_EMAIL;
		if (!isFirstNameValid(user.getFirstName()))
			return StatusCodes.WRONG_FIRST_NAME;
		if (!isLastNameValid(user.getLastName()))
			return StatusCodes.WRONG_LAST_NAME;
		if (!isPasswordValid(user.getPassword()))
			return StatusCodes.WRONG_PASSWORD;
		if (!isBirthDateValid(user.getBirthDate()))
			return StatusCodes.WRONG_BIRTH_DATE;
		if (!isPhoneValid(user.getPhone()))
			return StatusCodes.WRONG_PHONE;
		
		return StatusCodes.SUCCESS_USER_CREATION;
	}
	
	
	
	public static boolean isEmailValid(String email)
	{
		if (email == null)
			return false;
		
		return email.length() <= MAX_EMAIL_LEN &&
				email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
	}
	
	
	
	public boolean isEmailUnique(String email)
	{
		boolean isUnqTenants 	= !tenantDAO.findByEmail(email).isPresent();
		boolean isUnqLandlords 	= !landlordDAO.findByEmail(email).isPresent();
		
		return isUnqTenants && isUnqLandlords;
	}
	
	

	public static boolean isFirstNameValid(String name)
	{
		if (name == null)
			return false;
		
		return name.length() >= MIN_FIRST_NAME_LEN && 
				name.length() <= MAX_FIRST_NAME_LEN && 
				name.matches("^[\\p{L} ]+$");
	}
	
	
	
	public static boolean isLastNameValid(String lastName)
	{
		if (lastName == null)
			return false;
		
		return lastName.length() >= MIN_LAST_NAME_LEN &&
				lastName.length() <= MAX_LAST_NAME_LEN &&
				lastName.matches("^[\\p{L} ]+$");
	}
	
	
	
	public static boolean isPasswordValid(String password)
	{
		if (password == null)
			return false;
		
		return password.length() >= MIN_PASSWORD_LEN &&
				password.length() <= MAX_PASSWORD_LEN &&
				password.matches("^[^ '\"]+$");
	}
	
	
	
	public static boolean isBirthDateValid(Timestamp birthDate)
	{
		return birthDate != null;
	}
	
	
	
	public static boolean isPhoneValid(String phone)
	{
		if (phone == null)
			return false;
		
		return phone.length() >= MIN_PHONE_LEN &&
				phone.length() <= MAX_PHONE_LEN &&
				phone.matches("^[0-9+]+$");
	}
	
	
	
	public static boolean isUniversityValid(String university)
	{
		return university != null;
	}
	
}
