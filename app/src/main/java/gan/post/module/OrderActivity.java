package gan.post.module;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import gan.post.R;
import utils.ClearEditText;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ClearEditText mTextView= (ClearEditText) findViewById(R.id.edit_text);
        Button mButton= (Button) findViewById(R.id.next);
        ImageView mImageView= (ImageView) findViewById(R.id.imageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderActivity.this,CommentActivity.class);
                startActivity(intent);
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderActivity.this,NextOrderActivity.class);
                startActivity(intent);
            }
        });
    }

}
