package demos;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParametrizedTestDemo {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, -5, 3})
    public void checkPositiveValues(int arg) {
        assertThat(arg, greaterThan(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"foo", "bar", "car"})
    public void checkNonEmptyStrings(String arg) {
        assertThat(arg.length(), greaterThan(0));
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    public void checkNotNullStrings(String arg) {
        assertNotNull(arg);
    }

    private static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource("createWordsWithLength")
    public void checkLengthOfWords(String word, int length) {
        assertThat(word.length(), is(length));
    }

    private static Stream<Arguments> createWordsWithLength() {
        return Stream.of(
                Arguments.of("Hello", 5),
                Arguments.of("JUnit 5", 7));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/two-columns.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }

}
