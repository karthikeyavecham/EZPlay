package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.view.View.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.content.pm.*;

public class GamePlayView extends Activity implements OnTouchListener
{

	LinearLayout view;
	TextView test;
	float x,y;
	Display display;
	int screenWidth;
	int screenHeight;
	
	@Override
	public boolean onTouch(View p1, MotionEvent p2)
	{
		int action = p2.getAction();
		// TODO: Implement this method
		x=p2.getX();
		y=p2.getY();
		test.setText(""+MotionEvent.ACTION_UP);
		if(action==MotionEvent.ACTION_DOWN || action==MotionEvent.ACTION_UP || action==MotionEvent.ACTION_MOVE)
		{
			test.setText(""+x+","+y);
			
			if(x<=screenWidth/2)
			{
				
				test.append("brake");
			}
			else
			{
				test.append("nitro");
			}
		}
		return true;
	}

	public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
							 WindowManager.LayoutParams.FLAG_FULLSCREEN
							 );
		
        setContentView(R.layout.gameview);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		view = (LinearLayout) findViewById(R.id.lay_view);
		view.setSystemUiVisibility(    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
								   | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
								   | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
								   | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
								   | View.SYSTEM_UI_FLAG_FULLSCREEN
								   | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		test= (TextView) findViewById(R.id.show_touch);
		view.setOnTouchListener(this);
		display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		screenWidth = size.x;
		screenHeight = size.y;


    }
	
	
	
}
