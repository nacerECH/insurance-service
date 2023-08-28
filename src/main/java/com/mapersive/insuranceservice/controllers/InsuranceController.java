package com.mapersive.insuranceservice.controllers;


import com.mapersive.insuranceservice.dtos.InsuranceDto;
import com.mapersive.insuranceservice.services.IInsuranceService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/insurrance-service/api/insurrance")
@CrossOrigin("*")
public class InsuranceController {

    @Autowired
    IInsuranceService insuranceService;

    @PostMapping("import")
    public List<InsuranceDto> importInsurranceData (@Valid @RequestPart("file") MultipartFile file) throws IOException {
        return this.insuranceService.importInsurranceData(file);
    }

    @PostMapping("")
    public List<InsuranceDto> saveInsurance(@Valid @RequestBody List<InsuranceDto> insuranceDtos ) throws IOException {
        return this.insuranceService.loadInsurranceData(insuranceDtos);
    }

    @GetMapping("insurance")
    public InsuranceDto getInsuranceById(@Valid @RequestParam("PolicyId") Long policyId ) throws IOException {
        return this.insuranceService.getInsurranceByPolicyId(policyId);
    }

    @GetMapping("all")
    public List<InsuranceDto> getAllInsurance() throws IOException {
        return this.insuranceService.getAllInsurrances();
    }

    @GetMapping("")
    public List<InsuranceDto> getInsuranceByPagination(@Valid @RequestParam("page") int page, @Valid @RequestParam("size") int size) throws IOException {
        return this.insuranceService.getInsurrancesByPagination(page,size);
    }

}
