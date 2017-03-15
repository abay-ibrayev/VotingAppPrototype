package com.shareholder.abay.finapps.finappsproject.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.shareholder.abay.finapps.finappsproject.R;
import com.shareholder.abay.finapps.finappsproject.activity.DecisionActivity;

/**
 * Created by abay on 10/23/16.
 */
public class DialogAnswer extends DialogFragment implements View.OnClickListener{
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    View v;
    int id;
    boolean okPressed=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         v= inflater.inflate(R.layout.dialog_fragment,null);
        InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imgr.showSoftInput((EditText)v.findViewById(R.id.editAnswer), 0);
        ((EditText)v.findViewById(R.id.editAnswer)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    Log.i("myLogs","Enter pressed");
                    final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
                    getDialog().dismiss();
                    return true;
                }
                return false;
            }
        });
        ((TextView)v.findViewById(R.id.textAnswer)).setText(getArguments().getString("text"));
        id = getArguments().getInt("int");

        return v;
    }


    @Override
    public void onClick(View v) {


    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        DecisionActivity activity = (DecisionActivity) getActivity();
        activity.getDialogResult(((EditText)v.findViewById(R.id.editAnswer)).getText().toString(),id);
        this.dismiss();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

}
