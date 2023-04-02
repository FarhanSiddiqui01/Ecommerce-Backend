//package com.example.demo.controller;
//
//import com.example.demo.helper.FileUploadHelper;
//import com.example.demo.service.FileService;
//import org.apache.coyote.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//@RestController
//@RequestMapping("image")
//public class FileUploadController {
//
//    @Autowired
//    private FileService fileService;
//    @Value("${project.image}")
//    private  String path;
//
//    @PostMapping("/save/{productId}")
//    public ResponseEntity<ResponseImage> uploadPostImage(@RequestParam("image") MultipartFile image){
//
//        String fileName=this.fileService.uploadImage(path,image);
//        return null;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @Autowired
//    FileUploadHelper fileUploadHelper;
//
//    @PostMapping("/save")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile){
//        try{
//            if (multipartFile.isEmpty()){
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request not found");
//            }
// Boolean f = fileUploadHelper.uploadFile(multipartFile);
//            if (f){
//                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image")
//                        .path(multipartFile.getOriginalFilename()).toUriString());
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
//    }
//}
