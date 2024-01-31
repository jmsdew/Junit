package com.ohgiraffers.section02.lifecycle;

import org.junit.jupiter.api.*;

public class LifecycleAnnotationTests {

    /*
    *   모든 테스트 메소드와 라이프 사이클 관련 메소드는 abstract 이면 안 되고, void 형으로 작성해야한다.
    *   또한 접근 제한자는 사용하지 않아도 되지만 (default), private이면 안 된다.
    * */

    @BeforeAll        // test 가 실행되기 전에 딱 한번 실행됨
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    /*
    *   각각의 테스트 메소드가 동작한 직후 동작한다.
    * @Test, @RepeatedTest, @ParameterizedTest, @testFactory 가 실행된 이후 동작한다.
    * 주로 단위 테스트들이 수행된 이후 사용한 자원을 해제할 목적으로 사용한다.
    * */

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }




}
