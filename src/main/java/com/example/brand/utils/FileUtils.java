package com.example.brand.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileUtils {
    @Value("${folder.image}")
    String folderImageFile;

    public String savefile(MultipartFile multipartFile) throws Exception {

        InputStream initialStream = multipartFile.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        String namefile = System.currentTimeMillis()
                + multipartFile.getOriginalFilename();
        File targetFile = new File(folderImageFile  + namefile);

        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(buffer);
        }

        return namefile;
    }

}
