package com.animeshpreps.notes.async;

import android.os.AsyncTask;

import com.animeshpreps.notes.models.Note;
import com.animeshpreps.notes.persistance.NoteDao;

public class DeleteAsyncTask extends AsyncTask<Note, Void, Void> {

    private NoteDao mNoteDao;

    public DeleteAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.delete(notes);
        return null;
    }

}
