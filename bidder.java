import java.awt.*; 
import java.awt.event.*; 
import java.sql.*; 
import javax.swing.*; 
class Bidder extends JFrame implements ActionListener 
{ 
Float amt; 
String N[]={"prajith","abdu","harris","saji","prabat","chindan","samuel","sourav","akhildev"}; 
boolean status=false; 
JTextField BidderName; 
JTextField Price; 
JButton Btn=new JButton("Buy"); 
JButton Back=new JButton("Back"); 
String P_Name; 
int a=1; 
int X; 
Float V; 
Bidder(String Name,int x,Float Value) 
{ 
P_Name=Name; 
X=x; 
V=Value; 
setTitle("FIFA 18| Auction "); 
setSize(660, 760); 
setBackground(Color.white); 
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
JPanel p=new JPanel(); 
ImageIcon Q=new ImageIcon("C:\\Users\\harri\\Desktop\\Stuff\\Auction\\Bid.png"); 
JLabel J=new JLabel(Q); 
JLabel B=new JLabel("Bidder Name"); 
JLabel P=new JLabel("Bid Amount"); 
J.setBounds(0,0,655,750); 
BidderName=new JTextField(20); 
Price=new JTextField(20); 
BidderName.setBorder(javax.swing.BorderFactory.createEmptyBorder()); 
Price.setBorder(javax.swing.BorderFactory.createEmptyBorder()); 
Font font = new Font("Copperplate Gothic Bold",Font.BOLD,34); 
Font font1 = new Font("Copperplate Gothic Bold",Font.BOLD,25); 
BidderName.setFont(font); 
Price.setFont(font); 
B.setFont(font); 
P.setFont(font); 
Btn.setFont(font1); 
Back.setFont(font1); 
BidderName.setBounds(328,350,300,50); 
Price.setBounds(328,435,300,50); 
B.setBounds(30,240,280,270); 
P.setBounds(30,325,280,270); 
Btn.setBounds(185,650,125,50); 
Back.setBounds(330,650,125,50); 
p.add(Btn); 
p.add(Back); 
p.setLayout(null); 
p.add(P); 
p.add(Price); 
p.add(B); 
p.add(BidderName); 
p.add(J); 
add(p); 
setVisible(true); 
getRootPane().setDefaultButton(Btn); 
Btn.addActionListener(this); 
Back.addActionListener(this); 
} 
void funcG(int i)throws Exception 
{ 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root",""); 
PreparedStatement stmt; 
String query="select * from bank where id="+(i+1); 
ResultSet rs; 
stmt=con.prepareStatement(query); 
rs=stmt.executeQuery(); 
status=rs.next(); 
if(status==true) 
{ 
amt=Float.parseFloat(rs.getString("AMT")); 
} 
con.close(); 
} 
void funcI(int i,Float A)throws Exception 
{ 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root",""); 
Statement stmt; 
ResultSet rs; 
String query="update bank set AMT ="+A+" where id="+(i+1); 
stmt=con.createStatement(); 
stmt.execute(query); 
String st=P_Name+" brought by "+BidderName.getText()+" for "+Price.getText()+" M"; 
JOptionPane.showMessageDialog(this,st,"Succes",JOptionPane.INFORMATION_MESSAGE); 
try{new Buy(BidderName.getText(),P_Name,Float.parseFloat(Price.getText()));} 
catch(Exception e){} 
dispose(); 
stmt.close(); 
con.close(); 
} 
void check() throws Exception 
{ 
Float price=Float.parseFloat(Price.getText()); 
int flag=0; 
String Name=BidderName.getText(); 
for(int i=0;i<9;i++) 
{ 
if(Name.equalsIgnoreCase(N[i])) 
{ 
try{funcG(i);}catch(Exception e){} 
if(price<=amt&& price>=V) 
{ 
amt-=price;a=0; 
try{funcI(i,amt);}catch(Exception e){} 
} 
else if(price<V) JOptionPane.showMessageDialog(this,"the entered amount is less than base price","There was a problem",JOptionPane.ERROR_MESSAGE); 
else 
{ 
JOptionPane.showMessageDialog(this,"the entered amount is greater than available amount","There was a problem",JOptionPane.ERROR_MESSAGE);a=1; 
}flag=1; 
break; 
} 
} 
if(flag==0) 
JOptionPane.showMessageDialog(this,"Bidder Name Not Identified","There was a problem",JOptionPane.ERROR_MESSAGE);a=1; 
} 
public void actionPerformed(ActionEvent ae) 
{ 
if(ae.getSource()==Btn) 
{ 
if(a==1){try{ check();}catch(Exception e){}} 
else{ 
try{new Buy(BidderName.getText(),P_Name,Float.parseFloat(Price.getText()));} 
catch(Exception e){} 
dispose();} 
} 
if(ae.getSource()==Back) 
{ 
try{new Auction(X);}catch(Exception e){} 
dispose(); 
} 
} 
public static void main(String args[])throws Exception 
{ 
} 
} 
