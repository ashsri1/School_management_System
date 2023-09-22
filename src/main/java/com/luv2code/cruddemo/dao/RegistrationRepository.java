package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
}
