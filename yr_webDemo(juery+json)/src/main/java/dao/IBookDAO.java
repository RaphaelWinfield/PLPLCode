package dao;

import java.util.List;

import entity.Book;

public interface IBookDAO {
	
	public List<Book> getUserAll();//返回用户信息集合
	public boolean delete(int id) ;//根据id删除用户
	public boolean update(int id,String name, String author);//更新用户信息

}
