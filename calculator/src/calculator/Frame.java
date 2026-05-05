package calculator;
import java.awt.Color;
import javax.swing.*;
public class Frame {
	JFrame f1;
	JPanel p1;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,menis,mul,div,reverse,equal,dot,mod,ans,delete;
	JTextField t;
	JLabel l;
	Frame(){
		f1=new JFrame("calculator");
		f1.setSize(294, 457);
		f1.setResizable(false); // make the size fixed
		f1.setLocationRelativeTo(null); // to appear in the middle of the screen
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// the icon in the frame **********
		ImageIcon img = new ImageIcon("D:\\calculator\\src\\calculator\\icon.jpg.jpg");
		f1.setIconImage(img.getImage());
		// *********
		
		p1=new JPanel();
		t=new JTextField();
		l=new JLabel();
		ans=new JButton("An");
		b0=new JButton("0");
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
	menis=new JButton("-");
	plus=new JButton("+");
	mul=new JButton("x");
	div=new JButton("/");
	reverse=new JButton("←");
	delete=new JButton("C");
	dot=new JButton(".");
	mod=new JButton("%");
	equal=new JButton("=");
	// set layout
	p1.setLayout(null);
	f1.setLayout(null);
	p1.setBounds(0,0,280,420);
	ans.setBounds(250,10,20,20);
	t.setBounds(0,0,280,140);
	l.setBounds(0,10,20,20);
	b0.setBounds(10, 350, 90, 50);
	b1.setBounds(10, 290, 40, 50);
	b2.setBounds(60,290,40,50);
	b3.setBounds(110,290,40,50);
	b4.setBounds(10,230,40,50);
	b5.setBounds(60,230,40,50);
	b6.setBounds(110,230,40,50);
	b7.setBounds(10,170,40,50);
	b8.setBounds(60, 170, 40, 50);
	b9.setBounds(110,170,40,50);
	menis.setBounds(220,230,50,50);
	plus.setBounds(220, 290, 50, 50);
	mul.setBounds(160,290,50,50);
	delete.setBounds(220,170,50,50);
	div.setBounds(160,230,50,50);
	reverse.setBounds(160,170,50,50);
	dot.setBounds(110,350,40,50);
	mod.setBounds(160,350,50,50);
	equal.setBounds(220,350,50,50);
	// t2 font 
	l.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 15));
	// add components
	p1.add(t);
	t.add(ans);
	t.add(l);
	p1.add(reverse);
	p1.add(equal);
	p1.add(mod);
	p1.add(dot);
	p1.add(div);
	p1.add(mul);
	p1.add(delete);
	p1.add(plus);
	p1.add(menis);
		p1.add(b0);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.setBackground(Color.black);
	f1.add(p1);
	f1.setVisible(true);	
	}
}
