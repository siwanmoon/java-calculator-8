package calculator.view;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "결과 : ";

    public static void printOutput(long result) {
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
