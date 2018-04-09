package com.eternity_myth.gank.network;


import com.eternity_myth.gank.model.GankData;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {
    /**
     * 获取分类资源
     *
     * @param category
     * @param pageSize
     * @param page
     * @return
     */
    @GET("data/{category}/{pagesize}/{page}")
    rx.Observable<ApiResponse<List<GankData>>> getGankCategoryDatas(@Path("category") String
                                                                            category,
                                                                    @Path("pagesize") int
                                                                            pageSize,
                                                                    @Path("page") int page);


}
