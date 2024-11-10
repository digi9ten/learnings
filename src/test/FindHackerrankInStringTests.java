package test;

import main.FindHackerrankInString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindHackerrankInStringTests {

    @Test
    void generalTests() {
        assertEquals("YES", FindHackerrankInString.hackerrankInString("hackerrank"));

        assertEquals("NO", FindHackerrankInString.hackerrankInString("helloworld"));

        assertEquals("NO", FindHackerrankInString.hackerrankInString(""));

        assertEquals("NO", FindHackerrankInString.hackerrankInString(null));

        assertEquals("YES", FindHackerrankInString.hackerrankInString("hackerrrank"));

        assertEquals("YES", FindHackerrankInString.hackerrankInString("hackysgdherherweishtank"));
    }
}
