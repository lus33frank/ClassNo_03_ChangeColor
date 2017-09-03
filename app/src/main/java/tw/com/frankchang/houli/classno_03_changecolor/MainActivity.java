package tw.com.frankchang.houli.classno_03_changecolor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Spinner spList;
    RadioButton rbRed, rbGreen, rbBlue;
    SeekBar skBar;
    TextView tvSelect, tvShow;
    ToggleButton tgbtn;

    private int fRed,fGreen,fBlue;
    private int bRed,bGreen,bBlue;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewer();
    }

    void findviewer(){
        spList = (Spinner)findViewById(R.id.spinner);
        spList.setOnItemSelectedListener(spinnerListener);

        rbRed = (RadioButton)findViewById(R.id.radioButton);
        rbRed.setOnClickListener(rbsClicker);
        rbGreen = (RadioButton)findViewById(R.id.radioButton2);
        rbGreen.setOnClickListener(rbsClicker);
        rbBlue = (RadioButton)findViewById(R.id.radioButton3);
        rbBlue.setOnClickListener(rbsClicker);

        skBar = (SeekBar)findViewById(R.id.seekBar);
        skBar.setOnSeekBarChangeListener(seekBarChanger);

        tvSelect = (TextView)findViewById(R.id.textView);
        tvShow = (TextView)findViewById(R.id.textView2);

        tgbtn = (ToggleButton)findViewById(R.id.toggleButton);
        tgbtn.setOnCheckedChangeListener(tgbListener);
    }

    View.OnClickListener rbsClicker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.radioButton:
                    if(pos==0){
                        skBar.setProgress(fRed);
                    }else{
                        skBar.setProgress(bRed);
                    }
                    tvSelect.setText(getResources().getText(R.string.Red));
                    tvSelect.setTextColor(Color.RED);
                    break;

                case R.id.radioButton2:
                    if(pos==0){
                        skBar.setProgress(fGreen);
                    }else{
                        skBar.setProgress(bGreen);
                    }
                    tvSelect.setText(getResources().getText(R.string.Green));
                    tvSelect.setTextColor(Color.GREEN);
                    break;

                case R.id.radioButton3:
                    if(pos==0){
                        skBar.setProgress(fBlue);
                    }else{
                        skBar.setProgress(bBlue);
                    }
                    tvSelect.setText(getResources().getText(R.string.Blue));
                    tvSelect.setTextColor(Color.BLUE);
                    break;

            }
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarChanger = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //正在拖拉時會呼叫此方法

            //第一次設計
//            if (rbRed.isChecked()) {
//                tvShow.setTextColor(Color.rgb(progress, 0, 0));
//            }
//            if (rbGreen.isChecked()) {
//                tvShow.setTextColor(Color.rgb(0, progress, 0));
//            }
//            if (rbBlue.isChecked()) {
//                tvShow.setTextColor(Color.rgb(0, 0, progress));
//            }

            //最後設計
            if (pos == 0) {
                //前景色
                if (rbRed.isChecked()) {
                    fRed = progress;
                }
                if (rbGreen.isChecked()) {
                    fGreen = progress;
                }
                if (rbBlue.isChecked()) {
                    fBlue = progress;
                }
                tvShow.setTextColor(Color.rgb(fRed, fGreen, fBlue));
            }
            else {
                //背景色
                if(rbRed.isChecked()){
                    bRed=progress;
                }
                if(rbGreen.isChecked()){
                    bGreen=progress;
                }
                if(rbBlue.isChecked()) {
                    bBlue=progress;
                }
                tvShow.setBackgroundColor(Color.rgb(bRed, bGreen, bBlue));
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            //正要拖拉時會呼叫此方法
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            //停止拖拉時會呼叫此方法
        }
    };

    CompoundButton.OnCheckedChangeListener tgbListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                tvShow.setBackgroundColor(Color.BLACK);
            }else{
                tvShow.setBackgroundColor(Color.WHITE);
            }
        }
    };

    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            pos = position;

            if (rbRed.isChecked()) {
                if (pos == 0) {
                    skBar.setProgress(fRed);
                }
                else {
                    skBar.setProgress(bRed);
                }
            }
            if (rbGreen.isChecked()) {
                if (pos == 0) {
                    skBar.setProgress(fGreen);
                }
                else {
                    skBar.setProgress(bGreen);
                }
            }
            if (rbBlue.isChecked()) {
                if (pos == 0) {
                    skBar.setProgress(fBlue);
                }
                else {
                    skBar.setProgress(bBlue);
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //無作用
        }
    };
}
