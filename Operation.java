package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
    private static Polinom result;

    public static ArrayList<Monom> add(Polinom a, Polinom b) {

        int i = 0, j = 0;
        result = new Polinom();
        result.setPolinom(new ArrayList<Monom>());
        while(i != a.getPolinom().size() || j != b.getPolinom().size())
        {
            if(i == a.getPolinom().size())
            {
                while(j != b.getPolinom().size())
                {
                    result.getPolinom().add(b.getPolinom().get(j));
                    j++;
                }
            }
            else
            if(j == b.getPolinom().size())
            {
                while(i != a.getPolinom().size())
                {
                    result.getPolinom().add(a.getPolinom().get(i));
                    i++;
                }
            }
            else
            {
                if(a.getPolinom().get(i).getPower() > b.getPolinom().get(j).getPower())
                {
                    result.getPolinom().add(a.getPolinom().get(i));
                    i++;
                }
                else
                if(a.getPolinom().get(i).getPower() < b.getPolinom().get(j).getPower())
                {
                    result.getPolinom().add(b.getPolinom().get(j));
                    j++;
                }
                else
                {
                    if(a.getPolinom().get(i).getCoef() + b.getPolinom().get(j).getCoef() != 0)
                    {
                        Monom c = new Monom();
                        c.setCoef(a.getPolinom().get(i).getCoef() + b.getPolinom().get(j).getCoef());
                        c.setPower(a.getPolinom().get(i).getPower());
                        result.getPolinom().add(c);
                    }

                    i++;
                    j++;
                }
            }

        }
        return result.getPolinom();
    }

    public static ArrayList<Monom> sub(Polinom a, Polinom b) {
        result = new Polinom();
        result.setPolinom(new ArrayList<Monom>());
        int i = 0, j = 0;
        while(i != a.getPolinom().size() || j != b.getPolinom().size())
        {
            if(i == a.getPolinom().size())
            {
                while(j != b.getPolinom().size())
                {
                    Monom m = new Monom();
                    m.setCoef(-b.getPolinom().get(j).getCoef());
                    m.setPower(b.getPolinom().get(j).getPower());
                    result.getPolinom().add(m);
                    j++;
                }
            }
            else
            if(j == b.getPolinom().size())
            {
                while(i != a.getPolinom().size())
                {
                    result.getPolinom().add(a.getPolinom().get(i));
                    i++;
                }
            }
            else
            {
                if(a.getPolinom().get(i).getPower() > b.getPolinom().get(j).getPower())
                {
                    result.getPolinom().add(a.getPolinom().get(i));
                    i++;
                }
                else
                if(a.getPolinom().get(i).getPower() < b.getPolinom().get(j).getPower())
                {
                    Monom m = new Monom();
                    m.setCoef(b.getPolinom().get(j).getCoef() * (-1));
                    result.getPolinom().add(m);
                    j++;
                }
                else
                {
                    if(a.getPolinom().get(i).getCoef() - b.getPolinom().get(j).getCoef() < 1 && a.getPolinom().get(i).getCoef() - b.getPolinom().get(j).getCoef() >= 0)
                    {
                        i++; j++;
                    }
                    else
                    {
                        Monom c = new Monom();
                        c.setCoef(a.getPolinom().get(i).getCoef() - b.getPolinom().get(j).getCoef());
                        c.setPower(a.getPolinom().get(i).getPower());
                        result.getPolinom().add(c);
                        i++; j++;
                    }
                }
            }

        }
        return result.getPolinom();
    }

    public static ArrayList<Monom> mul(Polinom a, Polinom b) {

        result = new Polinom();
        result.setPolinom(new ArrayList<Monom>());

        for(int i = 0; i < a.getPolinom().size(); i++)
            for(int j = 0; j < b.getPolinom().size(); j++)
            {
                Monom m = new Monom();
                m.setCoef(a.getPolinom().get(i).getCoef() * b.getPolinom().get(j).getCoef());
                m.setPower(a.getPolinom().get(i).getPower() + b.getPolinom().get(j).getPower());
                result.getPolinom().add(m);
            }
        for(int i = 0; i < result.getPolinom().size() - 1; i++)
            for(int j = i + 1; j < result.getPolinom().size(); j++)
            {
                if(result.getPolinom().get(i).getPower() == result.getPolinom().get(j).getPower())
                {
                    result.getPolinom().get(i).setCoef(result.getPolinom().get(i).getCoef() + result.getPolinom().get(j).getCoef());
                    result.getPolinom().remove(j);
                    j--;
                }
            }
        return result.getPolinom();
    }

    public static ArrayList<Monom> div(Polinom a, Polinom b) {

        Polinom rez = new Polinom();
        rez.setPolinom(new ArrayList<Monom>());

        Polinom rest = new Polinom();
        rest.setPolinom(a.getPolinom());

        Polinom coef = new Polinom();
        coef.setPolinom(new ArrayList<Monom>());
        while(a.getPolinom() != null)
        {
            if(a.getPolinom().size() == 0)
            {
                break;
            }
            if(b.getPolinom().size() == 0)
                throw new IndexOutOfBoundsException();
            if(a.getPolinom().get(0).getPower() < b.getPolinom().get(0).getPower())
                break;
            Monom m = new Monom();
            float c = a.getPolinom().get(0).getCoef() / b.getPolinom().get(0).getCoef();


            m.setCoef(c);
            m.setPower(rest.getPolinom().get(0).getPower() - b.getPolinom().get(0).getPower());
            coef.getPolinom().add(m);
            rez.getPolinom().add(m);

            rest.setPolinom(Operation.mul(b, coef));
            rest.setPolinom(Operation.sub(a, rest));
            if(rest.getPolinom().size() == 0)
                a.setPolinom(null);
            else
                a.setPolinom(rest.getPolinom());
            coef.getPolinom().clear();
        }

        return rez.getPolinom();
    }

    public static ArrayList<Monom> der(Polinom a) {
        int size = a.getPolinom().size();
        int i = 0;
        while(i != size)
        {
            a.getPolinom().get(i).setCoef(a.getPolinom().get(i).getCoef() * a.getPolinom().get(i).getPower());
            a.getPolinom().get(i).setPower(a.getPolinom().get(i).getPower() - 1);
            i++;
        }
        return a.getPolinom();
    }

    public static ArrayList<Monom> integ(Polinom a) {
        int size = a.getPolinom().size();
        int i = 0;
        while(i != size)
        {
            a.getPolinom().get(i).setCoef(a.getPolinom().get(i).getCoef() / (a.getPolinom().get(i).getPower() + 1));
            a.getPolinom().get(i).setPower(a.getPolinom().get(i).getPower() + 1);
            i++;
        }
        return a.getPolinom();
    }

    public static Polinom mul(Polinom a, float scalar)
    {
        for(int i = 0; i < a.getPolinom().size(); i++)
        {
            Monom m = new Monom();
            m.setCoef(a.getPolinom().get(i).getCoef() * scalar);
            m.setPower(a.getPolinom().get(i).getPower());
            result.getPolinom().add(m);
        }
        return result;
    }

    public static ArrayList<Monom> toPolinom(String s)
    {
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

    public static String toString(Polinom a)
    {
        String s = "";
        for(Monom m : a.getPolinom())
        {
//			if(m.getPower() == 0)
//			{
//				s += "+" + m.getCoef(); continue;
//			}
//			if(m.getPower() == 1)
//			{
//				s += "+" + m.getCoef() + "x"; continue;
//			}
            s += "+" + m.getCoef() + "x^" + m.getPower();
        }
        return s;
    }
}
