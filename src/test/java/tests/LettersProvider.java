package tests;

import org.testng.annotations.DataProvider;

public class LettersProvider {
    @DataProvider
    public static Object[][] getLetters() {
       return new Object[][] {{"a"},{"b"},{"c"}};

    }
}
