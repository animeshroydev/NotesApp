package com.animeshpreps.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.animeshpreps.notes.models.Note;
import com.animeshpreps.notes.util.LinedEditText;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "NoteActivity";

    // ui component
    private LinedEditText mLinedEditText;
    private EditText mEditTitle;
    private TextView mViewTitle;

    // vars
    private boolean mIsNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mLinedEditText = findViewById(R.id.note_text);
        mEditTitle = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);

        if (getIncomingIntent()) {
            // this is a new note (EDIT MODE)
        } else {
            // this is not a new note (VIEW MODE)
        }

    }

    private boolean getIncomingIntent() {
        if (getIntent().hasExtra("selected_note")) {

            Note incomingNote = getIntent().getParcelableExtra("selected_one");
            Log.d(TAG, "getIncomingIntent: " + incomingNote.toString());

            mIsNewNote = false;
            return false;
        }
        return true;
    }
}