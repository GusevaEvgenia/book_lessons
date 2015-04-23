package com.android_lessons.belkin.crime;

import android.support.v4.app.Fragment;

/**
 * Created by Belkin on 02.04.2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }
}
