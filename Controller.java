package controller;
import view.View;


//import java.util.Collections;
import java.awt.event.*;

import javax.swing.JOptionPane;

import model.Operation;
import model.Polinom;
//import java.io.IOException;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;

public class Controller {
    View view = new View();
    char btn = 0;
    String first = "";
    String second = "";
    public Controller()
    {
        view.add_1_Listener(new Btn_1_Listener());
        view.add_2_Listener(new Btn_2_Listener());
        view.add_3_Listener(new Btn_3_Listener());
        view.add_4_Listener(new Btn_4_Listener());
        view.add_5_Listener(new Btn_5_Listener());
        view.add_6_Listener(new Btn_6_Listener());
        view.add_7_Listener(new Btn_7_Listener());
        view.add_8_Listener(new Btn_8_Listener());
        view.add_9_Listener(new Btn_9_Listener());

        view.add_Add_Listener(new Btn_Add_Listener());
        view.add_Sub_Listener(new Btn_Sub_Listener());
        view.add_Mul_Listener(new Btn_Mul_Listener());
        view.add_Div_Listener(new Btn_Div_Listener());
        view.add_Deriv_Listener(new Btn_Deriv_Listener());
        view.add_Int_Listener(new Btn_Int_Listener());

        view.add_Plus_Listener(new Btn_plus_Listener());
        view.add_Minus_Listener(new Btn_minus_Listener());
        view.add_Pow_Listener(new Btn_pow_Listener());
        view.add_first_Listener(new Btn_first_Listener());
        view.add_second_Listener(new Btn_second_Listener());
        view.add_clear_Listener(new Btn_clear_Listener());
        view.add_x_Listener(new Btn_x_Listener());
        view.add_0_Listener(new Btn_0_Listener());
        view.getFrame().setVisible(true);
    }

    public class Btn_1_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "1"; view.setLabelFirst(first); break;
                case 's': second += "1"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_2_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "2"; view.setLabelFirst(first); break;
                case 's': second += "2"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_3_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "3"; view.setLabelFirst(first); break;
                case 's': second += "3"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_4_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "4"; view.setLabelFirst(first); break;
                case 's': second += "4"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_5_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "5"; view.setLabelFirst(first); break;
                case 's': second += "5"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_6_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "6"; view.setLabelFirst(first); break;
                case 's': second += "6"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_7_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "7"; view.setLabelFirst(first); break;
                case 's': second += "7"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_8_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "8"; view.setLabelFirst(first); break;
                case 's': second += "8"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_9_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "9"; view.setLabelFirst(first); break;
                case 's': second += "9"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_Add_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Polinom a = new Polinom();
            a.setPolinom(view.getLabelFirst());
            Polinom b = new Polinom();
            b.setPolinom(view.getLabelSecond());
            Polinom result = new Polinom();
            result.setPolinom(Operation.add(a, b));
            view.setResultLabel(Operation.toString(result));
        }
    }

    public class Btn_Sub_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Polinom a = new Polinom();
            a.setPolinom(view.getLabelFirst());
            Polinom b = new Polinom();
            b.setPolinom(view.getLabelSecond());
            Polinom result = new Polinom();
            result.setPolinom(Operation.sub(a, b));
            view.setResultLabel(Operation.toString(result));
        }
    }

    public class Btn_Mul_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Polinom a = new Polinom();
            a.setPolinom(view.getLabelFirst());
            Polinom result = new Polinom();
            Polinom b = new Polinom();
            b.setPolinom(view.getLabelSecond());
            result.setPolinom(Operation.mul(a, b));
            view.setResultLabel(Operation.toString(result));
        }
    }

    public class Btn_Div_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                String s = "";
                Polinom a = new Polinom();
                a.setPolinom(view.getLabelFirst());
                Polinom result = new Polinom();
                Polinom b = new Polinom();
                b.setPolinom(view.getLabelSecond());
//			if(a.getPolinom().size() < b.getPolinom().size())
//				throw new DeimpartitMaiMicDecatImpartitorException();
                result.setPolinom(Operation.div(a, b));
                s += "cat: " + Operation.toString(result);
                if(a.getPolinom() != null)
                    s += " rest: " + Operation.toString(a);
                view.setResultLabel(s);
            }catch(IndexOutOfBoundsException f) {
                JOptionPane.showMessageDialog(null, "Nu se poate face impartirea deoarece al doilea camp este vid!");
            }
//			catch(DeimpartitMaiMicDecatImpartitorException g) {
//				JOptionPane.showMessageDialog(null, "Nu se poate face impartirea deoarece polinomul deimpartitului are grad mai mic decat polinomul impartitorului!");
//			}
        }
    }

    public class Btn_Deriv_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Polinom a = new Polinom();
            a.setPolinom(view.getLabelFirst());
            Polinom result = new Polinom();
            result.setPolinom(Operation.der(a));
            view.setResultLabel(Operation.toString(result));
        }
    }

    public class Btn_Int_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Polinom a = new Polinom();
            a.setPolinom(view.getLabelFirst());
            Polinom result = new Polinom();
            result.setPolinom(Operation.integ(a));
            view.setResultLabel(Operation.toString(result));
        }
    }

    public class Btn_first_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            btn = 'f';
        }
    }

    public class Btn_second_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            btn = 's';
        }
    }

    public class Btn_plus_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "+"; view.setLabelFirst(first); break;
                case 's': second += "+"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_minus_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "-"; view.setLabelFirst(first); break;
                case 's': second += "-"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_pow_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "^"; view.setLabelFirst(first); break;
                case 's': second += "^"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_clear_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first = ""; view.setLabelFirst(first); break;
                case 's': second = ""; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_x_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "x"; view.setLabelFirst(first); break;
                case 's': second += "x"; view.setLabelSecond(second); break;
            }
        }
    }

    public class Btn_0_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (btn)
            {
                case 'f': first += "0"; view.setLabelFirst(first); break;
                case 's': second += "0"; view.setLabelSecond(second); break;
            }
        }
    }

}
