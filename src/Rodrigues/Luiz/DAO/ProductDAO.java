package Rodrigues.Luiz.DAO;

import Rodrigues.Luiz.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private final Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Product product) throws SQLException {
        String sql = "INSERT INTO PRODUCT (NAME, UNIT, QUANTITY, MONEYSPENT) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, product.getName());
            pstm.setString(2, product.getUnit());
            pstm.setDouble(3, product.getQuantity());
            pstm.setDouble(4, product.getMoneyspent());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    product.setId(rst.getInt(1));
                }
            }
        }
    }

    public void searchName(String name) throws SQLException {


        String sql = "SELECT * FROM PRODUCT WHERE NAME LIKE ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + name + "%");

            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    Product product = new Product(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getDouble(5));
                    System.out.println(product);
                }
            }
        }
    }

    public void searchId(Integer id) throws SQLException {


        String sql = "SELECT * FROM PRODUCT WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);

            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    Product product = new Product(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getDouble(5));
                    System.out.println(product);
                }
            }
        }
    }

    public void update(Double quant, Integer id) throws SQLException {
        String sql = "UPDATE PRODUCT SET QUANTITY = ? WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setDouble(1, quant);
            pstm.setInt(2, id);

            pstm.execute();


        }
    }

    public void delete() throws SQLException {

    }

    public List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<Product>();

        String sql = "SELECT ID, NAME, UNIT, QUANTITY, MONEYSPENT FROM PRODUCT";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()) {
                while(rst.next()) {
                    Product product = new Product(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getDouble(5));

                    products.add(product);
                }
            }
        }
        return products;
    }

    public void Incoming(Double in) throws SQLException {

    }

    public void Outgoing(Double out) throws SQLException {

    }
}
