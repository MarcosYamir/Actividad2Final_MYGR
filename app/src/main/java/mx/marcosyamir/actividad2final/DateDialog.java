package mx.marcosyamir.actividad2final;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by UPFIM-SIMyVC2 on 07/06/2016.
 */
@SuppressLint("ValidFragment")
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText etFechaNacimiento;

    public DateDialog(View v){
        etFechaNacimiento = (EditText)v;
    }

    public Dialog onCreateDialog(Bundle saveInstanceState){
        final Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this, year,month,day );
    }

    public void onDateSet(DatePicker v, int year, int month, int day){
        String date = day + "/" + (month+1) + "/" + year;
        etFechaNacimiento.setText(date);
    }
}
