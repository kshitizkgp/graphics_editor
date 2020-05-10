
package graphicseditor;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.*;
import java.io.Serializable;


public class Ellipse implements Serializable{

    private Ellipse2D.Float ell;
    private Color fillColor = new Color(255, 255, 255);
    private Color boundaryColor = new Color(0,0,0);
    private boolean selected = false;
    private float lineWidth = 1.0f;
    private float[]  dashPattern = {5.0f,5.0f};
    private float textX;
    private float textY;
    private float textXoffset;
    private float textYoffset;
    private grouping group = null;

    public Ellipse(){

    }

    public Ellipse(Ellipse2D.Float e){
        this.ell = e;
    }

    public Ellipse(Ellipse e){
        this.ell = new Ellipse2D.Float(e.getEll().x, e.getEll().y, e.getEll().width, e.getEll().height);
        this.fillColor = e.fillColor;
        this.boundaryColor = e.boundaryColor;
        this.lineWidth = e.lineWidth;
        this.dashPattern = e.dashPattern;
    }

    public void updatePos(float newX, float newY, float oldX, float oldY){
        this.ell.x += newX - oldX;
        this.ell.y += newY - oldY;
    }

    public void PanPos(float x, float y){
        this.ell.x += x;
        this.ell.y += y;
    }

    public void scale(float x){
        this.ell.x *= x;
        this.ell.y *= x;
        this.ell.width *= x;
        this.ell.height *= x;
    }

    /**
     * @return the ell
     */
    public Ellipse2D.Float getEll() {
        return ell;
    }

    /**
     * @param ell the ell to set
     */
    public void setEll(Ellipse2D.Float ell) {
        this.ell = ell;
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
     * @return the isSelected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param isSelected the isSelected to set
     */
    public void setSelected(boolean isSelected) {
        this.selected = isSelected;
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
}
