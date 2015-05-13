package es.uva.inf.kave.myapplication;

/**
 * Created by coke on 12/05/15.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Teoria extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.teoria, container, false);
        return rootView;
    }
}
