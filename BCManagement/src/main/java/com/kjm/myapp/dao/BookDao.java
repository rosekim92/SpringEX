package com.kjm.myapp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kjm.myapp.model.Book;

@Repository("bookDao")
public class BookDao {
    
    @Autowired
    private SqlSession sqlSession;
 
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
 
    public List<Book> findAllList() {
         
        return sqlSession.selectList("findAllList");
    }
 
    public int insertBC(Book book){
    	System.out.println("dao : "+book.getCompany());
    	
    	return sqlSession.insert("com.kjm.mybatis.bc.insertBC",book);
    }
 
    public int deleteByNum(int num){
    	return sqlSession.delete("deleteByNum", num);
    }

    public int bcUpdateByNum(HashMap<String, Object> map){
    	return sqlSession.update("bcUpdateByNum", map);
    }
    
    public Book getBctableByNum(int num){
    	return sqlSession.selectOne("getBctableByNum", num);
    }
}
