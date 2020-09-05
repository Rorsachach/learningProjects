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

* `Method` 功能
	* `Object	invoke(Object obj, Object... args)` 执行方法
	```java
	public class Reflect4 {
		public static void main(String[] args) throws Exception {
			Class c = Person.class;

			Method setName = c.getMethod("setName", String.class);
			Person p = new Person();
			System.out.println(p);
			setName.invoke(p, "fxy"); // p对象使用setName方法，其中参数为"fxy"
			System.out.println(p);
		}
	}
	```
	
	* 案例：
		* 需求：协议一个框架，帮助创建任意类的对象，执行任意方法
		* 实现：
			1. 配置文件
			2. 反射
		* 步骤：
			1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
			2. 在程序中加载读取配置文件
			3. 使用反射技术来加载类文件进内存
			4. 创建对象
			5. 执行方法

## 注解

* 功能：
	* 编译检查
	* 编写文档
	* 代码分析

* JDK中定义的注解
	* @Override：检测是否是继承父类(接口)的
	* @Deprecated：表示已经过时
	* @SuppressWarnings：压制警告
* 自定义注解
	* 格式：
		1. 元注解
		2. `public @interface 注解名{}`
	* 本质：注解的本质就是一个接口，该接口默认集成 Annotation 接口
		`public interface org.example.web.day1.Annotation.MyAnno extends java.lang.annotation.Annotation { }`
		![[Pasted image.png]]
	* 属性：接口中定义的抽象方法	
		* 要求：
			1. 返回值类型
				* 基本数据类型
				* String
				* 枚举
				* 注解
				* 数组
			2. 定义了属性，在使用时需要给属性赋值
				* `default` 可以设置默认初始化值
				* 如果只有一个属性，且为 `value`， 则value可省略
	* 元注解
		用来表述注解的注解。
		1. @Target：描述注解能够作用的位置
			* ElementType：
				* TYPE：作用于类
				* METHOD：作用于方法
				* FIELD：作用于成员变量
		1. @Retention：描述注解被保留的阶段
			* `@Retention(RetentionPolicy.RUNTIME)`：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到，一般自定义注解均使用RUNTIME值
		2. @Documented：描述注解会被抽取到文档
		3. @Inherited：描述注解会被子类继承
* 使用注解
	通过注解来替换配置文件的操作，次部分和反射案例`ReflectDemo.java`进行对比
	1. 获取注解定义位置的对象 Class Method Field
	2. 获取位置对象上的注解对象 `getAnnotation()`，实际上此步创建了一个实现注解(接口)的子类
	3. 调用注解中的抽象方法获取配置的属性值
	
	```java
	@Pro(className = "org.example.web.day1.Annotation.Student", methodName = "eat")
	public class ReflectDemo2 {
		public static void main(String[] args) throws Exception {
			// 1. 解析注解
			// 获取该类的字节码文件
			Class<ReflectDemo2> c = ReflectDemo2.class;
			// 获取注解对象
			// 在内存中生成了一个该注释接口的子类实现对象
			Pro pro = c.getAnnotation(Pro.class);
			// 调用注解对象中定义的抽象方法，获取返回值
			String className = pro.className();
			String methodName = pro.methodName();

			Class cls = Class.forName(className);
			Constructor constructor = cls.getConstructor();
			Object o = constructor.newInstance();
			cls.getMethod(methodName).invoke(o);
		}
	}
	```
	```java
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Pro {
		String className();
		String methodName();
	}
	```

* 注解实例
	简单的测试框架
```java
package org.example.web.day1.Annotation;

import java.lang.reflect.Method;

/**
 * @author: 卑微小冯
 * Date: 2020/9/5 上午7:49
 * Project: learningProjects
 * Package: org.example.web.day1.Annotation
 *
 * 当方法执行后，会自动检测所有家了check注解的方法，判断方法是否有异常
 */

public class TestCheck {
    public static void main(String[] args) {
        //1. 创建计算器对象
        TestCalc calc = new TestCalc();
        Class c = calc.getClass();

        Method[] methods = c.getMethods();

        int num = 0;

        for (Method method : methods) {
            if(method.isAnnotationPresent(Check.class)){
                try{
                    method.invoke(calc, 1,0);
                }catch (Exception e){
                    System.out.println("第"+num+"个方法出异常了");
                    System.out.println("异常名称"+e.getCause().getClass().getSimpleName());
                    System.out.println("异常原因"+e.getCause().getMessage());
                }
                num++;
            }
        }

        System.out.println(num);
    }
}
```

```java
package org.example.web.day1.Annotation;

/**
 * @author: 卑微小冯
 * Date: 2020/9/5 上午7:51
 * Project: learningProjects
 * Package: org.example.web.day1.Annotation
 */

public class TestCalc {
    @Check
    public int add(int a, int b){
        return a/b;
    }

    @Check
    public int sub(int a, int b){
        return a-b;
    }

    @Check
    public int mul(int a, int b){
        return a*b;
    }

    @Check
    public int div(int a, int b){
        return a/b;
    }

    @Check
    public void show(int a, int b){
        System.out.println("ending...");
    }
}
```

## 小结
* 大多数时候，我们会使用注解，而不是自定义注解
* 注解给谁用？
	1. 编译器
	2. 给解析程序用
* 注解不是程序的一部分，可以理解为注解就是一个标签