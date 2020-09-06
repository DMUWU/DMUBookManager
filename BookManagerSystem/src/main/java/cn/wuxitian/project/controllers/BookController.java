package cn.wuxitian.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	@RequestMapping("/")
	public String start() {
		System.out.println("0411");
		return "index";
		
	}
	@RequestMapping("/index")
	public String toIndex() {
		System.out.println("0411");
		return "index";
		
	}
	@RequestMapping("/books")
	public String toBooks() {

		return "book/books";
		
	}
	
}
