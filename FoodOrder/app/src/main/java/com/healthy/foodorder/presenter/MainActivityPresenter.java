package com.healthy.foodorder.presenter;

import android.content.Context;
import android.util.Log;

import com.healthy.foodorder.interactor.InteractorInterface;
import com.healthy.foodorder.interactor.MainActivityInteractor;
import com.healthy.foodorder.interfaces.MainActivityInterface;
import com.healthy.foodorder.model.Food;
import com.healthy.foodorder.view.MainActivity;

import java.util.ArrayList;

/**
 * Created by bridgeit on 6/3/17.
 */

public class MainActivityPresenter implements PresenterInterface{
    private  String TAG="MainActivityPresenter";
    private MainActivityInteractor mInteractorInterface;
    private MainActivityInterface mMainActivityInterface;
    private  Context context;

    public MainActivityPresenter(MainActivityInterface mainActivityInterface) {

        mMainActivityInterface=mainActivityInterface;
    }

    public   void getFoodURL(String url ){
        Log.i(TAG, "getFoodURL: get");
        mInteractorInterface=new MainActivityInteractor(this);
        mInteractorInterface.getBackData(url);
       // mMainActivityInteractor.getAllData(url, this);
    }

    @Override
    public void getBackData(ArrayList<Food> arrayList) {
        Log.i(TAG, "getBackData: set");
        mMainActivityInterface.getBackData(arrayList);
        mMainActivityInterface.closeDialog();

    }

    @Override
    public void closeDialog() {
        mMainActivityInterface.closeDialog();

    }
}
