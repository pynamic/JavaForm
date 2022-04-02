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
public class SanphamDAO implements Serializable{
    public List<Sanpham> getAll()
    {
        Connection connection = null;
        ResultSet rs = null;
        List<Sanpham> lst = new ArrayList<Sanpham>();
        try
        {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection();
            String strSQL = "SELECT * FROM sanpham";
            rs =  data.getDataTable(strSQL, connection);
            while(rs.next())
            {
                Sanpham sp=new Sanpham();
                sp.setId(rs.getInt("id"));
                sp.setSanpham(rs.getString("sanpham"));
                sp.setQuycach(rs.getInt("quycach"));
                sp.setGiamgia(rs.getInt("giamgia"));
                sp.setGia(rs.getInt("gia"));
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
                    Logger.getLogger(KhachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lst;
    }
    public int Themsp(Sanpham sp)
    {
        Connection connection = null;
        int kq=-1;
        try
        {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection(); 
            String strSQL = "INSERT INTO sanpham VALUES(?,?,?,?,?)";
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement(strSQL);

            pre.setInt(1, sp.getId());
            pre.setString(2, sp.getSanpham());
            pre.setInt(3, sp.getQuycach());
            pre.setInt(4, sp.getGiamgia());
            pre.setInt(5,sp.getGia());
            
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
    public int Xoasp(int id) {
        Connection connection = null;
        int kq=0;
        try
        {
            Dataconnection data = new Dataconnection();
            connection =  data.getConnection(); 
            String strSQL =  "DELETE FROM sanpham WHERE id=?";
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement(strSQL);
            
            pre.setInt(1, id);
           
             kq = pre.executeUpdate();
        }catch(SQLException ex) {
          Logger.getLogger(Sanpham.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public int Updatesp(Sanpham sp) {
        Connection connection = null;
        int kq=0;
        try
        {
            Dataconnection data = new Dataconnection();
            connection=data.getConnection();
            String strSQL =  "UPDATE sanpham SET sanpham=?, giamgia=?, quycach=?, gia=? WHERE id=?";
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement(strSQL);
            
            pre.setString(1, sp.getSanpham());
            pre.setInt(2, sp.getGiamgia());
            pre.setInt(3, sp.getQuycach());  
            pre.setInt(4,sp.getGia());
            pre.setInt(5, sp.getId());
            
             kq = pre.executeUpdate();
        }catch(SQLException ex) {
          Logger.getLogger(Sanpham.class.getName()).log(Level.SEVERE, null, ex);
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
    public Sanpham findProductById(int id) {
        Sanpham sp=new Sanpham();
        Connection connection = null;
        try
        {
            Dataconnection data = new Dataconnection();
            connection = data.getConnection();
            String strSQL =  "SELECT * FROM product WHERE id=?";
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement(strSQL);
            
            pre.setInt(1, id);
            
            ResultSet rs = pre.executeQuery();
            rs.next();
            sp = new Sanpham(
                    rs.getInt("id"),
                    rs.getString("sanpham"),
                    rs.getInt("quycach"),
                    rs.getInt("giamgia"),
                    rs.getInt("gia")
                );
            return sp;
            
        }catch(SQLException ex) {
          Logger.getLogger(Sanpham.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return sp;
    }
    
    
}
