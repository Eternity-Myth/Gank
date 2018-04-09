package com.eternity_myth.gank.view;

import com.eternity_myth.gank.model.GankData;

import java.util.List;

public interface TypeFragmentView {

    String getCategory();

    int getCurPage();

    void addOnePage();

    void makeUpDatas(List<GankData> datas);

    void notifyAdapter();

    void resetDatas();
}
