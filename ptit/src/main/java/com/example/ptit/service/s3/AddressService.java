package com.example.ptit.service.s3;

import com.example.ptit.dto.AddressDto;
import com.example.ptit.entity.Address;

import java.util.List;

public interface AddressService {
    List<AddressDto> findALlAddress() throws Exception;
    public void saveAddress(AddressDto addressDto);
    public void deleteAddressByAddressId(String addressId);
    AddressDto findAddressByAddressId(String addressId);
//    void updateAddressByAddressId(String addressId);
}
