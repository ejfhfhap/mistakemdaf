package com.main.branche.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	
	
	//file hdd에 삭제
	public boolean fileDelete(String path,String fileName)throws Exception {
		File file = new File(path, fileName);
		
		return file.delete();
	}
	
	// file을 hdd에 저장
	public String fileSave(MultipartFile multipartFile, String path)throws Exception{
		// 1. 파일을 어디에 저장 할지
		// /resources/upload/bankBook/...
		// 톰캣 파일에서 자동으로 압축푸는 webapp까지가 루트
		
		//2. 저장관리는 운영체제가 담당 Application이 운영체제랑 통신함
		File file = new File(path);
		
		// 존재하지 않으면 폴더를 생성
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 파일을 저장하기 중복되면 안됨
//		Calendar ca = Calendar.getInstance();
//		ca.getTimeInMillis();
		
		// 확장자 추가
		String name = UUID.randomUUID().toString();
		name = name + "_" + multipartFile.getOriginalFilename();
		
		//OrginalName에서 substring이용해서 추출
	//	System.out.println(name);
		
		// 5. 파일 저장 두가지 방법
		file = new File(file, name);
		
		//1) multifile객체의 transferTo 메서드 사용
		multipartFile.transferTo(file);
		
		//2) Spring API FileCopyUtis 객체의 copy 메서드 사용
	//	FileCopyUtils.copy(multipartFile.getBytes(), file);
		return name;
	}
}
