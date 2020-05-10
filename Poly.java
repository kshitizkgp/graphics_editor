
package graphicseditor;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class Poly extends MouseAdapter{

    private Polygon poly;
    private Color fillColor = new Color(255, 255, 255);
    private Color boundaryColor = new Color(0,0,0);
    private boolean selected = false;
    private float lineWidth = 1.0f;
    private float[]  dashPattern = {1.0f,1.0f};
    private float textX;
    private float textY;
    private float textXoffset;
    private float textYoffset;
    private grouping group = null;
    private ArrayList<Integer> xp = new ArrayList<Integer>();
    private ArrayList<Integer> yp = new ArrayList<Integer>();
    private PaintSurface paint_surface;
    Rectangle2D.Float re = new Rectangle2D.Float();


    public Poly(PaintSurface ps){
        poly = new Polygon();
        paint_surface = ps;
    }

    public Poly(Polygon p){
        this.poly = p;
    }

    public Poly(Poly p){
       this.poly = new Polygon (p.getPoly().xpoints,p.getPoly().ypoints,p.getPoly().npoints);
       this.fillColor = p.fillColor;
       this.boundaryColor = p.boundaryColor;
       this.lineWidth = p.lineWidth;
       this.dashPattern = p.dashPattern;
    }

    public void updatePos(float newX, float newY, float oldX, float oldY){

        for (int i=0;i<this.poly.npoints;i++){

            this.poly.xpoints[i] += newX - oldX;
            this.poly.ypoints[i] += newY - oldY;
        }
    }

    public void PanPos(float x, float y){
        for (int i=0;i<this.poly.npoints;i++){

            this.poly.xpoints[i] += x;
            this.poly.ypoints[i] += y;
        }
    }

    public void scale(float x){
        for (int i=0;i<this.poly.npoints;i++){

            this.poly.xpoints[i] *= x;
            this.poly.ypoints[i] *= x;
        }
    }

    @Override
    public void mousePressed(MouseEvent e){

        if (xp.size() == 0){
            re.height = 10;
            re.width = 10;
            re.x = e.getX() - 5;
            re.y = e.getY() - 5;
        }

        if (xp.size() >0){
            if(re.contains(e.getX(), e.getY())){

                int x[] = new int[xp.size()];
                int y[] = new int[xp.size()];

                for (int i=0;i<xp.size();i++){
                    x[i] = xp.get(i);
                    y[i] = yp.get(i);
                }
                this.poly = new Polygon(x,y,xp.size());
                xp.clear();yp.clear();
                paint_surface.getPoly_array().add(this);
                paint_surface.setNum_poly(paint_surface.getNum_poly() + 1);
                paint_surface.setMake_poly(new Poly(paint_surface));
                paint_surface.enablePolygonCreating();
                paint_surface.repaint();
                return;
            }
        }
        getXp().add(e.getX());
        getYp().add(e.getY());
        paint_surface.repaint();
    }

    /**
     * @return the poly
     */
    public Polygon getPoly() {
        return poly;
    }

    /**
     * @param poly the poly to set
     */
    public void setPoly(Polygon poly) {
        this.poly = poly;
    }

    /**
     * @return the fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * @param fillColor the fillColor to set
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * @return the boundaryColor
     */
    public Color getBoundaryColor() {
        return boundaryColor;
    }

    /**
     * @param boundaryColor the boundaryColor to set
     */
    public void setBoundaryColor(Color boundaryColor) {
        this.boundaryColor = boundaryColor;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the lineWidth
     */
    public float getLineWidth() {
        return lineWidth;
    }

    /**
     * @param lineWidth the lineWidth to set
     */
    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * @return the dashPattern
     */
    public float[] getDashPattern() {
        return dashPattern;
    }

    /**
     * @param dashPattern the dashPattern to set
     */
    public void setDashPattern(float[] dashPattern) {
        this.dashPattern = dashPattern;
    }

    /**
     * @return the textX
     */
    public float getTextX() {
        return textX;
    }

    /**
     * @param textX the textX to set
     */
    public void setTextX(float textX) {
        this.textX = textX;
    }

    /**
     * @return the textY
     */
    public float getTextY() {
        return textY;
    }

    /**
     * @param textY the textY to set
     */
    public void setTextY(float textY) {
        this.textY = textY;
    }

    /**
     * @return the textXoffset
     */
    public float getTextXoffset() {
        return textXoffset;
    }

    /**
     * @param textXoffset the textXoffset to set
     */
    public void setTextXoffset(float textXoffset) {
        this.textXoffset = textXoffset;
    }

    /**
     * @return the textYoffset
     */
    public float getTextYoffset() {
        return textYoffset;
    }

    /**
     * @param textYoffset the textYoffset to set
     */
    public void setTextYoffset(float textYoffset) {
        this.textYoffset = textYoffset;
    }

    /**
     * @return the group
     */
    public grouping getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(grouping group) {
        this.group = group;
    }

    /**
     * @return the xp
     */
    public ArrayList<Integer> getXp() {
        return xp;
    }

    /**
     * @param xp the xp to set
     */
    public void setXp(ArrayList<Integer> xp) {
        this.xp = xp;
    }

    /**
     * @return the yp
     */
    public ArrayList<Integer> getYp() {
        return yp;
    }

    /**
     * @param yp the yp to set
     */
    public void setYp(ArrayList<Integer> yp) {
        this.yp = yp;
    }
}
