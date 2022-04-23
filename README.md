# Spring框架
学习Spring框架笔记和代码
# 1、框架的概述
   所谓的框架其实就是程序的架子，在这个程序的架子中，搭建起程序的基本的骨架，针对程序的通用问题给出了便捷的解决方案，可以使开发人员基于框架快速开发具体的应用程序。
   就像盖房子，老家盖楼自己一旦一点的打地基慢慢盖。
               现在大楼大厦这种，都是搭建架子，然后再填水泥…
   小程序用Servlet+JSP
   大程序用框架SSM
# 2、常用的框架
##   早期框架 SSH
     

  -  Struts2   Servlet       (不安全)
   - Spring   javabean
   -  Hibernate   jdbc（设计理念好，性能低，复杂/难）

##   现在框架 SSM
        

- Spring     javabean
-  SpringMVC    Servlet
- Mybatis   jdbc

# 3、Spring框架的概述
   Spring是一个开源框架，可以整合许多其他的框架进行工作。
   Spring的主要技术是IOC(DI)和AOP
         IOC(DI)  --   控制反转（依赖注入）
         简单说让IOC完成对对象的创建和销毁
               以前Person p=new Person();
               IOC Person p=null;   告诉IOC我要用p即可，IOC负责创 
建具体的对象
              以前的做法不能解耦合，现在可以使用IOC管理，解决耦合问题
         AOP – 面向切面编程
               也是为了解耦合，层与层之间加入切面代码
# 4、IOC（DI）的概念
   所谓的IOC称之为控制反转，简单来说就是将对象的创建的权力及对象的生命周期的管理过程交给由Spring框架来处理，从此再开发过程中不再需要关注对象的创建和生命周期的管理，而是再需要时由Spring框架提供，这个由Spring框架管理对象和生命周期的机制称之为控制反转。
而在创建对象的过程中Spring可以依据配置对对象的属性进行设置，这个过程称之为依赖注入，也成为DI。
Book b=new Book();      ---   IOC
b.setId();
b.setProductName();         --DI
# 5、IOC的第一个案例—环境的搭建
   IOC控制反转，管理javabean
  -  (1)下载Spring开发包    https://spring.io
      docs文档 libs     开发用的jar包     schema   约束
  - （2）创建一个普通的Java项目就可以（Spring因为是管理模型层的javabean，
没必要非得创建web项目）
 -  （3）导入spring开发需要用的jar包（开发IOC的例子，使用如下7个jar
