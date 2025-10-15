package calculator.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

import calculator.common.Constants;

public class SplitBySeparator {
    public static String[] checkChar (String inputString, ArrayList<String> separator) {
        // 디폴트 구분자로 문자열을 나누기 위해 전처리 해줌
        String regex = String.join("|", Constants.DEFAULT_SEPARATOR);

        if (separator.size() > Constants.DEFAULT_SEPARATOR.size()) {
            // 커스텀 구분자가 존재할 시 //(커스텀 구분자)\n 부분 문자열에서 제거
            int customSeparatorIndex = inputString.lastIndexOf("\n");
            inputString = inputString.substring(customSeparatorIndex + 1);

            // 커스텀 구분자가 존재할 시 디폴트 구분자 전처리에 추가해줌
            String safeCustomSeparator = Pattern.quote(separator.get(separator.size() - 1));
            regex = regex + "|" + safeCustomSeparator;
        }

        // 구분자로 문자열을 나눠줌
        String[] splitResult = inputString.split(regex);

        //구분자로 나눠준 후 입력값에 문자열이 남아있는지 확인하고 IllegalArgumentException 출력
        //@Todo

        return splitResult;
    }
}
