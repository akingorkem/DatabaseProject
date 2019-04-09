
package termproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.NullPointerException;
public class StudentDatabase {
   
    
   
    String id="project";
    String password="labrador1907";
    String host="localhost";
    String port="3306";
    String db_name="mydb";
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iau","project","labrador1907");
            System.out.println("Bağlandı");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public StudentDatabase()  {
        Connection con = null;
        String url = "jdbc:mysql://"+host+":"+port+"/"+db_name;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,id,password);
            System.out.println("Veritabanı başarıyla bağlandınız");
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(StudentDatabase.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("Driver calısmadı");
        } catch(SQLException ex){
            Logger.getLogger(StudentDatabase.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("Connection calısmadı");
        }
    }    
         
    
    public static void main(String[] args){
        StudentDatabase stu = new StudentDatabase();
        
        /*PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT * FROM studentinfo ";
        try {
            ps = getConnection().prepareStatement(query);
            
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(" görkem");
            }
        } catch(SQLException ex){
            Logger.getLogger(StudentDatabase.class.getName()).log(Level.SEVERE,null,ex);}
        */
        }
        

    }

    


