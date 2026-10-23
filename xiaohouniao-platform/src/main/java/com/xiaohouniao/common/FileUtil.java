package com.xiaohouniao.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class FileUtil {

    public static String upload(MultipartFile file, String uploadPath) {
        if (file == null || file.isEmpty()) return null;
        try {
            String dateDir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            File dir = new File(uploadPath, dateDir);
            if (!dir.exists()) dir.mkdirs();

            String originalName = file.getOriginalFilename();
            String ext = "";
            if (originalName != null && originalName.contains(".")) {
                ext = originalName.substring(originalName.lastIndexOf("."));
            }
            String newName = UUID.randomUUID().toString().replace("-", "") + ext;
            File dest = new File(dir, newName);
            file.transferTo(dest);
            return "/uploads/" + dateDir + "/" + newName;
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败", e);
        }
    }
}
