package com.designpattern.Behavioral.template;

import java.awt.*;

public abstract class FourAngle {
   private Point p1,p2,p3,p4;

    public FourAngle(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    public void drawLine(Graphics g, Point a, Point b){
        g.drawLine(a.x,a.y,b.x,b.y);
    }

    public void draw(Graphics g ){
        drawLine(g,p1,p2);
        // current = draw2ndLine(g, p2, p3);

    }

}
