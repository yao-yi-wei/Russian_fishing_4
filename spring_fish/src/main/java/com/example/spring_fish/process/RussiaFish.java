package com.example.spring_fish.process;

import com.example.spring_fish.service.FishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@Component
public class RussiaFish {

    @Autowired
    private FishServiceImpl fishService;

    private Random random=new Random();

    public void startFishing(int count) throws InterruptedException {
        //等待切换到游戏界面

        Thread.sleep(5000);


        //渔夫消息
        int rest1= random.nextInt(count/2);
        int rest2= random.nextInt(count/2)+count/2;

        //循环钓鱼
        for(int i=0;i<count;i++){

            //抛竿
            fishService.paoGan();
            //收线
            if(fishService.shouXian()){
                //没鱼提竿
                fishService.shouGan();
            }
            else{
                //中鱼
                fishService.zhongYu();
            }
            //饿了吃萝卜
            fishService.eatRadish();
            //鼠标动一下
            fishService.headChange(10);
            //位置动一下
            fishService.locationChange();

            TimeUnit.SECONDS.sleep(1);

            //渔夫偶尔休息一下
            if(i==rest1||i==rest2){
                Thread.sleep(random.nextInt(10000)+10000);
            }


        }
    }

}
