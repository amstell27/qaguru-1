package guru.qa;

import org.junit.jupiter.api.*;

@DisplayName("Это наш первый простой тест")
    
    public class FirstSimpleTest {

    @DisplayName("Простенький тест на assertEquals")
    @Test
    void firstTest() {
        Assertions.assertEquals(1,1);
    }
}
