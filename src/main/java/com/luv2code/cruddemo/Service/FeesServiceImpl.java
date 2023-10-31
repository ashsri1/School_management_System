package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.FeesRepository;
import com.luv2code.cruddemo.entity.Fees;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Repository
@Service
public class FeesServiceImpl implements FeesService{

    private FeesRepository feesRepository;

    @Autowired
    public FeesServiceImpl(FeesRepository theFeesRepository){
        feesRepository=theFeesRepository;
    }

    @Override
    public List<Fees> findAll() {
        return feesRepository.findAll();
    }

    @Override
    public Fees findById(int theId) {

        Optional<Fees> result=feesRepository.findById(theId);
        Fees theFees=null;
        if (result.isPresent()){
            theFees=result.get();
        }
        else {
            throw new RuntimeException("Did not find fees id -" + theId);
        }

        return theFees;
    }
    @Transactional
    @Override
    public Fees save(Fees theFees) {
        return feesRepository.save(theFees);
    }
}
