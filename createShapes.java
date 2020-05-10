package graphicseditor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class createShapes extends MouseAdapter{

    float startx, starty;
    int shape_create;
    PaintSurface paint_surface;

    public createShapes(PaintSurface ps){
        this.paint_surface = ps;
        this.shape_create = ps.getShape();
    }

    @Override
    public void mousePressed(MouseEvent event){
        startx = event.getX();
        starty = event.getY();
        System.out.println(startx);
        System.out.println(event.getX());
        shape_create = paint_surface.getShape();
        if (shape_create == 1){
            Rectangle2D.Float rec = new Rectangle2D.Float(startx, starty, 0, 0);
            Rect r = new Rect(rec);
            paint_surface.getRect_array().add(r);
            paint_surface.setNum_rect(paint_surface.getNum_rect() + 1);
        }
        if (shape_create == 2){
            Ellipse2D.Float ellipse = new Ellipse2D.Float(startx, starty, 0, 0);
            Ellipse e = new Ellipse(ellipse);
            paint_surface.getEllipse_array().add(e);
            paint_surface.setNum_ellipse(paint_surface.getNum_ellipse() + 1);
        }
        if (shape_create == 3){
            Line2D.Float line = new Line2D.Float(startx, starty, startx, starty);
            Line l = new Line(line);
            paint_surface.getLine_array().add(l);
            paint_surface.setNum_line(paint_surface.getNum_line() + 1);
        }

        if (shape_create == 4){
            Rectangle2D.Float rec = new Rectangle2D.Float(startx, starty, 0, 0);
            Rect r = new Rect(rec);
            paint_surface.getText_rect().add(r);
            paint_surface.setNum_text(paint_surface.getNum_text() + 1);
        }

        if (shape_create == 5){
            Ellipse2D.Float ellipse = new Ellipse2D.Float(startx, starty, 0, 0);
            Ellipse e = new Ellipse(ellipse);
            paint_surface.getEllipse_array().add(e);
            paint_surface.setNum_ellipse(paint_surface.getNum_ellipse() + 1);
        }
        if (shape_create == 6){
            Rectangle2D.Float rec = new Rectangle2D.Float(startx, starty, 0, 0);
            Rect r = new Rect(rec);
            paint_surface.getImg_rect().add(r);
            paint_surface.setNum_images(paint_surface.getNum_images() + 1);
        }

        paint_surface.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent event){

        float width = event.getX() - startx;
        float height = event.getY() - starty;
        shape_create = paint_surface.getShape();
        if (shape_create == 1){
            paint_surface.getRect_array().get(paint_surface.getNum_rect()-1).getRectangle().width = width;
            paint_surface.getRect_array().get(paint_surface.getNum_rect()-1).getRectangle().height = height;
        }
       else if (shape_create == 2){
           paint_surface.getEllipse_array().get(paint_surface.getNum_ellipse() - 1).getEll().width = width;
           paint_surface.getEllipse_array().get(paint_surface.getNum_ellipse() - 1).getEll().height = height;
       }
       else if (shape_create == 3){
           paint_surface.getLine_array().get(paint_surface.getNum_line() - 1).getLine_drawn().x2 = event.getX();
           paint_surface.getLine_array().get(paint_surface.getNum_line() - 1).getLine_drawn().y2 = event.getY();
       }
       else if (shape_create == 4){
            paint_surface.getText_rect().get(paint_surface.getNum_text()-1).getRectangle().width = width;
            paint_surface.getText_rect().get(paint_surface.getNum_text()-1).getRectangle().height = height;
        }

       else if (shape_create == 5){
           float wi = Math.min(width,height );
           paint_surface.getEllipse_array().get(paint_surface.getNum_ellipse() - 1).getEll().width = wi;
           paint_surface.getEllipse_array().get(paint_surface.getNum_ellipse() - 1).getEll().height = wi;
       }
       else if (shape_create == 6){
           paint_surface.getImg_rect().get(paint_surface.getNum_images() - 1).getRectangle().width = width;
           paint_surface.getImg_rect().get(paint_surface.getNum_images() - 1).getRectangle().height = height;
       }
       paint_surface.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent E){
        System.out.println("In m in releasing");
        if (shape_create == 6){
            shape_create = 1;
            paint_surface.setShape(1);
        }
        if (shape_create == 4){
            shape_create = 1;
            paint_surface.setShape(1);
        }
    }

}
