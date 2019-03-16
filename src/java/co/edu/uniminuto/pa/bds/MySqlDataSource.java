/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.pa.bds;

//import com.mysql.cj.jdbc.MysqlDataSource;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.ds.PGPoolingDataSource;

/**
 *
 * @author nixoduaa
 */
public class MySqlDataSource {
    private static MySqlDataSource miMySqlDS = null;
    private static PGPoolingDataSource ds = null;
    
    private MySqlDataSource(){
        ds = new PGPoolingDataSource();
        ds.setServerName("ec2-75-101-133-29.compute-1.amazonaws.com");
        ds.setPortNumber(5432);
        ds.setDatabaseName("d785dmjqq43q28");
        ds.setUser("mvfytxsaitttvk");
        ds.setPassword("cfeeed1b3575542accb37a7909fa091c7bbdaf06949f972da7d5e495a522ff68");        
    }
    
    public static Connection getConexionBD()
    {
        try {
            if (miMySqlDS == null)
            {
                miMySqlDS = new MySqlDataSource();            
            }
            
            return ds.getConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySqlDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}