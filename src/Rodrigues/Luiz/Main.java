package Rodrigues.Luiz;

import Rodrigues.Luiz.DAO.ConnectionDAO;
import Rodrigues.Luiz.DAO.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        Product cookie = new Product("cookie", "un",20.0, 40.0);

        try(Connection connection = new ConnectionDAO().connect()) {
            ProductDAO productDao = new ProductDAO(connection);

//            productDao.save(cookie);
//
//            List<Product> listOfProducts = productDao.list();
//            listOfProducts.forEach(System.out::println);
            productDao.searchName("il");

            productDao.update(20.0, 2);

            productDao.searchName("milk");

            productDao.searchId(1);
        }

    }
}
