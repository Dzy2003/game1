package com.game.pojo;

import com.game.Plane.Enemy;
import com.game.View.MyPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Bullet {
    //使用MyPanel的原因是，要调用MyPanel中的timer
    public MyPanel myPanel;

    //width，height是子弹宽度与高度
    public int width = 5;
    public int height = 11;

    //x，y是子弹的坐标
    public int x;
    public int y;

    //将所有的子弹 图片对象放到数组中
    public Image[] images = new Image[] {
            Toolkit.getDefaultToolkit().getImage("images/bullet1.png"),
            Toolkit.getDefaultToolkit().getImage("images/bullet2.png")
    };
    //存放当前图片的下标
    public int imageIndex = 0;
    public Bullet(MyPanel myPanel) {
        this.myPanel = myPanel;
    }
    //画子弹
    public void drawSelf(Graphics g) {
        g.drawImage(this.images[imageIndex],x,y,width,height,null);
        g.drawImage(this.images[imageIndex],x-30,y,width,height+30,null);
        g.drawImage(this.images[imageIndex],x+30,y,width,height+30,null);

        //每隔50毫秒切换一张图片
        if(this.myPanel.timer%50==0) {
            imageIndex++;
            //图片遍历到最后一个后，图片下标再次重0开始
            if(this.imageIndex==this.images.length) {
                this.imageIndex = 0;
            }

            //子弹的坐标向上移动
            y=y-15;

            //如果子弹飞出窗口，则移除子弹
            if(y<0) {
                //移除子弹
                this.myPanel.bullets.remove(this);

            }
        }
        //判断子弹是否打中敌机
        for(int i=0; i<this.myPanel.enemys.size(); i++) {
            Enemy e = this.myPanel.enemys.get(i);

            //判断
            if((this.x>=e.x-e.width && this.x<=e.x+e.width) && (this.y>=e.y-e.height && this.y<=e.y+e.height)) {
                //移除该子弹
                this.myPanel.bullets.remove(this);
                //减去敌机的hp值
                e.underAttack();
            }
        }
    }
}


