package cn.wuxitian.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wuxitian.project.model.Book;
import cn.wuxitian.project.model.User;
import cn.wuxitian.project.service.BookService;
import cn.wuxitian.project.service.HostHolder;

@Controller//当前是控制层 url 127.0.0.1《==》localhost  http://127.0.0.1:8080/BookManager/
public class BookController {
	  @Autowired
	  private BookService bookService;

	  @Autowired
	  private HostHolder hostHolder;

	  @RequestMapping(path = {"index"}, method = {RequestMethod.GET})
	  public String bookList(Model model) {

	    User host = hostHolder.getUser();
	    if (host != null) {
	      model.addAttribute("host", host);
	    }
	    //装载book数据，放到model里面
	    loadAllBooksView(model);
	    return "book/books"; //templates/ + book/books + .html   

	  }

	  @RequestMapping(path = {"/books/add"}, method = {RequestMethod.GET})
	  public String addBook() {
	    return "book/addbook";
	  }


	  @RequestMapping(path = {"/books/add/do"}, method = {RequestMethod.POST})
	  public String doAddBook(
	      @RequestParam("name") String name,
	      @RequestParam("author") String author,
	      @RequestParam("price") String price
	  ) {

	    Book book = new Book();
	    book.setName(name);
	    book.setAuthor(author);
	    book.setPrice(price);
	    bookService.addBooks(book);

	    return "redirect:/index";

	  }

	  @RequestMapping(path = {"/books/{bookId:[0-9]+}/delete"}, method = {RequestMethod.GET})
	  public String deleteBook(
	      @PathVariable("bookId") int bookId
	  ) {

	    bookService.deleteBooks(bookId);
	    return "redirect:/index";

	  }

	  @RequestMapping(path = {"/books/{bookId:[0-9]+}/recover"}, method = {RequestMethod.GET})
	  public String recoverBook(
	      @PathVariable("bookId") int bookId
	  ) {

	    bookService.recoverBooks(bookId);
	    return "redirect:/index";

	  }

	  /**
	   * 为model加载所有的book
	   */
	  private void loadAllBooksView(Model model) {
	    model.addAttribute("books", bookService.getAllBooks());
	  }
	
}