包）
![在这里插入图片描述](https://img-blog.csdnimg.cn/92e368ee33c04bfea045dcdc803feb04.png)

   （4）spring开发需要创建一个专门的配置文件，文件名和位置任意，一般定
义再在src目录下，文件名一般定义为applicationContext.xml
   （5）spring的spring-beans-3.2.xsd约束引入进来
# 6、IOC的第一个案例2
   类Person  -->  IOC创建、管理Person
# 7、IOC的实现原理
   在初始化一个Spring容器时，Spring会解析指定的xml文件，当解析到其中的<bean>标签时，会根据该标签的class属性中指定的类的全路径名，通过反射该类的对象，将该对象存入内置的Map中管理。
Class.forName(“com.lddx.bean.Person”)   --->Person类
（通过反射获得的类对象等价于new Person获得的对象）
Map.put(“person”,Person);   
以上都是Spring容器底层完成的
当通过context.getBean(“person”)方法从容器中获取对象时，相当于底层
Map.get(“person”)   --->Person
由此可以得出几个推论：
- （1）默认情况下，多次获取同一个id的bean，得到的将是同一个对象
- （2）即使是同一个类，如果配置多个<bean>标签具有不同的id，每个id都会
在内置的Map中由一对键值对，其中的值就是这个类创建的不同对象
-  （3）同一个<beans>标签下，不允许配置多个相同id的<bean>标签，如果相
同会报错。
# 8、IOC获取对象的方式  -- SpringN01_03_IOCDemo02
-   （1）通过bean标签的id属性来获取对象
-   （2）通过bean标签的class属性来获取对象
     （有潜在风险，在配置中的<bean>标签可能会出现多个一样的class属性）
-   （3）通过别名来获取对象（前提需要使用alias标签定义别名）
# 9、IOC创建对象的方式    SpringN01_04_IOCCreate
   - （1）通过类的无参构造方式创建对象
   - （2）通过静态工厂的方式创建对象
       很多时候，我们面对的类是无法通过无参构造去创建的，例如该类没有
无参构造，是抽象类等情况，此时无法要求Spring的IOC通过无参构造来创建对象了，可以使用静态工厂的方式来创建。
（简单来说就是把创建对象的过程封装到了静态工厂中）
 -   （3）通过实例工厂的方式创建对象
        实例工厂也可以理解为类是无法通过无参构造来创建的问题，解决的思
路和静态工厂的方式类似，只不过实例工厂方式提供的方法是非静态方
法。
 -   （4）通过Spring工厂的方式创建对象  
        Spring内置了一个工厂接口，是FactoryBean。
      可以通过实现该接口来开发Spring工厂，来完成对对象的创建

# 10、单例和多例
Spring容器管理的对象（javabean对象）在默认情况下都是单例模式，也就是说一个javabean对象只会创建一次，存在内置的map中，之后无论获取多少次该对象，都返回的是同一个对象。
```java
<bean id=”person” class=”com.lddx.bean.Person”></bean>
底层：Person p=new Person()   单例模式会只创建一次
      Map.put(“person”,p);
      Context.getBean(“person”)  -->Map.get(“person”);
```

Spring默认采用单例方式，减少了对象的创建，从而减少了内存的消耗。
但是在实际开发中是存在很多多例模式的需求的，Spring框架也提供了可以设置多例模式的方式。（当当网中设计的购物车---多例）
多例模式是对象每次使用都会创建一个新的对象，不会像单例只会创建一次。
使用scope=”singleton/prototype”来设置是单例模式还是多例模式
总结：
- （1）单例模式
     Bean在单例模式下，spring容器启动时解析xml，发现bean标签后，直接创建bean的对象，并存入Map中保存。此后无论调用多少次getBean()获取对象，都是从Map中获取的同一个对象。
- （2）多例模式
     Bean在多例模式下，spring容器启动时解析xml，发现bean标签后，只是将bean进行管理，并不会创建该对象。此后每次使用getBean()获取对象的时候，Spring的IOC才会创建该对象并保存到Map中，所以getBean()获取的对象每一次都是一个新对象。
# 11、懒加载
   Spring默认会在容器初始化的过程中，解析xml文件，并将单例模式的bean创建并保存到Map中，这种机制在bean比较少的情况下问题不大，一旦bean非常多的时候，spring的初始化过程就需要花费大量的时间来创建bean，花费大量的空间存储bean，但是这些bean可能很久都用不上，这种在启动时时间和空间上的浪费显得非常不值得。
   Spring提供了懒加载机制。所谓的懒加载机制就是规定bean不在xml解析时立即创建，而是在后续第一次用到是才创建，而从减轻在Spring初始化过程中对时间和空间的消耗浪费。因为是单例模式，还是会创建，只不过懒加载机制把创建的时间往后推迟了而已，推迟第一次用的时候才创建。
（强调：懒加载机制只对单例模式起作用，对于多例模式设置懒加载没有意义）
 lazy-init=””属性设置是否懒加载，true表示懒加载，false不懒加载（默认）
 在`<beans>`标签中设置default-lazy-init=””是否懒加载
 总结：
 - 1如果lazy-init和default-lazy-init同时对bean标签设置，lazy-init的优
先级更高；
- 2、如果lazy-init=””设置的值为default，相当于是引用default-lazy-init设置的值。



# 12、Spring容器的初始化和销毁

```java
Spring容器初始化的时候做一些创建、连接等操作；
Spring容器销毁时做一些关闭、释放资源等操作。
init-method=”” Spring容器初始化的时候执行设置的方法
destory-method=”” Spring销毁的时候执行设置的方法
```

# 13、依赖注入—DI
IOC（DI）控制反转（依赖注入）
    在IOC创建对象的过程中，Spring可以依据相关配置对对象的属性赋值，对对象的属性赋值的过程称之为依赖注入，也叫DI。
   以前的做法—不使用Spring框架
  

```java
 Person p=new Person();
   p.setName(“zs”);
   p.setAge(20);
   p.setAddress(“山东…”);
   或者
   Person p1=new Person(“zs”,20,”山东…”);
```

   现在Spring框架帮我们把Person创建，也会把Person中的属性进行赋值，这就是IOC和DI。
DI依赖注入的两种方式：
（1）set方法注入
（2）构造方法注入

# 14、DI-set方法注入  SpringN01_06_DI_set
# 15、自动装配  -- autowire    SpringN01_07_DI_set_autowire

```java
使用set方式依赖注入的时候，如果一个<bean>中需要引入另外一个<bean>,配置的代码<property name="dog" ref="d"></property>，如果需要引入的<bean>特别多，需要写<property name="dog" ref="d"></property>的配置就会很多，可以使用自动装配，使用自动装配，那么<property name="dog" ref="d"></property>配置就可以省略不写了。
autowire=”byName”   保证javabean类中私有属性的名字和<bean>标签中的id的名字一致，否则自动装配不成功。一般使用byName进行自动装配。

autowire=”byType”   通过javabean类的类型来进行自动装配，
保证javabean类中的私有属性的类型要和<bean>标签中的class的内容一致。
此方法有风险，不可以出现多个<bean>标签中的class同名的情况，如果有同名的情况，通过byTpye的方式自动装配就会出错。
```

# 16、构造方法的依赖注入
对象中的私有属性的另外一种方式是在对象创建的过程中，通过构造方法传入并设置对象的属性。Spring也可以通过这样的构造方法的方式实现属性的注入。



# 二、注解、IOC(注解方式)、DI(注解的方式)
## 1、注解的概念    
   注释：给人看的提示信息，程序不看也不执行。
   注解：主要给程序看的信息，程序会执行。
通常用来在某种程度上，尤其是框架上，注解用来代替配置文件，实现轻量级配置。
   注解是从JDK5.0开始提供的特性。
## 2、几个常见的注解
  （1）@Override   子类继承父类，重写父类方法的注解
  （2）@Deprecated    过时注解
  （3）@SuppressWarnings   消除黄色警告
## 3、自定义注解
   自定义一个注解的过程类似于定义一个接口
   可以通过@interface来定义一个注解
   该注解可以在一个类中的任何地方使用
   元注解：可以通过元注解来修饰注解，控制自定义注解的特征（元注解都是sun公司提供好的）
###  （1）@Target  -- 声明当前定义的注解可以用在什么位置
  

```java
ElementType.CONSTRUCTOR        构造方法中
ElementType.FIELD              成员变量
ElementType.LOCAL_VARIABLE     局部变量上
ElementType.METHOD             方法上
ElementType.PACKAGE            包
ElementType.PARAMETER          方法参数
ElementType.TYPE               类
```
### （2）@Retention   了解即可，偏底层设计
声明当前定义的注解被保留到什么阶段
A.java源文件   --->  A.class字节码文件  --->JVM
                      编译                        运行
RetentionPolicy.SOURCE 保留到源码阶段，在编译过程中丢失，主要是
给编译器在编译代码的时候看到。
RetentionPolicy.CLASS  保留到.java和..class阶段，加载到jvm虚拟机
运行时就丢失了。
        RetentionPolicy.RUNTIME  全阶段
### （3）@Documented  文档注解
指定当前注解是否会被文档提取工具提取到自动生成的文档中 
### （4）注解中声明属性
- 1）在注解中声明属性的过程类似于接口中定义方法；
- 2）在注解声明中定义的属性需要在使用注解时为属性赋值（相当于接口中的方法必须重写，注解中的属性必须赋值）；
- 3）在注解中声明的属性必须是public，public可以省略；
- 4）在注解中声明的属性的类型必须是八大基本数据类型，String类型、Class类型，枚举类型(enum)，其它注解类型，或者以上类型的一维数组。
- 5）在给注解中的属性赋值时，可以在使用注解的后面使用小括号，小括号里采用属性名=赋值内容的方式赋值，多个值之间用逗号分隔开。
- 6）可以在注解中声明属性时，使用default给属性赋一个默认值
- 7）如果注解中只有一个属性需要被赋值，且该属性的名字叫value，则在赋值的时候value=是可以省略的
- 8）如果注解中某个属性是一个一维数组类型，且给该属性赋值时，赋值的内容只有一个值，则赋值时大括号是可以省略的。
- 如果赋值的内容是多个值，则赋值的内容必须放在大括号里
## 4、注解的反射：基于注解实现控制程序执行
   RetentionPolicy.RUNTIME级别的注解会保留到程序运行时，可以通过反射技术获取，从而根据是否有注解或注解属性值的不同控制程序按照不同方式进行。
 

```java
 boolean isAnnotationPresent()     判断是否有注解
 getAnnotation()                 获得注解
```

