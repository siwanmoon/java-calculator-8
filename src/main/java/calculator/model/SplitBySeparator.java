package calculator.model;

import java.util.ArrayList;
import java.util.regex.Pattern;
import calculator.common.Constants;

public class SplitBySeparator {
    public static String[] checkChar (String inputString, ArrayList<String> separator) {
        // 디폴트 구분자로 문자열을 나누기 위해 전처리 해줌
        String regex = String.join("|", Constants.DEFAULT_SEPARATOR);

        // 커스텀 구분자 부분을 지우고 더할 문자열 부분만 남김
        inputString = deleteCustomSeparator(inputString);

        if (separator.size() > Constants.DEFAULT_SEPARATOR.size()) {
            // 커스텀 구분자가 존재할 시 디폴트 구분자 전처리에 추가해줌
            String safeCustomSeparator = Pattern.quote(separator.getLast());
            regex = regex + "|" + safeCustomSeparator;
        }

        // 구분자로 문자열을 나눠줌
        return inputString.split(regex);
    }

    // 커스텀 구분자가 선언되었을 시 //(커스텀 구분자)\n 부분 문자열에서 제거
    public static String deleteCustomSeparator (String inputString) {
        int customSeparatorPrefixIndex = inputString.indexOf(Constants.CUSTOM_SEPARATOR_PREFIX);
        int customSeparatorSuffixIndex = inputString.lastIndexOf(Constants.CUSTOM_SEPARATOR_SUFFIX);

        if(customSeparatorPrefixIndex != -1 && customSeparatorSuffixIndex != -1) {
            // 커스텀 구분자의 종료 선언이 시작되는 지점에 종료 선언 문자열의 길이를 더해 입력 문자열을 잘라줌
            inputString = inputString.substring(customSeparatorSuffixIndex +
                    Constants.CUSTOM_SEPARATOR_SUFFIX.length());
        }

        return inputString;
    }
}
