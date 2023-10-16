package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Class_Room;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface Class_RoomService {


    List<Class_Room> findAll();

    Class_Room findById(int theId);

    Class_Room save(Class_Room theClass_Room);
}
