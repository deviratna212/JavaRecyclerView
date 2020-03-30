package id.ac.uty.javarecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textPrice, textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.image_detail);
        textPrice = findViewById(R.id.price_detail);
        textTitle = findViewById(R.id.title_detail);

        imageView.setImageResource(getIntent().getIntExtra("image", 0));
        textPrice.setText(getIntent().getStringExtra("price"));
        textTitle.setText(getIntent().getStringExtra("title"));

    }
}
