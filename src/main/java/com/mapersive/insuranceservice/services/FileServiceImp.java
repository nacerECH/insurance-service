package com.mapersive.insuranceservice.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@Service
public class FileServiceImp implements  IFileService{

    private final Path root = Paths.get("src/main/resources");

    @Override
    public void init() {

        try {
            Files.createDirectories(root);   // create folder resource
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }

    }

    @Override
    public String save(MultipartFile file) {

        init();
        String stored_filename;

        try {
            String filename = file.getOriginalFilename();
            Random rd = new Random();
            stored_filename = String.valueOf(System.currentTimeMillis())+ "_"+rd.nextInt(100)+filename;
            Files.copy(file.getInputStream(), this.root.resolve(stored_filename ));

        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }

        return stored_filename;
    }

    @Override
    public Resource load(String filename) {

        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
