/**
 * 
 */
package com.timber.eceiro.common.utils;

/**
 * @author 李旭日
 *
 */
import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @author gaoxuyang
 *
 */
public class FileUtils {

    /**
     * 
     * @param file 文件
     * @param path   文件存放路径
     * @param fileName 原文件名
     * @return
     */
     public static boolean upload(MultipartFile file, String path){


            File dest = new File(path);

            try {
                //保存文件
                file.transferTo(dest);
                return true;
            } catch (IllegalStateException e) {             
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        }
}
