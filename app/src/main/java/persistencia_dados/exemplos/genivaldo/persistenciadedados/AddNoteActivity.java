package persistencia_dados.exemplos.genivaldo.persistenciadedados;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import persistencia_dados.exemplos.genivaldo.persistenciadedados.Dao.NotesDao;

public class AddNoteActivity extends AppCompatActivity {
    private NotesDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);
        dao = new NotesDao(this);
        dao.open();
        Button saveButton = (Button) findViewById(R.id.save_note_button);
        final EditText noteText = (EditText) findViewById(R.id.note_text);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = noteText.getEditableText().toString();
                dao.create(note);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        dao.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dao.close();
        super.onPause();
    }
}