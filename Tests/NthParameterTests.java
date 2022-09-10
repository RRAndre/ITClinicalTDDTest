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
                    filter.filterUppercase(0, "");
                    filter.filterUppercase(1, "");
                    filter.filterUppercase(2, "");
                    filter.filterUppercase(3, "");
                    filter.filterUppercase(4, "");
                    filter.filterUppercase(5, "");
                });
    }
    @Test
    void argumentNIsNegativeOrZeroTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(-1, "ITCLiNicAl");
                    filter.filterUppercase(-100, "ITCLiNicAl");
                    filter.filterUppercase(-2, "ITCLiNicAl");
                    filter.filterUppercase(0, "ITCLiNicAl");
                    filter.filterUppercase(-10, "ITCLiNicAl");
                    filter.filterUppercase(-0, "ITCLiNicAl");
                });
    }

    @Test
    void argumentNIsBiggerThanTextLengthTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(9, "ITCLiNicAl");
                    filter.filterUppercase(100, "ITCLiNicAl");
                    filter.filterUppercase(15, "ITCLiNicAl");
                    filter.filterUppercase(20, "ITCLiNicAl");
                    filter.filterUppercase(30, "ITCLiNicAl");
                    filter.filterUppercase(1000, "ITCLiNicAl");
                });
    }

    @Test
    void argumentNIsSmallerThanTextLengthTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(9, "ITCLiNicAl");
                });
    }
}
