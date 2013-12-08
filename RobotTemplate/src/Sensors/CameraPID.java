/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sensors;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 *
 * @author Aubrey
 */
public class CameraPID implements PIDSource {
    
    AxisCamera camera;
    
    public CameraPID() {
        camera = AxisCamera.getInstance();
    }
    
    public double pidGet() {
        return getHSet();
    }
    
    public double getHSet() {
        return 0;
    }
    
}
