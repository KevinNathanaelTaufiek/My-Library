package com.kevinnt.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSeeAllBooks, btnCurentlyReadingBooks, btnAlreadyReadBooks, btnWishlist, btnSeeFavourites, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        Utils.getInstance(this);

        btnSeeAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAlreadyReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });

        btnCurentlyReadingBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadActivity.class);
                startActivity(intent);
            }
        });

        btnWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });

        btnSeeFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavouriteActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.app_name);
                builder.setMessage("this app is made by kevin,\n" + "want to know more about me?\n" + "Click the visit button :)");
                builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);

                        intent.putExtra("url","https://kevinnathanaeltaufiek.github.io/");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });

    }

    private void initViews() {
        btnSeeAllBooks = findViewById(R.id.btnSeeAllBooks);
        btnCurentlyReadingBooks = findViewById(R.id.btnCurrentlyReadingBooks);
        btnAlreadyReadBooks = findViewById(R.id.btnAlreadyReadBooks);
        btnWishlist = findViewById(R.id.btnWishlist);
        btnSeeFavourites = findViewById(R.id.btnSeeFavourites);
        btnAbout = findViewById(R.id.btnAbout);
    }
}