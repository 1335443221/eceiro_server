package com.timber.eceiro.common.utils;
				import java.io.File;
				import java.io.IOException;
			
				import java.io.FileInputStream;
				import java.io.FileOutputStream;

				//获取文件目录并复制文件
				public class AudioSuffix {
				public static String audioSuffix(String url)  throws IOException{
				String url1 = "../../data/resource/"+url; //目标文件
				if(url.lastIndexOf(".")!=-1){
				String str= url.substring(0, url.lastIndexOf("."));
				String url2 = "../../data/resource/work/Tomcat/localhost/ROOT/"+str+".mp3"; //要赋值的路径及文件名
				File file = new File(url2);
				if (file.getParentFile() != null && !file.getParentFile().exists()) {
				    file.getParentFile().mkdirs();
				}
				FileInputStream in = new FileInputStream(new File(url1));
				FileOutputStream out = new FileOutputStream(new File(url2));
				byte[] buff = new byte[10485760]; //限制大小
				int n = 0;
				while ((n = in.read(buff)) != -1) {
				       out.write(buff, 0, n);
				}
				out.flush();
				in.close();
				out.close();
				return "work/Tomcat/localhost/ROOT/"+str+".mp3";
				}
				return "";
				}
				
				}
				
				
