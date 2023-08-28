package com.mapersive.insuranceservice.services;

import com.mapersive.insuranceservice.dtos.InsuranceDto;
import com.mapersive.insuranceservice.exceptions.FileNotSupportedException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IInsuranceService {

    List<InsuranceDto> importInsurranceData(MultipartFile file) throws IOException, FileNotSupportedException;
    List<InsuranceDto> loadInsurranceData(List<InsuranceDto> insuranceDtos);
    InsuranceDto getInsurranceByPolicyId(Long Policy_id);
    List<InsuranceDto> getAllInsurrances();
    List<InsuranceDto> getInsurrancesByPagination(int page, int size);


}
