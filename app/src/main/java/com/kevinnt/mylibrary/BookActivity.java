package com.kevinnt.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY = "bookId";

    private ImageView bookImage;
    private Button btnAddToCurrentlyRead , btnAddToWantToRead , btnAddToAlreadyRead , btnAddToFavourite;
    private TextView txtBookName, txtBookAuthor, txtBookPages, txtBookDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();

        Intent intent = getIntent();

        if(intent != null){
            int incomingBookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if(incomingBookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookById(incomingBookId);
                if(incomingBook != null){
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleCurrentlyRead(incomingBook);
                    handleWantToRead(incomingBook);
                    handleFavourite(incomingBook);
                }
            }

        }

    }


    private boolean isBookExist(ArrayList<Book> books, Book incomingBook){
        for(Book b : books){
            if(b.getId() == incomingBook.getId()){
                return true;
            }
        }
        return false;
    }

    private void handleFavourite(Book incomingBook) {

        if(isBookExist(Utils.getInstance(this).getFavouriteBooks(), incomingBook)){
            btnAddToFavourite.setEnabled(false);
        }
        else{
            btnAddToFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToFavouriteBooks(incomingBook)){
                        Toast.makeText(BookActivity.this, "Buku berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BookActivity.this, FavouriteActivity.class));
                    }else {
                        Toast.makeText(BookActivity.this, "Ada yang salah, Coba lagi!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void handleWantToRead(Book incomingBook) {

        if(isBookExist(Utils.getInstance(this).getWantToReadBooks(), incomingBook)){
            btnAddToWantToRead.setEnabled(false);
        }
        else{
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToWantToReadBooks(incomingBook)){
                        Toast.makeText(BookActivity.this, "Buku berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WishlistActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BookActivity.this, "Ada yang salah, Coba lagi!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }



    private void handleCurrentlyRead(Book incomingBook) {
        if(isBookExist(Utils.getInstance(this).getCurrentlyReadingBooks(), incomingBook)){
            btnAddToCurrentlyRead.setEnabled(false);
        }
        else{
            btnAddToCurrentlyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToCurrentlyReadingBooks(incomingBook)){
                        Toast.makeText(BookActivity.this, "Buku berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(BookActivity.this, "Ada yang salah, Coba lagi!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

    private void handleAlreadyRead(Book incomingBook) {
//        ArrayList<Book> books = Utils.getInstance().getAlreadyReadBooks();
//
//        boolean isExist = false;
//
//        for(Book b : books){
//            if(b == incomingBook){
//                isExist = true;
//            }
//        }

        if(isBookExist(Utils.getInstance(this).getAlreadyReadBooks(), incomingBook)){
            btnAddToAlreadyRead.setEnabled(false);
        }
        else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(BookActivity.this).addToAlreadyRead(incomingBook)){
                        Toast.makeText(BookActivity.this, "Buku berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, AlreadyReadActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BookActivity.this, "Ada yang salah, Coba lagi!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void setData(Book book) {
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookImage);

        txtBookName.setText(book.getName());
        txtBookAuthor.setText(book.getAuthor());
        txtBookPages.setText(Integer.toString(book.getPages()));
        txtBookDesc.setText(book.getLongDesc());
    }

    private void initView() {
        bookImage = findViewById(R.id.bookImage);
        btnAddToCurrentlyRead = findViewById(R.id.btnAddToCurrentRead);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToRead);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToFavourite = findViewById(R.id.btnAddToFavourite);
        txtBookName = findViewById(R.id.txtBookName);
        txtBookAuthor = findViewById(R.id.txtBookAuthor);
        txtBookPages = findViewById(R.id.txtBookPages);
        txtBookDesc = findViewById(R.id.txtBookDesc);
    }
}