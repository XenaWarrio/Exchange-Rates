package dx.queen.projectwithguys.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import dx.queen.projectwithguys.R;


public class MainActivity extends AppCompatActivity implements InterfaceForFragments {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openMainFragment();
    }

    private void openMainFragment(){
        Log.d("TAG", "OPEN FIRST FRAGMENT");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentholder, MainFragment.newInstance(this))
                .commit();
    }

    private void openDetailsFragment(int position){
        Log.d("TAG", "OPEN SECOND FRAGMENT");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentholder, DetailFragment.newInstance(position))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void openDetailFragment(int position) {
        openDetailsFragment(position);
    }
}
