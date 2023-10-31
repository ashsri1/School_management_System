package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence,Integer> {
}
