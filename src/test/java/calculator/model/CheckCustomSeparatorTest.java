package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckCustomSeparatorTest {
    @Test
    @DisplayName("커스텀 구분자 확인")
    void checkCustomSeparator() {
        String test1 = "//12\n25,5";
        String test2 = "//12234";
        String test3 = "/\n4562";
        String test4 = "//,\n45:5,4";

        assertThat(CheckCustomSeparator.getSeparator(test1)).isEqualTo("12");
        assertThat(CheckCustomSeparator.getSeparator(test2)).isEqualTo(",");
        assertThat(CheckCustomSeparator.getSeparator(test3)).isEqualTo(",");
        assertThat(CheckCustomSeparator.getSeparator(test4)).isEqualTo(",");
    }
}
