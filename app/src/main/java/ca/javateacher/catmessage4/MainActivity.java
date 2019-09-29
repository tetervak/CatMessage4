package ca.javateacher.catmessage4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
    implements InputFragment.InputListener{

  private static final String ABOUT_FRAGMENT_TAG = "aboutFragment";

  // it is the layout fragment
  private OutputFragment mOutputFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // lookup the layout fragment
    mOutputFragment = (OutputFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragment_output);
    assert mOutputFragment != null;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.about) {
      showAbout();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void showAbout() {
    AboutFragment aboutFragment = AboutFragment.newInstance();
    aboutFragment.show(getSupportFragmentManager(), ABOUT_FRAGMENT_TAG);
  }

  @Override
  public void updateMessage(String text) {
      mOutputFragment.updateMessage(text);
  }
}
