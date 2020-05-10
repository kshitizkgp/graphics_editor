package graphicseditor;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

public class clipArt implements Serializable{

    private ArrayList<Rect> rect_objects = new ArrayList<Rect>();
    private ArrayList<Ellipse> ellipse_objects = new ArrayList<Ellipse>();
    private ArrayList<Line> line_objects = new ArrayList<Line>();
    private ArrayList<Rect> image_objects = new ArrayList<Rect>();
    private ArrayList<Image> image_images = new ArrayList<Image>();
    private ArrayList<grouping> group_objects = new ArrayList<grouping>();
    private PaintSurface paint_surface;
    private boolean enabled = false;

    public clipArt(){

    }
    public clipArt(PaintSurface ps){
        this.paint_surface = ps;
        for (Rect r: paint_surface.getRect_array()){
            if (r.isSelected() ){
                rect_objects.add(r);
                r.setSelected(false);
            }
        }
        for (Ellipse r: paint_surface.getEllipse_array()){
            if (r.isSelected()){
                ellipse_objects.add(r);
                r.setSelected(false);
            }
        }
        for (Line r: paint_surface.getLine_array()){
            if (r.isSelected()){
                r.setSelected(false);
                line_objects.add(r);
            }
        }
        for (int i=0;i<paint_surface.getImg_rect().size();i++){

            if (paint_surface.getImg_rect().get(i).isSelected()){
                paint_surface.getImg_rect().get(i).setSelected(false);
                image_objects.add(paint_surface.getImg_rect().get(i));
                image_images.add(paint_surface.getImages().get(i));
            }
        }

    }

    public void show(){
        for (Rect r: this.getRect_objects()){
            paint_surface.getRect_array().add(r);
            paint_surface.setNum_rect(paint_surface.getNum_rect()+1);
        }
        for (Ellipse r: this.getEllipse_objects()){
            paint_surface.getEllipse_array().add(r);
            paint_surface.setNum_ellipse(paint_surface.getNum_ellipse() + 1);
        }
        for (Line r: this.getLine_objects()){
            paint_surface.getLine_array().add(r);
            paint_surface.setNum_line(paint_surface.getNum_line() + 1);
        }
        for (int i=0;i<this.getImage_objects().size();i++){
            paint_surface.getImg_rect().add(this.getImage_objects().get(i));
            paint_surface.getImages().add(this.image_images.get(i));
            paint_surface.setNum_images(paint_surface.getNum_images() + 1);
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

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the image_images
     */
    public ArrayList<Image> getImage_images() {
        return image_images;
    }

    /**
     * @param image_images the image_images to set
     */
    public void setImage_images(ArrayList<Image> image_images) {
        this.image_images = image_images;
    }
}
