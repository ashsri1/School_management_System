package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission,Integer> {
}
