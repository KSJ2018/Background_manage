package com.ksj.Utils;

import java.io.File;

public interface FileUploadBlock {
    void onSuccess(File file);
    void onFail(String fileName,String msg);
}
