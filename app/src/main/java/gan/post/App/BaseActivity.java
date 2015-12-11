package gan.post.App;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import gan.post.module.home.HomeActivity;

/**
 * Created by gan on 2015/12/9.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        startActivity(new Intent(this, HomeActivity.class));
        super.onCreate(savedInstanceState, persistentState);
    }
}
