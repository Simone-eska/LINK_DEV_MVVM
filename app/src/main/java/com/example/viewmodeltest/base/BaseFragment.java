package com.example.viewmodeltest.base;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.viewmodeltest.customViews.LoadingDialog;

public abstract class BaseFragment<T extends BaseModel> extends Fragment
implements Observer<T>{

    BaseViewModel baseViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        baseViewModel=getViewModel();
        if(baseViewModel!=null){
            registerObservables();
            if(showLoadingOnCreate()&&baseViewModel.liveData.getValue()==null){
                showLoadingDialog();
                baseViewModel.onCreate();
            }
        }
    }



    protected void showLoadingDialog(){
        ((BaseActivity)(getActivity())) .showLoadingDialog();
    }
    protected void hideLoadingDialog(){
        ((BaseActivity)(getActivity())) .hideLoadingDialog();
    }

    protected void registerObservables(){
        getViewModel().liveData.observe(this,this);
        getViewModel().errorMsg.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String o) {
                ((BaseActivity)(getActivity())).onError(o);
            }
        });
    }

    protected abstract BaseViewModel<T> getViewModel();
    protected abstract boolean showLoadingOnCreate();

}
