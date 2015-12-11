package gan.post.module.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gan.post.R;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    private DistanceFragment mDistanceFragment;
    private LatestFragment mLatestFragment;
    private RewardFragment mRewardFragment;
    private WeightFragment mWeightFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction mTransaction;
    private Button distance;
    private Button latest;
    private Button reward;
    private Button weight;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_order,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_order);
        distance = (Button) findViewById(R.id.bt_distance);
        latest = (Button) findViewById(R.id.bt_latest);
        reward = (Button) findViewById(R.id.bt_reward);
        weight = (Button) findViewById(R.id.bt_weight);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Order");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_arrow_nav);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(OrderActivity.this,FilterActivity.class));
                return true;
            }
        });
        mDistanceFragment = new DistanceFragment();
        mLatestFragment = new LatestFragment();
        mRewardFragment = new RewardFragment();
        mWeightFragment = new WeightFragment();
        fragmentManager = getSupportFragmentManager();
        //开启
        mTransaction = fragmentManager.beginTransaction();
        mTransaction.replace(R.id.fl_content, mWeightFragment).commit();

        distance.setOnClickListener(this);
        latest.setOnClickListener(this);
        reward.setOnClickListener(this);
        weight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.bt_distance:
                Toast.makeText(OrderActivity.this, "1", Toast.LENGTH_SHORT).show();
                ft.replace(R.id.fl_content, mDistanceFragment);
                break;
            case R.id.bt_latest:
                Toast.makeText(OrderActivity.this, "2", Toast.LENGTH_SHORT).show();
                ft.replace(R.id.fl_content, mLatestFragment);
                break;
            case R.id.bt_reward:
                Toast.makeText(OrderActivity.this, "3", Toast.LENGTH_SHORT).show();
                ft.replace(R.id.fl_content, mRewardFragment);
                break;
            case R.id.bt_weight:
                Toast.makeText(OrderActivity.this, "4", Toast.LENGTH_SHORT).show();
                ft.replace(R.id.fl_content, mWeightFragment);
                break;
        }
        ft.commit();
    }
}
