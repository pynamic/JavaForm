/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18600313;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HocVien
 */
public class Dataconnection {
    
    Connection conn = null;
    static String ConnectionString ="jdbc:mysql://localhost/banhang";
    private PreparedStatement pre;
    
    public Connection getConnection()
    {
        try{
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "");
            conn = DriverManager.getConnection(ConnectionString, connectionProps);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    
    public ResultSet getDataTable(String strSQL,Connection connection)
    {
        ResultSet rs = null;
        try
        {
            if (conn != null) {
                Statement st = conn.createStatement();
                rs = st.executeQuery(strSQL);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int Insert(String strSQL,Connection connection)
    {
        try
        {
            if (conn != null) {
               int kq = getPre().executeUpdate();
               
            }
            
        }
        catch(Exception ex)
        {
        
        }
        return 0;
    }
    public boolean update(String strSQL) {
        boolean rt = true;
        try {
            Statement st = conn.createStatement();
            rt = st.execute(strSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Dataconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rt;
    }
    /**
     * @return the pre
     */
    public PreparedStatement getPre() {
        return pre;
    }

    /**
     * @param pre the pre to set
     */
    public void setPre(PreparedStatement pre) {
        this.pre = pre;
    }
    
}
