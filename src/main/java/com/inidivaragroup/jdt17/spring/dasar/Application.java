package com.inidivaragroup.jdt17.spring.dasar;

import com.inidivaragroup.jdt17.spring.dasar.exam.DistribusiService;
import com.inidivaragroup.jdt17.spring.dasar.exam.configuration.DistribusiConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.exam.configuration.GudangConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.exam.configuration.SalesConfiguration;
import com.inidivaragroup.jdt17.spring.dasar.example.configuration.*;
import com.inidivaragroup.jdt17.spring.dasar.example.dto.HelloDTO;
import com.inidivaragroup.jdt17.spring.dasar.example.dto.WorldDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
//		var context = new AnnotationConfigApplicationContext(
//				JDTConfiguration.class
//		);
//
//		System.out.println(context.getBean("getInitialConfiguration"));
//
//		context.close();
//
//		var db1 = DatabaseConfiguration.getInstance();
//		var db2 = DatabaseConfiguration.getInstance();
//
//		System.out.println("database - 1 === " + db1);
//		System.out.println("database - 2 === " + db2);
//
//		var contextBeanHello  = new AnnotationConfigApplicationContext(
//				BeanConfiguration.class
//		);
//
//		HelloDTO helloDTO = contextBeanHello.getBean(HelloDTO.class);
//
//		contextBeanHello.close();
//
//		var contextBeanWorld  = new AnnotationConfigApplicationContext(
//				BeanConfiguration.class
//		);
//
//		WorldDTO worldDTO = contextBeanWorld.getBean(WorldDTO.class);
//
//		contextBeanWorld.close();
//
//		var contextDuplicateBean = new AnnotationConfigApplicationContext(
//				DuplicateBeanConfiguration.class
//		);
//
//		HelloDTO foo1 = contextDuplicateBean.getBean("hello1", HelloDTO.class);
//		HelloDTO foo2 = contextDuplicateBean.getBean("hello2", HelloDTO.class);
//
//		System.out.println(foo1);
//		System.out.println(foo2);
//
//		contextDuplicateBean.close();
//
//		var contextPrimaryBean = new AnnotationConfigApplicationContext(
//				BeanConfiguration.class
//		);
//
//		WorldDTO foo = contextPrimaryBean.getBean(WorldDTO.class);
//
//		System.out.println(foo);
//
//		contextPrimaryBean.close();
//
//		var contextBeanName = new AnnotationConfigApplicationContext(
//				BeanNameConfiguration.class
//		);
//
//		HelloDTO helloDTO1 = contextBeanName.getBean("helloSatuBean", HelloDTO.class);
//		HelloDTO HelloDTO2 = contextBeanName.getBean("helloDuaBean", HelloDTO.class);
//
//		contextBeanName.close();
//
//		var dependsOnBean = new AnnotationConfigApplicationContext(
//				DependsOnConfiguration.class
//		);
//
//		HelloDTO dependsOnBar = dependsOnBean.getBean("foo",HelloDTO.class);
//
//		System.out.println("Call the depends on " + dependsOnBar);
//
//		WorldDTO dependsOnFoo = dependsOnBean.getBean("bar",WorldDTO.class);
//
//		System.out.println("Call the depends on " + dependsOnFoo);
//
//		dependsOnBean.close();
//
		var context = new AnnotationConfigApplicationContext(
				GudangConfiguration.class,
				SalesConfiguration.class,
				DistribusiConfiguration.class
		);

		var service = context.getBean(DistribusiService.class);

		service.distribusiBarang();

		context.close();

		SpringApplication.run(Application.class, args);
	}

}
