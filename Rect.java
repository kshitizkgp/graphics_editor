
package graphicseditor;



import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Rect implements Serializable{
    private Rectangle2D.Float rectangle;
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

    public Rect(){

    }

    public Rect(Rectangle2D.Float r){
        this.rectangle = r;
    }

    public Rect(Rect r){
       this.rectangle = new Rectangle2D.Float (r.getRectangle().x,r.getRectangle().y,r.getRectangle().width,r.getRectangle().height);
       this.fillColor = r.fillColor;
       this.boundaryColor = r.boundaryColor;
       this.lineWidth = r.lineWidth;
       this.dashPattern = r.dashPattern;
    }

    public void updatePos(float newX, float newY, float oldX, float oldY){
        this.rectangle.x += newX - oldX;
        this.rectangle.y += newY - oldY;
    }

    public void PanPos(float x, float y){
        this.rectangle.x += x;
        this.rectangle.y += y;
    }

    public void scale(float x){
        this.rectangle.x *= x;
        this.rectangle.y *= x;
        this.rectangle.width *= x;
        this.rectangle.height *= x;
    }
    /**
     * @return the rectangle
     */
    public Rectangle2D.Float getRectangle() {
        return rectangle;
    }

    /**
     * @param rectangle the rectangle to set
     */
    public void setRectangle(Rectangle2D.Float rectangle) {
        this.rectangle = rectangle;
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
     * @return the Selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param Selected the Selected to set
     */
    public void setSelected(boolean Selected) {
        this.selected = Selected;
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


}
