package com.snavi.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.snavi.entities.Tenant;

public interface TenantDAO extends CrudRepository<Tenant, Integer> {

	Optional<Tenant> findByEmail(String email);
}
