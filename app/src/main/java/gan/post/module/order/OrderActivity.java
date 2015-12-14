package gan.post.module.order;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gan.post.R;

public class OrderActivity extends AppCompatActivity {

    private DistanceFragment mDistanceFragment;
    private LatestFragment mLatestFragment;
    private RewardFragment mRewardFragment;
    private WeightFragment mWeightFragment;
    private ViewPager mViewPager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_order, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_order);
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
                startActivity(new Intent(OrderActivity.this, FilterActivity.class));
                return true;
            }
        });
        initFragment();
    }

    private void initFragment() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        List<String> tabList = new ArrayList<>();
        mDistanceFragment = new DistanceFragment();
        mLatestFragment = new LatestFragment();
        mRewardFragment = new RewardFragment();
        mWeightFragment = new WeightFragment();
        tabList.add("Latest");
        tabList.add("Distance");
        tabList.add("Reward");
        tabList.add("Weight");
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(3)));
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(mDistanceFragment);
        fragmentList.add(mLatestFragment);
        fragmentList.add(mRewardFragment);
        fragmentList.add(mWeightFragment);
        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(),
                fragmentList, tabList);
        mViewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
    }


}
