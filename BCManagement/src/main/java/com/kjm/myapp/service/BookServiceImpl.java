package com.kjm.myapp.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.kjm.myapp.dao.BookDao;
import com.kjm.myapp.model.Book;
 
@Service
public class BookServiceImpl implements BookService {
     
//    @Resource(name="bookDao")
    @Autowired
    private BookDao bookDao;
    
    public void setBookDao(BookDao bookDao){
    	this.bookDao = bookDao;
    }
 
    @Override
    public List<Book> findAllList() {
        return bookDao.findAllList();
    }
 
    @Override
    public int insertBC(Book book){
    	System.out.println("service : " + book.getCompany());
    	return bookDao.insertBC(book);
    }

	@Override
	public int deleteByNum(int num) {
		return bookDao.deleteByNum(num);
		
	}

	@Override
	public int bcUpdateByNum(HashMap<String, Object> map) {
		return bookDao.bcUpdateByNum(map);
	}

	@Override
	public Book getBctableByNum(int num) {
		return bookDao.getBctableByNum(num);
	}
    
}