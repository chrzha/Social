package com.chrzha.social.controller;


import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class DBBackupRestoreController {
	
	@RequestMapping("/backup")
	public @ResponseBody String backupDB(){
		String result = "success";
		
		try {
			Runtime rt = Runtime.getRuntime();
                        String cmd ="C:\\Windows\\mysqldump -hlocalhost -uroot -padmin uspto > C:\\uspto_backup.sql"; //一定要加 -h localhost(或是服务器IP地址)
                        rt.exec("cmd /c " + cmd);
                        System.out.println("备份成功!");
		} catch (IOException e) {
			System.out.println("备份失败!");
			e.printStackTrace();
		}

		return result;
	}
	
	@RequestMapping("/restoreDB")
	public @ResponseBody String restoreDB(){
		String result = "success";
		
		try {
			Runtime rt = Runtime.getRuntime();
                        String cmd ="mysql -h localhost -uroot -padmin uspto < C:\\uspto_backup.sql"; //一定要加 -h localhost(或是服务器IP地址)
                        rt.exec("cmd /k " + cmd);
                        System.out.println("还原成功!");
		} catch (IOException e) {
			System.out.println("还原失败!");
			e.printStackTrace();
		}

		return result;
	}

}
