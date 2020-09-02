# java web 第一天
## Junit 单元测试
* 测试分类：
	1. 黑盒测试：不需要写代码，给输入值，看程序是否能够输出期望值
	2. 白盒测试：需要写代码。关注程序具体的执行流程。
* Junit：白盒测试
	* 步骤：
		1. 定义一个测试类，测试用例
			* 建议：
				* 测试类名：被测试的类名+Test
				* 包名：xxx.xxx.xxx.test
		2. 定义测试方法：可以独立执行
			* 建议：
				* 方法名：test+测试方法名
				* 返回值：void
				* 参数列表：空 
		3. 给方法添加@Test
		4. 导入junit依赖

	* 测试结果：
		* 红色：失败
		* 绿色：成功
		* 一般不进行打印，使用断言的方式来处理结果
			* `Assert.assertEquals(a,b);`

	* 补充
		* @Before
			* 修饰的方法会在测试方法执行之前执行
		* @After
			* 修饰的方法会在测试方法执行之后执行

```java
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

```