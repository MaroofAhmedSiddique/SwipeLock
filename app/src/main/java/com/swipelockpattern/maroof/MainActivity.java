package com.swipelockpattern.maroof;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amnix.materiallockview.MaterialLockView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private String CorrectPattern = "123698745";
    private MaterialLockView materialLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialLockView = (MaterialLockView) findViewById(R.id.pattern);

        materialLockView.setOnPatternListener(new MaterialLockView.OnPatternListener() {
            @Override
            public void onPatternDetected(List<MaterialLockView.Cell> pattern, String SimplePattern) {
                Log.e("SimplePattern", SimplePattern);
                if (!SimplePattern.equals(CorrectPattern)) {

                    materialLockView.setDisplayMode(MaterialLockView.DisplayMode.Wrong);
                    // materialLockView.clearPattern();

                } else {
                    materialLockView.setDisplayMode(MaterialLockView.DisplayMode.Correct);
                }
                super.onPatternDetected(pattern, SimplePattern);
            }
        });

    }
}
