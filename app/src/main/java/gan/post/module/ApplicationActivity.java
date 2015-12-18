package gan.post.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


import gan.post.R;

public class ApplicationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button submit;
    private RelativeLayout certificateLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        initView();
    }

    private void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
        certificateLayout = (RelativeLayout) findViewById(R.id.certificate_layout);
        certificateLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                Intent sIntent = new Intent(ApplicationActivity.this,SubmittedActivity.class);
                startActivity(sIntent);
                break;
            case R.id.certificate_layout:
                Intent cIntent = new Intent(ApplicationActivity.this,CertificateActivity.class);
                startActivity(cIntent);
                break;
        }
    }
}
