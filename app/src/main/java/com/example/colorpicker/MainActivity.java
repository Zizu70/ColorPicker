package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.SeekBar;
import android.os.Bundle;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private TextView textViewHead;

    private SeekBar seekBarRed ;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

    private TextView textViewRed;
    private TextView textViewGreen;
    private TextView textViewBlue;

    private TextView textViewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        textViewHead.setBackgroundColor(android.graphics.Color.rgb(156, 114, 232));
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean user) {
            updateTextViews();
            updateTextViewColor();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

    };

    private void updateTextViews() {
        textViewRed.setText("Red: " + seekBarRed.getProgress());
        textViewGreen.setText("Green: " + seekBarGreen.getProgress());
        textViewBlue.setText("Blue: " + seekBarBlue.getProgress());
    }

    private void updateTextViewColor() {
        int red = seekBarRed.getProgress();
        int green = seekBarGreen.getProgress();
        int blue = seekBarBlue.getProgress();

        textViewColor.setText(String.format(red + ", " + green + ", " + blue) );
        textViewColor.setBackgroundColor(android.graphics.Color.rgb(red, green, blue));

        if (red + green + blue < 383) {
            textViewColor.setTextColor(Color.WHITE);
        } else {
            textViewColor.setTextColor(Color.BLACK);
        }
    }

    private void init() {
        textViewHead = findViewById(R.id.textViewHead);

        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarBlue = findViewById(R.id.seekBarBlue);

        textViewRed = findViewById(R.id.textViewRed);
        textViewGreen = findViewById(R.id.textViewGreen);
        textViewBlue = findViewById(R.id.textViewBlue);

        textViewColor = findViewById(R.id.textViewColor);

        seekBarRed.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBarGreen.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBarBlue.setOnSeekBarChangeListener(seekBarChangeListener);
    }
}