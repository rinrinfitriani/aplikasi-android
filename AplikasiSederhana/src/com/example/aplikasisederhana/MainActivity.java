package com.example.aplikasisederhana;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText Nama, JenisKelamin, Umur, Hobi;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Nama = (EditText)findViewById(R.id.txtNama);
        JenisKelamin = (EditText)findViewById(R.id.txtJnsKelamin);
        Umur = (EditText)findViewById(R.id.txtUmur);
        Hobi = (EditText)findViewById(R.id.txtHobi);
        
        
       
    }
    
    
    public void BtnSimpan (View v){
    	
    	ArrayList<NameValuePair> parameter = new ArrayList<NameValuePair>();
    	parameter.add(new BasicNameValuePair("nama", Nama.getText().toString()));
    	parameter.add(new BasicNameValuePair("jeniskelamin", JenisKelamin.getText().toString()));
    	parameter.add(new BasicNameValuePair("umur", Umur.getText().toString()));
    	parameter.add(new BasicNameValuePair("hobi", Hobi.getText().toString()));
    	String respon = null;
    	
    	try {
			respon = Sever.executeHttpPost("http://10.0.2.2/android/koneksi.php", parameter);
			String res = respon.toString();
			res = res.trim();
			res=res.replaceAll("\\s", "");
			if(res.equals("1")){
				
				Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_LONG).show();
				
			}else{
				
				Toast.makeText(getApplicationContext(), "Data Tersimpan ke Server", Toast.LENGTH_LONG).show();
				
			}
		} catch (Exception e) {
			
			Toast.makeText(getApplicationContext(), "Error :"+ e.toString(), Toast.LENGTH_LONG).show();
		}
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
