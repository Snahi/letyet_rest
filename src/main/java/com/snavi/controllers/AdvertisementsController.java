package com.snavi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snavi.DbConstants;

@RestController
@RequestMapping("/advertisements")
@CrossOrigin
public class AdvertisementsController {
	
	// CONST ////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final int RESULTS_PER_REQUEST = 20;

	// fields ///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	JdbcTemplate template;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Map<String, Object>>> findAdvertisements(
			@RequestParam String city,
			@RequestParam String startDate,
			@RequestParam String endDate,
			@RequestParam String lowestPrice,
			@RequestParam String highestPrice,
			@RequestParam String billsIncluded,
			@RequestParam int startingRow)
	{
		String sql =
				"SELECT * FROM advertisements JOIN residential_units ON (" 
				+ DbConstants.ADV_RESIDENTIAL_UNIT + "= residential_units.id) WHERE "
				+ (city.isEmpty() ? "" : DbConstants.RESIDENTIAL_UNIT_CITY + "='" + city + "' AND ")
				+ (startDate.isEmpty() ? "" : DbConstants.ADV_START_DATE + "='" + startDate + "' AND ")
				+ (endDate.isEmpty() ? "" : DbConstants.ADV_END_DATE + "='" + endDate + "' AND ")
				+ (lowestPrice.isEmpty() ? "" : DbConstants.ADV_PRICE + ">='" + lowestPrice + "' AND ")
				+ (highestPrice.isEmpty() ? "" : DbConstants.ADV_PRICE + "<='" + highestPrice + "' AND ")
				+ (billsIncluded.isEmpty() ? "" : DbConstants.ADV_BILLS_INC + "='" + billsIncluded + "' AND ");
		
		if (!city.isEmpty() || !startDate.isEmpty() || !endDate.isEmpty() || !lowestPrice.isEmpty() || 
				!highestPrice.isEmpty() || !billsIncluded.isEmpty())
			sql = sql.substring(0, sql.length() - 4);
		else
			sql = sql.substring(0, sql.length() - 6);

		sql += " LIMIT " + startingRow + ", " + RESULTS_PER_REQUEST + ";";
		
		return ResponseEntity.status(StatusCodes.SUCCESS_SEARCH).body(template.queryForList(sql));
	}
}
