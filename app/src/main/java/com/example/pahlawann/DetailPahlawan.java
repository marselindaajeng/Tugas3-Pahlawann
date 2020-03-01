package com.example.pahlawann;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailPahlawan extends AppCompatActivity {

    ImageView ivDetail;
    TextView tvDetail,tvNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pahlawan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivDetail = findViewById(R.id.iv_detail);
        tvDetail = findViewById(R.id.team_deskripsi);
        tvNama = findViewById(R.id.team_heroName);

        getIncomingIntent();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getIncomingIntent(){
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            int ivThumb = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(ivThumb).into(ivDetail);
            String getDesc = bundle.getString("detail");
            String getTitle= bundle.getString("title");

            tvDetail.setText(getDesc);
            tvNama.setText(getTitle);
        }
    }



}

