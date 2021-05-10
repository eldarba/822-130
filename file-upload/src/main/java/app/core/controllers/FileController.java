package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.core.services.FileStorageService;

@RestController
public class FileController {

	@Autowired
	private FileStorageService storageService;

	@PostMapping("uploadFile")
	public String uploadFile(@RequestParam MultipartFile file) {
		return this.storageService.storeFile(file);
	}

}
