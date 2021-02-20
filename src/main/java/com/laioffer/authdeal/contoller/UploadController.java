package com.laioffer.authdeal.contoller;

import com.laioffer.authdeal.Util.FileUploadUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping(value ="/upload", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestParam("image") MultipartFile multipartFile) throws IOException {

        System.out.println(multipartFile.toString());

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        String uploadDir = "/image/" + multipartFile.getOriginalFilename();
        //String uploadDir = "/image_upload/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }
}