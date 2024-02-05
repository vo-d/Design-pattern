/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */

public abstract class CameraApp{
    protected ShareStrategy shareMethod;
    public CameraApp(){
        this.shareMethod = new EmailSharing();
    }

    public abstract void edit();

    public void take(){
        System.out.println("Take a photo");
    }

    public void save(){
        System.out.println("Save a photo");
    }

    public void setShareStrategy(ShareStrategy method){
        this.shareMethod = method;
    }

    public void share(){
        this.shareMethod.shareLog();
    }
}

