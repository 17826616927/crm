package com.bjpowernode;

import com.bjpowernode.Impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestSomeService {
    /**
     * spring默认创建对象的时间：在创建spring的容器时，会创建配置文件中的所有的对象。
     * spring创建对象：默认调用的是无参数构造方法
     */
    @Test
    public void testSomeService(){
      /*  SomeService someService=new SomeServiceImpl();
        someService.doSome();*/

        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
         String config="SomeService.xml";

        //2.创建表示spring容器的对象， ApplicationContext
        // ApplicationContext就是表示Spring容器，通过容器获取对象了
        // ClassPathXmlApplicationContext:表示从类路径中加载spring的配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象， 你要调用对象的方法
        //getBean("配置文件中的bean的id值")
        SomeService someService = (SomeService)ac.getBean("someService");
        //使用spring创建好的对象
        someService.doSome();
    }

    /**
     * 获取spring配置文件中对象的个数，和具体对象名称
     */
    @Test
    public void testSomeService1(){
        String config="SomeService.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        int num=ac.getBeanDefinitionCount();
        System.out.println("Spring配置文件中一个有"+num+"个对象");
        String[] names=ac.getBeanDefinitionNames();
        for(String s:names){
            System.out.println(s);
        }
    }
    @Test
    public void testSomeService2(){
        String config="SomeService.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        Date mydate =(Date) ac.getBean("mydate");
        System.out.println(mydate);
    }
}
