package com.example.demo.service.impl;

import com.example.demo.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String name= file.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();
        String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));
        String filePath = path+ File.separator+fileName1;


        File f = new File(path);

        if (!f.exists()){
            f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));
        System.out.println(Paths.get(filePath));
        return name;

    }

    @Override
    public InputStream getResources(String path, String fileName) throws FileNotFoundException {
        String fullPath=path+File.separator+fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }
}
