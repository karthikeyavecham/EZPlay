package com.mycompany.myapp;

import android.app.*;
import android.bluetooth.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;

public class MainActivity extends Activity implements OnClickListener
{

	private static boolean BT_STATUS;
	private static boolean isEnabled;
	private static BluetoothAdapter bluetoothAdapter;
	@Override
	public void onClick(View p1)
	{
		Intent intent = new Intent(this,com.mycompany.myapp.GamePlayView.class);
		startActivity(intent);
		/*if(BT_STATUS==true)
		{
			btButton.setText("turn off");
			Toast.makeText(this,"turning on",Toast.LENGTH_SHORT).show();
		}
		else 
		{
			btButton.setText("turn on");
			Toast.makeText(this,"turning off",Toast.LENGTH_SHORT).show();
		}
		setBluetooth(BT_STATUS);
		*/
	}
	


	Button btButton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		btButton = (Button) findViewById(R.id.bt_button);
		btButton.setOnClickListener(this);
		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		bluetoothAdapter.setName("gamepad");
		
		isEnabled= bluetoothAdapter.isEnabled();
		BT_STATUS=isEnabled;
		
		
	
    }
	
	public static boolean setBluetooth(boolean enable) {
		isEnabled= bluetoothAdapter.isEnabled();
		if (enable && !isEnabled) {
			BT_STATUS=false;
			return bluetoothAdapter.enable(); 
		}
		else if(!enable && isEnabled) {
			BT_STATUS=true;
			return bluetoothAdapter.disable();
		}
		// No need to change bluetooth state
		return true;
	}
}
