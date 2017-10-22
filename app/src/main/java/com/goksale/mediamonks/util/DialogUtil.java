package com.goksale.mediamonks.util;


import android.app.ProgressDialog;
import android.content.Context;

import com.goksale.mediamonks.R;

public final class DialogUtil {

    private static ProgressDialog progressDialog;

    private DialogUtil() {
    }

    public static void showProgress(Context context) {
        progressDialog = new ProgressDialog(context, ProgressDialog.THEME_HOLO_DARK);
        progressDialog.setMessage(context.getString(R.string.general_loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public static void dismissProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
