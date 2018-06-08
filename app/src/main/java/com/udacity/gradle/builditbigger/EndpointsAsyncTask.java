package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService = null;
    private Context context;
    private String jokesResult;
    private EndpointAsyncTaskListener listener;

    public interface EndpointAsyncTaskListener {
        void onTaskComplete(String result);
    }

    public EndpointsAsyncTask(EndpointAsyncTaskListener listener) {
        this.listener = listener;
    }

    public void setListener(EndpointAsyncTaskListener listener) {
        this.listener = listener;
    }

//    public EndpointsAsyncTask(Context mContext) {
//        this.context = mContext;
//    }

    private String joke;
    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8888/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
        try {
//            joke = myApiService.tellJoke(new MyBean()).execute().getJoke();
            joke = myApiService.tellJoke().execute().getData();
            return joke;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (joke != null && !joke.isEmpty()) {
            this.listener.onTaskComplete(result);
        }
    }

}
