package com.example.investify.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.investify.Fragments.CryptoFragment;
import com.example.investify.Fragments.StocksFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment frag = new Fragment();
        if (position == 0) {
            frag = new StocksFragment();
        }
        if (position == 1) {
            frag = new CryptoFragment();
        }
        return frag;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
