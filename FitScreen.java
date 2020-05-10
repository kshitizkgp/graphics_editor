
package graphicseditor;


public class FitScreen {

    private int topx=10000,topy=100000,bottomx=0,bottomy=0;
    private PaintSurface paint_surface;

    public FitScreen(PaintSurface ps){
        this.paint_surface = ps;
    }

    public void fit(){
        for (Rect r: paint_surface.getRect_array()){
            if (r.getRectangle().x < topx){
                topx = (int) r.getRectangle().x;
            }
            if (r.getRectangle().y < topy){
                topy = (int)r.getRectangle().y;
            }
            if (r.getRectangle().x + r.getRectangle().width >  bottomx){
                bottomx = (int)(r.getRectangle().x + r.getRectangle().width);
            }
            if (r.getRectangle().y + r.getRectangle().height >  bottomy){
                bottomy = (int)(r.getRectangle().y + r.getRectangle().height);
            }
        }
        for (Ellipse r: paint_surface.getEllipse_array()){
            if (r.getEll().x < topx){
                topx = (int) r.getEll().x;
            }
            if (r.getEll().y < topy){
                topy = (int)r.getEll().y;
            }
            if (r.getEll().x + r.getEll().width >  bottomx){
                bottomx = (int)(r.getEll().x + r.getEll().width);
            }
            if (r.getEll().y + r.getEll().height >  bottomy){
                bottomy = (int)(r.getEll().y + r.getEll().height);
            }
        }
        for (Line r: paint_surface.getLine_array()){
            if (r.getLine_drawn().x1 < topx){
                topx = (int) r.getLine_drawn().x1;
            }
            if (r.getLine_drawn().y1 < topy){
                topy = (int)r.getLine_drawn().y1;
            }
            if (r.getLine_drawn().x2>  bottomx){
                bottomx = (int)(r.getLine_drawn().x2);
            }
            if (r.getLine_drawn().y2 >  bottomy){
                bottomy = (int)(r.getLine_drawn().y2);
            }
        }
        for (Rect r: paint_surface.getImg_rect()){
            if (r.getRectangle().x < topx){
                topx = (int) r.getRectangle().x;
            }
            if (r.getRectangle().y < topy){
                topy = (int)r.getRectangle().y;
            }
            if (r.getRectangle().x + r.getRectangle().width >  bottomx){
                bottomx = (int)(r.getRectangle().x + r.getRectangle().width);
            }
            if (r.getRectangle().y + r.getRectangle().height >  bottomy){
                bottomy = (int)(r.getRectangle().y + r.getRectangle().height);
            }
        }
        for (Poly p :paint_surface.getPoly_array()){
            for (int i=0;i<p.getPoly().npoints;i++){
                if (p.getPoly().xpoints[i] > bottomx){
                    bottomx = p.getPoly().xpoints[i];
                }
                if (p.getPoly().ypoints[i] > bottomy){
                    bottomy = p.getPoly().ypoints[i];
                }
                if (p.getPoly().xpoints[i] < topx){
                    topx = p.getPoly().xpoints[i];
                }
                if (p.getPoly().ypoints[i] < topy){
                    topy = p.getPoly().ypoints[i];
                }
            }
        }

        paint_surface.getZoom().fit_screen(topx, topy, bottomx - topx, bottomy-topy);
    }
}
