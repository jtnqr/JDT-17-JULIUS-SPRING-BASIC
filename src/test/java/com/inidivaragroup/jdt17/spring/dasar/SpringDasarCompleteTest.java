package com.inidivaragroup.jdt17.spring.dasar;

import com.inidivaragroup.jdt17.spring.dasar.example.aware.MyComponent;
import com.inidivaragroup.jdt17.spring.dasar.example.component.*;
import com.inidivaragroup.jdt17.spring.dasar.example.configuration.*;
import com.inidivaragroup.jdt17.spring.dasar.example.event.LoginService;
import com.inidivaragroup.jdt17.spring.dasar.example.factory.FactoryBeanConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.factory.PaymentGatewayClient;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.Connection;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.LifeCycleConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.Server;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.ServerComponent;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.ServerConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Bar;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import com.inidivaragroup.jdt17.spring.dasar.example.scope.DoubletonConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.scope.PrototypeConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.service.MerchantService;
import com.inidivaragroup.jdt17.spring.dasar.example.service.MerchantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Map;

class SpringDasarCompleteTest {

    @Test
    void testPrototypeScope() {
        var context = new AnnotationConfigApplicationContext(PrototypeConfiguration.class);
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        Assertions.assertNotSame(foo1, foo2);
        context.close();
    }

    @Test
    void testDoubletonScope() {
        var context = new AnnotationConfigApplicationContext(DoubletonConfiguration.class);
        Bar bar1 = context.getBean(Bar.class);
        Bar bar2 = context.getBean(Bar.class);
        Bar bar3 = context.getBean(Bar.class);
        Assertions.assertNotSame(bar1, bar2);
        Assertions.assertSame(bar1, bar3);
        context.close();
    }

    @Test
    void testLifeCycleCallback() {
        var context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        Connection connection = context.getBean(Connection.class);
        Assertions.assertNotNull(connection);
        context.close();
    }

    @Test
    void testServerLifeCycleAnnotation() {
        var context = new AnnotationConfigApplicationContext(ServerConfiguration.class);
        Server server = context.getBean(Server.class);
        Assertions.assertNotNull(server);
        context.close();
    }

    @Test
    void testServerComponentLifeCycle() {
        var context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ServerComponent serverComponent = context.getBean(ServerComponent.class);
        Assertions.assertNotNull(serverComponent);
        context.close();
    }

    @Test
    void testImportConfiguration() {
        var context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);
        Assertions.assertNotNull(foo);
        Assertions.assertNotNull(bar);
        context.close();
    }

    @Test
    void testComponentScanAndComponent() {
        var context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        Assertions.assertEquals("Hello World", helloWorld.hello());
        context.close();
    }

    @Test
    void testDependencyInjectionVariants() {
        var context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        
        FooBarConstructor constructorDi = context.getBean(FooBarConstructor.class);
        Assertions.assertNotNull(constructorDi.getFoo());
        Assertions.assertNotNull(constructorDi.getBar());

        FooBarSetter setterDi = context.getBean(FooBarSetter.class);
        Assertions.assertNotNull(setterDi.getFoo());
        Assertions.assertNotNull(setterDi.getBar());

        FooBarField fieldDi = context.getBean(FooBarField.class);
        Assertions.assertNotNull(fieldDi.getFoo());
        Assertions.assertNotNull(fieldDi.getBar());

        context.close();
    }

    @Test
    void testQualifier() {
        var context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        FooBarQualifier fooBarQualifier = context.getBean(FooBarQualifier.class);
        Assertions.assertEquals("FooSecond", fooBarQualifier.getFoo().getClass().getSimpleName());
        context.close();
    }

    @Test
    void testOptionalDependency() {
        var context = new AnnotationConfigApplicationContext(OptionalConfiguration.class, FooBarOptional.class);
        FooBarOptional fooBarOptional = context.getBean(FooBarOptional.class);
        Assertions.assertNull(fooBarOptional.getFoo());
        Assertions.assertFalse(fooBarOptional.getOptionalFoo().isPresent());
        Assertions.assertNull(fooBarOptional.getFooProvider().getIfAvailable());
        context.close();
    }

    @Test
    void testFactoryBean() {
        var context = new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);
        PaymentGatewayClient client = context.getBean(PaymentGatewayClient.class);
        Assertions.assertNotNull(client);
        Assertions.assertEquals("api-key", client.getApiKey());
        Assertions.assertEquals("secret-key", client.getSecretKey());
        context.close();
    }

    @Test
    void testInheritance() {
        var context = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        MerchantService service = context.getBean(MerchantService.class);
        Assertions.assertEquals("Merchant Service", service.getName());
        MerchantServiceImpl impl = context.getBean(MerchantServiceImpl.class);
        Assertions.assertEquals("Merchant Service", impl.getName());
        context.close();
    }

    @Test
    void testListableBeanFactory() {
        var context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ListableBeanFactory factory = context;
        Map<String, Foo> beans = factory.getBeansOfType(Foo.class);
        Assertions.assertFalse(beans.isEmpty());
        beans.forEach((name, bean) -> System.out.println(name + " : " + bean));
        context.close();
    }

    @Test
    void testBeanPostProcessors() {
        var context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Foo foo = context.getBean(Foo.class);
        Assertions.assertNotNull(foo.getId());
        Assertions.assertTrue(foo.getId().startsWith("PREFIX-"));
        context.close();
    }

    @Test
    void testBeanFactoryPostProcessor() {
        var context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        Assertions.assertNotSame(foo1, foo2);
        context.close();
    }

    @Test
    void testAwareAndEventListeners() {
        var context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MyComponent component = context.getBean(MyComponent.class);
        Assertions.assertNotNull(component.getApplicationContext());
        
        LoginService loginService = context.getBean(LoginService.class);
        loginService.login("johndoe");
        context.close();
    }
}
