package gan.post.module.help;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gan.post.R;


public class ItemAdapter extends ArrayAdapter<Item> {
    private int resourceId;
    public ItemAdapter(Context context,int resource,List<Item>Objects){
        super(context,resource,Objects);
        resourceId = resource;
    }
    public View getView(int position,View convertView,ViewGroup parent){

        Item item = getItem(position);
        View view =
                LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_item);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item);
        textView.setText(item.getText());
        imageView.setImageResource(item.getImageId());
        return view;
    }
}
