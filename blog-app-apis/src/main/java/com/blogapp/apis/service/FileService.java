package com.blogapp.apis.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String uploadImage(String path, MultipartFile file) throws IOException;
	
	InputStream getResources(String path, String FileName) throws FileNotFoundException;
}
