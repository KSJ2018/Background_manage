package com.ksj.FileUpload.Service.Impl;

import com.ksj.FileUpload.Mapper.FileUploadMapper;
import com.ksj.FileUpload.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    FileUploadMapper mapper;

    @Override
    public List<Map<String, Object>> getFactorysById(Integer id) {
        return mapper.getFactorysById(id);
    }
}
