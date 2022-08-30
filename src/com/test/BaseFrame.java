package com.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class BaseFrame extends JFrame{
    //窗口的宽度和高度（具体值由背景图片大小决定）
    public static int frameWidth=480;
    public static int frameHeight=700;
    public MyPanel myPanel;


    //构造方法
    public  BaseFrame()
    {

        //设置标题
        super("飞机大战");

        //获得屏幕分辨率
        Dimension  screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //设置窗口位置和大小，左上角（x，y），宽和高（w，h）
        setBounds((int) ((screenSize.getWidth()-frameWidth)/2),30,frameWidth,frameHeight);
        //创建一个MyPanel对象
        this.myPanel=new MyPanel();

        //设置MyPanel对象的位置和大小
        this.myPanel.setBounds(0,0,frameWidth,frameHeight);
        //将组件添加到窗口中
        this.add(this.myPanel);
        //设置布局方式
        setLayout(null);
        //显示窗口，JFrame 默认窗口不显示
        setVisible(true);
        //设置窗口关闭，关闭窗口后，程序停止
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
