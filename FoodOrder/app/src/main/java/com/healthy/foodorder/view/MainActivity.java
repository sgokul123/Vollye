package com.healthy.foodorder.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.healthy.foodorder.adapter.ImageAdapter;
import com.healthy.foodorder.interfaces.MainActivityInterface;
import com.healthy.foodorder.model.Food;
import com.healthy.foodorder.presenter.MainActivityPresenter;
import com.healthy.foodorder.R;
import com.healthy.foodorder.presenter.PresenterInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {
    private String TAG="MainActivity";
    private RecyclerView mRecyclerView;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        MainActivityPresenter mainActivityPresenter=new MainActivityPresenter(this);
        String url="https://choco-lava.herokuapp.com/borrow/getfood";
        showProgress();
        Log.i(TAG, "onCreate: ");

        mainActivityPresenter.getFoodURL(url);
    }

    @Override
    public void getBackData(ArrayList<Food> arrayList) {

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ImageAdapter imageAdapter=new ImageAdapter(arrayList,getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(imageAdapter);
        mProgressDialog.dismiss();

    }

    @Override
    public void closeDialog() {
        mProgressDialog.dismiss();
    }

    public  void  showProgress(){
        mProgressDialog =new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Please Wait while loading data...");
        mProgressDialog.show();
    }
}
