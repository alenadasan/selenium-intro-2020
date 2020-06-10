package demos;

import org.junit.jupiter.api.*;

/**
 * Created by Ale on 26/07/17.
 */
public class AnnotationsTest extends AnnotationsTestBase {
    @BeforeAll
    public static void classSetUp() {
        System.out.println("Before Class");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before Test Method");
    }

    @Test
    public void testOne() {
        System.out.println("Test one");
    }

    @Test
    public void testTwo() {
        System.out.println("Test two");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After Test Method");
    }

    @AfterAll
    public static void classTearDown() {
        System.out.println("After Class");
    }
}
