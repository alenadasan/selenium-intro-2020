package demos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Created by Ale on 03/01/18.
 */
public class AnnotationsTestBase {
    @BeforeAll
    public static void baseClassSetUp() {
        System.out.println("Test Base Before Class");
    }

    @AfterAll
    public static void baseClassTearDown() {
        System.out.println("Test Base After Class");
    }

    @BeforeEach
    public void baseSetUp() {
        System.out.println("Test Base Before Test Method");
    }

    @AfterEach
    public void baseTearDown() {
        System.out.println("Test Base After Test Method");
    }
}
