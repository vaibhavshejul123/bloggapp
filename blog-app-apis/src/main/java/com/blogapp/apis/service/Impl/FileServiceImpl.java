package com.blogapp.apis.service.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blogapp.apis.service.FileService;
@Service
public class FileServiceImpl implements FileService{


	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
//		file name
		String name=file.getOriginalFilename();
//		abc.png
		
//		random name generated file 
		String randomID=UUID.randomUUID().toString();
		String fileName1=randomID.concat(name.substring(name.lastIndexOf(".")));
		
		String filePath=path + File.separator + fileName1;
		
//		create folder if not created
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
//		file copy
		
		Files.copy(file.getInputStream(),Paths.get(filePath));
		return null;
	}

	@Override
	public InputStream getResources(String path, String fileName) throws FileNotFoundException {
		String fullPath=path + File.separator + fileName;
		InputStream is=new FileInputStream(fullPath);
//		db logic to return inputStream
	
		return is;
	}

}
