package com.example.QuanLySinhVien.Controller;

import com.example.QuanLySinhVien.dto.SectionDto;
import com.example.QuanLySinhVien.entity.Section;
import com.example.QuanLySinhVien.service.Section.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/section")
@RequiredArgsConstructor
public class SectionController {
    private final SectionService sectionService;

    @GetMapping("")
    public ResponseEntity<Object> findAllSection(){
        return new ResponseEntity<>(sectionService.findAllSection(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find-section-by-id")
    public ResponseEntity<Object> findSectionById(@RequestParam String id){
        Section section = sectionService.findSectionById(id);
        if(section == null){
            return new ResponseEntity<>("", HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(section,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find-section-by-shiftId-and-roomId")
    public ResponseEntity<Object> findSectionByShiftIdAndRoomId(@RequestParam int shiftId, String roomId){
        Section section = sectionService.findSectionByShiftIdAndRoomId(shiftId,roomId);
        if(section== null){
            return new ResponseEntity<>("",HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(section, HttpStatusCode.valueOf(200));
    }


    @PostMapping("/create")
    public ResponseEntity<Object> addSection(@RequestBody SectionDto sectionDto){
        return new ResponseEntity<>(sectionService.addSection(sectionDto),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find-all-sections-by-subject-id")
    public ResponseEntity<Object>  findAllSectionBySubjectId(@RequestParam String id){
        return new ResponseEntity<>(sectionService.findAllBySubjectId(id),HttpStatusCode.valueOf(200));
    }
}
