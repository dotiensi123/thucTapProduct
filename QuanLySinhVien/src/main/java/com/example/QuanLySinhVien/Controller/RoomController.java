package com.example.QuanLySinhVien.Controller;

import com.example.QuanLySinhVien.entity.Room;
import com.example.QuanLySinhVien.service.Room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    @GetMapping("")
    public ResponseEntity<Object> findAllRoom(){
        return new ResponseEntity<>(roomService.findAllRoom(),HttpStatusCode.valueOf(200));
    }
    @GetMapping("/find-room-by-id")
    public ResponseEntity<Object> findRoomById(@RequestParam String id){
        Room room = roomService.findRoomById(id);
        if(room ==null){
            return new ResponseEntity<>("", HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(room, HttpStatusCode.valueOf(200));
    }
}
