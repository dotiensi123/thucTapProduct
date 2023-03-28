package com.example.ptit.service.impl;

import com.example.ptit.dto.AddressDto;
import com.example.ptit.entity.Address;
import com.example.ptit.exception.ApplicationException;
import com.example.ptit.repository.AddressRepository;
import com.example.ptit.service.s3.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    @Override
    public List<AddressDto> findALlAddress() throws Exception {
        List<Address> addresses = addressRepository.findAll();
        if(addresses.isEmpty()){
            throw new ApplicationException(400,"no data");
        }
        else return addresses.stream().map(address -> mapper.map(address,AddressDto.class)).toList();
    }

    @Override
    public void saveAddress(AddressDto addressDto) {
        Address address1 = addressRepository.findAddressesByAddressId(addressDto.getAddressId());
        if(address1==null){
            Address address = mapper.map(addressDto,Address.class);
            addressRepository.save(address);
        }
        else{
            throw new ApplicationException(400,"data exits");
        }
    }

    @Override
    public AddressDto findAddressByAddressId(String addressId) {
        Address address = addressRepository.findAddressesByAddressId(addressId);
        AddressDto addressDto = mapper.map(address,AddressDto.class);
        return addressDto;
    }

    @Transactional
    @Override
    public void deleteAddressByAddressId(String addressId) {
        Address address = addressRepository.findAddressesByAddressId(addressId);
        if(address!=null){
            addressRepository.deleteAddressByAddressId(addressId);
        }
        else{
            throw new ApplicationException(400,"data not exits");
        }
    }

}
