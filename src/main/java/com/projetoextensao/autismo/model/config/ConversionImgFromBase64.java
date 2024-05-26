package com.projetoextensao.autismo.model.config;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class ConversionImgFromBase64 {
	
	public static String convertFromBase64(File file) {
		
		try {
			byte[] fileContent = FileUtils.readFileToByteArray(file);
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
