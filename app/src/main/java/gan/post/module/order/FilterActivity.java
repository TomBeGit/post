package gan.post.module.order;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Filter;

import gan.post.R;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbtTenHours;
    private Button mbtTwenHours;
    private Button mbtTowDays;
    private Button mbtFiveDays;
    private Button mbtOK;
    private Button mbtCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Filter");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_arrow_nav);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mbtTenHours = (Button) findViewById(R.id.bt_10_h);
        mbtTwenHours = (Button) findViewById(R.id.bt_24_h);
        mbtTowDays = (Button) findViewById(R.id.bt_2_d);
        mbtFiveDays = (Button) findViewById(R.id.bt_5_d);
        mbtOK = (Button) findViewById(R.id.bt_ok);
        mbtCancel = (Button) findViewById(R.id.bt_cancel);
        mbtFiveDays.setOnClickListener(this);
        mbtTwenHours.setOnClickListener(this);
        mbtTowDays.setOnClickListener(this);
        mbtTenHours.setOnClickListener(this);
        mbtOK.setOnClickListener(this);
        mbtCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_10_h:
                setStyle(mbtTenHours);
                break;
            case R.id.bt_24_h:
                setStyle(mbtTwenHours);
                break;
            case R.id.bt_2_d:
                setStyle(mbtTowDays);
                break;
            case R.id.bt_5_d:
                setStyle(mbtFiveDays);
                break;
            case R.id.bt_ok:
                finish();
                break;
            case R.id.bt_cancel:
                finish();
                break;
        }
    }

    private void setStyle(Button button) {
        mbtTenHours.setBackgroundResource(R.drawable.button_gray_style);
        mbtTwenHours.setBackgroundResource(R.drawable.button_gray_style);
        mbtTowDays.setBackgroundResource(R.drawable.button_gray_style);
        mbtFiveDays.setBackgroundResource(R.drawable.button_gray_style);
        button.setBackgroundResource(R.drawable.button_green_style);
    }
}
