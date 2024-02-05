/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */

public class PremiumCameraApp extends CameraApp{
    public PremiumCameraApp(){
        super.shareMethod = new TextSharing();
    }

    public void edit(){
        System.out.println("Advanced photo editing");
    }
    public void share(){
        this.shareMethod.shareLog();
    }
}
