package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public File save(MultipartFile photo, String path) {
        File dir = new File("");
        dir = new File(dir.getAbsolutePath() + path);

        if (!dir.exists())
            dir.mkdirs();
        try {
            String filename = photo.getOriginalFilename();
            File savefile = new File(dir + "/" + filename);
            photo.transferTo(savefile);
            return savefile;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
