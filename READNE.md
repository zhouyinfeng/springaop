## Spring AOP
#### Sping有 SringCore  AOP  ORM  DAO  MVC  WEB  CONTENT

### spring aop是什么
* 1.spring aop 是一种编程范式，不是编程语言
* 2.是oop的补充，不是替代
* 3.解决待定问题，不是所有问题

总体来说：就是把业务控制代码和业务实现代码进行有效的分离。面向切面，将日志、安全、事务管理等服务抽离处出来，形成切面，实现反复利用，然后将“方面”动态的插入到业务逻辑中，让业务逻辑方便的使用切面提供的服务

### 使用AOP的好处
* 1.集中处理某一关注点/横切逻辑
* 2.很方便的添加/深处关注点，使关注点分离
* 3.侵入性少，增强代码的可读性以及可维护性
* 4.解决代码重复问题


### Aop应用场景
* 权限控制  
* 缓存控制  
* 事务控制  
* 审计日志 
* 性能监控 
* 分布式追踪   
* 异常处理

### 支持AOP的语言

java  c/c++  .net  Ruby  Python  PHP 等

###  与其他语言的对比
* c（面向过程）
* java c++（面向对象）
* 函数式编程
* 事件驱动编程

### Spring AOP里面重要的概念
* 切面（Aspect）：方面的实现，比如日志，事务，权限切面，通常是存放方面实现的java类
* 目标对象（Target Object）：被一个或者多个切面所通知的对象
* 通知（Advice）：是切面的具体实现，以目标方法为参照点。根据放的位置不同，分为前置通知，后置通知，异常通知，环绕通知，最终通知
* 切入点（PointCut）：就是通知应该织入到哪些连接点上，就是用正则表达式表示的一系列连接点的集合
* 目标对象：指要织入切面的对象，这些对象只包含核心业务逻辑代码
* 代理对象：将通知应用到目标对象后，被动态创建的对象。代理对象的功能相当于目标对象中实现的核心业务逻辑功能加上切面代码实现的功能
* 织入：将切面应用到模目标对象，从而创建一个新的代理对象的过程


### Spring AOP的原理
* java的动态代理机制
* cglib

#### java的动态代理模式


#### cglib（基于类或者接口，但是不能是final方法）

### 使用AOP的几种方式
* 经典的基于代理的AOP
* @AspectJ注解驱动的切面
* 纯POJO切面
* 注入式AspectJ切面

### 有无接口的Spring AOP实现的区别
* Spring AOP默认使用标准的JavaSE动态代理作为AOP代理，这使得任何接口（或者接口集）都可以被代理
* Spring AOP的cglib主要代理类

### AOP的五种通知类型
* 前置通知（Before advice）：在某个连接点之前执行的通知，但不能阻止连接点前的执行（除非它跑出一个异常）
* 返回后通知（After returing advice）：在某连接点正常完成后执行的通知
* 异常通知（After throwing advice）：在方法抛出异常退出时执行的异常
* 后置通知（After（finally）advice）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）
* 环绕通知（Around Advice）：包围一个连接点的通知

### AOP五种Advice注解
* @Before  前置通知
* @After(finally) 后置通知，方法执行完之后
* @AfterReturning  返回通知，成功执行之后
* @AfterThrowing  异常通知，抛出异常后
* @Around  环绕通知

Advice中的参数以及结果绑定

@AfterReturning(returning = "ret",pointcut = "webLog()") <br>
    public void doAfterReturning(Object ret) throws Throwable{ <br>
        logger.info("后置拦截--------->"+ret);<br>
        logger.info("RESPONSE--------->"+ret);<br>
    }

### 关于通配符的使用（在切入点时候用到）
* *匹配任意数量的字符
* +匹配指定类以及子类
* ..一般用于匹配任意数的子包或参数

### 指示器的使用
* 匹配方法    execution()
* 匹配注解    @target()  @args() @within()  @annotation()
* 匹配包/类型 within()
* 匹配对象    this()  target()  bean()
* 匹配参数    args()
* 举例子

### 主要讲一下execution
* execution由五部分组成
* 修饰符 返回值 包名 描述方法名 匹配方法抛出的异常
 
@Pointcut("execution(public * com.zyf.springboot_excution.service..*Service.*(..) )") </br>
拦截以Service结尾的类下面的任意参数

### 里面涉及的注解
*  @Component 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
* @service 服务（用于标注业务层组件，注入dao）
* @controller 控制器（用于标注控制层组件，注入服务）
* @repository dao（用于标注数据访问组件，实现dao访问）


