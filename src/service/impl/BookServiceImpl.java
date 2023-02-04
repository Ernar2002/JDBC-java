package service.impl;

import db.IDB;
import models.Book;
import models.Student;
import service.interfaces.IBookService;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookServiceImpl implements IBookService {
    private final IDB db;

    public BookServiceImpl(IDB db){
        this.db = db;
    }

    @Override
    public void save(Book book) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO books(title,author,isbn,year,quantity) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setString(3, book.getIsbn());
            st.setInt(4, book.getYear());
            st.setInt(5, book.getQuantity());

            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Book getById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,title,author,isbn,year,quantity FROM books WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getInt("year"),
                        rs.getInt("quantity"));

                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,title,author,isbn,year,quantity FROM books";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getInt("year"),
                        rs.getInt("quantity"));

                books.add(book);
            }

            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Book getByISBN(String isbn) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,title,author,isbn,year,quantity FROM books WHERE isbn=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, isbn);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getInt("year"),
                        rs.getInt("quantity"));

                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
