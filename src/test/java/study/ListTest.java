package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    @ParameterizedTest
    @CsvSource(value = {
            "+ - * / : true true true true",
            "+ * * + : true true true true",
            "+ e * A : true false true false",
            "+ + ^ + : true true false true"
    }, delimiter = ':')
    public void listTest2(String source, String expected) {
        //given
        List<Boolean> expectedBooleans = Stream.of(expected.split(" "))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());

        List<String> list = Arrays.asList(source.split(" "));
        assertThat(list).extracting(e -> e.matches("^(\\+)|(-)|(\\*)|(/)$"))
                .containsExactly(
                        expectedBooleans.get(0), expectedBooleans.get(1),
                        expectedBooleans.get(2), expectedBooleans.get(3)
                );
    }

    @ParameterizedTest
    @CsvSource(value = {"+ - * A : 3", "+ e * A : 2", "+ + ^ + : 3"}, delimiter = ':')
    public void listTest3(String source, int expected) {
        //given
        Pattern pattern = Pattern.compile("^(\\+)|(-)|(\\*)|(/)$");
        List<String> list = Arrays.asList(source.split(" "));
        assertThat(list).filteredOn(e -> pattern.matcher(e).find())
                .size()
                .isEqualTo(expected);
    }
}
