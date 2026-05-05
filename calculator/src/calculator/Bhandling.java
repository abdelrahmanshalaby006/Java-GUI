package calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Bhandling implements ActionListener{
	String op="";
	double z=0,y=0,lastans=0;
	Frame f;
	public Bhandling(Frame f1){
		f=f1;
		//add listener
		f.equal.addActionListener(this);
		f.mod.addActionListener(this);
		f.dot.addActionListener(this);
		f.reverse.addActionListener(this);
		f.delete.addActionListener(this);
		f.div.addActionListener(this);
		f.mul.addActionListener(this);
		f.plus.addActionListener(this);
		f.menis.addActionListener(this);
		f.b0.addActionListener(this);
		f.b1.addActionListener(this);
		f.b2.addActionListener(this);
		f.b3.addActionListener(this);
		f.b4.addActionListener(this);
		f.b5.addActionListener(this);
		f.b6.addActionListener(this);
		f.b7.addActionListener(this);
		f.b8.addActionListener(this);
		f.b9.addActionListener(this);
        	f.ans.addActionListener(this);
	}
	@Override
	 public void actionPerformed(ActionEvent e) {

		// numbers
		if(e.getSource()==f.b0) {f.t.setText(f.t.getText()+"0");}
		else if(e.getSource()==f.b1) {f.t.setText(f.t.getText()+"1");}
		else if(e.getSource()==f.b2) {f.t.setText(f.t.getText()+"2");}
		else if(e.getSource()==f.b3) {f.t.setText(f.t.getText()+"3");}
		else if(e.getSource()==f.b4) {f.t.setText(f.t.getText()+"4");}
		else if(e.getSource()==f.b5) {f.t.setText(f.t.getText()+"5");}
		else if(e.getSource()==f.b6) {f.t.setText(f.t.getText()+"6");}
		else if(e.getSource()==f.b7) {f.t.setText(f.t.getText()+"7");}
		else if(e.getSource()==f.b8) {f.t.setText(f.t.getText()+"8");}
		else if(e.getSource()==f.b9) {f.t.setText(f.t.getText()+"9");}
		else if(e.getSource()==f.ans) {
			f.t.setText(String.valueOf(lastans));
		}
		// important ****************
		else if(e.getSource()==f.dot) {
			if(!f.t.getText().contains("."))
				f.t.setText(f.t.getText()+".");
			}
			//*************
		else if (e.getSource() == this.f.delete) {
			f.t.setText("");
			z = (double) 0.0F;
			y = (double) 0.0F;
			op="";
		}
		 if(e.getSource()==f.reverse) {
			String text = f.t.getText();
			if(!text.isEmpty()) {
				f.t.setText(text.substring(0, text.length() - 1));
			}
		}

		// operations
		else if(e.getSource()==f.mod) {z=Double.parseDouble(f.t.getText());
		f.t.setText("");
		op="%";
	    f.l.setText(op);}
		else if(e.getSource()==f.plus) {
		z=Double.parseDouble(f.t.getText());
		f.t.setText("");
		op="+";
		f.l.setText(op);
		}
		else if(e.getSource()==f.menis) {	z=Double.parseDouble(f.t.getText());
		f.t.setText("");
		op="-";
	    f.l.setText(op);}
		else if(e.getSource()==f.mul) {	z=Double.parseDouble(f.t.getText());
		f.t.setText("");
		op="*";
	    f.l.setText(op);}
		else if(e.getSource()==f.div) {	z=Double.parseDouble(f.t.getText());
		f.t.setText("");
		op="/";
	    f.l.setText(op);}

		// equal button
else if(e.getSource()==f.equal) {
//	f.t.setText("I Love You<3");
 	y=Double.parseDouble(f.t.getText());
	f.l.setText(""); // clear the currunt op text
	if(op.equals("+")) {
        lastans=z+y;
        f.t.setText(z+" + "+y+" = " +(y+z));}
	else if(op.equals("-")) {
         lastans=z-y;
        f.t.setText(z+" - "+y+" = " +(z-y));}
	else if(op.equals("*")) {
         lastans=z*y;
        f.t.setText(z+" x "+y+" = " +(z*y));}
	else if(op.equals("/")) {
         lastans=z/y;
        f.t.setText(z+" /"+y+" = " +(z/y));}
}
else if(op.equals("%")){
     lastans=z/100;
    f.t.setText(z+op+" = " +(z/100));
}
}
}
//ans