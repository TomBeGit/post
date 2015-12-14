package gan.post.module.order;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gan.post.R;
import gan.post.model.bean.OrderInfo;

public class WeightFragment extends Fragment {

    private ListView list_view;
    private List<OrderInfo> orderInfos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight, null);
        list_view = (ListView) view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
        Myadapter myadapter = new Myadapter();
        list_view.setAdapter(myadapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("order",orderInfos.get(position));
                startActivity(intent);
            }
        });
    }

    private void initData() {
        orderInfos = new ArrayList<>();
        OrderInfo info = new OrderInfo();
        info.setFromAddress("重庆");
        info.setToAddress("北京");
        Date dt = new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
        String nowTime = "";
        nowTime = df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
        info.setUpdated(nowTime);
        info.setReward("20$");
        info.setWeight("5KG");
        orderInfos.add(info);
        OrderInfo info1 = new OrderInfo();
        info1.setFromAddress("北京");
        info1.setToAddress("上海");
        info1.setUpdated(nowTime);
        info1.setReward("15$");
        info1.setWeight("15KG");
        orderInfos.add(info1);
    }

    private class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return orderInfos.size();
        }

        @Override
        public Object getItem(int position) {
            return orderInfos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View view;
            ViewHolder holder;
            if (convertView == null) {
                view = View.inflate(getActivity(), R.layout.item_order, null);
                holder = new ViewHolder();
                holder.fromAddress = (TextView) view.findViewById(R.id.tv_from);
                holder.toAddress = (TextView) view.findViewById(R.id.tv_to);
                holder.updated = (TextView) view.findViewById(R.id.tv_updated);
                holder.reward = (TextView) view.findViewById(R.id.tv_reward);
                holder.weight = (TextView) view.findViewById(R.id.tv_weight);
                view.setTag(holder);
            } else {
                view = convertView;
                holder = (ViewHolder) view.getTag();
            }
            OrderInfo info = orderInfos.get(position);
            holder.fromAddress.setText(info.getFromAddress());
            holder.toAddress.setText(info.getToAddress());
            holder.updated.setText(info.getUpdated());
            holder.reward.setText(info.getReward());
            holder.weight.setText(info.getWeight());
            return view;
        }
    }

    static class ViewHolder {
        TextView fromAddress;
        TextView toAddress;
        TextView updated;
        TextView reward;
        TextView weight;
    }
}
