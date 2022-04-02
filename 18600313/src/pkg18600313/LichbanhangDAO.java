/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18600313;
import java.io.Serializable;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author TUAN
 */
public class LichbanhangDAO {
    public List<Lichbanhang> getAll()
    {
        Connection connection = null;
        ResultSet rs = null;
        List<Lichbanhang> lst = new ArrayList<Lichbanhang>();
        try
        {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection();
            String strSQL = "SELECT * FROM lichbanhang";
            rs =  data.getDataTable(strSQL, connection);
            while(rs.next())
            {
                Lichbanhang sp=new Lichbanhang();
                sp.setId(rs.getInt("id"));
                sp.setTen(rs.getString("ten"));
                sp.setNgay(rs.getDate("ngay"));
                sp.setTien(rs.getInt("tien"));
                lst.add(sp);
            }
        }
        catch(Exception e)
        {
        
        }
        finally {
            if (connection != null) {
                try {
                    rs.close();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LichbanhangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lst;
    }
    public int Themlich(Lichbanhang sp)
    {
        Connection connection = null;
        try
        {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection(); 
            String strSQL = "INSERT INTO lichbanhang(id, ten,tien) VALUES (?,?,?)";
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement(strSQL);

            pre.setInt(1, sp.getId());
            pre.setString(2, sp.getTen());
            pre.setInt(3, sp.getTien());
            
            data.setPre(pre);
            int kq = data.Insert(strSQL, connection);
        }
        catch(Exception e)
        {
        
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
}
