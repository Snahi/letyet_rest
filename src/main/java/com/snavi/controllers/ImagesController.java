package com.snavi.controllers;

import java.sql.SQLException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.jdbc.Blob;

@RestController
@RequestMapping("/images")
@CrossOrigin
public class ImagesController {

	@Autowired
	JdbcTemplate template;
	
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getImage(@PathVariable int id)
	{
		String sql = "SELECT photo FROM photos WHERE id=" + id + ";";
		
		Blob photoBlob = template.queryForObject(sql, Blob.class);
		
		byte[] photo;
		
		try
		{
			photo = photoBlob.getBytes(1, (int) photoBlob.length());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
		}
		
		String result = new String(Base64.getEncoder().encode(photo));
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
