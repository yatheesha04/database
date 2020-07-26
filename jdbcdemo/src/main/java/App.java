

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {

		// TODO Auto-generated method stub
		
	

		   //  Database credentials
		   static final String USER = "sa";
		   static final String PASS = "";
		   
		   public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("org.hsqldb.jdbcDriver");

		   
		    
		      conn=  DriverManager.getConnection("jdbc:hsqldb:file:///c:/hsqldb/mydb", "SA", "");
		     // conn = DriverManager.getConnection("jdbc:hsqldb:file:database.dat;shutdown=true", "sa", "");
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT id, username, password FROM final";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		       
		         String first = rs.getString("username");
		         String last = rs.getString("password");

		         //Display values
		         System.out.print("ID: " + id);
		      
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
			   System.out.println("se  :"+ se);
		     
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      
		      System.out.println("e  :"+ e);
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		    	  System.out.println("se  :"+ se2);
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		    	  System.out.println("se  :"+ se);
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
}