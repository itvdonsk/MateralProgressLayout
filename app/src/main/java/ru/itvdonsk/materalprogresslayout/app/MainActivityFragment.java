package ru.itvdonsk.materalprogresslayout.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

import ru.itvdonsk.app.R;
import ru.itvdonsk.materialprogresslayout.MaterialProgressLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    MaterialProgressLayout mMaterialProgressLayout;
    Random rnd = new Random();

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mMaterialProgressLayout = (MaterialProgressLayout) view.findViewById(R.id.material_progress_layout);
        Button buttonStart = (Button) view.findViewById(R.id.buttonRefreshStart);
        Button buttonStop = (Button) view.findViewById(R.id.buttonRefreshStop);
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonRefreshStart:
                mMaterialProgressLayout.setSize(rnd.nextInt(2));
                mMaterialProgressLayout.setProgressBackgroundColorSchemeColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                mMaterialProgressLayout.setColorSchemeColors(
                        Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
                        Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
                        Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                );
                mMaterialProgressLayout.setRefreshing(true);
                break;
            case R.id.buttonRefreshStop:
                mMaterialProgressLayout.setRefreshing(false);
                break;
        }
    }
}
