import java.awt.*; 
import java.awt.event.*; 
import java.sql.*; 
import javax.swing.*; 
class Buy extends JFrame //implements ActionListener 
{ 
JTextField txt; 
Boolean status=false; 
String Player[]=new String[11]; 
int n; 
JLabel B; 
PreparedStatement stmt=null; 
void Extract(String Bidder,String Name,Float Price)throws Exception 
{ 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root",""); 
String Query="insert into "+Bidder+" values(?,?)"; 
stmt=con.prepareStatement(Query); 
stmt.setString(1,Name); 
stmt.setFloat(2,Price); 
stmt.executeUpdate(); 
stmt.close(); 
con.close(); 
dispose(); 
new Auction(); 
} 
Buy(String BidderName,String Name,Float Price) 
{ 
try{Extract(BidderName,Name,Price);}catch(Exception e){} 
} 
public static void main(String args[])throws Exception 
{ 
} 
