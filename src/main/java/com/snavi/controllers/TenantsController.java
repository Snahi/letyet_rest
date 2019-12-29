package com.snavi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snavi.entities.Tenant;
import com.snavi.repositories.TenantDAO;
import com.snavi.validators.UserAdapter;
import com.snavi.validators.UserDataValidator;

@RestController
@RequestMapping("/tenants")
@CrossOrigin
public class TenantsController {
	
	// fields ////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private TenantDAO tenantDAO;
	@Autowired
	private UserDataValidator userDataValidator;
	
	
	
	// end points ////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Tenant> createTenant(
			@RequestBody(required=true) Tenant tenant)
	{
		int status = userDataValidator.validateUser(new UserAdapter(tenant));
		
		if (status == StatusCodes.SUCCESS_USER_CREATION)
		{
			tenant = tenantDAO.save(tenant);
		}

		return ResponseEntity.status(status).body(tenant);
	}
	
}
