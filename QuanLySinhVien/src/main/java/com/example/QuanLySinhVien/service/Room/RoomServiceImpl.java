package com.example.QuanLySinhVien.service.Room;

import com.example.QuanLySinhVien.entity.Room;
import com.example.QuanLySinhVien.repo.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final RoomRepo roomRepo;
    @Override
    public Room findRoomById(String id) {
        return roomRepo.findRoomById(id);
    }

    @Override
    public List<Room> findAllRoom() {
        return roomRepo.findAll();
    }
}
