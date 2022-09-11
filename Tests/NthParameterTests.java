import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NthParameterTests {
    private UppercaseLettersFilter filter;
    String sampleText = "ITCLiNicAl";
    String sampleWithSpaces = "ITCLiNicAl NEW TEXT";
    String allLowerCase = "itclinical lowercase text";

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

    //Testing the argument N
    @Test
    void argumentNIsNegativeTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(-1, sampleText);
                });
    }

    @Test
    void argumentNIsZeroTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(0, sampleText);
                });
    }

    @Test
    void argumentNIsSameAsTextLengthTest() { //My thought on this one is that the iterator will never find a letter at the index
        //equal to the text length
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(10, sampleText);
                });
    }

    @Test
    void argumentNIsBiggerThanTextLengthTest() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    filter.filterUppercase(100, sampleText);
                });
    }

    // Testing the text
    @Test
    void sampleTextWithNEquals1Test() {
        assertEquals("ITCLNA", filter.filterUppercase(1, sampleText));
    }

    @Test
    void sampleTextWithNEquals2Test() {
        assertEquals("TLN", filter.filterUppercase(2, sampleText));
    }

    @Test
    void sampleTextWithNEquals3Test() {
        assertEquals("CNA", filter.filterUppercase(3, sampleText));
    }

    @Test
    void sampleTextWithNEquals4Test() {
        assertEquals("L", filter.filterUppercase(4, sampleText));
    }

    @Test
    void newTextWithNEquals1Test() {
        assertEquals("ITCLNANEWTEXT", filter.filterUppercase(1, sampleWithSpaces));
    }

    @Test
    void allLowerCaseReturnsEmptyStringTest() {
        assertEquals("", filter.filterUppercase(1, allLowerCase));
    }

    //Testing numbers and special characters
    @Test
    void numbersAreReturnedTest() {
        assertEquals("ICL1N", filter.filterUppercase(1, "ItCL1Nical"));
    }

    @Test
    void specialCharactersAreReturnedTest() {
        assertEquals("!CL1N", filter.filterUppercase(1, "!tCL1Nical"));
    }

    @Test
    void whiteSpacesAreNotReturnedTest() {
        assertEquals("!CL1N", filter.filterUppercase(1, "!tCL1 Nical"));
    }
    /*@Test  ver como faço um teste para ver os números do hashmap
    void counterReturnsCorrectNumberOfCharsTest(){
        assertEqu
    }*/
}
