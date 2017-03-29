package com.example.plymouthandcornwallwing;

        import java.text.Format;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;
        import java.util.List;

        import android.app.Activity;
        import android.app.DatePickerDialog;
        import android.app.DatePickerDialog.OnDateSetListener;
        import android.app.Dialog;
        import android.app.DialogFragment;
        import android.os.Bundle;
        import android.support.annotation.IdRes;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View.OnClickListener;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import static android.R.attr.startYear;

public class personalDetails extends Activity
        implements OnDateSetListener, View.OnClickListener {
    /**
     * Private members of the class
     */
    private TextView tvDisplayDate;
    private Button bPickDate;
    private Spinner yearGroup;
    private Button bSpinner;
    private RadioGroup memberType;
    private int Y;
    private int M;
    private int D;
    private int A;
    private RadioGroup rbc;
    private RadioGroup rbv;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        // When we select this spinner item, a Toast message will be displayed
        yearGroup = (Spinner) findViewById(R.id.yearGroup);

        setCurrentDate();
        button_clickEvent();


    }

    // display current date
    public void setCurrentDate() {


       Calendar c = Calendar.getInstance();

        Y = c.get(Calendar.YEAR)-12;
        M = c.get(Calendar.MONTH);
        D = c.get(Calendar.DAY_OF_MONTH);}


    public void button_clickEvent() {
        bPickDate = (Button) findViewById(R.id.bDate);
        bPickDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt(DialogActivity.YEAR, Y);
                b.putInt(DialogActivity.MONTH, M);
                b.putInt(DialogActivity.DATE, D);
                DialogFragment picker = new DialogActivity();
                picker.setArguments(b);
                picker.show(getFragmentManager(), "fragment_date_picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int Y, int M, int D) {
        tvDisplayDate.setText(new StringBuilder()
                        // Month is 0 based so add 1
                        .append(D).append("/")
                        .append(M + 1).append("/")
                        .append(Y).append(" "));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(parent.getContext(),
                "Year Group Selcted : " + parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
    }


    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

    }
}