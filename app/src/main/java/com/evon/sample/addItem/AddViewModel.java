package com.evon.sample.addItem;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import com.evon.sample.db.AppDatabase;
import com.evon.sample.db.Model;


public class AddViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    public void addItem(final Model model) {
        new addAsyncTask(appDatabase).execute(model);
    }

    private static class addAsyncTask extends AsyncTask<Model, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Model... params) {
            db.itemAndPersonModel().addItem(params[0]);
            return null;
        }

    }
}
