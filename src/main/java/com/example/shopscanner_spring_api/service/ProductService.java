package com.example.shopscanner_spring_api.service;

import com.example.shopscanner_spring_api.api.model.Product;
import com.example.shopscanner_spring_api.api.model.ShoppingList;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends GenericService{

    public ProductService() {
        super();
    }

    public Product getProduct(String productId) {
        try {
            int quantity = 1;
            String sql ="SELECT * FROM \"ShopScanner_Schema\".products WHERE id like ?;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, productId);

            ResultSet rs = ps.executeQuery();
            ps.close();

            if (!rs.next()){return null;}//In case the product does not exist

            String name = rs.getString("name");
            double price = rs.getDouble("price");
            String seller = rs.getString("seller");
            String image = rs.getString("image");
            String sale  = rs.getString("sale");
            String url = rs.getString("url");
            rs.close();

            return new Product(productId,name,price,seller,sale,url,image,quantity);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    //NOTE: the accepted sort methods will be: id (default), priceAsc, priceDesc
    public ArrayList<Product> getPage(int page, int size, String search, String sort, String seller) {
        //First we build the sql sentence
        String sql = "SELECT * FROM \"ShopScanner_Schema\".products  WHERE name like ?";
        if (!seller.equals("ANY")){sql+=" AND seller LIKE ?";}
        if (sort.equals("ANY")){sql+=" ORDER BY id";}
        else{
            switch (sort){
                case "priceASC": sql+=" ORDER BY price ASC";
                    break;
                case "priceDESC": sql+=" ORDER BY price DESC";
                    break;
                default: sql+=" ORDER BY id";
                    break;
            }
        }
        sql+=" LIMIT ? OFFSET ?;";
        try {
            ArrayList<Product> products = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"%"+search+"%");
            if (!seller.equals("ANY")){
                ps.setString(2,seller);
                ps.setInt(3,size);
                ps.setInt(4,size*page);
            }
            else{
                ps.setInt(2, size);
                ps.setInt(3, size * page);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String pseller = rs.getString("seller");
                String image = rs.getString("image");
                String sale  = rs.getString("sale");
                String url = rs.getString("url");

                Product act = new Product(id,name,price,pseller,sale,url,image,1);
                products.add(act);
            }
            ps.close();
            rs.close();
            return products;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Product> getShoppingListProducts(int shoppingListId) {//I am asuming a list wont be too heavy to handle, so no pagination needed
        try {
            ArrayList<Product>products = new ArrayList<>();
            String sql="SELECT * FROM \"ShopScanner_Schema\".shopping_lists WHERE list_id like ?;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, shoppingListId+"");
            ResultSet rs = ps.executeQuery();
            ps.close();

            if (!rs.next()){return null;}//In case the list does not exist

            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                String productId = rs.getString("product_id");
                String sql2 ="SELECT * FROM \"ShopScanner_Schema\".products WHERE id like ?;";
                ps = this.connection.prepareStatement(sql2);
                ps.setString(1, productId);

                ResultSet rs2 = ps.executeQuery();
                ps.close();

                String name = rs2.getString("name");
                double price = rs2.getDouble("price");
                String seller = rs2.getString("seller");
                String image = rs2.getString("image");
                String sale  = rs2.getString("sale");
                String url = rs2.getString("url");

                Product act = new Product(productId,name,price,seller,sale,url,image,quantity);
                products.add(act);

                rs2.close();
            }
            rs.close();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
