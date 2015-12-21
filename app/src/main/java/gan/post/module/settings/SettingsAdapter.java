package gan.post.module.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gan.post.R;

/**
 * Created by Dell on 2015/12/21.
 */
public class SettingsAdapter extends ArrayAdapter<SettingsItem> {
    private int resourceID;
    public SettingsAdapter(Context context,int textViewResourceId,
                           List<SettingsItem> objects){
        super(context,textViewResourceId,objects);
        resourceID = textViewResourceId;
    }
public View getView(int position,View contentView,ViewGroup parent){
    SettingsItem item = getItem(position);
    View view = LayoutInflater.from(getContext()).inflate(resourceID, null);
    ImageView settingsImage = (ImageView) view.findViewById(R.id.settings_image);
    TextView settingsName = (TextView) view.findViewById(R.id.settings_name);
    settingsImage.setImageResource(item.getImageId());
    settingsName.setText(item.getName());
    return view;
}
}
