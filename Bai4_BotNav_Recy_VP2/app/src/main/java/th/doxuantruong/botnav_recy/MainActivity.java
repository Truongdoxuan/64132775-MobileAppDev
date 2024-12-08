package th.doxuantruong.botnav_recy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import th.doxuantruong.botnav_recy.databinding.ActivityMainBinding;
import th.doxuantruong.botnav_recy.fragments.CN1_Fragment;
import th.doxuantruong.botnav_recy.fragments.CN2_Fragment;
import th.doxuantruong.botnav_recy.fragments.CN3_Fragment;
import th.doxuantruong.botnav_recy.fragments.CN4_Fragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new CN1_Fragment());

        binding.bottomNavigation.setBackground(null);

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_cn1) {
                replaceFragment(new CN1_Fragment());
            } else if (item.getItemId() == R.id.nav_cn2) {
                replaceFragment(new CN2_Fragment());
            } else if (item.getItemId() == R.id.nav_cn3) {
                replaceFragment(new CN3_Fragment());
            } else if (item.getItemId() == R.id.nav_cn4) {
                replaceFragment(new CN4_Fragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
