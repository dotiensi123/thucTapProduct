package com.example.ptit.repository;

import com.example.ptit.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,String> {
//    @Query(value = "select * from address where address_id=?1",nativeQuery = true)
//    Address findAddressesByAddressId(String addressId);

    Address findAddressesByAddressId(String addressId);

    void deleteAddressByAddressId(String addressId);
}
