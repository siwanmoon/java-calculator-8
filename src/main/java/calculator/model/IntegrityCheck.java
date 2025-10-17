package calculator.model;

import java.util.ArrayList;

public class IntegrityCheck {
    private static final String UNEXPECTED_STRING_EXCEPTION =
            "구분자 외의 문자 입력이 인식되었습니다.";
    private static final String CUSTOM_SEPARATOR_DIGIT =
            "주의! 커스텀 구분자가 숫자로만 이뤄져있습니다. 오타에 주의하세요.";

    public static void checkUnexpectedString (ArrayList<String> dividedInput) { // 구분자 제외한 문자 확인
        for (String s: dividedInput) {
            if (!s.chars().allMatch(Character :: isDigit)) {
                // 문자열에 숫자를 제외한 문자가 존재하면 IllegalArgumentException 발생
                throw new IllegalArgumentException(UNEXPECTED_STRING_EXCEPTION);
            }
        }
    }

    public static void checkCustomSeparatorDigit (String customSeparator) {
        // 커스텀 구분자가 숫자로만 이뤄져있으면 경고문 출력
        if (customSeparator.chars().allMatch(Character :: isDigit)) {
            System.out.println(CUSTOM_SEPARATOR_DIGIT);
        }
    }
}
