package com.game.View;

import com.game.Handle.FrameMouseListener;
import com.game.Plane.Enemy1;
import com.game.Plane.Enemy2;
import com.game.Plane.Enemy3;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;



public class BaseFrame extends JFrame{

    public static int frameWidth=480;
    public static int frameHeight=700;
    //状态
    public MyPanel myPanel;

    //鼠标监听事件
    public FrameMouseListener frameMouseListener;

    public void setTouchListener() {
        this.frameMouseListener=new FrameMouseListener();
        this.frameMouseListener.baseFrame = this;
        this.addKeyListener(this.frameMouseListener);
    }
    public void addEnemyType(Class c) {
        this.myPanel.enemyType.add(c);
    }

    public  BaseFrame()
    {
        super("雷霆战机");
        //获得屏幕分辨率
        Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();

        //设置窗口大小和位置
        setBounds((int) ((screenSize.getWidth()-frameWidth)/2),0,frameWidth,frameHeight);

        //设置布局方式
        setLayout(null);

        //创建一个MyPanel对象
        this.myPanel=new MyPanel();

        //设置MyPanel对象的位置和大小
        this.myPanel.setBounds(0,0,frameWidth,frameHeight);

        //将组件添加到窗口中
        this.add(this.myPanel);

        //设置监听器
        setTouchListener();
        //添加敌机类型
        addEnemyType(Enemy1.class);
        addEnemyType(Enemy2.class);
        addEnemyType(Enemy3.class);
        //鼠标点击状态变为开始
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标左键代号是1
                if (e.getButton() ==1){
                    myPanel.state = 1;
                    repaint();
                }
            }
        });
        //显示窗口
        setVisible(true);

        //设置窗口关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

