package view;

import model.Polinom;
import model.Monom;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class View{

    private JFrame frame;
    private JButton Btn2;
    private JButton Btn4;
    private JButton Btn8;
    private JButton Btn7;
    private JButton Btn5;
    private JButton Btn6;
    private JButton Btn1;
    private JButton Btn9;
    private JButton Btn3;
    private JButton BtnAdd;
    private JButton BtnSub;
    private JButton BtnMul;
    private JButton BtnDiv;
    private JButton BtnInt;
    private JButton BtnDeriv;
    private JButton BtnFirst;
    private JButton BtnSecond;
    private JButton BtnPow;
    private JButton BtnPlus;
    private JButton BtnMinus;
    private JLabel LabelResult;
    private JLabel resultLabel;
    private JLabel FirstLabel;
    private JLabel SecondLabel;
    private JButton BtnClear;
    private JButton BtnX;
    private JButton Btn0;

    public View() {

        frame = new JFrame();
        frame.setBounds(100, 100, 663, 267);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        Btn2 = new JButton("2");
        Btn2.setBounds(80, 89, 44, 23);
        frame.getContentPane().add(Btn2);

        Btn4 = new JButton("4");
        Btn4.setBounds(26, 123, 44, 23);
        frame.getContentPane().add(Btn4);

        Btn8 = new JButton("8");
        Btn8.setBounds(80, 157, 44, 23);
        frame.getContentPane().add(Btn8);

        Btn7 = new JButton("7");
        Btn7.setBounds(26, 157, 44, 23);
        frame.getContentPane().add(Btn7);

        Btn5 = new JButton("5");
        Btn5.setBounds(80, 123, 44, 23);
        frame.getContentPane().add(Btn5);

        Btn6 = new JButton("6");
        Btn6.setBounds(134, 123, 44, 23);
        frame.getContentPane().add(Btn6);

        Btn1 = new JButton("1");
        Btn1.setBounds(26, 89, 44, 23);
        frame.getContentPane().add(Btn1);

        Btn3 = new JButton("3");
        Btn3.setBounds(134, 89, 44, 23);
        frame.getContentPane().add(Btn3);

        Btn9 = new JButton("9");
        Btn9.setBounds(134, 157, 44, 23);
        frame.getContentPane().add(Btn9);

        BtnAdd = new JButton("Add");
        BtnAdd.setBounds(188, 89, 98, 23);
        frame.getContentPane().add(BtnAdd);

        BtnSub = new JButton("Substract");
        BtnSub.setBounds(188, 123, 98, 23);
        frame.getContentPane().add(BtnSub);

        BtnMul = new JButton("Multiply");
        BtnMul.setBounds(296, 89, 98, 23);
        frame.getContentPane().add(BtnMul);

        BtnDiv = new JButton("Divide");
        BtnDiv.setBounds(296, 123, 98, 23);
        frame.getContentPane().add(BtnDiv);

        BtnDeriv = new JButton("Derivate");
        BtnDeriv.setBounds(296, 157, 98, 23);
        frame.getContentPane().add(BtnDeriv);

        BtnInt = new JButton("Integrate");
        BtnInt.setBounds(296, 191, 98, 23);
        frame.getContentPane().add(BtnInt);

        LabelResult = new JLabel("Result");
        LabelResult.setBounds(16, 61, 84, 14);
        frame.getContentPane().add(LabelResult);

        resultLabel = new JLabel("");
        resultLabel.setBounds(110, 61, 529, 14);
        frame.getContentPane().add(resultLabel);

        FirstLabel = new JLabel("");
        FirstLabel.setBounds(109, 20, 285, 14);
        frame.getContentPane().add(FirstLabel);

        SecondLabel = new JLabel("");
        SecondLabel.setBounds(109, 36, 285, 14);
        frame.getContentPane().add(SecondLabel);

        BtnFirst = new JButton("First");
        BtnFirst.setBounds(10, 11, 89, 23);
        frame.getContentPane().add(BtnFirst);

        BtnSecond = new JButton("Second");
        BtnSecond.setBounds(10, 36, 89, 23);
        frame.getContentPane().add(BtnSecond);

        BtnPow = new JButton("^");
        BtnPow.setBounds(134, 191, 44, 23);
        frame.getContentPane().add(BtnPow);

        BtnPlus = new JButton("+");
        BtnPlus.setBounds(26, 191, 44, 23);
        frame.getContentPane().add(BtnPlus);

        BtnMinus = new JButton("-");
        BtnMinus.setBounds(80, 191, 44, 23);
        frame.getContentPane().add(BtnMinus);

        BtnClear = new JButton("C");
        BtnClear.setBounds(188, 191, 98, 23);
        frame.getContentPane().add(BtnClear);

        BtnX = new JButton("x");
        BtnX.setBounds(242, 157, 44, 23);
        frame.getContentPane().add(BtnX);

        Btn0 = new JButton("0");
        Btn0.setBounds(188, 157, 44, 23);
        frame.getContentPane().add(Btn0);
    }
// gettere si settere

    public JFrame getFrame() {
        return this.frame;
    }

    public ArrayList<Monom> getLabelFirst()
    {
        String s = FirstLabel.getText();
        Polinom pol = new Polinom();
        pol.setPolinom(new ArrayList<Monom>());
        Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
        Matcher m = p.matcher(s);
        while (m.find()) {
            Monom mon = new Monom();
            float a = Float.parseFloat(m.group(1));
            int b = Integer.parseInt(m.group(2));
            mon.setCoef(a);
            mon.setPower(b);
            pol.getPolinom().add(mon);
        }
        return pol.getPolinom();
    }

    public ArrayList<Monom> getLabelSecond()
    {
        String s = SecondLabel.getText();
        Polinom pol = new Polinom();
        pol.setPolinom(new ArrayList<Monom>());
        Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
        Matcher m = p.matcher(s);
        while (m.find()) {
            Monom mon = new Monom();
            float a = Float.parseFloat(m.group(1));
            int b = Integer.parseInt(m.group(2));
            mon.setCoef(a);
            mon.setPower(b);
            pol.getPolinom().add(mon);
        }
        return pol.getPolinom();
    }

    public void setLabelFirst(String s)
    {
        FirstLabel.setText(s);
    }

    public void setLabelSecond(String s)
    {
        SecondLabel.setText(s);
    }

    public void setResultLabel(String s)
    {
        resultLabel.setText(s);
    }

// actionListeneri

    public void add_1_Listener(ActionListener listener)
    {
        Btn1.addActionListener(listener);
    }
    public void add_2_Listener(ActionListener listener)
    {
        Btn2.addActionListener(listener);
    }
    public void add_3_Listener(ActionListener listener)
    {
        Btn3.addActionListener(listener);
    }
    public void add_4_Listener(ActionListener listener)
    {
        Btn4.addActionListener(listener);
    }
    public void add_5_Listener(ActionListener listener)
    {
        Btn5.addActionListener(listener);
    }
    public void add_6_Listener(ActionListener listener)
    {
        Btn6.addActionListener(listener);
    }
    public void add_7_Listener(ActionListener listener)
    {
        Btn7.addActionListener(listener);
    }
    public void add_8_Listener(ActionListener listener)
    {
        Btn8.addActionListener(listener);
    }
    public void add_9_Listener(ActionListener listener)
    {
        Btn9.addActionListener(listener);
    }

    public void add_Add_Listener(ActionListener listener)
    {
        BtnAdd.addActionListener(listener);
    }
    public void add_Sub_Listener(ActionListener listener)
    {
        BtnSub.addActionListener(listener);
    }
    public void add_Mul_Listener(ActionListener listener)
    {
        BtnMul.addActionListener(listener);
    }
    public void add_Div_Listener(ActionListener listener)
    {
        BtnDiv.addActionListener(listener);
    }

    public void add_Int_Listener(ActionListener listener)
    {
        BtnInt.addActionListener(listener);
    }
    public void add_Deriv_Listener(ActionListener listener)
    {
        BtnDeriv.addActionListener(listener);
    }

    public void add_first_Listener(ActionListener listener)
    {
        BtnFirst.addActionListener(listener);
    }
    public void add_second_Listener(ActionListener listener)
    {
        BtnSecond.addActionListener(listener);
    }
    public void add_Plus_Listener(ActionListener listener)
    {
        BtnPlus.addActionListener(listener);
    }
    public void add_Minus_Listener(ActionListener listener)
    {
        BtnMinus.addActionListener(listener);
    }
    public void add_Pow_Listener(ActionListener listener)
    {
        BtnPow.addActionListener(listener);
    }

    public void add_clear_Listener(ActionListener listener)
    {
        BtnClear.addActionListener(listener);
    }

    public void add_x_Listener(ActionListener listener)
    {
        BtnX.addActionListener(listener);
    }

    public void add_0_Listener(ActionListener listener)
    {
        Btn0.addActionListener(listener);
    }

}