package com.example.fragmentdemo;

import java.util.List;

public interface OnFragmentManager {
    void onItemSelected(List<Food> list);
    void onPriceToTal(String price);
}
