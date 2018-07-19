package com.ksj.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class FileTool {
    public static void uploadFile(byte[] file, String filePath, String fileName, FileUploadBlock block) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String newName = String.format("%s%s", UUID.randomUUID().toString(), suffix);

        File uploadFile = new File(filePath + File.separator + newName);
        if (uploadFile.exists()) {
            block.onFail(fileName, "文件已存在！");
            return;
        }

        FileOutputStream out = new FileOutputStream(filePath + File.separator + newName);
        out.write(file);
        out.flush();
        out.close();

        if (uploadFile.length() > 0) {
            block.onSuccess(uploadFile);
        } else {
            block.onFail(fileName, "文件可能为空！");
        }
    }
}
