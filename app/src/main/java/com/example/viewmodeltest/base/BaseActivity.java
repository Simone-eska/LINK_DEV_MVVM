package com.example.viewmodeltest.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.customViews.LoadingDialog;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            performHomeClickAction();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

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
    abstract protected void performHomeClickAction();

}
