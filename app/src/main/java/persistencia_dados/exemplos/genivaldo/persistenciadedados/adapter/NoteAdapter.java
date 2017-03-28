package persistencia_dados.exemplos.genivaldo.persistenciadedados.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import persistencia_dados.exemplos.genivaldo.persistenciadedados.R;
import persistencia_dados.exemplos.genivaldo.persistenciadedados.model.Note;

public class NoteAdapter extends ArrayAdapter<Note> {

    private int layout;

    public NoteAdapter(Context context, int layout, List<Note> notes) {
        super(context, layout, notes);
        this.layout = layout;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.layout, parent, false);
        }
        TextView noteText = (TextView) view.findViewById(R.id.note_text_view);
        Note note = getItem(position);
        noteText.setText(note.getNote());
        return view;
    }
}

