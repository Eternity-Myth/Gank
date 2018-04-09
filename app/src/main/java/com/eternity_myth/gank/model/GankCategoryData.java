package com.eternity_myth.gank.model;

import com.eternity_myth.gank.model.GankData;

import java.util.List;

public class GankCategoryData {

    private List<GankData> Android;
    private List<GankData> iOS;
    private List<GankData> 福利;

    public List<GankData> getAndroid() {
        return Android;
    }

    public void setAndroid(List<GankData> Android) {
        this.Android = Android;
    }

    public List<GankData> getIOS() {
        return iOS;
    }

    public void setIOS(List<GankData> iOS) {
        this.iOS = iOS;
    }

    public List<GankData> get福利() {
        return 福利;
    }

    public void set福利(List<GankData> 福利) {
        this.福利 = 福利;
    }
}
