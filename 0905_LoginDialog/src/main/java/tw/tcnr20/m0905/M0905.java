package tw.tcnr20.m0905;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class M0905 extends AppCompatActivity implements View.OnClickListener {

    private Button b001;
    private TextView ans;
    private Dialog mDog;
    private Button Bok;
    private Button Bcal;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0905);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001=(Button)findViewById(R.id.m0905_b001);
        ans=(TextView)findViewById(R.id.m0905_ans);

        b001.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0905_b001:
                    ans.setText("");

                    mDog=new Dialog(M0905.this);
                    mDog.setTitle(getString(R.string.login));
                    mDog.setCancelable(false);

                    mDog.setContentView(R.layout.login_dlg);
                    Bok=(Button)mDog.findViewById(R.id.m0905_btnOK);
                    Bcal=(Button)mDog.findViewById(R.id.m0905_btnCancel);

                    Bok.setOnClickListener(this);
                    Bcal.setOnClickListener(this);
                    mDog.show();
                    break;

                case R.id.m0905_btnOK:
                    EditText edtUserName = (EditText) mDog.findViewById(R.id.edtUserName);
                    EditText edtPassword = (EditText) mDog.findViewById(R.id.edtPassword);
                    ans.setText(getString(R.string.m0905_ans) +
                            getString(R.string.m0905_t001) +
                            edtUserName.getText().toString() + "\n" +
                            getString(R.string.m0905_t002) +
                            u_md5(edtPassword.getText().toString()));  //密碼用MD5加密

//                mTxtResult.setText(getString(R.string.m0905_ans) +
//                        getString(R.string.m0905_t001) +
//                        edtUserName.getText().toString() + "\n" +
//                        getString(R.string.m0905_t002)+edtPassword.getText().toString() );  //
                    mDog.cancel();
                    break;
                case R.id.m0905_btnCancel:
                    mDog.cancel();
                    break;
            }
    }


        public static String u_md5(String content) {
            byte[] hash;
            try {
                hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("NoSuchAlgorithmException",e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UnsupportedEncodingException", e);
            }

            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 0xFF) < 0x10){
                    hex.append("0");
                }
                hex.append(Integer.toHexString(b & 0xFF));
            }
            return hex.toString();
        }


}