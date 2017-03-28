package persistencia_dados.exemplos.genivaldo.persistenciadedados;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Genivaldo on 24/03/2017.
 */

public class SharedPrefsActivity extends Activity {

    final static String APP_PREFS = "app_prefs";
    final static String USERNAME_KEY = "username";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_prefs);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences(APP_PREFS, MODE_PRIVATE);
        String username = prefs.getString(USERNAME_KEY, null);
        TextView message = (TextView) findViewById(R.id.welcome_message);
        Button addNameButton = (Button) findViewById(R.id.add_name_button);
        if (username != null) {
            message.setText("Bem vindo , " + username + "!");
            addNameButton.setText(" Trocar de nome ");
        } else {
            message.setText(" Você não cadastrou seu nome ... ");
            addNameButton.setText(" Adicionar nome ");
        }
        addNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedPrefsActivity.this, AddNameActivity.class);
                startActivity(intent);
            }
        });
    }
}
