import java.awt.*; 
import java.awt.event.*; 
import java.sql.*; 
import javax.swing.*; 
import java.awt.image.BufferedImage; 
import java.net.*; 
import java.io.InputStream; 
import javax.imageio.ImageIO; 
import java.util.Random; 
class Auction extends JFrame implements ActionListener 
{ 
boolean status=false; 
int Age,Overall,z; 
Float Value; 
String Name,Photo,Nationality,Flag,Club,CLogo,Preff; 
Random randomNum = new Random(); 
int x= randomNum.nextInt(205); 
JButton Next=new JButton("NEXT"); 
JButton Buy=new JButton("BUY"); 
int M(int x)throws Exception 
{System.out.println("Inside M: "+x); 
Boolean flag;flag=Exclude(x); 
if(flag==true) 
{ 
x=randomNum.nextInt(205); 
x=M(x); 
} 
else if(flag==false) 
{ swap(x); 
} 
System.out.println("Returning : "+x); 
return x; 
} 
void swap(int x)throws Exception 
{ 
System.out.println("Swapping "+x+" with 999"); 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root",""); 
Statement stmt; 
String query="update count set C ="+999+" where id="+(x); 
stmt=con.createStatement(); 
stmt.execute(query); 
stmt.close(); 
con.close(); 
} 
Boolean Exclude(int x)throws Exception 
{ 
int Array[]=new int[205]; 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root",""); 
PreparedStatement stmt=con.prepareStatement("Select C from count"); 
ResultSet rs; 
rs=stmt.executeQuery(); 
status=rs.next(); 
for(int i=0;rs.next();i++) 
{ 
Array[i]=(rs.getInt("C")); 
} 
for(int i=0;i<205;i++) 
{ 
if(x==Array[i]) 
{ 
return false; 
} 
} 
return true; 
} 
void Extract(int y)throws Exception 
{ 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root",""); 
PreparedStatement stmt=con.prepareStatement("select * from player where ID=\""+y+"\""); 
ResultSet rs=stmt.executeQuery(); 
status=rs.next(); 
if(status==true) 
{ 
Name=rs.getString("Name"); 
Age=rs.getInt("AGE"); 
Photo=rs.getString("Photo"); 
Nationality=rs.getString("Nationality"); 
Flag=rs.getString("Flag"); 
Overall=rs.getInt("Overall"); 
Club=rs.getString("Club"); 
CLogo=rs.getString("Club Logo"); 
Value=rs.getFloat("Value"); 
Preff=rs.getString("PREFERED POSITION"); 
} 
con.close(); 
} 
void Extract()throws Exception 
{System.out.println("Displaying player :"+z); 
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root",""); 
PreparedStatement stmt=con.prepareStatement("select * from player where ID=\""+z+"\""); 
ResultSet rs=stmt.executeQuery(); 
status=rs.next(); 
if(status==true) 
{ 
Name=rs.getString("Name"); 
Age=rs.getInt("AGE"); 
Photo=rs.getString("Photo"); 
Nationality=rs.getString("Nationality"); 
Flag=rs.getString("Flag"); 
Overall=rs.getInt("Overall"); 
Club=rs.getString("Club"); 
CLogo=rs.getString("Club Logo"); 
Value=rs.getFloat("Value"); 
Preff=rs.getString("PREFERED POSITION"); 
} 
con.close(); 
} 
Auction(int X) throws Exception 
{ 
Extract(X); 
setTitle("FIFA 18| Auction "); 
setSize(660, 760); 
setBackground(Color.white); 
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
// setUndecorated(true); 
setResizable(false); 
JPanel p=new JPanel(); 
ImageIcon Q=new ImageIcon("C:\\Users\\harri\\Desktop\\Stuff\\Auction\\Back.png"); 
JLabel J=new JLabel(Q); 
J.setBounds(0,0,655,750); 
p.setLayout(null); 
URL url_Photo = new URL(Photo); 
URL url_Flag = new URL(Flag); 
URL url_CLogo = new URL(CLogo); 
Image image_Photo = ImageIO.read(url_Photo.openStream()); 
Image image_Flag = ImageIO.read(url_Flag.openStream()); 
Image image_CLogo = ImageIO.read(url_CLogo.openStream()); 
JLabel label_Photo = new JLabel(new ImageIcon(image_Photo)); 
JLabel label_Flag = new JLabel(new ImageIcon(image_Flag)); 
JLabel label_CLogo = new JLabel(new ImageIcon(image_CLogo)); 
JLabel label_Name =new JLabel(Name); 
JLabel label_Club =new JLabel(Club); 
JLabel label_Value =new JLabel(Float.toString(Value)); 
JLabel label_Preff=new JLabel(Preff); 
JLabel label_Overall=new JLabel(Integer.toString(Overall)); 
JLabel label_Age=new JLabel(Integer.toString(Age)); 
JLabel label_Nationality=new JLabel(Nationality); 
JLabel M=new JLabel("M"); 
JLabel a=new JLabel("AGE :"); 
JLabel n=new JLabel("NATIONALITY :"); 
JLabel P=new JLabel("POSITION :"); 
JLabel c=new JLabel("CLUB :"); 
JLabel b=new JLabel("BASE PRICE :"); 
JLabel o=new JLabel("RATING :"); 
Font font1 = new Font("Copperplate Gothic Bold",Font.BOLD,45); 
Font font = new Font("Copperplate Gothic Bold",Font.BOLD,30); 
Font font2 = new Font("Copperplate Gothic Bold",Font.BOLD,25); 
label_Name.setFont(font1); 
label_Age.setFont(font2); 
label_Preff.setFont(font2); 
label_Club.setFont(font2); 
label_Nationality.setFont(font2); 
M.setFont(font2); 
a.setFont(font); 
n.setFont(font); 
P.setFont(font); 
c.setFont(font); 
b.setFont(font); 
o.setFont(font); 
Next.setFont(font2); 
Buy.setFont(font2); 
label_Value.setFont(font2); 
label_Overall.setFont(font2); 
label_Photo.setBounds(15,342,48,48); 
label_Flag.setBounds(360,448,23,17); 
label_CLogo.setBounds(210,520,24,24); 
label_Name.setBounds(75,240,615,270); 
label_Club.setBounds(237,472,300,125); 
label_Value.setBounds(335,550,148,125); 
M.setBounds(400,550,148,125); 
label_Overall.setBounds(255,510,148,125); 
label_Preff.setBounds(282,410,250,175); 
label_Age.setBounds(180,340,48,148); 
label_Nationality.setBounds(385,381,250,148); 
a.setBounds(75,327,148,175); 
n.setBounds(75,368,290,175); 
P.setBounds(75,410,200,175); 
c.setBounds(75,448,148,175); 
b.setBounds(75,526,348,175); 
o.setBounds(75,485,348,175); 
Next.setBounds(330,650,125,50); 
Buy.setBounds(185,650,125,50); 
p.add(M); 
p.add(label_Photo); 
p.add(label_CLogo); 
p.add(label_Name); 
p.add(label_Club); 
p.add(label_Value); 
p.add(label_Preff); 
p.add(label_Age); 
p.add(label_Nationality); 
p.add(label_Flag); 
p.add(label_Overall); 
p.add(a); 
p.add(n); 
p.add(P); 
p.add(c); 
p.add(o); 
p.add(b); 
p.add(Next); 
p.add(Buy); 
p.add(J); 
add(p); 
setVisible(true); 
Next.addActionListener(this); 
Buy.addActionListener(this); 
} 
Auction() throws Exception 
{ 
try{z=M(x);}catch(Exception e){System.out.println("ERROR");} 
System.out.println("Z :" +z); 
Extract(); 
setTitle("FIFA 18| Auction "); 
setSize(660, 760); 
setBackground(Color.white); 
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
// setUndecorated(true); 
setResizable(false); 
JPanel p=new JPanel(); 
ImageIcon Q=new ImageIcon("C:\\Users\\harri\\Desktop\\Stuff\\Auction\\Back.png"); 
JLabel J=new JLabel(Q); 
J.setBounds(0,0,655,750); 
p.setLayout(null); 
URL url_Photo = new URL(Photo); 
URL url_Flag = new URL(Flag); 
URL url_CLogo = new URL(CLogo); 
Image image_Photo = ImageIO.read(url_Photo.openStream()); 
Image image_Flag = ImageIO.read(url_Flag.openStream()); 
Image image_CLogo = ImageIO.read(url_CLogo.openStream()); 
JLabel label_Photo = new JLabel(new ImageIcon(image_Photo)); 
JLabel label_Flag = new JLabel(new ImageIcon(image_Flag)); 
JLabel label_CLogo = new JLabel(new ImageIcon(image_CLogo)); 
JLabel label_Name =new JLabel(Name); 
JLabel label_Club =new JLabel(Club); 
JLabel label_Value =new JLabel(Float.toString(Value)); 
JLabel label_Preff=new JLabel(Preff); 
JLabel label_Overall=new JLabel(Integer.toString(Overall)); 
JLabel label_Age=new JLabel(Integer.toString(Age)); 
JLabel label_Nationality=new JLabel(Nationality); 
JLabel M=new JLabel("M"); 
JLabel a=new JLabel("AGE :"); 
JLabel n=new JLabel("NATIONALITY :"); 
JLabel P=new JLabel("POSITION :"); 
JLabel c=new JLabel("CLUB :"); 
JLabel b=new JLabel("BASE PRICE :"); 
JLabel o=new JLabel("RATING :"); 
Font font1 = new Font("Copperplate Gothic Bold",Font.BOLD,45); 
Font font = new Font("Copperplate Gothic Bold",Font.BOLD,30); 
Font font2 = new Font("Copperplate Gothic Bold",Font.BOLD,25); 
label_Name.setFont(font1); 
label_Age.setFont(font2); 
label_Preff.setFont(font2); 
label_Club.setFont(font2); 
label_Nationality.setFont(font2); 
a.setFont(font); 
n.setFont(font); 
P.setFont(font); 
c.setFont(font); 
b.setFont(font); 
o.setFont(font); 
M.setFont(font2); 
Next.setFont(font2); 
Buy.setFont(font2); 
label_Value.setFont(font2); 
label_Overall.setFont(font2); 
label_Photo.setBounds(15,342,48,48); 
label_Flag.setBounds(360,448,23,17); 
label_CLogo.setBounds(210,520,24,24); 
label_Name.setBounds(75,240,615,270); 
label_Club.setBounds(237,472,300,125); 
label_Value.setBounds(335,550,148,125); 
M.setBounds(400,550,148,125); 
label_Overall.setBounds(255,510,148,125); 
label_Preff.setBounds(282,410,250,175); 
label_Age.setBounds(180,340,48,148); 
label_Nationality.setBounds(385,381,250,148); 
a.setBounds(75,327,148,175); 
n.setBounds(75,368,290,175); 
P.setBounds(75,410,200,175); 
c.setBounds(75,448,148,175); 
b.setBounds(75,526,348,175); 
o.setBounds(75,485,348,175); 
Next.setBounds(330,650,125,50); 
Buy.setBounds(185,650,125,50); 
p.add(M); 
p.add(label_Photo); 
p.add(label_CLogo); 
p.add(label_Name); 
p.add(label_Club); 
p.add(label_Value); 
p.add(label_Preff); 
p.add(label_Age); 
p.add(label_Nationality); 
p.add(label_Flag); 
p.add(label_Overall); 
p.add(a); 
p.add(n); 
p.add(P); 
p.add(c); 
p.add(o); 
p.add(b); 
p.add(Next); 
p.add(Buy); 
p.add(J); 
add(p); 
setVisible(true); 
Next.addActionListener(this); 
Buy.addActionListener(this); 
} 
public void actionPerformed(ActionEvent ae) 
{ 
if(ae.getSource()==Next) 
{ 
try{new Auction();} 
catch(Exception e){} 
dispose(); 
} 
if (ae.getSource()==Buy) 
{ 
try{new Bidder(Name,x,Value);} 
catch(Exception e){} 
dispose(); 
} 
} 
public static void main(String args[])throws Exception 
{ 
//Auction a=new Auction(); 
} 
} 
