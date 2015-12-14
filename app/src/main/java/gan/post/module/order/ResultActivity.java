package gan.post.module.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gan.post.R;

public class ResultActivity extends AppCompatActivity {
    private Button mBtCallHim;
    private Button mBtViewOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mBtCallHim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ResultActivity.this,"call him",Toast.LENGTH_SHORT).show();
            }
        });
        mBtViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        setContentView(R.layout.activity_result);
        mBtCallHim = (Button) findViewById(R.id.bt_call_him);
        mBtViewOrder = (Button) findViewById(R.id.bt_view_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Result");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_arrow_nav);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
