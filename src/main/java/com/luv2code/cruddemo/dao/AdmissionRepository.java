package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission,Integer> {


}
