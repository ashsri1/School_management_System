package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
