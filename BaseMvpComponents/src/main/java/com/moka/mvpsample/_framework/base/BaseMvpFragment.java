package com.moka.mvpsample._framework.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


public abstract class BaseMvpFragment<VIEW extends BaseView> extends BaseFragment implements BaseView {

	private BasePresenter<VIEW> presenter;
	private View rootView;

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		presenter = getPresenter();
		if ( null != presenter ) {
			presenter.attachView((VIEW) this);
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if ( null != presenter )
			presenter.detachView();
	}

	protected abstract BasePresenter<VIEW> getPresenter();

	public void setRootView(View rootView) {
		this.rootView = rootView;
	}

	public View findViewById(int resId) {
		if ( null != rootView )
			return rootView.findViewById(resId);
		else
			return null;
	}

}
