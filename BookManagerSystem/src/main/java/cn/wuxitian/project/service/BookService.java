package cn.wuxitian.project.service;


import cn.wuxitian.project.dao.BookDAO;
import cn.wuxitian.project.model.Book;
import cn.wuxitian.project.model.enums.BookStatusEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nowcoder on 2018/08/04 下午3:41
 */
@Service
public class BookService {

  //数据访问层，mybatis框架
  @Autowired
  private BookDAO bookDAO;

  public List<Book> getAllBooks() {
    return bookDAO.selectAll();
  }

  public int addBooks(Book book) {
    return bookDAO.addBook(book);
  }

  public void deleteBooks(int id) {
    bookDAO.updateBookStatus(id, BookStatusEnum.DELETE.getValue());
  }

  public void recoverBooks(int id) {
    bookDAO.updateBookStatus(id, BookStatusEnum.NORMAL.getValue());
  }
}
