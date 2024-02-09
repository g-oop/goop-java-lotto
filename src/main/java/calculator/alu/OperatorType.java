package calculator.alu;

import java.util.Arrays;

public enum OperatorType {
    ADD("+"),
    SUB("-"),
    MULTI("*"),
    DIVISION("/");

    private String code;

    OperatorType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean isAdd() {
        return this == ADD;
    }

    public boolean isSub() {
        return this == SUB;
    }

    public boolean isMultiple() {
        return this == MULTI;
    }

    public boolean isDivision() {
        return this == DIVISION;
    }

    public static OperatorType valueOfCode(String code) {
        return Arrays.stream(values())
            .filter(value -> value.code.equals(code))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 코드입니다 : " + code));
    }

    public static boolean isValidCode(String code) {
        return Arrays.stream(values())
            .filter(value -> value.code.equals(code)).findAny().isPresent();
    }
}
