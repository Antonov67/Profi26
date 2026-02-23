package com.example.profi26.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.profi26.R;
import com.google.android.material.button.MaterialButton;

public class LanguageSelectActivity extends AppCompatActivity {

    MaterialButton lb1, lb2, lb3, lb4, lastChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.Base_Theme_Profi26);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_language_select);

        //меняем цвет статус бара
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.deep_blue));
        }

        //сохраняем цвет кнопок
        lb1 = findViewById(R.id.lb1);
        lb2 = findViewById(R.id.lb2);
        lb3 = findViewById(R.id.lb3);
        lb4 = findViewById(R.id.lb4);

        lastChecked = null;

        View.OnClickListener toggleListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialButton clickedButton = (MaterialButton) v;

                // Снимаем выделение с предыдущей кнопки
                if (lastChecked != null) {
                    lastChecked.setEnabled(true);
                }
                // Выделяем новую
                clickedButton.setEnabled(false);
                lastChecked = clickedButton;
            }

        };

        lb1.setOnClickListener(toggleListener);
        lb2.setOnClickListener(toggleListener);
        lb3.setOnClickListener(toggleListener);
        lb4.setOnClickListener(toggleListener);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}