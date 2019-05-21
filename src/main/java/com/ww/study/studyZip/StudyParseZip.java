package com.ww.study.studyZip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 学习解析.zip文件 获取其中的文件保存至服务器中
 *
 * @author: Sun
 * @create: 2019-04-30 11:59
 * @version: v1.0
 */
public class StudyParseZip {
    public static void main(String[] args) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(new File("/Users/sun/学习资料/测试上传.zip")));
        // 获取输入流中的下一个Entry
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        // 判断是否为空
        while(zipEntry != null){
            zipEntry = zipInputStream.getNextEntry();
        }

    }
}
