package com.snavi.controllers;

import org.springframework.http.HttpStatus;

public interface StatusCodes {

	// users creation //////////////////////////////////////////////////////////////////////////////////////////
	static final int WRONG_EMAIL 			= 460;
	static final int WRONG_PASSWORD 		= 461;
	static final int WRONG_FIRST_NAME 		= 462;
	static final int WRONG_LAST_NAME 		= 463;
	static final int WRONG_BIRTH_DATE 		= 464;
	static final int WRONG_PHONE 			= 465;
	static final int WRONG_UNIVERSITY 		= 466;
	static final int NON_UNQ_EMAIL			= 467;
	static final int SUCCESS_USER_CREATION 	= HttpStatus.CREATED.value();
	
	// advertisement search ////////////////////////////////////////////////////////////////////////////////////
	static final int SUCCESS_SEARCH = HttpStatus.OK.value();
}
