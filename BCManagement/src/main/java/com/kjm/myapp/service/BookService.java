package com.kjm.myapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kjm.myapp.model.Book;

@Service
public interface BookService {
     
	public List<Book> findAllList();

    public int insertBC(Book book);
    
    public int deleteByNum(int num);
    
    public int bcUpdateByNum(HashMap<String, Object> map);
    
    public Book getBctableByNum(int num);
 
}