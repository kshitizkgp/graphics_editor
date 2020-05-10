
package graphicseditor;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;


public class Zoom extends MouseAdapter{

    private Rectangle2D.Float rect_zoom;
    private PaintSurface paint_surface;
    private float startedx,startedy;
    private float scale_factor;
    private float centerx , centery;

    public Zoom(PaintSurface ps){
        this.paint_surface = ps;
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        centery = (float) (d.getHeight()/2);
        centerx = (float) (d.getWidth()/2);

    }

    @Override
    public void mousePressed(MouseEvent E){
        setStartedx(E.getX());
        setStartedy(E.getY());
        setRect_zoom(new Rectangle2D.Float(E.getX(), E.getY(), 0, 0));
        getPaint_surface().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent E){
        float width = E.getX() - getStartedx();
        float height = E.getY() - getStartedy();
        rect_zoom.width = width;
        rect_zoom.height = height;
        getPaint_surface().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent E){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = paint_surface.getSize();
        System.out.format("Height and Width %d %d",(int)d.height,(int)d.width);
        setScale_factor(Math.min(d.height, d.width) / Math.min(getRect_zoom().height, getRect_zoom().width));
        paint_surface.setZoom_level(paint_surface.getZoom_level()*scale_factor);
        System.out.format("Scale Factor %f", scale_factor);
        for (Rect r: getPaint_surface().getRect_array()){
            r.scale(getScale_factor());
        }
        for (Ellipse e:getPaint_surface().getEllipse_array()){
            e.scale(getScale_factor());
        }
        for (Line l:getPaint_surface().getLine_array()){
            l.scale(getScale_factor());
        }
        for (Rect r : getPaint_surface().getImg_rect()){
            r.scale(getScale_factor());
        }
        for (Poly p:getPaint_surface().getPoly_array()){
            p.scale(getScale_factor());
        }
        paint_surface.repaint();
        int pan_x = (int) ((int)getRect_zoom().x * getScale_factor());
        int pan_y = (int)((int)getRect_zoom().y * getScale_factor());
        for (Rect r: getPaint_surface().getRect_array()){
            r.PanPos(-pan_x,- pan_y);
        }
        for (Ellipse e:getPaint_surface().getEllipse_array()){
            e.PanPos(-pan_x,-pan_y);
        }
        for (Line l:getPaint_surface().getLine_array()){
            l.PanPos(-pan_x,-pan_y);
        }
        for (Rect r : getPaint_surface().getImg_rect()){
            r.PanPos(-pan_x,-pan_y);
        }
        for (Poly p:getPaint_surface().getPoly_array()){
            p.PanPos(-pan_x,-pan_y);
        }
        this.rect_zoom.width = 0;
        this.rect_zoom.height = 0;
        getPaint_surface().repaint();
    }

    public void fit_screen(float x, float y,float wi, float hi){
        System.out.println("Heeeelloo");
        System.out.println(x+"");
        System.out.println(y+"");
        System.out.println(wi+"");
        System.out.println(hi);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = paint_surface.getSize();
        System.out.format("Height and Width %d %d",(int)d.height,(int)d.width);
        setScale_factor(Math.min(d.height-100, d.width-100) / Math.min(wi,hi));
        paint_surface.setZoom_level(paint_surface.getZoom_level()*scale_factor);
        System.out.format("Scale Factor %f", scale_factor);
        for (Rect r: getPaint_surface().getRect_array()){
            r.scale(getScale_factor());
        }
        for (Ellipse e:getPaint_surface().getEllipse_array()){
            e.scale(getScale_factor());
        }
        for (Line l:getPaint_surface().getLine_array()){
            l.scale(getScale_factor());
        }
        for (Rect r : getPaint_surface().getImg_rect()){
            r.scale(getScale_factor());
        }
        for (Poly p:getPaint_surface().getPoly_array()){
            p.scale(getScale_factor());
        }
        paint_surface.repaint();
        int pan_x = (int) ((int)x * getScale_factor()) - 20;
        int pan_y = (int)((int)y * getScale_factor()) - 20;
        for (Rect r: getPaint_surface().getRect_array()){
            r.PanPos(-pan_x,- pan_y);
        }
        for (Ellipse e:getPaint_surface().getEllipse_array()){
            e.PanPos(-pan_x,-pan_y);
        }
        for (Line l:getPaint_surface().getLine_array()){
            l.PanPos(-pan_x,-pan_y);
        }
        for (Rect r : getPaint_surface().getImg_rect()){
            r.PanPos(-pan_x,-pan_y);
        }
        for (Poly p:getPaint_surface().getPoly_array()){
            p.PanPos(-pan_x,-pan_y);
        }
        //getPaint_surface().repaint();
    }

