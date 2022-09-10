import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NthParameterTests {
    private UppercaseLettersFilter filter;

    @BeforeEach
    void setup() {
        filter = new UppercaseLettersFilter();
    }
    @Test
    void noStringIsProvidedTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(1, "");
                });
    }
    @Test
    void argumentNIsNegativeTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(-1, "ITCLiNicAl");
                });
    }
    @Test
    void argumentNIsZeroTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(0, "ITCLiNicAl");
                });
    }
    @Test
    void argumentNIsSameAsTextLengthTest() { //My thought on this one is that the iterator will never find a letter at the index
        //equal to the text length
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(10, "ITCLiNicAl");
                });
    }
    @Test
    void argumentNIsBiggerThanTextLengthTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(100, "ITCLiNicAl");
                });
    }
}
