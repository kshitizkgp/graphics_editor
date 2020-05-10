
package graphicseditor;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;


public class grouping implements Serializable{

    private ArrayList<Rect> rect_objects = new ArrayList<Rect>();
    private ArrayList<Ellipse> ellipse_objects = new ArrayList<Ellipse>();
    private ArrayList<Line> line_objects = new ArrayList<Line>();
    private ArrayList<Rect> image_objects = new ArrayList<Rect>();
    private ArrayList<grouping> group_objects = new ArrayList<grouping>();
    private PaintSurface paint_surface;

    public grouping(PaintSurface ps){
        this.paint_surface = ps;
        for (Rect r: paint_surface.getRect_array()){
            if (r.getGroup()== null & r.isSelected() ){
                rect_objects.add(r);
                r.setGroup(this);

            }
        }
        for (Ellipse r: paint_surface.getEllipse_array()){
            if (r.isSelected() & r.getGroup() == null){
                System.out.println("I m here");
                ellipse_objects.add(r);
                r.setGroup(this);
            }
        }
        for (Line r: paint_surface.getLine_array()){
            if (r.isSelected() & r.getGroup() == null){
                line_objects.add(r);
                r.setGroup(this);
            }
        }
        for (Rect r: paint_surface.getImg_rect()){
            if (r.isSelected() & r.getGroup() == null){
                image_objects.add(r);
                r.setGroup(this);
            }
        }
    }

    /**
     * @return the rect_objects
     */
    public ArrayList<Rect> getRect_objects() {
        return rect_objects;
    }

    /**
     * @param rect_objects the rect_objects to set
     */
    public void setRect_objects(ArrayList<Rect> rect_objects) {
        this.rect_objects = rect_objects;
    }

    /**
     * @return the ellipse_objects
     */
    public ArrayList<Ellipse> getEllipse_objects() {
        return ellipse_objects;
    }

    /**
     * @param ellipse_objects the ellipse_objects to set
     */
    public void setEllipse_objects(ArrayList<Ellipse> ellipse_objects) {
        this.ellipse_objects = ellipse_objects;
    }

    /**
     * @return the line_objects
     */
    public ArrayList<Line> getLine_objects() {
        return line_objects;
    }

    /**
     * @param line_objects the line_objects to set
     */
    public void setLine_objects(ArrayList<Line> line_objects) {
        this.line_objects = line_objects;
    }

    /**
     * @return the image_objects
     */
    public ArrayList<Rect> getImage_objects() {
        return image_objects;
    }

    /**
     * @param image_objects the image_objects to set
     */
    public void setImage_objects(ArrayList<Rect> image_objects) {
        this.image_objects = image_objects;
    }

    /**
     * @return the group_objects
     */
    public ArrayList<grouping> getGroup_objects() {
        return group_objects;
    }

    /**
     * @param group_objects the group_objects to set
     */
    public void setGroup_objects(ArrayList<grouping> group_objects) {
        this.group_objects = group_objects;
    }

    /**
     * @return the paint_surface
     */
    public PaintSurface getPaint_surface() {
        return paint_surface;
    }

    /**
     * @param paint_surface the paint_surface to set
     */
    public void setPaint_surface(PaintSurface paint_surface) {
        this.paint_surface = paint_surface;
    }
}
