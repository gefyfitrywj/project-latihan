/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gefy
 */
import java.sql.*;

public class KoneksiDatabase {
    String DBurl = "jdbc:mysql://localhost/db_hp";
    String DBusername = "root";
    String DBpassword = "";
    public Connection connection;
    public Statement statement;

    public KoneksiDatabase() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Connection Failed\n" + ex.getMessage());
        }
    } 
}
