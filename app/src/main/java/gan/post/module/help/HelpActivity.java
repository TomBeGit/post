package gan.post.module.help;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import gan.post.R;


public class HelpActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ListView mlistview;
    private List<Item> itemList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_help);
        initItem();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.back);

        ItemAdapter adapter = new ItemAdapter(HelpActivity.this,
                R.layout.list_item,itemList);
        mlistview = (ListView) findViewById(R.id.list_view);
        mlistview.setAdapter(adapter);

    }
    private void initItem(){
        Item FAQ = new Item("FAQ",R.drawable.enter);
        itemList.add(FAQ);
        Item PaymentAgreement = new Item("Payment Agreement",R.drawable.enter);
        itemList.add(PaymentAgreement);
        Item UserAgreement = new Item("User Agreement",R.drawable.enter);
        itemList.add(UserAgreement);
        Item RegistrationAgreemen = new Item("Registration Agreement",
                R.drawable.enter);
        itemList.add(RegistrationAgreemen);
        Item Aboutcoupon = new Item("About coupon",R.drawable.enter);
        itemList.add(Aboutcoupon);
    }

            public void onClick(View v){

            }

}