    public void normal(){

        scale_factor = 1/(paint_surface.getZoom_level());
        paint_surface.setZoom_level(paint_surface.getZoom_level()*scale_factor);
        System.out.format("Scale Factor %f", scale_factor);
        for (Rect r: getPaint_surface().getRect_array()){
            r.scale(getScale_factor());
        }
        for (Ellipse e:getPaint_surface().getEllipse_array()){
            e.scale(getScale_factor());
        }
        for (Line l:getPaint_surface().getLine_array()){
            l.scale(getScale_factor());
        }
        for (Rect r : getPaint_surface().getImg_rect()){
            r.scale(getScale_factor());
        }
        for (Poly p:getPaint_surface().getPoly_array()){
            p.scale(getScale_factor());
        }
        paint_surface.repaint();
        int pan_x = (int) ((int)getRect_zoom().x * (1/getScale_factor()));
        int pan_y = (int)((int)getRect_zoom().y * (1/getScale_factor()));
        for (Rect r: getPaint_surface().getRect_array()){
            r.PanPos(pan_x, pan_y);
        }
        for (Ellipse e:getPaint_surface().getEllipse_array()){
            e.PanPos(pan_x, pan_y);
        }
        for (Line l:getPaint_surface().getLine_array()){
            l.PanPos(pan_x, pan_y);
        }
        for (Rect r : getPaint_surface().getImg_rect()){
            r.PanPos(pan_x, pan_y);
        }
        for (Poly p:getPaint_surface().getPoly_array()){
            p.PanPos(pan_x, pan_y);
        }
        getPaint_surface().repaint();
    }

    public void zoomOut(){

        scale_factor = (float) ((float)1/(1.2));
        paint_surface.setZoom_level(paint_surface.getZoom_level()*scale_factor);
        System.out.format("Scale Factor %f", scale_factor);
        for (Rect r: getPaint_surface().getRect_array()){
            r.scale(getScale_factor());
        }
        for (Ellipse e:getPaint_surface().getEllipse_array()){
            e.scale(getScale_factor());
        }
        for (Line l:getPaint_surface().getLine_array()){
            l.scale(getScale_factor());
        }
        for (Rect r : getPaint_surface().getImg_rect()){
            r.scale(getScale_factor());
        }
        for (Poly p:getPaint_surface().getPoly_array()){
            p.scale(getScale_factor());
        }
        paint_surface.repaint();
    }

    public void zoomIn(){

        scale_factor = (float) ((float)1.2);
        paint_surface.setZoom_level(paint_surface.getZoom_level()*scale_factor);
        System.out.format("Scale Factor %f", scale_factor);
        for (Rect r: getPaint_surface().getRect_array()){
            r.scale(getScale_factor());
        }
        for (Ellipse e:getPaint_surface().getEllipse_array()){
            e.scale(getScale_factor());
        }
        for (Line l:getPaint_surface().getLine_array()){
            l.scale(getScale_factor());
        }
        for (Rect r : getPaint_surface().getImg_rect()){
            r.scale(getScale_factor());
        }
        for (Poly p:getPaint_surface().getPoly_array()){
            p.scale(getScale_factor());
        }
        paint_surface.repaint();
    }



    /**
     * @return the rect_zoom
     */
    public Rectangle2D.Float getRect_zoom() {
        return rect_zoom;
    }

    /**
     * @param rect_zoom the rect_zoom to set
     */
    public void setRect_zoom(Rectangle2D.Float rect_zoom) {
        this.rect_zoom = rect_zoom;
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
     * @return the startedx
     */
    public float getStartedx() {
        return startedx;
    }

    /**
     * @param startedx the startedx to set
     */
    public void setStartedx(float startedx) {
        this.startedx = startedx;
    }

    /**
     * @return the startedy
     */
    public float getStartedy() {
        return startedy;
    }

    /**
     * @param startedy the startedy to set
     */
    public void setStartedy(float startedy) {
        this.startedy = startedy;
    }

    /**
     * @return the scale_factor
     */
    public float getScale_factor() {
        return scale_factor;
    }

    /**
     * @param scale_factor the scale_factor to set
     */
    public void setScale_factor(float scale_factor) {
        this.scale_factor = scale_factor;
    }
}
