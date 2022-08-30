package com.test;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
public class MyPanel extends JPanel{
    //存放的是背景图片
    public Image bgImage;
    // 构造方法
    public MyPanel()
    {
        //获取图片对象
        this.bgImage=Toolkit.getDefaultToolkit().getImage("images/background.png");
    }
    //重写paintComponent方法获得画笔画出背景图
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //绘制背景图
        g.drawImage(this.bgImage, 0, 0-this.bgImage.getHeight(this), this.bgImage.getWidth(this),this.bgImage.getHeight(this), null);
        g.drawImage(this.bgImage, 0, 0, this.bgImage.getWidth(this),this.bgImage.getHeight(this),null);
    }
}