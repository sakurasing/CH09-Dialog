package tw.tcnr20.m0902;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.app.LauncherActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class M0902 extends AppCompatActivity {
    final String[] lisdig = {"張三", "李四", "王五", "陳六", "呂七", "宋八",
            "如果選擇項目太多", "Android也會", "自動的可以拖曳喔！～"};
    private Button b001;
    private Button b002;
    private TextView ans;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0902);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001 = (Button) findViewById(R.id.m0902_b001);
        b002 = (Button) findViewById(R.id.m0902_b002);
        ans = (TextView) findViewById(R.id.m0902_t001);

        b001.setOnClickListener(godig);
        b002.setOnClickListener(godig);
        b002.setOnLongClickListener(gogodig);
    }

    private View.OnLongClickListener gogodig=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            switch (view.getId()){
                case R.id.m0902_b001:
                    Toast.makeText(getApplicationContext(),getText(R.string.m0902_test01),Toast.LENGTH_SHORT).show();
                    break;

                case R.id.m0902_b002:
                    Toast.makeText(getApplicationContext(),getText(R.string.m0902_test01),Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    };

    private final View.OnClickListener godig = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.m0902_b001:
                    ans.setText("");
                    MyAlertDialog mydig = new MyAlertDialog(M0902.this);

                    mydig.setTitle(getString(R.string.m0902_title));
                    mydig.setMessage(getString(R.string.m0902_t001) + getString(R.string.m0902_b001));

                    mydig.setIcon(android.R.drawable.ic_dialog_info);
                    mydig.setCancelable(false);

                    mydig.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.m0902_positive), altdigposi);
                    mydig.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.m0902_negative), altdignega);
                    mydig.setButton(DialogInterface.BUTTON_NEUTRAL, getString(R.string.m0902_neutral), altdigneu);

                    mydig.show();

                    break;

                case R.id.m0902_b002:
                    ans.setText("");
                    AlertDialog.Builder altdig = new AlertDialog.Builder(M0902.this);

                    altdig.setTitle(getString(R.string.m0902_title));
                    altdig.setIcon(android.R.drawable.ic_dialog_info);
                    altdig.setCancelable(false);

                    //--------------------------------------------------------------
                    altdig.setItems(lisdig, new DialogInterface.OnClickListener() {


                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "select" + lisdig[i], Toast.LENGTH_SHORT).show();

                            ans.setText(getString(R.string.m0902_t001) + getString(R.string.m0902_b002) + "\n" + getString(R.string.m0902_click) + "" + lisdig[i]);

                        }

                    });


                    altdig.setPositiveButton(getString(R.string.m0902_positive), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ans.setText(getString(R.string.m0902_t001) +
                                    getString(R.string.m0902_b002) +
                                    getString(R.string.m0902_click) + " " +
                                    getString(R.string.m0902_positive) + " " +
                                    getString(R.string.m0902_button));
                        }
                    });

                    altdig.setNegativeButton(getString(R.string.m0902_negative), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ans.setText(getString(R.string.m0902_t001) +
                                    getString(R.string.m0902_b002) +
                                    getString(R.string.m0902_click) + " " +
                                    getString(R.string.m0902_negative) + " " +
                                    getString(R.string.m0902_button));
                        }
                    });

                    altdig.setNeutralButton(getString(R.string.m0902_neutral), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ans.setText(getString(R.string.m0902_t001) +
                                    getString(R.string.m0902_b002) +
                                    getString(R.string.m0902_click) + " " +
                                    getString(R.string.m0902_neutral) + " " +
                                    getString(R.string.m0902_button));
                        }
                    });
                    altdig.show();
                    break;
            }
        }
    };

    private DialogInterface.OnClickListener altdigposi=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            ans.setText(getString(R.string.m0902_t001) +
                    getString(R.string.m0902_b001) +
                    getString(R.string.m0902_click) + " " +
                    getString(R.string.m0902_positive) + " " +
                    getString(R.string.m0902_button));

        }
    };

    private DialogInterface.OnClickListener altdignega=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            ans.setText(getString(R.string.m0902_t001) +
                    getString(R.string.m0902_b001) +
                    getString(R.string.m0902_click) + " " +
                    getString(R.string.m0902_negative) + " " +
                    getString(R.string.m0902_button));
        }
    };
    private DialogInterface.OnClickListener altdigneu=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            ans.setText(getString(R.string.m0902_t001) +
                    getString(R.string.m0902_b001) +
                    getString(R.string.m0902_click) + " " +
                    getString(R.string.m0902_neutral) + " " +
                    getString(R.string.m0902_button));
        }
    };


}



