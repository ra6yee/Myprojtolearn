package src.TestJunit;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PrimitiveIterator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
private Calculator calculator=new Calculator();
    @Before

   // calculator= new Calculator();

    @Test
    void add() {
        assertEquals(12,calculator.Add(10,2));
    }

    @Test
    void div() {
    }

    @Test
    void multiPly() {
    }

    @Test
    void subtraction() {
    }
}