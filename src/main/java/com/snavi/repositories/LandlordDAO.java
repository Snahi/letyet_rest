package com.snavi.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.snavi.entities.Landlord;

public interface LandlordDAO extends CrudRepository<Landlord, Integer> {

	Optional<Landlord> findByEmail(String email);
}
