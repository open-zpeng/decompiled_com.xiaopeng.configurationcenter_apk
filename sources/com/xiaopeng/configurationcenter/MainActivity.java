package com.xiaopeng.configurationcenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public class MainActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.configurationcenter.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
    }
}
