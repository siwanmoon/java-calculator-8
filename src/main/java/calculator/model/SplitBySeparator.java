package calculator.model;

import java.util.ArrayList;
import calculator.common.Constants;

public class SplitBySeparator {
    public static String[] checkChar (String inputString, ArrayList<String> separator) {
        //커스텀 구분자가 존재할시 //(커스텀 구분자)\n 부분 문자열에서 제거
        if (separator.size() > Constants.DEFAULT_SEPARATOR.size()) {
            int customSeparatorIndex = inputString.lastIndexOf("\n");
            inputString = inputString.substring(customSeparatorIndex + 1);
        }

        String regex = String.join("|", separator);
        String[] splitResult = inputString.split(regex);

        return splitResult;
    }
}
