package com.example.demo.exceptionhandler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	
	private int statusCode;
	private Date time;
	private String message;
	private String description;
	
}
