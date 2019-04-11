package com.example.viewmodeltest.base;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.viewmodeltest.customViews.LoadingDialog;

public abstract class BaseActivity extends AppCompatActivity{

    private static LoadingDialog loadingDialog =new LoadingDialog();

    void showToast(int stringResource){
        Toast.makeText(this,stringResource,Toast.LENGTH_SHORT).show();
    }

    public void showLoadingDialog(){
        if(loadingDialog !=null&& loadingDialog.isShown())
            return;
        loadingDialog = new LoadingDialog();
       loadingDialog.show(getSupportFragmentManager(),"tag");
    }
    public void hideLoadingDialog(){
        if(loadingDialog !=null && loadingDialog.isShown())
            loadingDialog.dismiss();
    }

    public void onError(String msg){
        hideLoadingDialog();
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}
