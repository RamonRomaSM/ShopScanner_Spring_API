package com.example.shopscanner_spring_api.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GenericService {
    protected Connection connection;
    protected Properties properties;

    public GenericService() {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream("ConnectionData.properties");
            properties.load(input);
            input.close();
            connection= DriverManager.getConnection(properties.getProperty("CONNECTION_URL"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
