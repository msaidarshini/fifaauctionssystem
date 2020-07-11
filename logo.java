import java.awt.*; 
import java.awt.event.*; 
import java.sql.*; 
import javax.swing.*; 
import java.awt.image.BufferedImage; 
import java.net.*; 
import java.io.InputStream; 
import javax.imageio.ImageIO; 
import java.util.Random; 
class Logo extends JFrame 
{ 
Logo() 
{ 
setSize(781, 449); 
setBackground(Color.white); 
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
setUndecorated(true); 
setResizable(false); 
JPanel p=new JPanel(); 
ImageIcon Q=new ImageIcon("C:\\Users\\harri\\Desktop\\Stuff\\Auction\\Logo.jpg"); 
JLabel J=new JLabel(Q); 
J.setBounds(0,0,781, 449); 
p.setLayout(null); 
p.add(J); 
add(p); 
setVisible(true); 
} 
public static void main(String args[])throws Exception 
{ 
Logo l= new Logo(); 
new Auction(); 
l.dispose(); 
} 
}

