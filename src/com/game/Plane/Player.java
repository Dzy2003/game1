package com.game.Plane;

import com.game.pojo.Item;
import com.game.View.BaseFrame;
import com.game.View.MyPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
public class Player {

    //使用MyPanel的原因是，要调用MyPanel中的timer
    public MyPanel myPanel;
    //width，height是主角飞机宽度与高度
    public int width = 102;
    public int height = 126;
    //x，y是主角飞机的坐标（左上角）
    public int x;
    public int y;
    //将所有的主角飞机 图片对象放到数组中
    public Image[] images = new Image[]{
            Toolkit.getDefaultToolkit().getImage("images/me1.png"),
            Toolkit.getDefaultToolkit().getImage("images/me2.png")
    };

    //存放当前图片的下标
    public int imageIndex = 0;
    //构造方法
    public Player(MyPanel myPanel) {
        this.myPanel = myPanel;
        this.x = (BaseFrame.frameWidth - this.width) / 2;
        this.y = BaseFrame.frameHeight - this.height * 2;
    }
    public void drawSelf(Graphics g) {
        g.drawImage(this.images[imageIndex], x, y, width, height, null);
        //每隔50毫秒切换一张图片
        if (this.myPanel.timer % 50 == 0) {
            imageIndex++;
            //图片遍历到最后一个后，图片下标再次重0开始
            if (this.imageIndex == this.images.length) {
                this.imageIndex = 0;
            }
        }
     //判断主角飞机是否吃到奖品
       for(int i=0;i<this.myPanel.items.size();i++) {
            Item item=this.myPanel.items.get(i);
            if((this.x>=item.x-this.width && this.x<=item.x+item.width) && (this.y>=item.y-this.height && this.y<=item.y+item.height) ) {
                item.eated();
            }
        }
    }
    }



