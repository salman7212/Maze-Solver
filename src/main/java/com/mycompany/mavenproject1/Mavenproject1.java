/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Syed Ali
 */
public class Mavenproject1 extends JFrame {

   int[][] maze;
	    List<Integer>path=new ArrayList<>();
	    Mavenproject1(){ 
	        this.maze = new int[][]{
	            {1,1,1,1,1,1,1,1,1,1,1,1,1},
	            {1,0,1,1,1,1,1,1,1,1,1,1,1},
	            {1,0,0,0,0,0,0,1,1,1,1,1,1},
	            {1,1,0,1,0,1,0,1,1,1,1,1,1},
	            {1,1,0,1,0,1,0,1,1,1,1,1,1},
	            {1,1,0,0,0,0,0,0,0,0,0,1,1},
	            {1,1,1,1,0,1,1,1,1,1,0,1,1},
	            {1,1,1,1,0,1,1,1,1,1,0,1,1},
	            {1,1,1,1,0,0,1,1,0,1,0,1,1},
	            {1,1,1,1,1,0,1,1,0,0,0,1,1},
	            {1,1,1,1,1,0,1,1,1,1,0,1,1},
	            {1,1,1,1,1,0,0,0,0,0,0,9,1},
	            {1,1,1,1,1,1,1,1,1,1,1,1,1}};
	        setTitle("Maze Solver");
	        setSize(640,480);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        DepthFirst.searchpath(maze, 1, 1, path);
	        System.out.println(path);
	    }
	    @Override
	    public void paint(Graphics g){
	        //super.paint 
	        super.paint(g);
	        for(int i=0;i<maze.length;i++){
	            for(int j=0;j<maze[0].length;j++){
	                Color color;
                        color = switch (maze[i][j]) {
                            case 1 -> Color.BLACK;
                            case 9 -> Color.RED;
                            default -> Color.WHITE;
                        };
	                g.setColor(color);
	                g.fillRect(30*j, 30*i, 30, 30);
	                g.setColor(Color.RED);
	                g.drawRect(30*j, 30*i, 30, 30);
	            }
	        }
	        
	        for(int i=0;i<path.size();i+=2){
	            int pathx=path.get(i);
	            int pathy=path.get(i+1);
	            System.out.println("X coordinates"+pathx);
	            System.out.println("Y coordinates"+pathy);
	            g.setColor(Color.GREEN);
	            g.fillRect(30*pathx, 30*pathy, 30, 30);
	        }
	    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
	        Mavenproject1 view =new  Mavenproject1();
	        view.setVisible(true);
	    }
}
