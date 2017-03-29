package com.example.plymouthandcornwallwing.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class SimpleDialogFragment extends DialogFragment {
    private final String TAG = "AUC_SIMPLE";

    private SimpleDialogListener mHost;

    // TODO: Implement an interface for hosts to get callbacks
    public interface SimpleDialogListener {
        public void onPositveResult(DialogFragment dlg);
        public void onNegativeResult(DialogFragment dlg);
        public void onNeutralResult(DialogFragment dlg);
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //TODO: Create an AlertDialog.Builder instance
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //TODO: Set builder properties
        builder.setTitle("Peas Preference");
        builder.setMessage("Do you like sygar snap peas");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.i(TAG, "Positive button clicked");
                mHost.onPositveResult(SimpleDialogFragment.this);
            }
        }); builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.i(TAG, "Negative button clicked");
                mHost.onNegativeResult(SimpleDialogFragment.this);

            }
        }); builder.setNeutralButton("Not Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.i(TAG, "Neutral button clicked");
                mHost.onNeutralResult(SimpleDialogFragment.this);

            }
        });
        // TODO: return the created dialog
        return builder.create();
    }

    // TODO: Listen for cancel message by overriding onCancel
    @Override
    public void onCancel(DialogInterface dlg){
        super.onCancel(dlg);
        Log.i(TAG, "Dialog Cancelled");
    }


    // TODO: Override onAttach to get Activity instance
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mHost = (SimpleDialogListener)activity;
    }

}
