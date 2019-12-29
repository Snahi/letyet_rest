package com.snavi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snavi.entities.Landlord;
import com.snavi.repositories.LandlordDAO;
import com.snavi.validators.UserAdapter;
import com.snavi.validators.UserDataValidator;

@RestController
@RequestMapping("/landlords")
@CrossOrigin
public class LandlordsController {
	
	// fields /////////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private LandlordDAO landlordDAO;
	@Autowired
	private UserDataValidator userDataValidator;
	
	
	
	// end points /////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	@RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Landlord> createLandlord(
			@RequestBody(required=true) Landlord landlord)
	{
		int status = userDataValidator.validateUser(new UserAdapter(landlord));
		
		if (status == StatusCodes.SUCCESS_USER_CREATION)
		{
			landlord = landlordDAO.save(landlord);
		}

		return ResponseEntity.status(status).body(landlord);
	}
}
