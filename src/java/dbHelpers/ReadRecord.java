
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Artists;


public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Artists artist = new Artists();
    private int artistID;
    
    public ReadRecord (int artistID) {
    
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
    
    this.artistID = artistID;
    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public void doRead() {
    
        try {
            //Set up a string to hold our query
            String query = "SELECT * FROM artists WHERE artistID = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement (query);
            
            //fill in the preparedstatement
            ps.setInt(1, artistID);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            artist.setArtistID(this.results.getInt("artistID"));
            artist.setFirstName(this.results.getString("firstName"));
            artist.setLastName(this.results.getInt("lastName"));
            artist.setStageName(this.results.getString("stageName"));
            artist.setAge(this.results.getInt("age"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
    public Artists getArtist(){
        
        return this.artist;
        
    }    
}    
