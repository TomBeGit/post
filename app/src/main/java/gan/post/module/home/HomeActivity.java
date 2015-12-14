package gan.post.module.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gan.post.R;
import gan.post.model.bean.AdInfo;
import gan.post.module.order.OrderActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private TextView tv_intro;
    private LinearLayout dot_layout;
    private ArrayList<AdInfo> list = new ArrayList<AdInfo>();
    private LinearLayout mllSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                updateIntroAndDot();
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void order(View view) {
        Toast.makeText(HomeActivity.this, "order", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(HomeActivity.this, OrderActivity.class));
    }

    private void initData() {
        list.add(new AdInfo(R.drawable.a, "第一个广告"));
        list.add(new AdInfo(R.drawable.a, "第二个广告"));
        list.add(new AdInfo(R.drawable.a, "第三个广告"));
        list.add(new AdInfo(R.drawable.a, "第四个广告"));
        list.add(new AdInfo(R.drawable.a, "第五个广告"));

        initDots();

        viewPager.setAdapter(new MyPagerAdapter());

        updateIntroAndDot();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        TextView mTbTitle = (TextView) findViewById(R.id.toolbar_title);
//        mTbTitle.setText("Home");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tv_intro = (TextView) findViewById(R.id.tv_intro);
        dot_layout = (LinearLayout) findViewById(R.id.dot_layout);
        mllSend = (LinearLayout) findViewById(R.id.ll_send);
        mllSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this,"Send",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_wallet) {
            Toast.makeText(this, "nav_wallet", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.nav_billing) {
            Toast.makeText(this, "nav_billing", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.nav_receiving) {
            Toast.makeText(this, "nav_receiving", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.nav_deliver_app) {
            Toast.makeText(this, "nav_deliver_app", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.nav_op_ins) {
            Toast.makeText(this, "nav_op_ins", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.nav_set) {
            Toast.makeText(this, "nav_set", Toast.LENGTH_SHORT).show();
            return true;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 初始化dot
     */
    private void initDots() {
        for (int i = 0; i < list.size(); i++) {
            View view = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8, 8);
            if (i != 0) {
                params.leftMargin = 5;
            }
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_dot);
            dot_layout.addView(view);
        }
    }

    /**
     * 更新文本
     */
    private void updateIntroAndDot() {
        int currentPage = viewPager.getCurrentItem() % list.size();
        tv_intro.setText(list.get(currentPage).getIntro());

        for (int i = 0; i < dot_layout.getChildCount(); i++) {
            dot_layout.getChildAt(i).setEnabled(i == currentPage);
        }
    }

    class MyPagerAdapter extends PagerAdapter {

        /**
         * 返回多少page
         */
        @Override
        public int getCount() {
            return 100;
        }

        /**
         * true: 表示不去创建，使用缓存  false:去重新创建
         * view： 当前滑动的view
         * object：将要进入的新创建的view，由instantiateItem方法创建
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 类似于BaseAdapger的getView方法
         * 用了将数据设置给view
         * 由于它最多就3个界面，不需要viewHolder
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(HomeActivity.this, R.layout.adapter_viewpager, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);

            AdInfo adInfo = list.get(position % list.size());
            imageView.setImageResource(adInfo.getIconResId());

            container.addView(view);//一定不能少，将view加入到viewPager中

            return view;
        }

        /**
         * 销毁page
         * position： 当前需要消耗第几个page
         * object:当前需要消耗的page
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//			super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
