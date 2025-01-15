package com.example.shopscanner_spring_api.service;

import com.example.shopscanner_spring_api.api.model.Product;
import com.example.shopscanner_spring_api.api.model.ShoppingList;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


@Service
public class ShoppingListService extends GenericService{

    public ShoppingListService (){
        super();
    }

    public boolean addShoppingList(ShoppingList shoppingList) {
        String sql="INSERT INTO \"ShopScanner_Schema\".shopping_lists (user_id, list_id, name, last_modified, total_price) VALUES (?, ?, ?, ?,?)";

        PreparedStatement ps;
        try {
            //Primero añadir los datos de la lista
            ps = this.connection.prepareStatement(sql);
            ps.setString(1, shoppingList.getUserId());
            ps.setString(2,shoppingList.getListaId());
            ps.setString(3,shoppingList.getName());
            ps.setString(4,shoppingList.getLast_modified());
            ps.setDouble(5,shoppingList.getPrice());

            if(!ps.execute()){
                ps.close();
                connection.rollback();
                return false;
            }
            ps.close();

            //Ahora van los productos
            sql="INSERT INTO \"ShopScanner_Schema\".product_list (list_id, product_id, quantity) VALUES (?,?,?)";
            for(Product product : shoppingList.getProducts()){
                ps = this.connection.prepareStatement(sql);
                ps.setString(1,shoppingList.getListaId());
                ps.setString(2,product.getIdProducto());
                ps.setInt(3,product.getCantidad());
                if(!ps.execute()){
                    ps.close();
                    connection.rollback();
                    return false;
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean removeShoppingList(String idLista) {
        String sql="DELETE FROM \"ShopScanner_Schema\".shopping_lists WHERE list_id LIKE ?";

        PreparedStatement ps;
        try {
            //Primero añadir los datos de la lista
            ps = this.connection.prepareStatement(sql);
            ps.setString(1, idLista);
            if(!ps.execute()){
                ps.close();
                connection.rollback();
                return false;
            }
            ps.close();
            //Ahora van los productos
            sql="DELETE FROM \"ShopScanner_Schema\".product_list WHERE list_id LIKE ?";
            ps = this.connection.prepareStatement(sql);
            ps.setString(1,idLista);
            if(!ps.execute()){
                ps.close();
                connection.rollback();
                return false;
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateShoppingList(ShoppingList shoppingList) {
        String sql="UPDATE \"ShopScanner_Schema\".product_list WHERE list_id LIKE ? AND product_id LIKE ?";
        String sql_delete="DELETE FROM \"ShopScanner_Schema\".product_list WHERE list_id LIKE ? AND product_id LIKE ?";

        PreparedStatement ps;
        try {
            for(Product product : shoppingList.getProducts()){//If the quantity of a product s 0, means that is no longer inside of the list
                ps = (product.getCantidad()==0)? this.connection.prepareStatement(sql_delete):this.connection.prepareStatement(sql);
                ps = this.connection.prepareStatement(sql);
                ps.setString(1,shoppingList.getListaId());
                ps.setString(2,product.getIdProducto());
                if(!ps.execute()){
                    ps.close();
                    connection.rollback();
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
