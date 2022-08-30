package com.game.View;

import com.game.Handle.DrawableTherad;
import com.game.Plane.Enemy;
import com.game.Plane.Player;
import com.game.pojo.Bullet;
import com.game.pojo.Item;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

    //存放的是背景图片
    public int score;
    int state = 0;
    public Image bgImage;
    public DrawableTherad drawableTherad;
    public int timer;
    public int top = 0;
    public Player player;
    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    //存放所有的敌机
    public ArrayList<Enemy> enemys = new ArrayList<Enemy>();
    //存放所有的敌机类型
    public ArrayList<Class> enemyType = new ArrayList<Class>();
    //存放所有的奖品
    public ArrayList<Item> items = new ArrayList<Item>();
    // 构造方法
    public MyPanel() {
        this.bgImage = Toolkit.getDefaultToolkit().getImage("images/background.png");
        this.drawableTherad = new DrawableTherad(this);
        this.drawableTherad.start();
        this.player=new Player(this);
    }
    public void paintComponent(Graphics g) {


        super.paintComponent(g);
        if (state == 0){
            g.drawImage(bgImage,0,0,null);
            //改变画笔的颜色
            g.setColor(Color.BLUE);
            //改变文字大小和样式
            g.setFont(new Font("仿宋",Font.BOLD,50));
            //添加文字
            g.drawString("点击开始游戏",150,300);
        }
        if (state == 2){
            //改变画笔的颜色
            g.setColor(Color.red);
            //改变文字大小和样式
            g.setFont(new Font("仿宋",Font.BOLD,50));
            //添加文字
            g.drawString("GAME OVER",180,300);
        }
        //绘制背景图
        //g.drawImage(this.bgImage, 0, 0 - this.bgImage.getHeight(this), this.bgImage.getWidth(this), this.bgImage.getHeight(this), null);
        //g.drawImage(this.bgImage, 0, 0, this.bgImage.getWidth(this), this.bgImage.getHeight(this), null);
        if (state==1) {
            g.setColor(Color.green);
            //修改字体
            g.setFont(new Font("仿宋",Font.BOLD,40));

            timer++;
            if (timer == 10000)
                timer = 0;

            if (timer % 10 == 0) {
                top++;

                if (top > this.bgImage.getHeight(this))
                    top = 0;
            }
            this.player.drawSelf(g);
            //绘制子弹
            if(timer%100==0) {
                //创建子弹
                Bullet bullet = new Bullet(this);
                //设置坐标
                bullet.x = this.player.x+this.player.width/2 - bullet.width/2;
                bullet.y = this.player.y;

                //存入arrayList中
                this.bullets.add(bullet);
            }

            //画出所有的子弹
            for(int i=0; i<bullets.size(); i++) {
                this.bullets.get(i).drawSelf(g);
            }


            //绘制敌机
            if(timer%200==0) {
                if(this.enemyType.size()>0) {
                    //随机产生一种类型的敌机
                    int index = (int)(Math.random()*this.enemyType.size());
                    Enemy enemy = null;
                    try {
                        enemy = (Enemy)(this.enemyType.get(index).getConstructors()[0].newInstance(new Object[] {this}));
                    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                            | InvocationTargetException | SecurityException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    //将创建好的敌机放在数组里
                    this.enemys.add(enemy);
                }
            }

            //将所有的敌机画出来
            for(int i=0;i<this.enemys.size();i++) {
                this.enemys.get(i).drawSelf(g);
            }

            for(int i=0;i<this.items.size();i++) {
                this.items.get(i).drawSelf(g);
            }
        }

    }
}





