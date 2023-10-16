package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.Class_RoomRepository;
import com.luv2code.cruddemo.entity.Class_Room;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class Class_RoomImpl implements Class_RoomService{

    private Class_RoomRepository classRoomRepository;

    @Autowired
    public Class_RoomImpl(Class_RoomRepository theClass_RoomRepository) {
        classRoomRepository = theClass_RoomRepository;
    }


    @Override
    public List<Class_Room> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Class_Room findById(int theId) {

        Optional<Class_Room> result =classRoomRepository.findById(theId);
        Class_Room theClass_Room=null;
        if (result.isPresent()){
            theClass_Room=result.get();
        }
        else {
            throw new RuntimeException("did not find Class_room id - " + theId);
        }
        return theClass_Room;


    }

    @Override
    @Transactional
    public Class_Room save(Class_Room theClass_Room) {
        return classRoomRepository.save(theClass_Room);
    }


}

