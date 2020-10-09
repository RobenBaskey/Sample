package com.roben.laundrysample.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roben.laundrysample.R;
import com.roben.laundrysample.ZoomOutPageTransformer;
import com.roben.laundrysample.adapter.CategorySliderAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFrag extends Fragment {

    private ViewPager viewPager;
    //private ViewPager2 viewPager;
    private CategorySliderAdapter sliderAdapter;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);

        CategorySlider();
        return view;
    }

    private void CategorySlider() {
        List<Fragment> list = new ArrayList<>();
        list.add(new SteamIron());
        list.add(new DryClean());
        list.add(new HouseHold());

        viewPager = view.findViewById(R.id.category_viewpager);
        sliderAdapter = new CategorySliderAdapter(getFragmentManager(),list);
        //viewPager.setAdapter(sliderAdapter);
        viewPager.setAdapter(sliderAdapter);

//

        viewPager.setPageTransformer(true , (ViewPager.PageTransformer) new ZoomOutPageTransformer());
    }

}
