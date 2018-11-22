package android.dominando.demont_dev_02;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Carlos Carvalho on 27/09/2016.
 */
public class PageAdapterDestaque extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    public ItensDestaque tab1;

    public PageAdapterDestaque(FragmentManager fm, int numOfTabs){
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                tab1 = new ItensDestaque();
                MainActivity.mListFragment = tab1;
                return tab1;
            case 1:
                DepositosDetaque tab2 = new DepositosDetaque();
                return tab2;
            case 2:
                ListasDestaque tab3 = new ListasDestaque();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
