package com.little.pay.coding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class FileParserController {
	
	@GetMapping("/user/input")
	public void handleUserInputFile() {
		
	}

}
