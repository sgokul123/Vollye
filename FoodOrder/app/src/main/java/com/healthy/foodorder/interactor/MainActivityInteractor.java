package com.healthy.foodorder.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.healthy.foodorder.app.AppController;
import com.healthy.foodorder.interfaces.MainActivityInterface;
import com.healthy.foodorder.model.Food;
import com.healthy.foodorder.presenter.PresenterInterface;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgeit on 6/3/17.
 */

public class MainActivityInteractor implements  InteractorInterface {
    private  String TAG="MainActivityInteractor";
    private  ArrayList<Food> foods;
    private String url;
    private  PresenterInterface mPresenterInterface;
    public MainActivityInteractor(PresenterInterface presenterInterface) {
        this.mPresenterInterface=presenterInterface;

    }
    @Override
    public void getBackData(String url) {
        Log.i(TAG, "getAllData: get ");

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i(TAG, "onResponse:data ");
                foods=new ArrayList<>();

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Type listType = new TypeToken<List<Food>>() {}.getType();
                foods = gson.fromJson(response.toString(), listType);
                Log.i(TAG, "onResponse: sdata set");
                mPresenterInterface.getBackData(foods);
                mPresenterInterface.closeDialog();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mPresenterInterface.closeDialog();

                Log.i(TAG, "onErrorResponse: ");
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }

}
