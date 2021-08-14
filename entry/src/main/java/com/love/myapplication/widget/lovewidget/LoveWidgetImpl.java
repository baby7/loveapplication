package com.love.myapplication.widget.lovewidget;

import com.love.myapplication.entity.Info;
import com.love.myapplication.util.InfoUtil;
import com.love.myapplication.widget.controller.FormController;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.FormBindingData;
import ohos.aafwk.ability.ProviderFormInfo;
import ohos.aafwk.content.Intent;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.utils.zson.ZSONObject;


public class LoveWidgetImpl extends FormController {
    private static final HiLogLabel TAG = new HiLogLabel(HiLog.DEBUG, 0x0, LoveWidgetImpl.class.getName());
    private static final int DIMENSION_2X2 = 2;
    private static final int DIMENSION_4X4 = 4;

    public LoveWidgetImpl(Context context, String formName, Integer dimension) {
        super(context, formName, dimension);
    }

    @Override
    public ProviderFormInfo bindFormData() {
        HiLog.info(TAG, "bind form data");
        Info info = InfoUtil.getInfo();
        HiLog.info(TAG, ZSONObject.toZSONString(info));
        ZSONObject zsonObject = new ZSONObject();
        ProviderFormInfo providerFormInfo = new ProviderFormInfo();
        if (dimension == DIMENSION_2X2) {
            zsonObject.put("mini", true);
            zsonObject.put("big", false);
        }
        if (dimension == DIMENSION_4X4) {
            zsonObject.put("mini", false);
            zsonObject.put("big", true);
        }
        zsonObject.put("info", info);
        providerFormInfo.setJsBindingData(new FormBindingData(zsonObject));
        return providerFormInfo;
    }

    @Override
    public void updateFormData(long formId, Object... vars) {
        HiLog.info(TAG, "update form data timing, default 30 minutes");
    }

    @Override
    public void onTriggerFormEvent(long formId, String message) {
        HiLog.info(TAG, "handle card click event.");
    }

    @Override
    public Class<? extends AbilitySlice> getRoutePageSlice(Intent intent) {
        HiLog.info(TAG, "get the default page to route when you click card.");
        return null;
    }
}
