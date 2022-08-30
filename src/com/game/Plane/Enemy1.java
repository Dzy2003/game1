package com.game.Plane;

import com.game.pojo.Item;
import com.game.pojo.Item001;
import com.game.View.BaseFrame;
import com.game.View.MyPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Enemy1 extends Enemy{

    public Enemy1(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub

        this.width = 57;
        this.height = 43;
        this.hp = 3;

        this.x = (int) (Math.random()*(BaseFrame.frameWidth - this.width));
        this.y = - this.height;

        this.image = Toolkit.getDefaultToolkit().getImage("src/images/enemy1.png");

        this.items=new Item[] {
                new Item001(myPanel),
                new Item001(myPanel),
                new Item001(myPanel)
        };
    }

    //敌机爆炸效果，放在放到数组中
    public Image[] dieImages = new Image[] {
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down1.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down2.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down3.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down4.png"),
    };

    //存放当前图片的下标
    public int imageIndex = 0;

    //画敌机
    public void drawSelf(Graphics g) {
        //判断敌机是否被击中
        if(hp>0) {
            g.drawImage(this.image,x,y,width,height,null);
        }
        else {
            //被打中
            g.drawImage(this.dieImages[imageIndex],x,y,width,height,null);

            //每隔10毫秒切换一张图片
            if(this.myPanel.timer%50==0) {
                imageIndex++;
                if(imageIndex>=this.dieImages.length) {
                    //敌机死了
                    killed();
                }
            }
        }

        //敌机向下移动,如果敌机出界就销毁
        if(this.myPanel.timer%35==0) {
            y=y+10;
            if(y>=BaseFrame.frameHeight) {
                killed();
            }
        }
    }

}



