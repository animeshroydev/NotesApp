package com.animeshpreps.notes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.animeshpreps.notes.models.Note;
import com.animeshpreps.notes.util.LinedEditText;

public class NoteActivity extends AppCompatActivity implements
        View.OnTouchListener,
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{

    private static final String TAG = "NoteActivity";

    // ui component
    private LinedEditText mLinedEditText;
    private EditText mEditTitle;
    private TextView mViewTitle;

    // vars
    private boolean mIsNewNote;
    private Note mInitialNote;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mLinedEditText = findViewById(R.id.note_text);
        mEditTitle = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);

        if (getIncomingIntent()) {
            // this is a new note (EDIT MODE)
            setNewNoteProperties();
        } else {
            // this is not a new note (VIEW MODE)
            setNoteProperties();
        }

        setListener();

    }

    private void setListener() {
        mLinedEditText.setOnTouchListener(this);
        mGestureDetector = new GestureDetector(this, this);
    }

    private boolean getIncomingIntent() {
        if (getIntent().hasExtra("selected_note")) {

            mInitialNote = getIntent().getParcelableExtra("selected_note");

            mIsNewNote = false;
            return false;
        }
        mIsNewNote = true;
        return true;
    }

    private void setNoteProperties() {
        mViewTitle.setText(mInitialNote.getTitle());
        mEditTitle.setText(mInitialNote.getTitle());
        mLinedEditText.setText(mInitialNote.getContent());
    }

    private void setNewNoteProperties() {
        mViewTitle.setText("Note Title");
        mEditTitle.setText("Note Title");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {


        return mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(@Nullable MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTap: double tapped");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent motionEvent) {
        return false;
    }
}