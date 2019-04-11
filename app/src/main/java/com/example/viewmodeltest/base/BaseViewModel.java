package com.example.viewmodeltest.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseViewModel <T extends BaseModel> extends AndroidViewModel {

    public static final String API_KEY="533af958594143758318137469b41ba9";
    public static final String SOURCE="the-next-web";

    public MutableLiveData<T> liveData= new MutableLiveData<>();
    public MutableLiveData<String> errorMsg= new MutableLiveData<>();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }


    public void onCreate(){
        callFirstApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(T o) {
                        liveData.postValue(o);
                    }
                    @Override
                    public void onError(Throwable e) {
                        errorMsg.setValue(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });

    }

    protected abstract Observable<T> callFirstApi();

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }

}
