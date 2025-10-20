package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 문자열_커스텀구분자_테스트() {
        assertSimpleTest(() -> {
            run("//cut\\n1:2cut3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈칸_커스텀구분자_테스트() {
        assertSimpleTest(() -> {
            run("// \\n1:2 3 4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void long_이상의_큰수입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,45646545645464564654856445"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_null_테스트() {
        assertSimpleTest(() -> {
            run("//\\n1:2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 공백_입력_테스트() {
        assertSimpleTest(() -> {
            run("1::2,:3,,4,");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
