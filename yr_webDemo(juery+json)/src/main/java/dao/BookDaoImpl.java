package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import util.DBconn;

public class BookDaoImpl implements IBookDAO {

	@Override
	public List<Book> getUserAll() {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from books");
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("idbooks"));
				book.setName(rs.getString("booksName"));
				book.setAuthor(rs.getString("booksAuthor"));
				list.add(book);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		DBconn.init();
		String sql = "delete from books where idbooks="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	@Override
	public boolean update(int id, String name, String author) {
		// TODO Auto-generated method stub
		boolean flag = false;
		DBconn.init();
		String sql ="update books set booksName ='"+name
				+"', booksAuthor ='"+author
				+"' where idbooks = "+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
}
