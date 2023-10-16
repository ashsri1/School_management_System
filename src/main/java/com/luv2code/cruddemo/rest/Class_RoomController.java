package com.luv2code.cruddemo.rest;


import com.luv2code.cruddemo.Service.Class_RoomService;
import com.luv2code.cruddemo.entity.Class_Room;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class Class_RoomController {

    private Class_RoomService classRoomService;

    public Class_RoomController(Class_RoomService theClass_RoomService){
        classRoomService=theClass_RoomService;
    }

    @GetMapping("/class_room")
    public List<Class_Room> findAll(){
        return classRoomService.findAll();
    }

    @PostMapping("/class_room")
    public Class_Room addclassroom(@RequestBody Class_Room theClass_Room){
        theClass_Room.setClassroom_id(0);
        Class_Room dbClassroom = classRoomService.save(theClass_Room);
        return dbClassroom;
    }

    @PutMapping("/class_room")
    public Class_Room updateClassroom(@RequestBody Class_Room theClass_Room){
        Class_Room dbClassroom = classRoomService.save(theClass_Room);
        return dbClassroom;
    }

}
