package jp.jagaimo.mytai;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import jp.jagaimo.utils.App;

public class TopActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.Initialize(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        App.SetTransition(R.id.startButton, SettingsActivity.class, this);
    }

}
