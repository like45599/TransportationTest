package com.sdjt.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/traffic")
public class FileUploadController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String originalFileName = file.getOriginalFilename();
            Path path = Paths.get(uploadDir + originalFileName);

            // Check if file already exists, if yes, append a UUID to its name
            if (Files.exists(path)) {
                String newFileName = UUID.randomUUID().toString() + "_" + originalFileName;
                path = Paths.get(uploadDir + newFileName);
            }

            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + path.getFileName() + "'");

            return ResponseEntity.ok("File uploaded successfully: " + path.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file: " + file.getOriginalFilename());
        }
    }
}
