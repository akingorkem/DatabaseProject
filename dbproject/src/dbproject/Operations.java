/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Operations {
    Connection con = null;
    Statement sts = null;
    PreparedStatement pata = null;
    public boolean Login(String id, String password){
        String sorgu = "select * from studentinfo where stu_id=? and stu_pass=? ";
        try{
        pata = con.prepareStatement(sorgu);
        pata.setString(1, id);
        pata.setString(2, password);
        ResultSet rs = pata.executeQuery();
        return rs.next();
    }catch (SQLException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
        return false;
    }}
    
    
    String id ="project";
    String password = "labrador1907";
    String host ="localhost"; 
           
    String port= "3306";
    String db_name ="veritabanım";
    public Operations(){
        String url = "jdbc:mysql://"+host+":"+port+"/"+db_name+"?allowMultiQueries=true&useUnicode=true" +
    "&useJDBCCompliantTimezoneShift=true" +
    "&useLegacyDatetimeCode=false" +
    "&serverTimezone=UTC";
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,id,password);
        System.out.println("Database Baglandi");
    } catch (ClassNotFoundException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("Driver calismadi");
        
    }catch (SQLException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
    }
    
    
}
    public static void main(String[] args){
        Operations op = new Operations();
    }
}


