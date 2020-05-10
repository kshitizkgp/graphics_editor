
package graphicseditor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SelectShape extends MouseAdapter{

    private PaintSurface paint_surface;
    float selectedX, selectedY;

    public SelectShape(PaintSurface ps){
        this.paint_surface = ps;
    }

    @Override
    public void mousePressed(MouseEvent event){
        selectedX = event.getX();
        selectedY = event.getY();
        for (Rect r : paint_surface.getRect_array()){
            if (r.getRectangle().contains(selectedX, selectedY) & r.getGroup() == null){
                unselectAll();
                r.setSelected(true);
            }
            else if(r.getRectangle().contains(selectedX,selectedY)){
                unselectAll();
                grouping g = r.getGroup();
                for (Rect r2: g.getRect_objects()){
                    r2.setSelected(true);
                }
                for (Ellipse e: g.getEllipse_objects()){
                    e.setSelected(true);
                }
                for (Line l: g.getLine_objects()){
                    l.setSelected(true);
                }
                for (Rect r3: g.getImage_objects()){
                    r3.setSelected(true);
                }
            }
        }
        for (Ellipse e : paint_surface.getEllipse_array()){
            if (e.getEll().contains(selectedX, selectedY) & e.getGroup() == null){
                unselectAll();
                e.setSelected(true);

            }
            else if(e.getEll().contains(selectedX,selectedY)){
                unselectAll();
                grouping g = e.getGroup();
                System.out.println(" i m hrrrrrr");
                for (Rect r2: g.getRect_objects()){
                    r2.setSelected(true);
                }
                for (Ellipse e1: g.getEllipse_objects()){
                    e1.setSelected(true);
                }
                for (Line l: g.getLine_objects()){
                    l.setSelected(true);
                }
                for (Rect r3: g.getImage_objects()){
                    r3.setSelected(true);
                }
            }
        }
        for (Line l : paint_surface.getLine_array()){
            if (l.getLine_drawn().contains(selectedX, selectedY) & l.getGroup()== null){
                unselectAll();
                l.setSelected(true);

            }
            else if(l.getLine_drawn().contains(selectedX,selectedY)){
                unselectAll();
                grouping g = l.getGroup();
                for (Rect r2: g.getRect_objects()){
                    r2.setSelected(true);
                }
                for (Ellipse e: g.getEllipse_objects()){
                    e.setSelected(true);
                }
                for (Line l1: g.getLine_objects()){
                    l1.setSelected(true);
                }
                for (Rect r3: g.getImage_objects()){
                    r3.setSelected(true);
                }
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
