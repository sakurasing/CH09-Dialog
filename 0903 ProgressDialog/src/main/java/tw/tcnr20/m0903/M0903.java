package tw.tcnr20.m0903;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class M0903 extends AppCompatActivity{

    private Button btndig;
    private Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0903);
        setupViewCompont();
    }

    private void setupViewCompont() {
        btndig = (Button)findViewById(R.id.m0903_b001);
        btndig.setOnClickListener(btnprodig);

    }
    private View.OnClickListener btnprodig=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final ProgressDialog prodig=new ProgressDialog(M0903.this);

            prodig.setTitle(getString(R.string.m0903_title));
            prodig.setMessage(getString(R.string.m0903_message));
            prodig.setIcon(android.R.drawable.ic_dialog_email);
            prodig.setCancelable(false);

            prodig.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            prodig.setMax(100);
            prodig.show();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    Calendar begin = Calendar.getInstance();
                    do {
                        Calendar now = Calendar.getInstance();
                        int min_x=now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE);
                        int sec_x =now.get(Calendar.SECOND) - begin.get(Calendar.SECOND);
                        final int iDiffSec = 60 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE)) +
                                (now.get(Calendar.SECOND) - begin.get(Calendar.SECOND));
//-------------------------------------
                        if (iDiffSec * 10 > 100) {
                            mHandler.post(new Runnable() {
                                public void run() {
                                    prodig.setProgress(100);
                                }
                            });
                            break;
                        }
//-------------------------------------
                        mHandler.post(new Runnable() {
                            public void run() {
                                prodig.setProgress(iDiffSec * 10); //1,2,4,5
                            }
                        });
//-------------------------------------
                        if (iDiffSec * 10+5 < 100)
                            mHandler.post(new Runnable() {
                                public void run() {
                                    prodig.setSecondaryProgress(iDiffSec * 10+5);
                                }
                            });
                        else
                            mHandler.post(new Runnable() {
                                public void run() {
                                    prodig.setSecondaryProgress(100);
                                }
                            });
                    } while (true);
                    prodig.cancel();
               }
            }).start();
        }
    };

//    @Override
//    public void onClick(View view) {
//        ProgressDialog prodig=new ProgressDialog(this);
//
//        prodig.setTitle(getString(R.string.m0903_title));
//        prodig.setMessage(getString(R.string.m0903_message));
//        prodig.setIcon(android.R.drawable.ic_dialog_email);
//        prodig.setCancelable(false);
//
//        prodig.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        prodig.setMax(100);
//        prodig.show();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Calendar begin = Calendar.getInstance();
//                do {
//                    Calendar now = Calendar.getInstance();
//                    int min_x=now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE);
//                    int sec_x =now.get(Calendar.SECOND) - begin.get(Calendar.SECOND);
//                    final int iDiffSec = 60 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE)) +
//                            (now.get(Calendar.SECOND) - begin.get(Calendar.SECOND));
////-------------------------------------
//                    if (iDiffSec * 10 > 100) {
//                        mHandler.post(new Runnable() {
//                            public void run() {
//                                prodig.setProgress(100);
//                            }
//                        });
//                        break;
//                    }
////-------------------------------------
//                    mHandler.post(new Runnable() {
//                        public void run() {
//                            prodig.setProgress(iDiffSec * 10); //1,2,4,5
//                        }
//                    });
////-------------------------------------
//                    if (iDiffSec * 10+5 < 100)
//                        mHandler.post(new Runnable() {
//                            public void run() {
//                                prodig.setSecondaryProgress(iDiffSec * 10+5);
//                            }
//                        });
//                    else
//                        mHandler.post(new Runnable() {
//                            public void run() {
//                                prodig.setSecondaryProgress(100);
//                            }
//                        });
//                } while (true);
//                prodig.cancel();
//            }
//        }).start();
//    }
}