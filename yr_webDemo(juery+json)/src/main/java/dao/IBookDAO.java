package dao;

import java.util.List;

import entity.Book;

public interface IBookDAO {
	
	public List<Book> getUserAll();//�����û���Ϣ����
	public boolean delete(int id) ;//����idɾ���û�
	public boolean update(int id,String name, String author);//�����û���Ϣ

}
