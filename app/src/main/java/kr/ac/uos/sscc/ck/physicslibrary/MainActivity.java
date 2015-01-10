package kr.ac.uos.sscc.ck.physicslibrary;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		addMenuCard();
	}

	private void addMenuCard() {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft;

		ft = fm.beginTransaction();
		ft.add(R.id.main_layout, MenuCard.newInstance(R.drawable.board, getString(R.string.board)))
				.commit();

		ft = fm.beginTransaction();
		ft.add(R.id.main_layout, MenuCard.newInstance(R.drawable.library_services, getString(R.string.library_services)))
				.commit();

		ft = fm.beginTransaction();
		ft.add(R.id.main_layout, MenuCard.newInstance(R.drawable.my_page, getString(R.string.my_page)))
				.commit();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
