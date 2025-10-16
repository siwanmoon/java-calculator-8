package calculator.common;

import java.util.List;

public class Constants { // 공용 상수, 문자열 선언
    public static final List<String> DEFAULT_SEPARATOR = List.of(",", ":"); // 디폴트 구분자
    public static final String CUSTOM_SEPARATOR_PREFIX = "//"; // 커스텀 구분자 선언 접두사
    public static final String CUSTOM_SEPARATOR_SUFFIX = "\\n"; // 커스텀 구분자 선언 접미사
}
