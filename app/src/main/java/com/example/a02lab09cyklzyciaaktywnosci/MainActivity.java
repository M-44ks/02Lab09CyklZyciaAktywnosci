package com.example.a02lab09cyklzyciaaktywnosci;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifecycle";
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        statusTextView = findViewById(R.id.statusTextView);
        Button resetButton = findViewById(R.id.resetButton);
        Button closeButton = findViewById(R.id.closeButton);

        // Aktualizacja statusu
        updateStatus("onCreate");
        Log.d(TAG, "onCreate wywołane");

        // Obsługa przycisku "Reset Status"
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusTextView.setText("Status cyklu życia: brak danych");
            }
        });

        // Obsługa przycisku "Zamknij aplikację"
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateStatus("onStart");
        Log.d(TAG, "onStart wywołane");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateStatus("onResume");
        Log.d(TAG, "onResume wywołane");
    }

    @Override
    protected void onPause() {
        super.onPause();
        updateStatus("onPause");
        Log.d(TAG, "onPause wywołane");
    }

    @Override
    protected void onStop() {
        super.onStop();
        updateStatus("onStop");
        Log.d(TAG, "onStop wywołane");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateStatus("onRestart");
        Log.d(TAG, "onRestart wywołane");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        updateStatus("onDestroy");
        Log.d(TAG, "onDestroy wywołane");
    }

    private void updateStatus(String lifecycleEvent) {
        statusTextView.setText("Status cyklu życia: " + lifecycleEvent);
    }
}
