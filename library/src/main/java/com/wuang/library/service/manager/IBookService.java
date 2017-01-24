package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.Book;

public interface IBookService {

	public List<Book> findBook(Book t , int currPage , int pageSize); 
	public boolean updateOne(Book t);
	public boolean deleteOne(String id);
	public boolean insertOne(Book t);

	public Book findOne(String id);

}