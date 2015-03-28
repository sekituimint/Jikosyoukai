package com.example.jikosyoukai;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	/** スレッドUI操作用ハンドラ */
	private Handler mHandler = new Handler();
	private Handler mHandler2 = new Handler();
	private Handler mHandler3 = new Handler();
	
	/** テキストオブジェクト */
	private Runnable updateText;
	private Runnable updateText2;
	private Runnable updateText3;
	Integer count1ue,count2ue,count3ue;
	Integer count1naka,count2naka,count3naka;
	Integer count1sita,count2sita,count3sita;
	TextView text1ue,text1naka,text1sita;
	TextView text2ue,text2naka,text2sita;
	TextView text3ue,text3naka,text3sita;
	Button stop1,stop2,stop3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count1ue = 0;
        count1naka = 1;
        count1sita = 2;
        count2ue = 0;
        count2naka = 1;
        count2sita = 2;
        count3ue = 0;
        count3naka = 1;
        count3sita = 2;
        text1ue = (TextView) findViewById(R.id.slot1ue);
        text1naka = (TextView) findViewById(R.id.slot1naka);
        text1sita = (TextView) findViewById(R.id.slot1sita);
        text2ue = (TextView) findViewById(R.id.slot2ue);
        text2naka = (TextView) findViewById(R.id.slot2naka);
        text2sita = (TextView) findViewById(R.id.slot2sita);
        text3ue = (TextView) findViewById(R.id.slot3ue);
        text3naka = (TextView) findViewById(R.id.slot3naka);
        text3sita = (TextView) findViewById(R.id.slot3sita);
        text1ue.setText(count1ue.toString());
        text2ue.setText(count2ue.toString());
        text3ue.setText(count3ue.toString());
        text1naka.setText(count1naka.toString());
        text2naka.setText(count2naka.toString());
        text3naka.setText(count3naka.toString());
        text1sita.setText(count1sita.toString());
        text2sita.setText(count2sita.toString());
        text3sita.setText(count3sita.toString());
        
        stop1 =(Button)findViewById(R.id.stop1);
        
        
        stop1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 
            }
        });
        
        
        updateText = new Runnable() {
            public void run() {
            	count1ue -= 1;                
            	count1naka -= 1;
                count1sita -= 1;
                count1ue = checknum(count1ue);
                count1naka = checknum(count1naka);
                count1sita = checknum(count1sita);
                text1ue.setText(count1ue.toString());
                text1naka.setText(count1naka.toString());
                text1sita.setText(count1sita.toString());
                text1ue = checkcolor(count1ue,text1ue);
                text1naka = checkcolor(count1naka,text1naka);
                text1sita = checkcolor(count1sita,text1sita);
                mHandler.removeCallbacks(updateText);
                mHandler.postDelayed(updateText, 100);
            }
        };
        
        updateText2 = new Runnable() {
            public void run() { 
            	count2ue -= 1;                
            	count2naka -= 1;
                count2sita -= 1;
                count2ue = checknum(count2ue);
                count2naka = checknum(count2naka);
                count2sita = checknum(count2sita);
                text2ue.setText(count2ue.toString());
                text2naka.setText(count2naka.toString());
                text2sita.setText(count2sita.toString());
                text2ue = checkcolor(count2ue,text2ue);
                text2naka = checkcolor(count2naka,text2naka);
                text2sita = checkcolor(count2sita,text2sita);
                mHandler2.removeCallbacks(updateText2);
                mHandler2.postDelayed(updateText2, 100);
            }
        };
        
        updateText3 = new Runnable() {
            public void run() {
            	count3ue -= 1;                
            	count3naka -= 1;
                count3sita -= 1;
                count3ue = checknum(count3ue);
                count3naka = checknum(count3naka);
                count3sita = checknum(count3sita);
                text3ue.setText(count3ue.toString());
                text3naka.setText(count3naka.toString());
                text3sita.setText(count3sita.toString());
                text3ue = checkcolor(count3ue,text3ue);
                text3naka = checkcolor(count3naka,text3naka);
                text3sita = checkcolor(count3sita,text3sita);
                mHandler3.removeCallbacks(updateText3);
                mHandler3.postDelayed(updateText3, 100);
            }
        };
        
        stop2 =(Button)findViewById(R.id.stop2);
        
        
        stop2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
 
            }
        });
        
        stop2 =(Button)findViewById(R.id.stop2);
        
        
        stop2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        
        stop3 =(Button)findViewById(R.id.stop3);
        
        
        stop3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
 
            }
        });
        
        
        
        mHandler.postDelayed(updateText, 100);
        mHandler2.postDelayed(updateText2, 100);
        mHandler3.postDelayed(updateText3, 100);

        
        
    }
    
    public int checknum(int num){
    	int n = num;
    	if(n == -1){
    		n = 9;
    	}
    	return n;
    }
    
    public TextView checkcolor(int num,TextView view){
    	TextView n = view;
    	if(num == 7){
    		n.setTextColor(Color.RED);
    	}
    	else{
    		n.setTextColor(Color.BLACK);    		    		
    	}
    	return n;
    }
    
    
}
