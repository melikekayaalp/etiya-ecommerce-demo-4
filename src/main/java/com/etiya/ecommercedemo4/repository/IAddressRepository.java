package com.etiya.ecommercedemo4.repository;

import com.etiya.ecommercedemo4.entities.concretes.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address,Integer> {

    //join denenecek.Burası tamamlanmadı. Endpointi oluşturuldu. Where condition denenebilir.
    @Query("Select a from Address a JOIN a.addressType")
    List<Address> findByAddressType();
    @Query("Select p from Product as p WHERE name = :name")
    Product findByName(String name);

    @Query("select co from City c inner join c.country co where c.name = :name")
    Country findCountryByCityName(String name);

    @Query("select c from Town t inner join t.city c where t.name = :name")
    City findCityByTownName(String name);

    @Query("select t from District d inner join d.town t where d.name =:name")
    Town findTownByDistrictName(String name);

    @Query("select d from Street s inner join s.district d where s.id =:id")
    District findDistrictByStreetId(int id);
}
