package com.example.androidinterviewproject.base;


import com.example.androidinterviewproject.mvp.view.BaseView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BasePresenterTest {
    @Mock
    BaseView view;

    private BasePresenter testObject;

    @Before
    public void setUp() {
        testObject = new BasePresenter();
    }

    @Test
    public void getView() {
        testObject.setMView(view);
        assertNotNull(testObject.getView());
    }
}
