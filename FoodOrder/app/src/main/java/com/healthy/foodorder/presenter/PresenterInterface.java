package com.healthy.foodorder.presenter;

import com.healthy.foodorder.model.Food;

import java.util.ArrayList;

/**
 * Created by bridgeit on 8/3/17.
 */

public interface PresenterInterface {
    public  void getBackData(ArrayList<Food> arrayList);
    public void closeDialog();
}
