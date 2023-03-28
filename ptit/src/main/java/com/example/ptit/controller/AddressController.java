package com.example.ptit.controller;

import com.example.ptit.dto.AddressDto;
import com.example.ptit.dto.ResultDto;
import com.example.ptit.exception.ApplicationException;
import com.example.ptit.service.s3.AddressService;
import com.example.ptit.service.s3.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final StudentService studentService;
    private String addressId;

    @GetMapping()
    public ResponseEntity<Object> findAllAddress() throws Exception {
        try {
            return new ResponseEntity<>(addressService.findALlAddress(), HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Object> saveAddress(@RequestBody AddressDto addressDto){
        try{
            addressService.saveAddress(addressDto);
            return new ResponseEntity<>("created",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Object> findAddressByAddressId(@PathVariable("addressId") String addressId){
        try{
            AddressDto addressDto = addressService.findAddressByAddressId(addressId);
            return  new ResponseEntity<>(addressDto,HttpStatus.OK);
        }
        catch(Exception e){
            ResultDto resultDto = new ResultDto("address not found");
            return new ResponseEntity<>(resultDto,HttpStatus.OK);
        }
    }

    /**
     * @param addressId
     * @return danh sách các student ở địa chỉ addressId
     */
    @GetMapping("/{addressId}/students")
    public ResponseEntity<Object> findStudentInAddress(@PathVariable("addressId") String addressId){
        ResultDto resultDto = new ResultDto();
        try{
            AddressDto addressDto = addressService.findAddressByAddressId(addressId);
            addressDto.setStudentDtos(studentService.findStudentByAddressId(addressId));
            return new ResponseEntity<>(addressDto,HttpStatus.OK);
        }catch(Exception e){
            resultDto.setMessage(e.getMessage());
            return new ResponseEntity<>(resultDto,HttpStatus.OK);
        }
    }

    /**
     * @param addressId
     * @return  xóa address
     */
    @DeleteMapping("/{addressId}")
    public ResponseEntity<Object> deleteAddressByAddressId(@PathVariable("addressId") String addressId){
        try{
            addressService.deleteAddressByAddressId(addressId);
            return new ResponseEntity<>("delete ok",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
