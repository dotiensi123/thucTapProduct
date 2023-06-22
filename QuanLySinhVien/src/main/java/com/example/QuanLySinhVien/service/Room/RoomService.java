package com.example.QuanLySinhVien.service.Room;

import com.example.QuanLySinhVien.entity.Room;

import java.util.List;

public interface RoomService {
    Room findRoomById(String id);
    List<Room> findAllRoom();
}
