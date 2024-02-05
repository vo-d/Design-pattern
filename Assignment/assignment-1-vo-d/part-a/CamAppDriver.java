/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class CamAppDriver{
    public static void main(String[] args){
        PremiumCameraApp app = new PremiumCameraApp();
        app.take();
        app.save();
        app.edit();
        app.share();
        app.setShareStrategy(new SocialMediaSharing());
        app.share();
    }
}