package com.mapersive.insuranceservice.utils;

import com.mapersive.insuranceservice.dtos.InsuranceDto;
import com.mapersive.insuranceservice.entities.Insurance;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DtoMapper {
    public InsuranceDto toInsurranceDto(Insurance myObject){
        InsuranceDto myObjectDto = new InsuranceDto();
        BeanUtils.copyProperties(myObject, myObjectDto);
        return  myObjectDto;
    }

    public Insurance toInsurranceEntity(InsuranceDto myObjectDto){
        Insurance myObject = new Insurance();
        BeanUtils.copyProperties(myObjectDto,myObject);
        return  myObject;
    }
}
