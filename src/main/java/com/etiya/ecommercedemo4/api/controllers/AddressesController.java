package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IAddressService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo4.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"addresses")
public class AddressesController {

    private IAddressService addressService;

    @Autowired
    public AddressesController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAll")
    public List<Address> getAll(){
        return this.addressService.getAll();
    }

    @GetMapping("{id}")
    public Address getById(@PathVariable int id){
        return this.addressService.getById(id);
    }

    @GetMapping("/getByAdressType")
    public List<Address> getByAddressType(){
        return this.addressService.getByAddressType();
    }

    @PostMapping("/add")
    public AddAddressResponse add(@RequestBody @Valid AddAddressRequest addAddressRequest){
        return this.addressService.add(addAddressRequest);
    }

 /*   @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Country getCountryWithCityId(@PathVariable int id){
        return this.addressService.getCountryByCityId(id);
    }

  */
}
