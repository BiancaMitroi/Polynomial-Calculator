package model;
import model.Operation;
import model.Polinom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperationTest {

    Polinom a = new Polinom();
    Polinom b = new Polinom();
    Polinom result = new Polinom();

    @Test
    void adunare() {
        a.setPolinom(Operation.toPolinom("1x^1"));
        b.setPolinom(Operation.toPolinom("2x^0"));
        result.setPolinom(Operation.add(a, b));
        assertEquals("+1.0x^1+2.0x^0", Operation.toString(result));
    }
    @Test
    void adunare1() {
        a.setPolinom(Operation.toPolinom("1x^1"));
        b.setPolinom(Operation.toPolinom(""));
        result.setPolinom(Operation.add(a, b));
        assertEquals("+1.0x^1", Operation.toString(result));
    }
    @Test
    void adunare2() {
        a.setPolinom(Operation.toPolinom(""));
        b.setPolinom(Operation.toPolinom("1x^2"));
        result.setPolinom(Operation.add(a, b));
        assertEquals("+1.0x^2", Operation.toString(result));
    }
    @Test
    void adunare3() {
        a.setPolinom(Operation.toPolinom(""));
        b.setPolinom(Operation.toPolinom(""));
        result.setPolinom(Operation.add(a, b));
        assertEquals("", Operation.toString(result));
    }
    @Test
    void scadere() {
        a.setPolinom(Operation.toPolinom("1x^1"));
        b.setPolinom(Operation.toPolinom("2x^0"));
        result.setPolinom(Operation.sub(a, b));
        assertEquals("+1.0x^1+-2.0x^0", Operation.toString(result));
    }
    @Test
    void scadere1() {
        a.setPolinom(Operation.toPolinom(""));
        b.setPolinom(Operation.toPolinom("2x^0"));
        result.setPolinom(Operation.sub(a, b));
        assertEquals("+-2.0x^0", Operation.toString(result));
    }
    @Test
    void scadere2() {
        a.setPolinom(Operation.toPolinom("1x^1"));
        b.setPolinom(Operation.toPolinom(""));
        result.setPolinom(Operation.sub(a, b));
        assertEquals("+1.0x^1", Operation.toString(result));
    }
    @Test
    void scadere3() {
        a.setPolinom(Operation.toPolinom(""));
        b.setPolinom(Operation.toPolinom(""));
        result.setPolinom(Operation.sub(a, b));
        assertEquals("", Operation.toString(result));
    }
    @Test
    void inmultire() {
        a.setPolinom(Operation.toPolinom("1x^1"));
        b.setPolinom(Operation.toPolinom("2x^0"));
        result.setPolinom(Operation.mul(a, b));
        assertEquals("+2.0x^1", Operation.toString(result));
    }
    @Test
    void inmultire1() {
        a.setPolinom(Operation.toPolinom(""));
        b.setPolinom(Operation.toPolinom("2x^0"));
        result.setPolinom(Operation.mul(a, b));
        assertEquals("", Operation.toString(result));
    }
    @Test
    void inmultire2() {
        a.setPolinom(Operation.toPolinom("2x^0"));
        b.setPolinom(Operation.toPolinom(""));
        result.setPolinom(Operation.mul(a, b));
        assertEquals("", Operation.toString(result));
    }
    @Test
    void inmultire3() {
        a.setPolinom(Operation.toPolinom(""));
        b.setPolinom(Operation.toPolinom(""));
        result.setPolinom(Operation.mul(a, b));
        assertEquals("", Operation.toString(result));
    }
    @Test
    void impartire() {
        a.setPolinom(Operation.toPolinom("1x^1"));
        b.setPolinom(Operation.toPolinom("2x^0"));
        result.setPolinom(Operation.div(a, b));
        assertEquals("cat: +0.5x^1", "cat: " + Operation.toString(result));
    }
    @Test
    void impartire2() {
        a.setPolinom(Operation.toPolinom("2x^0"));
        b.setPolinom(Operation.toPolinom("1x^1"));
        result.setPolinom(Operation.div(a, b));
        assertEquals("cat: rest: +2.0x^0", "cat: " + Operation.toString(result) + "rest: " + Operation.toString(a));
    }
    @Test
    void impartire1() {
        a.setPolinom(Operation.toPolinom("2x^2+5x^0"));
        b.setPolinom(Operation.toPolinom("1x^1"));
        result.setPolinom(Operation.div(a, b));
        assertEquals("cat: +2.0x^1 rest: +5.0x^0", "cat: " + Operation.toString(result) + " rest: " + Operation.toString(a));
    }
    void impartire3() {
        a.setPolinom(Operation.toPolinom(""));
        b.setPolinom(Operation.toPolinom(""));
        result.setPolinom(Operation.div(a, b));
        assertEquals("cat:  rest: ", "cat: " + Operation.toString(result) + " rest: " + Operation.toString(a));
    }
    @Test
    void derivare() {
        a.setPolinom(Operation.toPolinom("1x^1"));
        result.setPolinom(Operation.der(a));
        assertEquals("+1.0x^0", Operation.toString(result));
    }
    @Test
    void integrare() {
        a.setPolinom(Operation.toPolinom("1x^1"));
        result.setPolinom(Operation.integ(a));
        assertEquals("+0.5x^2", Operation.toString(result));
    }

}
