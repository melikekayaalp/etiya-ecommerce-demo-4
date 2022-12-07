package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICityService;
import com.etiya.ecommercedemo4.business.abstracts.ITownService;
import com.etiya.ecommercedemo4.business.dtos.request.town.AddTownRequest;
import com.etiya.ecommercedemo4.business.dtos.response.town.AddTownResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.Town;
import com.etiya.ecommercedemo4.repository.ICityRepository;
import com.etiya.ecommercedemo4.repository.ITownRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownManager implements ITownService {
private ModelMapperService modelMapper;
    private ITownRepository townRepository;
    private ICityService cityService;

    public TownManager(ITownRepository townRepository,ICityService cityService,ModelMapperService modelMapper) {
        this.townRepository = townRepository;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Town> getAll() {
        return this.townRepository.findAll();
    }

    @Override
    public AddTownResponse add(AddTownRequest addTownRequest) {


        Town town = this.modelMapper.forRequest().map(addTownRequest,Town.class);
        Town savedTown = this.townRepository.save(town);
        AddTownResponse response =this.modelMapper.forResponse().map(savedTown,AddTownResponse.class);
        return response;

         /*Town town = new Town();
        town.setCity(this.cityService.getById((addTownRequest.getCityId())));
        town.setName(addTownRequest.getName());*/

        /*AddTownResponse response = new AddTownResponse();
        response.setId(savedTown.getId());
        response.setName(savedTown.getName());
        response.setCityName(savedTown.getCity().getName()); */

    }

    @Override
    public Town getById(int id) {
        return this.townRepository.findById(id).orElseThrow();
    }
}
