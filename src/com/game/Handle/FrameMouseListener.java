package com.game.Handle;

import com.game.View.BaseFrame;

import java.awt.event.*;

public class FrameMouseListener implements KeyListener {

   public BaseFrame baseFrame;
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        // TODO Auto-generated method stub
//        this.baseFrame.myPanel.player.x = e.getX() - this.baseFrame.myPanel.player.width/2;
//        this.baseFrame.myPanel.player.y = e.getY() - this.baseFrame.myPanel.player.height/2;
//    }
//
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        // TODO Auto-generated method stub
//
//    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.baseFrame.myPanel.player.x = e.getKeyLocation() - this.baseFrame.myPanel.player.width/2;
        this.baseFrame.myPanel.player.y = e.getKeyLocation() - this.baseFrame.myPanel.player.height/2;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_UP){
            //this.baseFrame.myPanel.player.x = e.getKeyLocation() - this.baseFrame.myPanel.player.width/2;
            this.baseFrame.myPanel.player.y = this.baseFrame.myPanel.player.y-25;
        }
        if (keyCode==KeyEvent.VK_DOWN){
            this.baseFrame.myPanel.player.y = this.baseFrame.myPanel.player.y+25;
        }
        if (keyCode==KeyEvent.VK_LEFT){
            this.baseFrame.myPanel.player.x= this.baseFrame.myPanel.player.x-25;
        }
        if (keyCode==KeyEvent.VK_RIGHT){
            this.baseFrame.myPanel.player.x= this.baseFrame.myPanel.player.x+25;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

