package com.example.QuanLySinhVien.repo;

import com.example.QuanLySinhVien.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room,String> {
    Room findRoomById(String id);
}
