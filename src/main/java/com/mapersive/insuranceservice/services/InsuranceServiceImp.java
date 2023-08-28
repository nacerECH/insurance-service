package com.mapersive.insuranceservice.services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapersive.insuranceservice.dtos.InsuranceDto;
import com.mapersive.insuranceservice.entities.Insurance;
import com.mapersive.insuranceservice.exceptions.FileNotSupportedException;
import com.mapersive.insuranceservice.repositories.InsuranceRepository;
import com.mapersive.insuranceservice.utils.DtoMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceServiceImp implements IInsuranceService {
    @Autowired
    private IFileService fileService;
    @Autowired
    private DtoMapper dtoMapper;

    @Autowired
    private InsuranceRepository insuranceRepository;
    @Override
    public List<InsuranceDto> importInsurranceData(MultipartFile file) throws IOException, FileNotSupportedException {
        if( FilenameUtils.getExtension(file.getOriginalFilename()).equals("json")) {
            fileService.save(file);
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                TypeReference<List<InsuranceDto>> typeReference = new TypeReference<>() {
                };
                List<InsuranceDto> insuranceDtos = mapper.readValue(file.getInputStream(), typeReference);
                List<Insurance> insurances = insuranceDtos.stream().map(ins -> dtoMapper.toInsurranceEntity(ins)).collect(Collectors.toList());
                return insurances.stream().map(insurance -> insuranceRepository.save(insurance)).collect(Collectors.toList()).stream().map(ins -> dtoMapper.toInsurranceDto(ins)).collect(Collectors.toList());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {

            throw new FileNotSupportedException("No json file");

        }
        return null;
    }

    @Override
    public List<InsuranceDto> loadInsurranceData(List<InsuranceDto> insuranceDtos) {
        List<Insurance> insurances= insuranceDtos.stream().map(ins->dtoMapper.toInsurranceEntity(ins)).collect(Collectors.toList());
        return insurances.stream().map(insurance -> insuranceRepository.save(insurance)).collect(Collectors.toList()).stream().map(ins->dtoMapper.toInsurranceDto(ins)).collect(Collectors.toList());
    }

    @Override
    public InsuranceDto getInsurranceByPolicyId(Long Policy_id) {
        return this.dtoMapper.toInsurranceDto(insuranceRepository.findById(Policy_id).orElse(null));
    }

    @Override
    public List<InsuranceDto> getAllInsurrances() {
        return insuranceRepository.findAll().stream().map(insurance -> dtoMapper.toInsurranceDto(insurance)).collect(Collectors.toList());
    }

    @Override
    public List<InsuranceDto> getInsurrancesByPagination(int page, int size) {
        return this.insuranceRepository.getInsurancesByPagination(PageRequest.of(page, size)).toList().stream().map(insurance -> dtoMapper.toInsurranceDto(insurance)).collect(Collectors.toList());
    }

}
