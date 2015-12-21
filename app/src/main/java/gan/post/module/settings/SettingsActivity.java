package gan.post.module.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import gan.post.R;


public class SettingsActivity extends AppCompatActivity {

    private List<SettingsItem> settingsItemList = new ArrayList<SettingsItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_settings);
        initSettings();
        SettingsAdapter adapter = new SettingsAdapter(SettingsActivity.this,
                R.layout.item_settings,settingsItemList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void initSettings(){
        SettingsItem Resetpassword = new SettingsItem("Reset password",
                R.drawable.enter);
        settingsItemList.add(Resetpassword);
        SettingsItem Clearcache = new SettingsItem("Clear cache",
                R.drawable.enter);
        settingsItemList.add(Clearcache);
        SettingsItem Aboutzthd = new SettingsItem("About zthd",
                R.drawable.enter);
        settingsItemList.add(Aboutzthd);

    }
}
