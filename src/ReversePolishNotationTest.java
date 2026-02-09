import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @org.junit.jupiter.api.Test
    void evaluatePostfix() {
        assertEquals(-14, ReversePolishNotation.evaluatePostfix("7 2 + 9 / 3 5 * -"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> ReversePolishNotation.evaluatePostfix("+ 2 * 2 3 + /"));
    }

    @org.junit.jupiter.api.Test
    void infixToPostfix() {
        assertEquals("a b c * + d e * f + g * + ", ReversePolishNotation.infixToPostfix("a + b * c + ( d * e + f ) * g"));

    }
    @org.junit.jupiter.api.Test
    void evaluatePrefix() {
        assertEquals("2", ReversePolishNotation.evaluatePrefix("/ * 2 3 + 1 2"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> ReversePolishNotation.evaluatePostfix("+ 2 * 2 3 + /"));
    }

}