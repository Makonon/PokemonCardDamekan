package makonon.pokemon.card.damekan;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.graphics.Color;

public class MainActivity extends Activity{
	
	TextView txtABattle;
	TextView txtABench1;
	TextView txtABench2;
	TextView txtABench3;
	TextView txtABench4;
	TextView txtABench5;
	TextView txtBBattle;
	TextView txtBBench1;
	TextView txtBBench2;
	TextView txtBBench3;
	TextView txtBBench4;
	TextView txtBBench5;
	TextView txtClr;
	TextView txtChg;
	TextView txtP10;
	TextView txtM10;
	TextView txtP50;
	TextView txtM50;
	
	int command = 0; //0:none 1:Clr 2:Chg 3:P10 4:M10 5:P50 6:M50
	int tmp = 0;
	String tmpstr = "";
	boolean chgmode = false;
	TextView txtTarget;
	TextView txtChgTarget;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		txtABattle = (TextView)findViewById(R.id.ABattle);
		txtABench1 = (TextView)findViewById(R.id.ABench1);
		txtABench2 = (TextView)findViewById(R.id.ABench2);
		txtABench3 = (TextView)findViewById(R.id.ABench3);
	    txtABench4 = (TextView)findViewById(R.id.ABench4);
		txtABench5 = (TextView)findViewById(R.id.ABench5);
		txtBBattle = (TextView)findViewById(R.id.BBattle);
		txtBBench1 = (TextView)findViewById(R.id.BBench1);
		txtBBench2 = (TextView)findViewById(R.id.BBench2);
		txtBBench3 = (TextView)findViewById(R.id.BBench3);
		txtBBench4 = (TextView)findViewById(R.id.BBench4);
		txtBBench5 = (TextView)findViewById(R.id.BBench5);
		txtClr = (TextView)findViewById(R.id.Clr);
		txtChg = (TextView)findViewById(R.id.Chg);
		txtP10 = (TextView)findViewById(R.id.P10);
		txtM10 = (TextView)findViewById(R.id.M10);
		txtP50 = (TextView)findViewById(R.id.P50);
		txtM50 = (TextView)findViewById(R.id.M50);
		
		onClickAllClr(null);
    }
	
	public void ValClr(){
		txtABattle.setText("0");
		txtABench1.setText("0");
		txtABench2.setText("0");
		txtABench3.setText("0");
		txtABench4.setText("0");
		txtABench5.setText("0");
		txtBBattle.setText("0");
		txtBBench1.setText("0");
		txtBBench2.setText("0");
		txtBBench3.setText("0");
		txtBBench4.setText("0");
		txtBBench5.setText("0");
	}
	
	public void CommandSet(int val){
		txtClr.setBackgroundColor(Color.YELLOW);
		txtChg.setBackgroundColor(Color.YELLOW);
		txtP10.setBackgroundColor(Color.YELLOW);
		txtM10.setBackgroundColor(Color.YELLOW);
		txtP50.setBackgroundColor(Color.YELLOW);
		txtM50.setBackgroundColor(Color.YELLOW);
		if(val != 0){txtTarget.setBackgroundColor(Color.RED);}
		command = val;
	}
	
	public void ChgClr(){
		if(chgmode == true){txtChgTarget.setBackgroundColor(Color.WHITE);}
		chgmode = false;
		txtChgTarget = null;
	}
	
	public void onClickAllClr(View view) {
		txtTarget = null;
		ValClr();
		CommandSet(0);
		ChgClr();
	}
	
	public void onClickClr(View view){
		txtTarget = txtClr;
		CommandSet(1);
		ChgClr();
	}
	
	public void onClickChg(View view){
		txtTarget = txtChg;
		CommandSet(2);
		ChgClr();
	}
	
	public void onClickP10(View view){
		txtTarget = txtP10;
		CommandSet(3);
		ChgClr();
	}
	
	public void onClickM10(View view){
		txtTarget = txtM10;
		CommandSet(4);
		ChgClr();
	}
	
	public void onClickP50(View view){
		txtTarget = txtP50;
		CommandSet(5);
		ChgClr();
	}
	
	public void onClickM50(View view){
		txtTarget = txtM50;
		CommandSet(6);
		ChgClr();
	}
	
	
	public void UpdateCard(){
		switch (command){
			case 1:
				txtTarget.setText("0");
				break;
			case 2:
				if(chgmode == false){
					chgmode = true;
					txtChgTarget = txtTarget;
					txtChgTarget.setBackgroundColor(Color.GREEN);
				}else{
					tmpstr = txtTarget.getText().toString();
					txtTarget.setText(txtChgTarget.getText().toString());
					txtChgTarget.setText(tmpstr);
					ChgClr();
				}
				break;
			case 3:
				UpdateDamage(10);
				break;
			case 4:
				UpdateDamage(-10);
				break;
			case 5:
				UpdateDamage(50);
				break;
			case 6:
				UpdateDamage(-50);
				break;
		}
	}
	
	public void UpdateDamage(int val){
		tmp = Integer.parseInt(txtTarget.getText().toString());
		tmp = tmp + val;
		if(tmp < 0){tmp = 0;}
		if(tmp > 990){tmp = 990;}
		txtTarget.setText(String.valueOf(tmp));
	}
	
	public void onClickABattle(View view){
		txtTarget = txtABattle;
		UpdateCard();
	}
	
	public void onClickABench1(View view){
		txtTarget = txtABench1;
		UpdateCard();
	}
	
	public void onClickABench2(View view){
		txtTarget = txtABench2;
		UpdateCard();
	}
	
	public void onClickABench3(View view){
		txtTarget = txtABench3;
		UpdateCard();
	}
	
	public void onClickABench4(View view){
		txtTarget = txtABench4;
		UpdateCard();
	}
	
	public void onClickABench5(View view){
		txtTarget = txtABench5;
		UpdateCard();
	}
	
	public void onClickBBattle(View view){
		txtTarget = txtBBattle;
		UpdateCard();
	}

	public void onClickBBench1(View view){
		txtTarget = txtBBench1;
		UpdateCard();
	}

	public void onClickBBench2(View view){
		txtTarget = txtBBench2;
		UpdateCard();
	}

	public void onClickBBench3(View view){
		txtTarget = txtBBench3;
		UpdateCard();
	}

	public void onClickBBench4(View view){
		txtTarget = txtBBench4;
		UpdateCard();
	}

	public void onClickBBench5(View view){
		txtTarget = txtBBench5;
		UpdateCard();
	}
}
