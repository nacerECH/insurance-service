package com.mapersive.insuranceservice.services;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface IFileService {

     void init();
     String save(MultipartFile file);

    Resource load(String filename);
}