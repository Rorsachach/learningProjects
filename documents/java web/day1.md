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

## 反射：框架设计的灵魂
* 框架：半成品软件。可以在框架的基础上进行软件开发，简化编码
* 反射：将类的各个组成部分封装为其他对象，这就是反射机制
	* 好处：
		1. 可以在程序运行过程中，操作这些对象
		2. 可以解耦，提高程序扩展性
* 获取类对象的方式：
	1. `Class.forName("类路径")`：(第一阶段，类还未进内存时)，将字节码文件加载进内存，返回Class对象
		* 多用于配置文件，将类名定义
	1. `类名.class`：(第二阶段，对应的类已经被引用，加载进了内存)，通过类名class获取
		* 多用于参数的传递
	1. `对象.getClass`：(第三阶段，已经实例化了对象)，通过对象来`getClass()`来获取对象对应的类对象
		* 多用于对象的获取字节码的方式
	* 结论：
		同一个字节吗(`*.class`)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取`Class`对象都是同一个。
* Class对象功能：
	* 获取功能：
		1. 获取成员变量
			* `Field	getDeclaredField(String name)` 获取任意的成员变量
			* `Field[]	getDeclaredFields()` 获取所有成员变量
			* `Field	getField(String name)` 获取public修饰的成员变量
			* `Field[]	getFields()`  获取所有public修饰的成员变量
		1. 获取构造方法
			* `Constructor<T>	getConstructor(Class<?>... parameterTypes)` 获取构造方法，根据参数列表的不同进行区分
				* 
			* `Constructor<?>[]	getConstructors()`
			* `Constructor<T>	getDeclaredConstructor(Class<?>... parameterTypes)`
			* `Constructor<?>[]	getDeclaredConstructors()`
		2. 获取成员方法
			* `Method	getMethod(String name, Class<?>... parameterTypes)`
			* `Method[]	getMethods()`
			* `Method	getDeclaredMethod(String name, Class<?>... parameterTypes)`
			* `Method[]	getDeclaredMethods()`
		3. 获取类名
			* `String	getName()`

* `Field` 功能
	* 获取成员变量后主要进行两种方法 `set` 和 `get`
						1. `Object o = field.get(p);// 获取P对象中的成员变量field`
						2. `field.set(p, 3); // 将P对象中的成员变量field设置为3`
						
	* 注意：在反射面前无论私有还是公有的变量均可以被访问和设置，在对私有变量进行访问和设置时需要 ==**忽略访问权限修饰符（暴力反射）**==

		```java
		Class c = Person.class;
		Field field = c.getDeclareField("name");
					

		field.setAccessible(true);

		Object o = field.get(p);
		System.out.println(o);
		```
		
		
* `Constructor`功能
	* 得到构造函数后可以创建对象
		* `T	newInstance(Object... initargs)` 可以创建对象
		* 如果使用空参数构造方法创建对象，操作可以进行简化。