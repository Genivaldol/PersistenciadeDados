package persistencia_dados.exemplos.genivaldo.persistenciadedados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import persistencia_dados.exemplos.genivaldo.persistenciadedados.Dao.NotesDao;
import persistencia_dados.exemplos.genivaldo.persistenciadedados.adapter.NoteAdapter;
import persistencia_dados.exemplos.genivaldo.persistenciadedados.model.Note;

public class SqliteActivity extends AppCompatActivity {

    private NotesDao dao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqllite_activity);
        dao = new NotesDao(this);
        dao.open();
    }

    @Override
    protected void onResume() {
        dao.open();
        super.onResume();
        List<Note> notes = dao.getAll();

        //criando meu adapater

        NoteAdapter adapter = new NoteAdapter(this, R.layout.list_notes_view, notes);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        dao.close();
        super.onPause();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_note) {
            Intent intent = new Intent(this, AddNoteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}