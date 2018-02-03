package in.blogspot.thejavedsalat.pinviewandroiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alimuzaffar.lib.pin.PinEntryEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PinEntryEditText pinEntry2 = (PinEntryEditText) findViewById(R.id.txt_pin_entry2);
        if (pinEntry2 != null) {
            pinEntry2.setAnimateText(true);
            pinEntry2.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
                @Override
                public void onPinEntered(CharSequence str) {
                    if (str.toString().equals("123456")) {
                        Toast.makeText(MainActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    } else {
                        pinEntry2.setError(true);
                        Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                        pinEntry2.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                pinEntry2.setText(null);
                            }
                        }, 1000);
                    }
                }
            });
        }

    }
}
