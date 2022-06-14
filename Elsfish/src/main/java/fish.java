import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class fish {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(5000);
        Color c1 = new Color(200, 214, 63);
        Color c2 = new Color(237, 195, 0);
        Color c3 = new Color(229, 188, 0);
        Color c4 = new Color(206, 56, 21);
        Color c5 = new Color(64, 64, 64);

        Color c_hungry = new Color(157, 43, 16);
        Color c_tired = new Color(157, 43, 16);

        Random random = new Random();
        Point pos = MouseInfo.getPointerInfo().getLocation();
        final int rangex=4;
        final int rangey=10;
        final int moverangx=1000;
        final int moverangy=400;
        int curmovex=moverangx/2;
        int curmovey=moverangy/2;
        int dirx=0;
        int diry=0;
        Thread.sleep(200);
        int stop1=random.nextInt(40);
        int stop2=random.nextInt(40)+50;
        for(int num=0;num<100;num++){
            if(stop1==num)Thread.sleep(random.nextInt(10000)+30000);
            if(stop2==num)Thread.sleep(random.nextInt(10000)+20000);

            robot.setAutoDelay(random.nextInt(200)+400);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.setAutoDelay(random.nextInt(200)+400);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.setAutoDelay(random.nextInt(200)+500);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.setAutoDelay(random.nextInt(200)+500);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.setAutoDelay(random.nextInt(200)+500);
            Thread.sleep(random.nextInt(1000)+2500);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.setAutoDelay(random.nextInt(200)+500);

            int chru=random.nextInt(22)+1;
            int taigan=24;
            int luobo=0;
            for(int i=0;i<28;i++){
                //随机动一下
                if(i==chru){
                    //随机移动鼠标
                    robot.setAutoDelay(30);
                    dirx=random.nextInt(2)-1;
                    diry=random.nextInt(4)-2;
                    for(int j=0;j<6;j++){
                        Point cur = MouseInfo.getPointerInfo().getLocation();
                        cur.x=cur.x+random.nextInt(2)-1+dirx;
                        cur.y=cur.y+random.nextInt(4)-2+diry;
                        if(cur.x<pos.x-rangex)cur.x=pos.x-rangex;
                        if(cur.x>pos.x+rangex)cur.x=pos.x+rangex;
                        if(cur.y<pos.y-rangey)cur.y=pos.y-rangey;
                        if(cur.y>pos.y+rangey)cur.y=pos.y+rangey;
                        robot.mouseMove(cur.x, cur.y);
                        robot.setAutoDelay(random.nextInt(30)+20);
                    }

                }
                if(i==taigan){
                    robot.mousePress(InputEvent.BUTTON3_MASK);
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                //判断是否中鱼
                Color pC = robot.getPixelColor(946, 1052);
                if(pC.equals(c1)||pC.equals(c2)||pC.equals(c3)||pC.equals(c4)){

                    int tee=0;

                    if(i<taigan){
                        //加速收线
                        robot.mousePress(InputEvent.BUTTON3_MASK);
                        robot.setAutoDelay(random.nextInt(200)+100);
                        robot.keyPress(KeyEvent.VK_SHIFT);
                    }

                    while(!robot.getPixelColor(835, 855).equals(c5)){
                        //是否没力气
                        if(robot.getPixelColor(192, 957).equals(c_tired)&&tee<3){
                            robot.keyPress(KeyEvent.VK_4);
                            robot.keyRelease(KeyEvent.VK_4);
                            tee++;
                        }
                        Thread.sleep(500);
                    }

                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.mouseRelease(InputEvent.BUTTON3_MASK);

                    robot.keyPress(KeyEvent.VK_SPACE);
                    robot.keyRelease(KeyEvent.VK_SPACE);

                    break;

                }

                if(robot.getPixelColor(193, 990).equals(c_hungry)&&luobo==0){
                    robot.keyPress(KeyEvent.VK_5);
                    robot.keyRelease(KeyEvent.VK_5);
                    luobo++;
                }
                Thread.sleep(1000);

            }

            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.mouseRelease(InputEvent.BUTTON3_MASK);

            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            Thread.sleep(random.nextInt(500)+500);

            //随机移动鼠标
            robot.setAutoDelay(random.nextInt(30)+20);
            dirx=random.nextInt(4)-2;
            diry=random.nextInt(4)-2;
            for(int j=0;j<10;j++){
                Point cur = MouseInfo.getPointerInfo().getLocation();
                cur.x=cur.x+random.nextInt(4)-2+dirx;
                cur.y=cur.y+random.nextInt(4)-2+diry;
                if(cur.x<pos.x-rangex)cur.x=pos.x-rangex;
                if(cur.x>pos.x+rangex)cur.x=pos.x+rangex;
                if(cur.y<pos.y-rangey)cur.y=pos.y-rangey;
                if(cur.y>pos.y+rangey)cur.y=pos.y+rangey;
                robot.mouseMove(cur.x, cur.y);
                robot.setAutoDelay(random.nextInt(30)+20);
            }

            //随机移动位置
            int dirmovex=random.nextInt(moverangx/2)-moverangx/4;
            int dirmovey=random.nextInt(moverangy/2)-moverangy/4;
            curmovex+=dirmovex;
            curmovey+=dirmovey;
            if(curmovex<=0)dirmovex=0;
            if(curmovex>=moverangx) dirmovex=0;
            if(curmovey<=0)dirmovey=0;
            if(curmovey>=moverangy) dirmovey=0;

            if(dirmovex>0){
                robot.keyPress(KeyEvent.VK_D);
                Thread.sleep(dirmovex);
                robot.keyRelease(KeyEvent.VK_D);
            }
            else{
                robot.keyPress(KeyEvent.VK_A);
                Thread.sleep(-dirmovex);
                robot.keyRelease(KeyEvent.VK_A);
            }

            if(dirmovey>0){
                robot.keyPress(KeyEvent.VK_W);
                Thread.sleep(dirmovey);
                robot.keyRelease(KeyEvent.VK_W);
            }
            else{
                robot.keyPress(KeyEvent.VK_S);
                Thread.sleep(-dirmovey);
                robot.keyRelease(KeyEvent.VK_S);
            }
        }

    }
}
