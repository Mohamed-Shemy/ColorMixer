package com.shemy.colormixer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    SeekBar RB,GB,BB;
    TextView color,RGB,HEX;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RB = findViewById(R.id.RB);
        GB = findViewById(R.id.GB);
        BB = findViewById(R.id.BB);
        color = findViewById(R.id.test);
        RGB = findViewById(R.id.RGB);
        HEX = findViewById(R.id.HEX);

        RB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
               Update();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        GB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Update();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        BB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Update();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void Update()
    {
        int r, g , b;
        r = RB.getProgress();
        g = GB.getProgress();
        b = BB.getProgress();
        color.setBackgroundColor(Color.rgb(r, g, b));
        RGB.setText(r + "," + g + "," + b);
        HEX.setText(toHex(r, g, b));
    }


    public void DecrementR(View view)
    {
        int v = RB.getProgress();
        RB.setProgress(Math.max(0,v-1));
    }


    public void IncrementR(View view)
    {
        int v = RB.getProgress();
        RB.setProgress(Math.min(255,v+1));
    }

    public void DecrementG(View view)
    {
        int v = GB.getProgress();
        GB.setProgress(Math.max(0,v-1));
    }

    public void IncrementG(View view)
    {
        int v = GB.getProgress();
        GB.setProgress(Math.min(255,v+1));
    }

    public void DecrementB(View view)
    {
        int v = BB.getProgress();
        BB.setProgress(Math.max(0,v-1));
    }

    public void IncrementB(View view)
    {
        int v = BB.getProgress();
        BB.setProgress(Math.min(255,v+1));
    }

    private String toHex(int r, int g, int b)
    {
        String hex = "#";
        hex += toHexHelp(r);
        hex += toHexHelp(g);
        hex += toHexHelp(b);
        return hex;
    }

    private String toHexHelp(int dec)
    {
        String hex = "";
        if(dec >= 0 && dec <= 9)
        {
            hex = "0" + dec;
            return hex;
        }
        int c;
        String h;
        while (dec > 0)
        {
            c = dec % 16;
            dec /= 16;
            switch (c)
            {
                case 10:hex += "A"; break;
                case 11:hex += "B"; break;
                case 12:hex += "C"; break;
                case 13:hex += "D"; break;
                case 14:hex += "E"; break;
                case 15:hex += "F"; break;
                default:hex += c;	break;
            }
        }
        h = hex;
        if(hex.length() == 1)
            hex = "0";
        else
            hex = "";
        for (int i = h.length() - 1; i >= 0; i--)
            hex += h.charAt(i);
        return hex;
    }

}
