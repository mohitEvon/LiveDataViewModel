package com.evon.sample.listItems;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.evon.sample.db.AppDatabase;
import com.evon.sample.db.Model;

import java.util.List;


public class ListViewModel extends AndroidViewModel {

    private final LiveData<List<Model>> itemAndPersonList;

    private AppDatabase appDatabase;

    public ListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        itemAndPersonList = appDatabase.itemAndPersonModel().getAllItems();
    }


    public LiveData<List<Model>> getItemAndPersonList() {
        return itemAndPersonList;
    }

    public void deleteItem(Model model) {
        new deleteAsyncTask(appDatabase).execute(model);
    }

    private static class deleteAsyncTask extends AsyncTask<Model, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Model... params) {
            db.itemAndPersonModel().deleteItem(params[0]);
            return null;
        }

    }

}
