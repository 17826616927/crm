package com.bjpowernode.Impl;

import com.bjpowernode.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl(){
        System.out.println("SomeServiceImpl构造方法执行！");
    }
    @Override
    public void doSome() {
        System.out.println("执行了doSome方法");
        System.out.println("*******");
    }
}
