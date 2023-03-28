package com.example.ptit.controller;

import com.example.ptit.entity.Instruction;
import com.example.ptit.service.s3.InstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instruction")
@RequiredArgsConstructor
public class InstructionController {
    private final InstructionService instructionService;

    @PostMapping()
    public ResponseEntity<?> saveInstruction(@RequestBody Instruction instruction){
        try{
            instructionService.saveInstruction(instruction);
            return new ResponseEntity<>("save ok",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
