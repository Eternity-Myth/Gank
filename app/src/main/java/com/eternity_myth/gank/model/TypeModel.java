package com.eternity_myth.gank.model;

import com.eternity_myth.gank.network.ApiResponse;
import com.eternity_myth.gank.network.NetworkApiClient;
import rx.Observable;


import java.util.List;

public class TypeModel {
    public Observable<ApiResponse<List<GankData>>> getTypeGankList(String category, int
            pageSize, int page) {
        return NetworkApiClient.getApiService().getGankCategoryDatas(category, pageSize, page);

    }
}
