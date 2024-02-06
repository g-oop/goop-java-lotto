//package calculator.alu;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
//import static org.junit.jupiter.api.Assertions.*;
//
//@DisplayName("도메인 - Alu 테스트")
//class AluTest {
//
//    private Alu alu;
//    @BeforeEach
//    void aluInit() {
//        alu = new Alu();
//    }
//    @Test
//    void add_정상() {
//        //given
//        int mainOperand = 0;
//        int subOperand = 1;
//        String operator = "+";
//        //when
//        int result = alu.add(mainOperand, subOperand, operator);
//        //then
//        assertThat(result).isEqualTo(mainOperand + subOperand);
//    }
//
//    @Test
//    void add_연산자_예외() {
//        //given
//        int mainOperand = 0;
//        int subOperand = 1;
//        String operator = "-";
//
//        assertThatIllegalArgumentException()
//            .isThrownBy(() -> alu.add(mainOperand, subOperand, operator))
//            .withMessage("덧셈 연산자 불일치: " + operator);
//    }
//
//    @Test
//    void sub() {
//        //given
//        int mainOperand = 0;
//        int subOperand = 1;
//        String operator = "-";
//        //when
//        int result = alu.sub(mainOperand, subOperand, operator);
//        //then
//        assertThat(result).isEqualTo(mainOperand - subOperand);
//    }
//
//    @Test
//    void sub_연산자_예외() {
//        //given
//        int mainOperand = 0;
//        int subOperand = 1;
//        String operator = "+";
//
//        assertThatIllegalArgumentException()
//            .isThrownBy(() -> alu.sub(mainOperand, subOperand, operator))
//            .withMessage("뺄셈 연산자 불일치: " + operator);
//    }
//
//    @Test
//    void multiple() {
//        //given
//        int mainOperand = 0;
//        int subOperand = 1;
//        String operator = "*";
//        //when
//        int result = alu.multiple(mainOperand, subOperand, operator);
//        //then
//        assertThat(result).isEqualTo(mainOperand * subOperand);
//    }
//
//    @Test
//    void multiple_연산자_예외() {
//        //given
//        int mainOperand = 0;
//        int subOperand = 1;
//        String operator = "/";
//
//        assertThatIllegalArgumentException()
//            .isThrownBy(() -> alu.multiple(mainOperand, subOperand, operator))
//            .withMessage("곱셈 연산자 불일치: " + operator);
//    }
//
//    @Test
//    void division() {
//        //given
//        int mainOperand = 4;
//        int subOperand = 2;
//        String operator = "/";
//        //when
//        int result = alu.division(mainOperand, subOperand, operator);
//        //then
//        assertThat(result).isEqualTo(mainOperand / subOperand);
//    }
//
//    @Test
//    void division_연산자_예외() {
//        //given
//        int mainOperand = 2;
//        int subOperand = 1;
//        String operator = "*";
//
//        assertThatIllegalArgumentException()
//            .isThrownBy(() -> alu.division(mainOperand, subOperand, operator))
//            .withMessage("나눗셈 연산자 불일치: " + operator);
//    }
//
//    @Test
//    void division_나머지_존재_예외() {
//        //given
//        int mainOperand = 5;
//        int subOperand = 2;
//        String operator = "/";
//
//        assertThatIllegalArgumentException()
//            .isThrownBy(() -> alu.division(mainOperand, subOperand, operator))
//            .withMessage("나눗셈 나머지 존재: " + mainOperand + "/" + subOperand);
//    }
//}
