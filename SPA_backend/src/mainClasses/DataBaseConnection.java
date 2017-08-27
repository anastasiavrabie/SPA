/*
 * SPA Manager
 */
package mainClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Factura;
import models.Product;
import models.User;

/**
 *
 * @author User
 */
public class DataBaseConnection 
{
    private Connection connection ;

    public DataBaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm?autoReconnect=true&useSSL=false","root", "Karlaroot2!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Factura> getRaport(int client){
        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.selectFacturi); PreparedStatement statement1 = connection.prepareStatement(DatabaseData.selectProduseFacturi)){
            ArrayList<Factura> arrayList = new ArrayList<>();
            statement.setInt(1, client);
            ResultSet rs = statement.executeQuery();
            ResultSet rs1;
            int x;
            while (rs.next()){
                Factura factura = new Factura();
                statement1.setInt(1, rs.getInt("idFactura"));
                factura.setID(rs.getInt("idFactura"));
                rs1 = statement1.executeQuery();
                while (rs1.next()){
                    factura.add(rs1.getString("nume"), rs1.getDouble("cantitate"),  rs1.getDouble("pret") , rs1.getInt("idProdus"),  rs1.getBoolean("serviciu"));
                }
                arrayList.add(factura);
                rs1.close();
            }

            rs.close();
            return arrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    

    public void insertCustomer(User user){
        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.insertUser)){
            statement.setInt(1, User.getUserID());
            statement.setString(2, user.getName());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   

    public void insertProduct(Product product){
        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.insertProduct)){
            int idProduct =  product.generateID();
            statement.setInt(1,idProduct);
            statement.setString(2, product.getName());
            if(product.isServices())
                statement.setDouble(3, 0);
            else
                statement.setDouble(3, product.getQuantity());
            statement.setDouble(4, product.getPrice());
            statement.setBoolean(5, product.isServices());
            statement.executeUpdate();
            addSale(idProduct, product.getQuantity(), product.getPrice(), "Aprovizionare");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void insertFactura(Factura factura, int userID){
//        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.insertFactura); PreparedStatement statement1 = connection.prepareStatement(DatabaseData.insertProduseFacturi)){
//            factura.setID(Factura.generateID());
//            statement.setInt(1, factura.getID());
//            statement.setInt(2, userID);
//            statement.setDouble(3, factura.getTotalFactura());
//            statement.executeUpdate();
//            for (int i = 0; i < factura.getListaProduse().size(); i++){
//                Product product = factura.getListaProduse().get(i);
//                statement1.setInt(1, factura.getID());
//                statement1.setInt(2, product.getProductId());
//                statement1.setDouble(3, product.getQuantity());
//                statement1.setDouble(4, product.getPrice());
//                statement1.setString(5, product.getName());
//                statement1.setBoolean(6, product.isServices());
//                statement1.executeUpdate();
//
//                Product product1 = hasProduct(product.getName());
//                User user = selectUser(userID);
//                addSale(product.getProductId(), product.getQuantity(), product.getPrice(), user.getName());
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addSale(int idProdus, double stock, double pret, String buyer){
//        try (PreparedStatement statement1 = connection.prepareStatement(DatabaseData.insertSale)) {
//            statement1.setDouble(1, idProdus);
//            statement1.setDouble(2, stock);
//            statement1.setDouble(3, pret);
//            statement1.setString(4, buyer);
//            statement1.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public ArrayList<User> selectClients(){
//        ArrayList<Client> arrayList = new ArrayList<>();
//        selectCustomers(arrayList);
//        selectCompany(arrayList);
//        return arrayList;
//    }

    public ArrayList<Product> selectProducts(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.selectProducts); ResultSet rs = statement.executeQuery()){
            while (rs.next()){
                arrayList.add(new Product(rs.getString("nume"),  rs.getDouble("pret") , rs.getInt("idProduse")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public Client selectClient(int idClient){
//        if(User.isCustomer(idClient)) return selectCustomer(idClient);
//        if(Company.isCompany(idClient)) return selectCompany(idClient);
        return null;
    }

    public User selectUser(int userID){
        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.selectUser);){
             statement.setInt(1, userID);
             ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return new User(rs.getString("nume"), rs.getString("card_id"), rs.getString("user_package"),rs.getInt("idpersoana_fizica"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   

    public void selectCustomers(ArrayList<User> arrayList){
        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.selectUsers);
             ResultSet rs = statement.executeQuery()){
            while (rs.next()){
                arrayList.add(new User(rs.getString("nume"), rs.getString("card_id"), rs.getString("user_package"),rs.getInt("idpersoana_fizica")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Product hasProduct(String message){
        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.selectProduct)){
            statement.setString(1, message);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                Product product = new Product(rs.getString("nume"), rs.getDouble("pret"), rs.getInt("idProduse"));
                rs.close();
                return product;
            }
            rs.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product hasProduct(int message){
        try (PreparedStatement statement = connection.prepareStatement(DatabaseData.selectProductID)){
            statement.setInt(1, message);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                Product product = new Product(rs.getString("nume"), rs.getDouble("pret"), rs.getInt("idProduse"));
                rs.close();
                return product;
            }
            rs.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void deleteProduct(int idProdus){
        try(PreparedStatement statement = connection.prepareStatement(DatabaseData.deleteProduct)) {
            statement.setInt(1, idProdus);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addSale(int productId, double d, double price, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
