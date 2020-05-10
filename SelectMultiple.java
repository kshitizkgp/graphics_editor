
package graphicseditor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SelectMultiple extends MouseAdapter{

    private PaintSurface paint_surface;
    float selectedX, selectedY;

    public SelectMultiple(PaintSurface ps){
        this.paint_surface = ps;
    }

    @Override
    public void mousePressed(MouseEvent event){

        selectedX = event.getX();
        selectedY = event.getY();
        for (Rect r : paint_surface.getRect_array()){
            if (r.getRectangle().contains(selectedX, selectedY)){
                if (r.isSelected() == false)
                    r.setSelected(true);
                else
                    r.setSelected(false);
            }
        }
        for (Ellipse e : paint_surface.getEllipse_array()){
            if (e.getEll().contains(selectedX, selectedY)){
                if (e.isSelected() == false)
                e.setSelected(true);
                else
                    e.setSelected(false);

            }
        }
        for (Line l : paint_surface.getLine_array()){
            if (l.getLine_drawn().contains(selectedX, selectedY)){
                if (l.isSelected() == false)
                l.setSelected(true);
                else
                    l.setSelected(false);

            }
        }
        paint_surface.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent E){
        float newX = E.getX();
        float newY = E.getY();
        float oldX = selectedX;
        float oldY = selectedY;
        for (Rect r : paint_surface.getRect_array()){
            if (r.isSelected()){
                r.updatePos(newX, newY, oldX,oldY);
                selectedX = newX;
                selectedY = newY;
            }
        }
        for (Ellipse e : paint_surface.getEllipse_array()){
            if (e.isSelected()){
                e.updatePos(newX, newY, oldX, oldY);
                selectedX = newX;
                selectedY = newY;
            }
        }
        for (Line l : paint_surface.getLine_array()){

            if (l.isSelected()){
                l.updatePos(newX, newY, oldX, oldY);
                selectedX = newX;
                selectedY = newY;
            }
        }
        paint_surface.repaint();
    }
    /**
     * @return the paint_surface
     */
    public PaintSurface getPaint_surface() {
        return paint_surface;
    }

    public void unselectAll(){
        for (Rect r: paint_surface.getRect_array()){
            r.setSelected(false);
        }
        for (Ellipse e : paint_surface.getEllipse_array()){
            e.setSelected(false);
        }
        for (Line l : paint_surface.getLine_array()){
            l.setSelected(false);

        }
    }

    /**
     * @param paint_surface the paint_surface to set
     */
    public void setPaint_surface(PaintSurface paint_surface) {
        this.paint_surface = paint_surface;
    }



}
