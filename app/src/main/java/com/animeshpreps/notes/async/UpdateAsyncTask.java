package com.animeshpreps.notes.async;

import android.os.AsyncTask;

import com.animeshpreps.notes.models.Note;
import com.animeshpreps.notes.persistance.NoteDao;

public class UpdateAsyncTask extends AsyncTask<Note, Void, Void> {

    private NoteDao mNoteDao;

    public UpdateAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.update(notes);
        return null;
    }

}
