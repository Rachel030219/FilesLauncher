package net.rachel030219.fileslauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;


public class LauncherActivity extends Activity {
    public final static int NOT_FOUND = 0;
    public final static int ANDROID = 1;
    public final static int GOOGLE = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        try {
            intent.setComponent(new ComponentName("com.google.android.documentsui", "com.android.documentsui.files.FilesActivity"));
            startActivity(intent);
        } catch (ActivityNotFoundException e1) {
            try {
                intent.setComponent(new ComponentName("com.android.documentsui", "com.android.documentsui.files.FilesActivity"));
                startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                Toast.makeText(this, "Files not found.", Toast.LENGTH_LONG).show();
            }
        }
        finish();
    }
}
