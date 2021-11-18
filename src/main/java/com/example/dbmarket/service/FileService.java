package com.example.dbmarket.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    public File save(MultipartFile photo, String path);
}
