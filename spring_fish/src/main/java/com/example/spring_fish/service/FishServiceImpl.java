package com.example.spring_fish.service;

import com.example.spring_fish.vo.Cr;
import com.example.spring_fish.vo.Rg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class FishServiceImpl implements FishService {

    @Autowired
    private Robotplus robot;

    private Robot qrobot=new Robot();


    private Random random =new Random();

    public FishServiceImpl() throws AWTException {
    }

    @Override
    public void paoGan() {

        robot.keyPress(KeyEvent.VK_SHIFT);

        robot.mousePress(InputEvent.BUTTON1_MASK);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.keyRelease(KeyEvent.VK_SHIFT);

        try {
            Thread.sleep(random.nextInt(1000)+3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //没鱼回复True,有鱼False
    @Override
    public boolean shouXian() {

        //开始收线
        robot.mousePress(InputEvent.BUTTON1_MASK);

        long wait=28000+random.nextInt(1000);
        long start = System.currentTimeMillis();
        long end = start+wait;

        //随机动几下
        int flag1=0;
        int flag2=0;
        long randTime1=random.nextInt(10000)+start;
        long randTime2=random.nextInt(12000)+10000+start;


        while(System.currentTimeMillis()<end)
        {
            //随机动两下
            if(flag1==0&&System.currentTimeMillis()>randTime1){
                headChange(3);
                flag1++;
            }
            if(flag2==0&&System.currentTimeMillis()>randTime2){
                headChange(3);
                flag2++;
            }


            if(hasFish()){
                return false;
            }
        }

        return true;
    }

    @Override
    public void zhongYu() {
        int tee=1;

        //提竿加速收线
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.keyPress(KeyEvent.VK_SHIFT);

        //一直收线
        while(!robot.getPixelColor(835, 855).equals(Cr.c5)){
            //没力气了喝茶
            Color tc = robot.getPixelColor(191, 959);
            if(Cr.isRed(tc.getRed(),tc.getGreen(),tc.getBlue())&&tee>0){
                robot.keyPress(KeyEvent.VK_4);
                robot.keyRelease(KeyEvent.VK_4);
                tee--;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //停止加速，放下鱼竿，停止收线
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);


        //按空格键收鱼
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);

        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    @Override
    public void shouGan() {
        //抬杆加速收线
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.keyPress(KeyEvent.VK_SHIFT);

        try {
            Thread.sleep(random.nextInt(1000)+2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public boolean hasFish(){
        Color pC = robot.getPixelColor(946, 1052);
        if(pC.equals(Cr.c1)||pC.equals(Cr.c2)||pC.equals(Cr.c3)||pC.equals(Cr.c4)){
            return true;
        }
        else{
            return false;
        }
    }


    public void eatRadish(){
        Color pixelColor = robot.getPixelColor(191, 991);
        if(Cr.isRed(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue())){
            robot.keyPress(KeyEvent.VK_5);
            robot.keyRelease(KeyEvent.VK_5);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void headChange(int nums){
        qrobot.setAutoDelay(random.nextInt(30)+20);
        int dirX=random.nextInt(3)-1;
        int dirY=random.nextInt(5)-2;
        for(int j=0;j<nums;j++){
            Point cur = MouseInfo.getPointerInfo().getLocation();
            cur.x=cur.x+random.nextInt(5)-2+dirX;
            cur.y=cur.y+random.nextInt(5)-2+dirY;
            qrobot.mouseMove(cur.x, cur.y);
        }
    }

    public void locationChange(){
        int dirMoveX=random.nextInt(Rg.moverangx/2)- Rg.moverangx /4;
        int dirMoveY=random.nextInt(Rg.moverangy/2)-Rg.moverangy/4;
        Rg.curmovex+=dirMoveX;
        Rg.curmovey+=dirMoveY;
        if(Rg.curmovex<=0)dirMoveX=0;
        if(Rg.curmovex>=Rg.moverangx) dirMoveX=0;
        if(Rg.curmovey<=0)dirMoveY=0;
        if(Rg.curmovey>=Rg.moverangy) dirMoveY=0;

        if(dirMoveX>0){
            robot.keyPress(KeyEvent.VK_D);
            try {
                Thread.sleep(dirMoveX);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyRelease(KeyEvent.VK_D);
        }
        else{
            robot.keyPress(KeyEvent.VK_A);
            try {
                Thread.sleep(-dirMoveX);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyRelease(KeyEvent.VK_A);
        }

        if(dirMoveY>0){
            robot.keyPress(KeyEvent.VK_W);
            try {
                Thread.sleep(dirMoveY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyRelease(KeyEvent.VK_W);
        }
        else{
            robot.keyPress(KeyEvent.VK_S);
            try {
                Thread.sleep(-dirMoveY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyRelease(KeyEvent.VK_S);
        }
    }

}
