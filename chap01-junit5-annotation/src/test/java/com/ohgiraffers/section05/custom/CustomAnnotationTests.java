package com.ohgiraffers.section05.custom;

public class CustomAnnotationTests {

    @WindowsTest
    public void testOnWindowOs(){}

    @DevelopmentTest
    public void testDevelopmentCustomTag(){}

    @ProductionTest
    public void testProductionCustomTag(){}

}
