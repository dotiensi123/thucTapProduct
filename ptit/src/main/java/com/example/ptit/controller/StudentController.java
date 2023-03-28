package com.example.ptit.controller;

import com.example.ptit.dto.ResultDto;
import com.example.ptit.dto.StudentDto;
import com.example.ptit.entity.Student;
import com.example.ptit.service.s3.AddressService;
import com.example.ptit.service.s3.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final ModelMapper mapper;
    private final AddressService addressService;
    // get all student
    @GetMapping
    public ResponseEntity<Object> findAllStudent(){
        try {
            return new ResponseEntity<>(studentService.findAllStudent(), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    // created a student
    @PostMapping()
    public ResponseEntity<Object> saveStudent(@RequestBody StudentDto studentDto){
        ResultDto resultDto = new ResultDto();
        try{
            StudentDto studentDto1 = studentService.findStudentByStudentCode(studentDto.getStudentCode());
            resultDto.setMessage("student is exits");
        }
        catch(Exception e){
            resultDto.setMessage("created ok");
            studentService.saveStudent(studentDto);
        }
        return new ResponseEntity<>(resultDto,HttpStatus.CREATED);
    }

    /**
     * @param studentCode
     * @return
     */
    // get student by True studentCode
    @GetMapping("/{studentCode}/full")
    public ResponseEntity<Object> findStudentByStudentCode(@PathVariable("studentCode") String studentCode){
        try{
            StudentDto studentDto = studentService.findStudentByStudentCode(studentCode);
            return new ResponseEntity<>(studentDto,HttpStatus.OK);
        }
        catch (Exception e){
            ResultDto resultDto = new ResultDto();
            resultDto.setMessage("student not exit");
            return new ResponseEntity<>(resultDto,HttpStatus.OK);
        }

    }
    // delete student by studentCode
    @DeleteMapping("/{studentCode}")
    public ResponseEntity<Object> deleteStudentByStudentCode(@PathVariable("studentCode") String studentCode){
        ResultDto resultDto = new ResultDto();
        try {
            StudentDto studentDto = studentService.findStudentByStudentCode(studentCode);
            resultDto.setMessage("delete ok");
            Student student = mapper.map(studentDto, Student.class);
            studentService.deleteStudent(student);
        }
        catch(Exception e){
            resultDto.setMessage("Student not found");
        }
        return new ResponseEntity<>(resultDto,HttpStatus.OK);
    }
    //update student by studentCode
    @PutMapping("/{studentCode}")
    public ResponseEntity<Object> updateStudent(@PathVariable("studentCode") String studentCode,
                                            @RequestParam(required = false) String studentName,
                                            @RequestParam(required = false) String addresId){
        ResultDto resultDto = new ResultDto();
        try{
            StudentDto studentDto = studentService.findStudentByStudentCode(studentCode);
            if(studentName!=null){
                studentDto.setStudentName(studentName);
            }
            if(addresId!=null){
                studentDto.setAddressId(addresId);
            }
            studentService.updateStudent(studentDto);
            resultDto.setMessage("update ok");
        }catch (Exception e){
            resultDto.setMessage("student not found");
        }
        return new ResponseEntity<>(resultDto,HttpStatus.OK);
    }
    // get address of student by student Code
    @GetMapping("/{studentCode}/address")
    public ResponseEntity<Object> getAllAddressOfStudentCode(@PathVariable("studentCode")String studentCode){
        ResultDto resultDto = new ResultDto();
        try{
            StudentDto  studentDto = studentService.findStudentByStudentCode(studentCode);
            studentDto.setAddressDto(addressService.findAddressByAddressId(studentDto.getAddressId()));
            return new ResponseEntity<>(studentDto,HttpStatus.OK);
        }catch(Exception e){
            resultDto.setMessage("student or address not found");
            return new ResponseEntity<>(resultDto,HttpStatus.OK);
        }
    }

    /**
     * @param studentCode
     * @return status in result dto
     *
     */
    // get student by name start with
    @GetMapping("/{studentCode}")
    public ResponseEntity<Object> findStudentByNameStartWith(@PathVariable("studentCode") String studentCode){
        try{
            List<StudentDto> studentDtos = studentService.findStudentByNameStartWith(studentCode);
            return new ResponseEntity<>(studentDtos,HttpStatus.OK);
        }
        catch (Exception e){
            ResultDto resultDto = new ResultDto();
            resultDto.setMessage("student not exit");
            return new ResponseEntity<>(resultDto,HttpStatus.OK);
        }

    }

    // get all courses of student take part in

}
