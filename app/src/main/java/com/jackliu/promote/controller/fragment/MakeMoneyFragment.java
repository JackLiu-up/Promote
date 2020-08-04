package com.jackliu.promote.controller.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.jackliu.promote.R;

public class MakeMoneyFragment extends Fragment {

    private MakeMoneyViewModel mViewModel;

    public static MakeMoneyFragment newInstance() {
        return new MakeMoneyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.make_money_fragment, container, false);

        FragmentStateAdapter fragmentStateAdapter = new FragmentStateAdapter() {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return null;
            }

            @Override
            public int getItemCount() {
                return 4;
            }
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MakeMoneyViewModel.class);
        // TODO: Use the ViewModel
    }

}
