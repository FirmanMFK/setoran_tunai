package firmanmfk.setorantunai.ui.tranksaksi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import firmanmfk.setorantunai.R;
import firmanmfk.setorantunai.ui.tranksaksi.slider.FragmentSlider;
import firmanmfk.setorantunai.ui.tranksaksi.slider.SliderIndicator;
import firmanmfk.setorantunai.ui.tranksaksi.slider.SliderPagerAdapter;
import firmanmfk.setorantunai.ui.tranksaksi.slider.SliderView;

/**
 * Created by Firman on 7/20/2017.
 * github.com/FirmanMFK
 * UwaCoding.github.io
 */

public class HomeFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        return rootView;
    }


    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://upload.wikimedia.org/wikipedia/commons/e/e0/Kantor_Pos.jpg"));
        fragments.add(FragmentSlider.newInstance("https://cdn.tmpo.co/data/2013/01/07/id_160124/160124_620.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.posindonesia.co.id/wp-content/uploads/2016/10/banner-posexpress.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.posindonesia.co.id/wp-content/uploads/2015/12/Paket-Pos-min.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }


}
