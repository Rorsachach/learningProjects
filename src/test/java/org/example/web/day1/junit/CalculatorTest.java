package org.example.web.day1.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    /**
     * 初始化方法
     * 用于资源申请
     */
    @Before
    public void init(){

    }

    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        int result = c.add(1,2);
        // 打印结果往往并没有什么用处
        // System.out.println(result);
        Assert.assertEquals(result,3);
    }

    /**
     * 释放资源
     */
    @After
    public void close(){

    }
}
