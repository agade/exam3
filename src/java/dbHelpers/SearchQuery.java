
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Artists;

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        
         Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void doSearch(String artistName){
        
        try {
            String query = "SELECT * FROM artists WHERE UPPER(firstName) LIKE ? ORDER BY artistID DESC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + firstName.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable(){
        
          String table = "";
                            
        
            table += "<table border=1>";
        
            table += "<tr><th>ArtistID</th>";
            table += "<th>First Name</th>";
            table += "<th>Last Name</th>";
            table += "<th>Stage Name</th>";
            table += "<th>Age</th></tr>"; 
        
        try {
            while(this.results.next()){
                
                Artists artist = new Artists();
                artist.setArtistID(this.results.getInt("artistID"));
                artist.setFirstName(this.results.getString("firstName"));
                artist.setLastName(this.results.getInt("lastName"));
                artist.setStageName(this.results.getString("stageName"));
                artist.setAge(this.results.getInt("age"));
                
                
              
                table += "<tr>";
                table += "<td>";
                table += artist.getArtistID();
                table += "</td>";
                
                table += "<td>";
                table += artist.getFirstName();
                table += "</td>";
                
                table += "<td>";
                table += artist.getLastName();
                table += "</td>";
                
                table += "<td>";
                table += artist.getStageName();
                table += "</td>";
                
                table += "<td>";
                table += artist.getAge();
                table += "</td>";
                
                table += "<td>";
                table +="<a href=update?artistID=" + artist.getArtistID() + "> Update </a>" + "<a href=delete?artistID=" + artist.getArtistID() + "> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
                
                return table;
    
    }    

}
