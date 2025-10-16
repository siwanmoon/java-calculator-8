package calculator.model;

public class IntegrityCheck {
    public static void checkUnexpectedString (String[] splittedInput) { // 구분자 제외한 문자 확인
        for(String s: splittedInput) {
            if(!s.chars().allMatch(Character :: isDigit)) {
                // 문자열에 숫자를 제외한 문자가 존재하면 IllegalArgumentException 발생
                throw new IllegalArgumentException("구분자 외의 문자 입력이 인식되었습니다");
            }
        }
    }
}
