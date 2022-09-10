public class Main {
    public static void main(String[] args) {
        UppercaseLettersFilter uppercaseLettersFilter = new UppercaseLettersFilter();
        uppercaseLettersFilter.filterUppercase(2, "THIS IS A text STRING THAT i am uSInG to CHEck my Output");
        uppercaseLettersFilter.filterUppercase(-1, "ITCLiNicAl");
        uppercaseLettersFilter.filterUppercase(1, "ITCLiNicAl");
        uppercaseLettersFilter.filterUppercase(2, "ITCLiNicAl");
        uppercaseLettersFilter.filterUppercase(3, "ITCLiNicAl");
        uppercaseLettersFilter.filterUppercase(100, "ITCLiNicAl");
        uppercaseLettersFilter.filterUppercase(10, "ITCLiNicAl");
    }
}
