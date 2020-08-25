# SpringMVC
## 一、 SpringMVC的搭建过程
### 1.1 导入jar
    commons-logging-1.1.3.jar
    spring-aop-4.1.6.RELEASE.jar
    spring-beans-4.1.6.RELEASE.jar
    spring-context-4.1.6.RELEASE.jar
    spring-core-4.1.6.RELEASE.jar
    spring-expression-4.1.6.RELEASE.jar
    spring-web-4.1.6.RELEASE.jar
    spring-webmvc-4.1.6.RELEASE.jar
### 1.2 在 web.xml 中配置SpringMVC的核心(前端)控制器 DispatcherServlet
**作用:** 加载SpringMVC的配置文件, 在下面的配置方式下, DispatcherServlet 自动加载配置文件
    ,此时的配置文件有默认的位置和名称
**默认位置:** /WEB-INF/ 下
**默认名称:** <servlet-name>-servlet.xml, 例如下面配置方式的文件名: springMVC-servlet.xml    
当加载了配置文件, springMVC 就会根据扫描组件找到控制层

    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
             version="4.0">
    
        <servlet>
            <servlet-name>springMVC</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    
            <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
            <servlet-name>springMVC</servlet-name>
            <url-pattern>/</url-pattern>
            <!--        <url-pattern>*.do</url-pattern>-->
            <!--        <url-pattern>*.action</url-pattern>-->
        </servlet-mapping>
    
    </web-app>
### 1.3 创建 springMVC-servlet.xml 文件

        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:context="http://www.springframework.org/schema/context"
               xsi:schemaLocation="
               http://www.springframework.org/schema/beans
               http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
        	http://www.springframework.org/schema/context
        	http://www.springframework.org/schema/context/spring-context-4.1.xsd
            ">
        
            <!-- 扫描组件, 并加上@Controller注解的类作为 springMVC 的控制层 -->
            <!-- springMVC中可以将一个 POJO 来作为一个控制层, 而不需要它实现任何的接口和继承任何的类 -->
            <context:component-scan base-package="com"/>
        
            <!-- 配置视图解析器 -->
            <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                <property name="prefix" value="/WEB-INF/"/>
                <property name="suffix" value=".jsp"/>
            </bean>
        
        </beans>
        
## 1.4 创建一个 POJO, 在类上加上 @Controller 注解, springMVC就会将此类作为 控制层, 让其处理请求响应
