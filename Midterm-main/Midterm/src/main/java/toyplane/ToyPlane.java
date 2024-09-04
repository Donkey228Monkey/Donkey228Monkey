/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toyplane;

/**
 *
 * @author redyr
 */
public abstract class ToyPlane{

    protected boolean isWound;
    private String model;

    public ToyPlane(String model) {
        this.model = model;
        isWound = false;
    }

    public String getModel() {
        return model;
    }

    public void wind() {
        isWound= true;
    }

    public boolean isWoundUp() {
        return isWound;
    }

    abstract String fly();
}
