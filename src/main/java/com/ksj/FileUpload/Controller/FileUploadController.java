package com.ksj.FileUpload.Controller;

import com.ksj.FileUpload.Service.FileUploadService;
import com.ksj.Utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/FileUpload")
public class FileUploadController {

    @Autowired
    FileUploadService service;

    @RequestMapping("/imgUpload")
    @ResponseBody
    public Map<String, Object> handleRequest(@RequestParam("fileList") MultipartFile[] files,
                                             HttpServletRequest request) throws Exception {



        Map<String, ArrayList> failMap = new HashMap<>();
        failMap.put("failMsg", new ArrayList<String>());

        if (files.length > 0) {
            for (MultipartFile file : files) {
                FileTool.uploadFile(file.getBytes(), "F:\\Upload\\Image", file.getOriginalFilename(), new FileUploadBlock() {
                    @Override
                    public void onSuccess(File file) {
                        String url = "htpp://" + request.getServerName() + ":" + request.getServerPort() + "/image/" + file.getName();
                        System.out.println("上传成功！\nurl为:" + url);
                    }

                    @Override
                    public void onFail(String fileName, String msg) {
                        failMap.get("failMsg").add(fileName + "上传失败，原因为：" + msg);
                    }
                });
            }
        }


        boolean allSuccess = failMap.get("failMsg").size() == 0;
        return WebTool.toResponseBody(allSuccess ? ResponseCode.OK : ResponseCode.REASON, null,
                allSuccess ? "" : failMap.get("failMsg").toString());
    }

    @RequestMapping("/getAllFactorys")
    @ResponseBody
    public Map<String,Object> getAllFactorys(){
        Integer userId = SecurityTool.getCurrentUser().getId();
        //查询当前用户下面有哪些厂区
        List<Map<String,Object>> factorys = service.getFactorysById(userId);

        return WebTool.toResponseBody(ResponseCode.OK, factorys, null);
    }

}
