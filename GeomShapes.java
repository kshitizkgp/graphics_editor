
package graphicseditor;


public abstract class GeomShapes implements java.awt.Shape{
    private boolean isSelected;

    /**
     * @return the isSelected
     */
    public boolean isIsSelected() {
        return isSelected;
    }

    /**
     * @param isSelected the isSelected to set
     */
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }


}
