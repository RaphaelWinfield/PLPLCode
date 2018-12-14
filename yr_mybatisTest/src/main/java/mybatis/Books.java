package mybatis;


public class Books {

  private long idbooks;
  private String booksName;
  private String booksAuthor;


  public long getIdbooks() {
    return idbooks;
  }

  public void setIdbooks(long idbooks) {
    this.idbooks = idbooks;
  }


  public String getBooksName() {
    return booksName;
  }

  public void setBooksName(String booksName) {
    this.booksName = booksName;
  }


  public String getBooksAuthor() {
    return booksAuthor;
  }

  public void setBooksAuthor(String booksAuthor) {
    this.booksAuthor = booksAuthor;
  }

}
