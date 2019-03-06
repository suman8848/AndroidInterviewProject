package com.example.androidinterviewproject;


import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.InstrumentationInfo;
import android.content.res.AssetManager;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import butterknife.internal.Utils;
import com.example.androidinterviewproject.mvp.model.Coupon;
import com.example.androidinterviewproject.mvp.model.ListOfCoupons;
import com.example.androidinterviewproject.mvp.presenters.ViewPagerFragmentPresenter;
import com.example.androidinterviewproject.mvp.view.ViewPagerFragmentView;
import io.reactivex.Observable;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ViewPagerFragmentPresenterTest {
    @Mock
    private Context context;
    @Mock
    private ViewPagerFragmentView viewPagerFragmentView;
    @Mock
    AssetManager assetManager;

    private ViewPagerFragmentPresenter viewPagerFragmentPresenter;
    InputStream inputStream;

    @Before
    public void setup() throws Exception {

        doReturn(assetManager).when(context).getAssets();
        URL resource = ViewPagerFragmentPresenterTest.class.getClassLoader().getResource("coupon.json");
        inputStream = new FileInputStream(resource.getPath());
        doReturn(inputStream).when(assetManager).open(anyString());
        viewPagerFragmentPresenter = new ViewPagerFragmentPresenter(context);
        viewPagerFragmentPresenter.setView(viewPagerFragmentView);
    }

    @Test
    public void test_loadJSONFromAsset_WhenTabOpen(){
        viewPagerFragmentPresenter.loadJSONFromAsset();
        verify(viewPagerFragmentView).onLoadDataSuccess(anyList());
    }


}
