package com.eternity_myth.gank.presenter;


import com.eternity_myth.gank.GankConfig;
import com.eternity_myth.gank.model.GankData;
import com.eternity_myth.gank.model.TypeModel;
import com.eternity_myth.gank.network.ApiCallback;
import com.eternity_myth.gank.network.ApiResponse;
import com.eternity_myth.gank.network.SubscriberCallback;
import com.eternity_myth.gank.presenter.BasePresenter;
import com.eternity_myth.gank.view.TypeFragmentView;

import java.util.List;

public class TypePresenter extends BasePresenter<TypeFragmentView> {
    private TypeModel mTypeModelnew = new TypeModel();

    public void getTypeGankList() {
        addSubscription(mTypeModelnew.getTypeGankList(mView.getCategory(), GankConfig.PAGE_SIZE,
                mView.getCurPage()), new SubscriberCallback(new ApiCallback<ApiResponse<List<GankData>>>() {
            @Override
            public void onSuccess(ApiResponse<List<GankData>> model) {
                if (!model.isError() && model.getResults().size() > 0) {
                    mView.makeUpDatas(model.getResults());
                    mView.addOnePage();
                }
                mView.notifyAdapter();
            }

            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onCompleted() {
            }
        }

        ));
    }
}

