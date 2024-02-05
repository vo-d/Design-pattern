/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */

public class BasicCameraApp extends CameraApp{
    public void setShareStrategy(ShareStrategy method){
        if(method instanceof SocialMediaSharing){
            System.out.println("This is the feature for only premium user");
        }
        else{
            super.shareMethod = method;
        }
    }
    public void edit(){
        System.out.println("Basic photo editing");
    }
}
