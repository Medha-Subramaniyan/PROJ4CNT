/*
 * Name: Medha Subramaniyan
 * Course: CNT 4714 – Summer 2025 – Project Four
 * Assignment title: A Three-Tier Distributed Web-Based Application
 * Date: July 31, 2025
 * Class: DBConnectionUtil
 */

package com.project4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import jakarta.servlet.ServletContext;

public class DBConnectionUtil {
    
    /**
     * Creates a database connection using the specified properties file
     * 
     * @param context ServletContext to access resources
     * @param propertiesFile Path to the properties file (e.g., "/WEB-INF/conf/client.properties")
     * @return Connection object
     * @throws SQLException if connection fails
     * @throws IOException if properties file cannot be loaded
     * @throws ClassNotFoundException if JDBC driver cannot be loaded
     */
    public static Connection getConnection(ServletContext context, String propertiesFile) 
            throws SQLException, IOException, ClassNotFoundException {
        
        // Load properties from the specified file
        Properties props = new Properties();
        props.load(context.getResourceAsStream(propertiesFile));
        
        // Try to load the JDBC driver, but don't fail if it's already loaded via SPI
        String driverClassName = props.getProperty("driver");
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            // Driver might already be loaded via SPI, continue
        }
        
        // Create and return the connection
        return DriverManager.getConnection(
            props.getProperty("url"),
            props.getProperty("user"),
            props.getProperty("password")
        );
    }
    
    /**
     * Creates a database connection using separate DB and user properties files
     * 
     * @param context ServletContext to access resources
     * @param dbPropertiesFile Path to DB properties file (contains driver and url)
     * @param userPropertiesFile Path to user properties file (contains user and password)
     * @return Connection object
     * @throws SQLException if connection fails
     * @throws IOException if properties file cannot be loaded
     * @throws ClassNotFoundException if JDBC driver cannot be loaded
     */
    public static Connection getConnection(ServletContext context, String dbPropertiesFile, String userPropertiesFile) 
            throws SQLException, IOException, ClassNotFoundException {
        
        // Load DB properties (driver and url)
        Properties dbProps = new Properties();
        dbProps.load(context.getResourceAsStream(dbPropertiesFile));
        
        // Load user properties (user and password)
        Properties userProps = new Properties();
        userProps.load(context.getResourceAsStream(userPropertiesFile));
        
        // Try to load the JDBC driver, but don't fail if it's already loaded via SPI
        String driverClassName = dbProps.getProperty("driver");
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            // Driver might already be loaded via SPI, continue
        }
        
        // Create and return the connection
        return DriverManager.getConnection(
            dbProps.getProperty("url"),
            userProps.getProperty("user"),
            userProps.getProperty("password")
        );
    }
    
    /**
     * Tests if a JDBC driver can be loaded
     * 
     * @param driverClassName The driver class name to test
     * @return true if driver can be loaded, false otherwise
     */
    public static boolean testDriver(String driverClassName) {
        try {
            Class.forName(driverClassName);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
} 