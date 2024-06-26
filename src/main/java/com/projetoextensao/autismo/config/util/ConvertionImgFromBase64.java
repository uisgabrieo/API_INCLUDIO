package com.projetoextensao.autismo.config.util;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public class ConvertionImgFromBase64 {
	
	public static String convertFromBase64(MultipartFile multipartFile) {
		
		try {
			byte[] fileContent = multipartFile.getBytes();
			String encodedFile = Base64.getEncoder().encodeToString(fileContent);
			return encodedFile;
		} catch (IOException e) {
			e.getMessage();
		}
		return null;
	}
	
    public static String showImage(String encodedString) {
    	
    	String base64 = encodedString;
    	String URLImg = "data:image/png;base64," + base64;
    	
    	return URLImg;
    }
}
