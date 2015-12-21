package gan.post.module.settings;

/**
 * Created by Dell on 2015/12/21.
 */
public class SettingsItem {
    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public SettingsItem(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }
}
