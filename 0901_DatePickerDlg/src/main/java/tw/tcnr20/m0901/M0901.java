package tw.tcnr20.m0901;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class M0901 extends AppCompatActivity implements View.OnClickListener {

    private TextView t001;
    private Button pickdate,picktime;
    private String u_date="";
    private String u_time="";
    private Calendar now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0901);
        setupviewCompoent();
    }

    private void setupviewCompoent() {
        pickdate=(Button)findViewById(R.id.m0901_b001);
        picktime=(Button)findViewById(R.id.m0901_b002);

        t001=(TextView)findViewById(R.id.m0901_t001);

        pickdate.setOnClickListener(this);
        picktime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        t001.setText(" ");
        now=Calendar.getInstance();
        switch (v.getId()){

            case R.id.m0901_b001:
                DatePickerDialog datePickDog=new DatePickerDialog(
                        this,datepickon,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH));

                datePickDog.setTitle(getString(R.string.m0901_datetitle));
                datePickDog.setMessage(getString(R.string.m0901_datemessage));
                datePickDog.setIcon(getDrawable(R.drawable.iconmy));
                datePickDog.setCancelable(false);
                datePickDog.show();

                break;

            case R.id.m0901_b002:

                TimePickerDialog timePickDog=new TimePickerDialog(
                        this,timepickon,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),false);
                timePickDog.setTitle(getString(R.string.m0901_timetitle));
                timePickDog.setMessage(getString(R.string.m0901_timemessage));
                timePickDog.setIcon(getDrawable(R.drawable.iconmy));
                timePickDog.show();

                break;

            }

        }
        private DatePickerDialog.OnDateSetListener datepickon = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            u_date=
                    (year) + getString(R.string.n_yy)+
                    (month + 1) + getString(R.string.n_mm) +
                    (dayOfMonth) + getString(R.string.n_dd);
            t001.setText(getString(R.string.m0901_datetitle)+u_date+"\n"+getString(R.string.m0901_timetitle)+u_time);

        }
    };

    private TimePickerDialog.OnTimeSetListener timepickon=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            u_time=
                    (hourOfDay) +getString(R.string.d_hh) +
                    (minute) +getString(R.string.d_mm);
            t001.setText(getString(R.string.m0901_datetitle)+u_date+"\n"+getString(R.string.m0901_timetitle)+u_time);

        }
    };


    }



