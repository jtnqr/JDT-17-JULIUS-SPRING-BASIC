package com.inidivaragroup.jdt17.spring.dasar;

import com.inidivaragroup.jdt17.spring.dasar.exam.DistribusiService;
import com.inidivaragroup.jdt17.spring.dasar.exam.configuration.DistribusiConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.exam.configuration.GudangConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.exam.configuration.SalesConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.aware.MyComponent;
import com.inidivaragroup.jdt17.spring.dasar.example.component.*;
import com.inidivaragroup.jdt17.spring.dasar.example.configuration.*;
import com.inidivaragroup.jdt17.spring.dasar.example.dto.HelloDTO;
import com.inidivaragroup.jdt17.spring.dasar.example.dto.WorldDTO;
import com.inidivaragroup.jdt17.spring.dasar.example.event.LoginService;
import com.inidivaragroup.jdt17.spring.dasar.example.factory.FactoryBeanConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.factory.PaymentGatewayClient;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.Connection;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.LifeCycleConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.Server;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.ServerComponent;
import com.inidivaragroup.jdt17.spring.dasar.example.lifecycle.ServerConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.listener.AppStartingListener;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Bar;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import com.inidivaragroup.jdt17.spring.dasar.example.scope.DoubletonConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.scope.PrototypeConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.service.MerchantService;
import com.inidivaragroup.jdt17.spring.dasar.example.service.MerchantServiceImpl;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Map;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        // 1. Initial JDT Configuration
        // var contextJDT = new AnnotationConfigApplicationContext(JDTConfiguration.class);
        // System.out.println(contextJDT.getBean("getInitialConfiguration"));
        // contextJDT.close();

        // 2. Database Configuration Instance
        // var db1 = DatabaseConfiguration.getInstance();
        // var db2 = DatabaseConfiguration.getInstance();
        // System.out.println("database - 1 === " + db1);
        // System.out.println("database - 2 === " + db2);

        // 3. HelloDTO Bean
        // var contextBeanHello = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        // HelloDTO helloDTO = contextBeanHello.getBean(HelloDTO.class);
        // contextBeanHello.close();

        // 4. WorldDTO Bean
        // var contextBeanWorld = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        // WorldDTO worldDTO = contextBeanWorld.getBean(WorldDTO.class);
        // contextBeanWorld.close();

        // 5. Duplicate Bean Configuration
        // var contextDuplicateBean = new AnnotationConfigApplicationContext(DuplicateBeanConfiguration.class);
        // HelloDTO foo1 = contextDuplicateBean.getBean("hello1", HelloDTO.class);
        // HelloDTO foo2 = contextDuplicateBean.getBean("hello2", HelloDTO.class);
        // System.out.println(foo1);
        // System.out.println(foo2);
        // contextDuplicateBean.close();

        // 6. Primary Bean Configuration
        // var contextPrimaryBean = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        // WorldDTO foo = contextPrimaryBean.getBean(WorldDTO.class);
        // System.out.println(foo);
        // contextPrimaryBean.close();

        // 7. Bean Name Configuration
        // var contextBeanName = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
        // HelloDTO helloDTO1 = contextBeanName.getBean("helloSatuBean", HelloDTO.class);
        // HelloDTO HelloDTO2 = contextBeanName.getBean("helloDuaBean", HelloDTO.class);
        // contextBeanName.close();

        // 8. DependsOn Configuration
        // var contextDependsOn = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
        // HelloDTO dependsOnBar = contextDependsOn.getBean("foo", HelloDTO.class);
        // System.out.println("Call the depends on " + dependsOnBar);
        // WorldDTO dependsOnFoo = contextDependsOn.getBean("bar", WorldDTO.class);
        // System.out.println("Call the depends on " + dependsOnFoo);
        // contextDependsOn.close();

        // 9. Distribusi Service Configuration
        // var contextDistribusi = new AnnotationConfigApplicationContext(
        //         GudangConfiguration.class,
        //         SalesConfiguration.class,
        //         DistribusiConfiguration.class
        // );
        // var service = contextDistribusi.getBean(DistribusiService.class);
        // service.distribusiBarang();
        // contextDistribusi.close();

        // 10. Lazy Configuration (HelloDTO & WorldDTO)
        // var contextLazy = new AnnotationConfigApplicationContext(LazyConfiguration.class);
        // HelloDTO firstLazy = contextLazy.getBean(HelloDTO.class);
        // WorldDTO secondLazy = contextLazy.getBean(WorldDTO.class);
        // System.out.println(firstLazy);
        // System.out.println(secondLazy);
        // contextLazy.close();

        // =========================================
        // SLIDE 69: Prototype Scope
        // =========================================
        System.out.println("\n--- [Slide 69] Prototype Scope ---");
        var contextPrototype = new AnnotationConfigApplicationContext(PrototypeConfiguration.class);
        Foo foo1 = contextPrototype.getBean(Foo.class);
        Foo foo2 = contextPrototype.getBean(Foo.class);
        System.out.println("Prototype Scope (foo1 == foo2): " + (foo1 == foo2)); // false
        contextPrototype.close();

        // =========================================
        // SLIDE 74: Doubleton Scope
        // =========================================
        System.out.println("\n--- [Slide 74] Doubleton Scope ---");
        var contextDoubleton = new AnnotationConfigApplicationContext(DoubletonConfiguration.class);
        Bar bar1 = contextDoubleton.getBean(Bar.class);
        Bar bar2 = contextDoubleton.getBean(Bar.class);
        Bar bar3 = contextDoubleton.getBean(Bar.class);
        System.out.println("Doubleton Scope (bar1 == bar2): " + (bar1 == bar2)); // false
        System.out.println("Doubleton Scope (bar1 == bar3): " + (bar1 == bar3)); // true
        contextDoubleton.close();

        // =========================================
        // SLIDE 80: Life Cycle Callbacks (Connection)
        // =========================================
        System.out.println("\n--- [Slide 80] Life Cycle Callbacks ---");
        var contextLifeCycle = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        Connection connection = contextLifeCycle.getBean(Connection.class);
        System.out.println("Connection Bean: " + connection);
        contextLifeCycle.close();

        // =========================================
        // SLIDE 85: Life Cycle Annotation (Server)
        // =========================================
        System.out.println("\n--- [Slide 85] Life Cycle Annotation ---");
        var contextServer = new AnnotationConfigApplicationContext(ServerConfiguration.class);
        Server server = contextServer.getBean(Server.class);
        System.out.println("Server Bean: " + server);
        contextServer.close();

        // =========================================
        // SLIDE 92: Import Configuration
        // =========================================
        System.out.println("\n--- [Slide 92] Import Configuration ---");
        var contextImport = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Foo fooImport = contextImport.getBean(Foo.class);
        Bar barImport = contextImport.getBean(Bar.class);
        System.out.println("Import Config (Foo): " + fooImport);
        System.out.println("Import Config (Bar): " + barImport);
        contextImport.close();

        // =========================================
        // SLIDE 102: Component Scan & HelloWorld Component
        // =========================================
        System.out.println("\n--- [Slide 102] Component Scan ---");
        var contextComponent = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        HelloWorld helloWorld = contextComponent.getBean(HelloWorld.class);
        System.out.println(helloWorld.hello());
        contextComponent.close();

        // =========================================
        // SLIDE 107/113/117: DI Variants (Constructor, Setter, Field)
        // =========================================
        System.out.println("\n--- [Slide 107/113/117] DI Variants ---");
        var contextDi = new AnnotationConfigApplicationContext(AppConfiguration.class);
        
        FooBarConstructor constructorDi = contextDi.getBean(FooBarConstructor.class);
        System.out.println("Constructor DI (Foo): " + constructorDi.getFoo());
        System.out.println("Constructor DI (Bar): " + constructorDi.getBar());

        FooBarSetter setterDi = contextDi.getBean(FooBarSetter.class);
        System.out.println("Setter DI (Foo): " + setterDi.getFoo());
        System.out.println("Setter DI (Bar): " + setterDi.getBar());

        FooBarField fieldDi = contextDi.getBean(FooBarField.class);
        System.out.println("Field DI (Foo): " + fieldDi.getFoo());
        System.out.println("Field DI (Bar): " + fieldDi.getBar());

        contextDi.close();

        // =========================================
        // SLIDE 122: Qualifier resolution
        // =========================================
        System.out.println("\n--- [Slide 122] Qualifier ---");
        var contextQualifier = new AnnotationConfigApplicationContext(AppConfiguration.class);
        FooBarQualifier fooBarQualifier = contextQualifier.getBean(FooBarQualifier.class);
        System.out.println("Qualifier selected (Foo): " + fooBarQualifier.getFoo().getClass().getSimpleName()); // FooSecond
        contextQualifier.close();

        // =========================================
        // SLIDE 126/130: Optional & ObjectProvider
        // =========================================
        System.out.println("\n--- [Slide 126/130] Optional & ObjectProvider ---");
        var contextOptional = new AnnotationConfigApplicationContext(OptionalConfiguration.class, FooBarOptional.class);
        FooBarOptional fooBarOptional = contextOptional.getBean(FooBarOptional.class);
        System.out.println("Optional DI (Foo is null): " + fooBarOptional.getFoo());
        System.out.println("Optional DI (Optional<Foo> isPresent): " + fooBarOptional.getOptionalFoo().isPresent());
        System.out.println("ObjectProvider DI (getIfAvailable): " + fooBarOptional.getFooProvider().getIfAvailable());
        contextOptional.close();

        // =========================================
        // SLIDE 136: Factory Bean
        // =========================================
        System.out.println("\n--- [Slide 136] Factory Bean ---");
        var contextFactory = new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);
        PaymentGatewayClient client = contextFactory.getBean(PaymentGatewayClient.class);
        System.out.println("Factory Bean Client ApiKey: " + client.getApiKey());
        System.out.println("Factory Bean Client SecretKey: " + client.getSecretKey());
        contextFactory.close();

        // =========================================
        // SLIDE 141: Inheritance / Interface Injection
        // =========================================
        System.out.println("\n--- [Slide 141] Inheritance / Interface Injection ---");
        var contextInheritance = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        MerchantService service = contextInheritance.getBean(MerchantService.class);
        System.out.println("Inheritance Interface name: " + service.getName());
        contextInheritance.close();

        // =========================================
        // SLIDE 145: Listable Bean Factory
        // =========================================
        System.out.println("\n--- [Slide 145] Listable Bean Factory ---");
        var contextListable = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ListableBeanFactory factory = contextListable;
        Map<String, Foo> beans = factory.getBeansOfType(Foo.class);
        beans.forEach((name, bean) -> System.out.println("ListableBeanFactory: " + name + " : " + bean));
        contextListable.close();

        // =========================================
        // SLIDE 152/158: Bean Post Processor (Id generator)
        // =========================================
        System.out.println("\n--- [Slide 152/158] Bean Post Processor ---");
        var contextBpp = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Foo fooBpp = contextBpp.getBean(Foo.class);
        System.out.println("BPP Generated Id: " + fooBpp.getId()); // Starts with PREFIX-
        contextBpp.close();

        // =========================================
        // SLIDE 163: Aware (MyComponent)
        // =========================================
        System.out.println("\n--- [Slide 163] Aware Interceptor ---");
        var contextAware = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MyComponent component = contextAware.getBean(MyComponent.class);
        component.doSomething();
        contextAware.close();

        // =========================================
        // SLIDE 167: Bean Factory Post Processor
        // =========================================
        System.out.println("\n--- [Slide 167] Bean Factory Post Processor ---");
        var contextBfpp = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Foo fooBfpp1 = contextBfpp.getBean(Foo.class);
        Foo fooBfpp2 = contextBfpp.getBean(Foo.class);
        // Changed to prototype scope by BFPP
        System.out.println("BFPP Scope Modified (foo1 == foo2): " + (fooBfpp1 == fooBfpp2)); // false
        contextBfpp.close();

        // =========================================
        // SLIDE 174: Event Listener & LoginService
        // =========================================
        System.out.println("\n--- [Slide 174] Event Listener ---");
        var contextEvent = new AnnotationConfigApplicationContext(AppConfiguration.class);
        LoginService loginService = contextEvent.getBean(LoginService.class);
        loginService.login("budi");
        contextEvent.close();

        // =========================================
        // Spring Boot Application Startup
        // =========================================
        System.out.println("\n=== [Slide 181] Starting Spring Boot Application ===");
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.addListeners(new AppStartingListener());
        app.run(args);
    }
}
