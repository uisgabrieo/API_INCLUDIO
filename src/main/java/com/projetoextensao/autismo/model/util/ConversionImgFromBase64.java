package com.projetoextensao.autismo.model.util;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ConversionImgFromBase64 {
	
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
	
    public static File convertToBase64(String encodedString, String outputFileName) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            File outputFile = new File(outputFileName);
            FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
            
            return outputFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
