package com.ohgiraffers.section01.test;

import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestAnnotationTests {

    /*
    *  1.  junit platform
    *   -jvm 에서 테스트 프레임워크를 실행하기 위한 테스트 엔진을 제공한다.
    * 2.  Junit Jupiter
    *   - Junit5 에서 테스트를 작성하고 실행하기 위한 엔진을 제공한다.
    * 3.  Junit Vintage
    *   - Junit3,4 를 기반으로 돌아가는 테스트 엔진을 제공해 준다.
    * */

    /*
    *   테스트 클래스는 적어도 한 개 이상의 @Test 어노테이션이 달린 메소들르 가진 클래스이다.
    *   테스트 클래스는 abstract이면 안되고, 한 개의 생성자를 가지고 있어야 한다.
    * (두 개 이상 작성하면 런타임 시 PreconditionViolationException 이 발생한다.)
    *   아무런 생성자도 작성하지 않으면 기본 생성자는 컴파일러가 자동으로 추가한다.
    * */

    public TestAnnotationTests(){


        /*
        *   기본적인 테스트 메소드를 만들기 위해 사용하는 어노테이션이다.
        * @Test 메소드는 단독으로 실행이 가능하다.
        * */
    }


    @Test
    @DisplayName("테스트 메소드1")
    public  void testMethod(){

    }

    @Test
    @DisplayName("displayName 우선순위 테스트")
    public void 테스트_메소드2(){
        /*
        *  클래스 레벨 @DisplayNameGenerator를 붙이게 되면 언더바를 공백으로 처리하여 테스트 이름을 부여해준다.
        * 단 @DisplayName 과 중복 작성 시에는 @DisplayName 에 부여한 테스트 이름이 우선순위를 가진다.
        * */
    }

}
