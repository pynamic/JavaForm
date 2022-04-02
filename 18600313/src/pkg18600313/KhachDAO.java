/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18600313;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author TUAN
 */
public class KhachDAO implements Serializable{
    public List<Khach> getAll()
    {
        Connection connection = null;
        ResultSet rs = null;
        List<Khach> lst = new ArrayList<Khach>();
        try
        {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection();
            String strSQL = "SELECT * FROM khach";
            rs =  data.getDataTable(strSQL, connection);
            while(rs.next())
            {
                Khach k=new Khach();
                k.setId(rs.getInt("id"));
                k.setTen(rs.getString("ten"));
                k.setSodu(rs.getInt("sodu"));
                k.setTienno(rs.getInt("tienno"));
                lst.add(k);
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
                    Logger.getLogger(KhachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lst;
    }
    
    public int ThemKhach(Khach sp)
    {
        Connection connection = null;
        int kq=0;
        try
        {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection(); 
            String strSQL = "INSERT INTO khach VALUSE(?,?,?,?)";
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement(strSQL);

            pre.setInt(1, sp.getId());
            pre.setString(2, sp.getTen());
            pre.setInt(3, sp.getSodu());
            pre.setInt(4, sp.getTienno());
            
            data.setPre(pre);
             kq = data.Insert(strSQL, connection);
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
        return kq;
    }
    public Khach FindbyID(int id) {
        Khach c=new Khach();
        
        Connection connection = null;
        try {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection();
            String strSQL =  "SELECT * FROM khach WHERE id=?";
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement(strSQL);
            
            pre.setInt(1, id);
            
            ResultSet rs = pre.executeQuery();
            rs.next();
            c = new Khach(
                    rs.getInt("id"),
                    rs.getString("ten"),
                    rs.getInt("sodu"),
                    rs.getInt("tienno")
                );
            
        }catch(SQLException ex) {
          Logger.getLogger(Khach.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return c;
    }
    public int updateTienById(int tiennap, int id) {
        Connection connection=null;
        int kq=0;
        try {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection();
            Khach c=null;

            String strSQL =  "SELECT * FROM khach WHERE id=?";
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement(strSQL);
            pre.setInt(1, id);        
            ResultSet rs = pre.executeQuery();
            rs.next();
            c = new Khach(
                    rs.getInt("id"),
                    rs.getString("ten"),
                    rs.getInt("sodu"),
                    rs.getInt("tienno")
                );
            
            tiennap += c.getSodu();
            
            strSQL =  "UPDATE khach SET sodu=? WHERE id=?";
            pre = (PreparedStatement) connection.prepareStatement(strSQL);
            
            pre.setFloat(1, tiennap);
            pre.setInt(2, id);
            
             kq = pre.executeUpdate();
        } catch (SQLException ex) {
          Logger.getLogger(Khach.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }
    
}
