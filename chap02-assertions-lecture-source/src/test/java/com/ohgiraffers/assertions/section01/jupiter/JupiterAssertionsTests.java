package com.ohgiraffers.assertions.section01.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class JupiterAssertionsTests {

    /*
    *  Junit jupiter 는 junit4 로부터 온 assertion 메소드와 새롭게 자바 8 람다 표현식으로 추가된 메소드를 제공한다.
    *  모든 jupiter assertions 의 메소드는 정적(static) 메소드 형태로 제공하고 있다.
    * */

    /*
    *   테스트 코드의 기본 구조
    *   given : 테스트 시 필요한 파라미터를 준비한다.
    *   when : 테스트 할 메소드를 호출한다.
    *   then : 실행 결과를 검증
    * */

    @Test
    @DisplayName("더하기 기능 테스트")
    void testAssertEquals(){
        // given 단계
        int firstNum = 10;
        int secondNum = 20;
        int expected = 30;

        // when  테스트 메소드 호출
        Calculator calculator = new Calculator();
        int result = calculator.plusTwoNumber(firstNum,secondNum);

        // then  - 예상한 결과, 받은 결과
        Assertions.assertEquals(expected, result);
        
        
        // 실패시 호출할 메시지
        /*Assertions.assertEquals(expected,result,"실패하는 경우 이게 보임");*/

/*        Assertions.assertEquals(expected,result,1);  // 오차 허용범위 체크*/

      /*  Assertions.assertEquals(expected,result,() ->"실패할 때 보여줄 메시지"); // 람다 표현식을 이용한 결과는 동일하지만 불필요한 경우 메시지를 만들지 않도록 지연로딩한다.*/
    }

    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    void testAssertNotEqualsWithInstances(){

        // given /whem
        Object obj1 = new Object();
        Object obj2 = new Object();

        // then
        Assertions.assertNotEquals(obj1,obj2);

    }
    // assertNull(actual) 메소드는 레퍼런스 변수가 null값을 가지는지를 판단한다.
    @Test
    @DisplayName("null 인지 테스트")
    void testAssertNull(){
        //given
        String str;
        // when
        str = null;

        //then
        Assertions.assertNull(str);
    }

    @Test
    @DisplayName("두 값이 같은지 확인")
    void testAssertTrue(){
        int num1 = 10;
        int num2 = 10;

        boolean result = num1 == num2;

       //  Assertions.assertTrue(result);
       // Assertions.assertEquals(result, num2==num1);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("동시에 여러 가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssertAll(){
        String firstName = "길동";
        String lastName = "홍";

        Person person = new Person(firstName, lastName);
        
        Assertions.assertAll(
                () -> Assertions.assertEquals(firstName, person.getFirstName(), "first name이 잘못됨"),
                () -> Assertions.assertNotEquals(lastName, person.getLastName(), "lastName이 잘못됨")
        );
    }

    @Test
    @DisplayName("인스턴스의 타입에 대한 검증을 수행하는 경우")
    void testAssertType(){

        //given - 테스트시 필요한 파라미터를 준비한다.
        String firstName = "길동";
        String lastName = "홍";

        // when - 테스트 대상 준비
        Person person = new Person(firstName, lastName);

        // then : 검증
        Assertions.assertInstanceOf(Person.class, person);
        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(Person.class, person),
                () -> Assertions.assertEquals(firstName, person.getFirstName()),
                () -> Assertions.assertEquals(lastName, person.getLastName())
        );
    }

    // 값은 값, 익셉션은 익셉션 나눠서 테스트 해야함. 한번에 묶기 X
    
    /*
    *   assertDoesNotThrow(execution) 메소드 호출 시 아무런 예외가 발생하지 않는지 확인
    * */
    
    @Test
    @DisplayName("void 메소드의 경우 exception 발생이 없이 정상적으로 동작하는지 테스트")
    void testAssertDoesNotThrow(){

        // given
        int firstNum = 10;
        int secondNum = 3;

        // when & then
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Assertions.assertDoesNotThrow(()->validator.checkDividableNumbers(firstNum,secondNum));

    }

    @Test
    @DisplayName("void 메소드의 경우 exception 발생하는지 테스트")
    void testAssertThrows(){
        //given
        int firstNum = 10;
        int secondNum = 0;

        String exceptedErrorMessage = "0으로 나눌 수 없습니다.";

/*        //when
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> validator.checkDividableNumbers(firstNum,secondNum),
            exceptedErrorMessage
        );*/

        //when
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Exception exception = Assertions.assertThrows(Exception.class,
                () -> validator.checkDividableNumbers(firstNum,secondNum)
        );
        System.out.println(exception);

        //then
        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(PositiveNumberValidator.class, validator), // 클래스 비교
                () -> Assertions.assertInstanceOf(IllegalArgumentException.class, exception),  // 예외 비교
                () -> Assertions.assertDoesNotThrow(()->validator.checkDividableNumbers(secondNum, firstNum)),  // 오류 안나는지 비교
                () -> Assertions.assertEquals(exceptedErrorMessage, exception.getMessage())
        );
    }

    @Test
    @DisplayName("예상 목록이 실제 목록과 일치하지 않는지 확인")
    void testAssertLinesMatch(){
        //given
        List<String> expected = Arrays.asList("java", "database", "spring");

        //when
        List<String>actual = Arrays.asList("java", "database", "spring");
        
        // then
        Assertions.assertLinesMatch(expected, actual, () -> "두 리스트의 값이 일치하지 않음");
    }

}