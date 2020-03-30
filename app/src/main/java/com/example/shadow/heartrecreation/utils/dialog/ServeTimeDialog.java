package com.example.shadow.heartrecreation.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shadow.heartrecreation.R;

public class ServeTimeDialog extends Dialog {

    private View layoutView;
    private TextView sure;
    private TextView time;
    private RelativeLayout layout;
    private ServeTimeDialogFace dialogFace;
    private CountDownTimer timer;

    public void setDialogFace(ServeTimeDialogFace dialogFace) {
        this.dialogFace = dialogFace;
    }

    public ServeTimeDialog(@NonNull Context context) {
        super(context, R.style.MyNewAlertDialog);
        initCameraDialog(context);
    }

    private void initCameraDialog(Context mContext) {
        layoutView = LayoutInflater.from(mContext).inflate(R.layout.dialog_serve_sure, null);
        sure = (TextView) layoutView.findViewById(R.id.tv_sure);
        time = (TextView) layoutView.findViewById(R.id.tv_time);
        layout = (RelativeLayout) layoutView.findViewById(R.id.layout_sure);
        layout.setEnabled(false);
        timer=new CountDownTimer(3*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                time.setVisibility(View.GONE);
                sure.setTextColor(Color.parseColor("#FFFE849B"));
                layout.setEnabled(true);
                timer.cancel();
            }
        };
        setCancelable(false);
        setContentView(layoutView);
        initDialogWindow();
        setOnClickListener();
    }

    private void initDialogWindow() {
        Window window = getWindow();
        assert window != null;
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    public void showDialog() {
        show();
        timer.start();
    }


    private void setOnClickListener() {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
//                if (dialogFace != null) {
//                    dialogFace.sure();
//                    dismiss();
//                }
            }
        });

//        dialogOver.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//
//        baiduBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (dialogFace != null) {
//                    dialogFace.baiduBtn();
//                    dismiss();
//                }
//            }
//        });
    }

    public interface ServeTimeDialogFace {
        void sure();
    }
}
