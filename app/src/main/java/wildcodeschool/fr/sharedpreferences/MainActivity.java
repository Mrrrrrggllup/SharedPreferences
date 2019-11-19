package wildcodeschool.fr.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    String rememberTxt;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mTextView = findViewById(R.id.Backup);

        preferences = getPreferences(Context.MODE_PRIVATE);

        final String backup = preferences.getString("Remember", "");
        mTextView.setText(backup);

        final Button button = findViewById(R.id.save_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView remember = findViewById(R.id.remember_me);
                rememberTxt = remember.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Remember",rememberTxt);
                editor.apply();
                mTextView.setText(rememberTxt);
            }
        });
    }
}
