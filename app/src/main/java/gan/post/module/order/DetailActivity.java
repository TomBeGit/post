package gan.post.module.order;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import gan.post.R;
import gan.post.model.bean.OrderInfo;

public class DetailActivity extends AppCompatActivity {
    private Button mBtMarkUp;
    private Button mBtCollect;
    private TextView mTvName;
    private TextView mTvReward;
    private TextView mTvWeight;
    private TextView mTvTime;
    private TextView mTvDeadline;
    private TextView mTvFrom;
    private TextView mTvTo;
    private TextView mTvValue;
    private TextView mTvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mBtMarkUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(DetailActivity.this)
                        .create();
                alertDialog.show();
                Window window = alertDialog.getWindow();
                window.setContentView(R.layout.dialog_detail);
                Button mBtOk = (Button) window.findViewById(R.id.bt_ok);
                Button mBtCancel = (Button) window.findViewById(R.id.bt_cancel);
                mBtOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        finish();
                        startActivity(new Intent(DetailActivity.this, ResultActivity.class));
                    }
                });
                mBtCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            }
        });
        mBtCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Detail");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_arrow_nav);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtCollect = (Button) findViewById(R.id.bt_collect);
        mBtMarkUp = (Button) findViewById(R.id.bt_markup);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mTvReward = (TextView) findViewById(R.id.tv_reward);
        mTvWeight = (TextView) findViewById(R.id.tv_weight);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvDeadline = (TextView) findViewById(R.id.tv_deadline);
        mTvFrom = (TextView) findViewById(R.id.tv_from);
        mTvTo = (TextView) findViewById(R.id.tv_to);
        mTvValue = (TextView) findViewById(R.id.tv_value);
        mTvDesc = (TextView) findViewById(R.id.tv_desc);
        //得到点击的info对象
        OrderInfo info = (OrderInfo) getIntent().getSerializableExtra("order");
        Log.d("Log",info.toString());

    }
}
