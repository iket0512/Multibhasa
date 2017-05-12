package com.example.iket.multibhasa.assignment.presenter;

import com.example.iket.multibhasa.assignment.model.ProviderInterface;
import com.example.iket.multibhasa.assignment.model.data.ListData;
import com.example.iket.multibhasa.assignment.view.Callback;
import com.example.iket.multibhasa.assignment.view.ViewInterface;

/**
 * Created by iket on 9/5/17.
 */

public class PresenterInterfaceImpl implements PresenterInterface {
    private ProviderInterface providerInterface;
    private ViewInterface viewInterface;

    public PresenterInterfaceImpl(ViewInterface viewInterface,ProviderInterface providerInterface) {
        this.providerInterface=providerInterface;
        this.viewInterface=viewInterface;
    }

    @Override
    public void requestData() {
        viewInterface.showProgressBar(true);

        providerInterface.requestData(new Callback() {
            @Override
            public void onSuccess(ListData listData) {
                viewInterface.showProgressBar(false);
                viewInterface.setData(listData.getData());
            }
            @Override
            public void onFailure() {
                viewInterface.showProgressBar(false);
                viewInterface.showMessage("No Internet Connection");
            }
        });
    }
}
