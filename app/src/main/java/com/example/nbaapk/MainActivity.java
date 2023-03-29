package com.example.nbaapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.example.nbaapk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    private ActivityMainBinding binding;
    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //nav_bottom
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);

    }
    //back app
    private void showExitDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to exit ?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            finish();
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    @Override
    public void onBackPressed() {
        this.doubleBackToExitPressedOnce = true;
        showExitDialog();
        new Handler(Looper.getMainLooper()).postDelayed(new  Runnable(){
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;}
        }, 2000);
    }

}