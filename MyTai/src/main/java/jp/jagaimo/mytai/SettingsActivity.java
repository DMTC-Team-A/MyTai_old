package jp.jagaimo.mytai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setRegisterButtonClick();
    }

    private void setRegisterButtonClick() {
        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //他のEditTextとかから情報取ってきて保存
                //ページ処理
            }
        });
    }

}
