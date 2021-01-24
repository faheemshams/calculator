import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener
{
JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPlus,bMinus,bMulti,bDiv,bMod,bClear,bEqual,bdot;
JTextField tf;
JTextArea memArea;
JScrollPane memScrollBar;
double ans=0;
String operation=null,temp="";

calculator()
{
setTitle("calculator");
setLayout(null);
setSize(270,470);

tf=new JTextField();
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
bPlus=new JButton("+");
bMinus=new JButton("-");
bMulti=new JButton("*");
bDiv=new JButton("/");
bMod=new JButton("%");
bEqual=new JButton("=");
bClear=new JButton("C");
bdot=new JButton(".");

memArea=new JTextArea("");
memScrollBar = new JScrollPane(memArea);
memScrollBar.setBounds(20,15,230,100);
memScrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

tf.setBounds(20,130,230,40);
b1.setBounds(20,180,50,40);
b2.setBounds(80,180,50,40);
b3.setBounds(140,180,50,40);
bPlus.setBounds(200,180,50,40);

b4.setBounds(20,230,50,40);
b5.setBounds(80,230,50,40);
b6.setBounds(140,230,50,40);
bMinus.setBounds(200,230,50,40);

b7.setBounds(20,280,50,40);
b8.setBounds(80,280,50,40);
b9.setBounds(140,280,50,40);
bMulti.setBounds(200,280,50,40);

b0.setBounds(20,330,50,40);
bdot.setBounds(80,330,50,40);
bMod.setBounds(140,330,50,40);
bDiv.setBounds(200,330,50,40);

bClear.setBounds(20,380,110,40);
bEqual.setBounds(140,380,110,40);

add(memScrollBar);
add(tf);
add(b1);     add(b2);    add(b3);   add(bPlus);
add(b4);     add(b5);    add(b6);   add(bMinus);
add(b7);     add(b8);    add(b9);   add(bMulti);
add(b0);     add(bdot);  add(bMod); add(bDiv);
add(bClear); add(bEqual);

b0.addActionListener(this);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
bPlus.addActionListener(this);
bMinus.addActionListener(this);
bMulti.addActionListener(this);
bDiv.addActionListener(this);
bMod.addActionListener(this);
bClear.addActionListener(this);
bEqual.addActionListener(this);
bdot.addActionListener(this);

setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationByPlatform(true);
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
tf.setText(tf.getText()+"1");
else if(e.getSource()==b2)
tf.setText(tf.getText()+"2");
else if(e.getSource()==b3)
tf.setText(tf.getText()+"3");
else if(e.getSource()==b4)
tf.setText(tf.getText()+"4");
else if(e.getSource()==b5)
tf.setText(tf.getText()+"5");
else if(e.getSource()==b6)
tf.setText(tf.getText()+"6");
else if(e.getSource()==b7)
tf.setText(tf.getText()+"7");
else if(e.getSource()==b8)
tf.setText(tf.getText()+"8");
else if(e.getSource()==b9)
tf.setText(tf.getText()+"9");
else if(e.getSource()==b0)
{
if(!tf.getText().equals("0"))                 //to avoid repetition of zeroes
tf.setText(tf.getText()+"0");
}
else if(e.getSource()==bdot)
tf.setText(tf.getText()+".");
else if(e.getSource()==bClear)
{
tf.setText("");
ans=0;
operation=null;
temp="";
}
else if(e.getSource()==bPlus)
evaluate("+");
else if(e.getSource()==bMinus)
evaluate("-");
else if(e.getSource()==bMulti)
evaluate("*");
else if(e.getSource()==bDiv)
evaluate("/");
else if(e.getSource()==bMod)
evaluate("%");
else if(e.getSource()==bEqual)
{
try{                             //check if = is entered without an opreator
if(!operation.equals(null))
evaluate("=");
}
catch(Exception ex)
{return;
}
}}

public void evaluate(String op)
{
try        
    {          //to check if operators are added adjacently like 5+*
        Double check=Double.parseDouble(tf.getText());
    }
 catch(NumberFormatException e)
    {
        temp="";
        ans=0;
        operation=null;
        tf.setText("");                       
        return;
    }
temp=temp+tf.getText()+op;

if(operation==null)              //operation is prev and op is current
     {
        operation=op;
        ans=Double.parseDouble(tf.getText());
        tf.setText("");
     }
else 
{
if(operation.equals("+"))
ans+=Double.parseDouble(tf.getText());

else if(operation.equals("-"))
ans-=Double.parseDouble(tf.getText());

else if(operation.equals("*"))
ans*=Double.parseDouble(tf.getText());

else if(operation.equals("/"))
{
    if(tf.getText().equals("0"))
    {
     tf.setText("");
     operation=null;
     ans=0;
     JOptionPane.showMessageDialog(this,"DIVISION BY ZERO NOT DEFINED","ERROR",JOptionPane.WARNING_MESSAGE);
     temp="";
     return;
    }
    else
    ans=ans/Double.parseDouble(tf.getText());
}

else if(operation.equals("%"))
ans=ans%Double.parseDouble(tf.getText());
}

if(op.equals("="))
{
    if(ans-(int)ans==0)        //if ans has purely integer then print int
         tf.setText(Integer.toString((int)ans));
    
    else
         tf.setText(Double.toString(ans));    //else print double
    
    temp=temp+tf.getText();
    memArea.setText(memArea.getText()+temp+"\n");
    temp="";
    ans=0;
    operation=null;
}}
public static void main(String args[])
{
new calculator().setVisible(true);
}}