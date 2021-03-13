package com.laioffer.authdeal.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class UploadUtils {
  public static void saveFile(String uploadDir, String fileName,
      MultipartFile multipartFile) throws IOException {
    Path uploadPath = Paths.get(uploadDir);

    if (!Files.exists(uploadPath)) {
      Files.createDirectories(uploadPath);
    }

    try (InputStream inputStream = multipartFile.getInputStream()) {
      Path filePath = uploadPath.resolve("");
      long ret = Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
      System.out.print(ret);
      System.out.print(filePath.toAbsolutePath());
    } catch (IOException ioe) {
      throw new IOException("Could not save image file: " + fileName, ioe);
    }
  }
}