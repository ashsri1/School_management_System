package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Fees;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeesService {

    List<Fees> findAll();

    Fees findById(int theId);

    Fees save(Fees theFees);

}
