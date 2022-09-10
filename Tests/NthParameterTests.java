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
    @Test
    void sampleTextWithNEquals1Test(){
        assertEquals("ITCLNA",filter.filterUppercase(1, sampleText));
    }

    @Test
    void sampleTextWithNEquals2Test(){
        assertEquals("TLN",filter.filterUppercase(2, sampleText));
    }
    @Test
    void sampleTextWithNEquals3Test(){
        assertEquals("CNA",filter.filterUppercase(3, sampleText));
    }
    @Test
    void sampleTextWithNEquals4Test(){
        assertEquals("L",filter.filterUppercase(4, sampleText));
    }
    @Test
    void newTextWithNEquals1Test(){
        assertEquals("ITCLNANEWTEXT",filter.filterUppercase(1, sampleWithSpaces));
    }
    @Test
    void allLowerCaseReturnsEmptyStringTest(){
        assertEquals("",filter.filterUppercase(1, allLowerCase));
    }

}
