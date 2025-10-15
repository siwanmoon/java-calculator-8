package calculator.model;

// 커스텀 구분자를 확인해 있으면 구분자를, 없으면 빈칸을 return
public class CheckCustomSeparator {
    public static String getSeparator(String inputString) {
        if(inputString.startsWith("//") &&
                inputString.lastIndexOf("\n") != -1) { // "//"로 시작하고 "\n"이 문자열에 있을때 사이의 문자열 return
            return inputString.substring(2, inputString.lastIndexOf("\n"));
        }

        return "";
    }
}
