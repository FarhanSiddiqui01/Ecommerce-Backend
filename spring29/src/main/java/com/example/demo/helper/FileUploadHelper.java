//package com.example.demo.helper;
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//@Component
//
//public class FileUploadHelper {
//
//    public final String upload_Dir = new ClassPathResource("static/images/").getFile().getAbsolutePath();
//public FileUploadHelper() throws IOException {
//
//}
//    public  Boolean uploadFile(MultipartFile multipartFile){
//
//        Boolean f = false;
//
//        try{
////            Files.copy(multipartFile.getInputStream(), Path.get(upload_Dir+ File.separator+multipartFile.getOriginalFilename()))
//            Files.copy(multipartFile.getInputStream(),
//                    Paths.get(upload_Dir+File.separator+multipartFile.getOriginalFilename()),
//                    StandardCopyOption.REPLACE_EXISTING);
//        f=true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return f;
//    }
//
//
//}
