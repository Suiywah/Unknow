/**
 * 
 */
package com.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author feipt
 *
 */
@Controller
public class AccessController {
	@RequestMapping("/")
	public String indexPage(Model model) {
		return "firstPage";
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String errorHandler() {
		return "error";
	}
}
