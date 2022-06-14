package com.example.spring_fish.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Random;

@Aspect
@Component
public class RandomAop {

    private Robot robot=new Robot();
    private Random random=new Random();

    public RandomAop() throws AWTException {
    }

    @Pointcut("execution(* com.example.spring_fish.service.Robotplus.*(..))")
    //切入点签名
    public void log(){
        System.out.println("操作前随机等待切入了。。。");
    }

    @Before("log()")
    public void doBefore(){
        robot.setAutoDelay(random.nextInt(300)+500);
    }
}
