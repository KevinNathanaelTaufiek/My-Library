package com.kevinnt.mylibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Utils extends SQLiteOpenHelper {

    public static final String ALLBOOKS_TABLE = "ALLBOOKS";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String AUTHOR_COLUMN = "author";
    public static final String PAGES_COLUMN = "pages";
    public static final String IMAGE_URL_COLUMN = "imageUrl";
    public static final String SHORT_DESC_COLUMN = "shortDesc";
    public static final String LONG_DESC_COLUMN = "longDesc";
    public static final String EXPANDED_COLUMN = "expanded";
    public static final String ALREADY_READ_TABLE = "ALREADY_READ";
    public static final String CURRENTLY_READ_TABLE = "CURRENTLY_READ";
    public static final String FAVOURITE_TABLE = "FAVOURITE";
    public static final String WISHLIST_TABLE = "WISHLIST";
    public static final String BOOK_ID_COLUMN = "bookId";
    private static final String TAG = "UTILS";
    public static Utils instance;

    public Utils(@Nullable Context context) {
        super(context, "book.db", null, 1);

        Log.d(TAG, "Utils: CONSTRUCT START");

        if(getAllBooks().isEmpty()){
            addToAllBooks(new Book(1,"kuala kumal", "raditya dika", 263, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
            addToAllBooks(new Book(2,"Rich Dad Poor Dad", "Robert T. Kiosaki", 270, "https://1.bp.blogspot.com/-dOkvNvHwrs4/XW0ydMQdoiI/AAAAAAAANkM/nuB0i5JZKIcDFd3uz8YAcexkM7S6mjpWwCLcBGAs/s1600/Ringkasan%2Bbuku%2Brich%2Bdad%2Bpoor%2Bdad.png", "ini bukunya Om Robert Kiosaki", "Rich Dad Poor Dad adalah buku tahun 1997 karya Robert Kiyosaki dan Sharon Lechter. Rich Dad, Poor Dad adalah buku yang membahas masalah finansial yang dihadapi banyak orang dikarenakan ajaran keliru orang tua mereka mengenai keuangan, yang juga dialaminya semasa kecil dan remaja."));
            addToAllBooks(new Book(3,"Think and Grow Rich", "Napoleon Hill", 134, "https://ebooks.gramedia.com/ebook-covers/47982/image_highres/ID_TGR2019MTH06TGR.jpg", "ini bukunya kakek napoleon hill", "Think and Grow Rich adalah karya fundamental sang penulis buku sukses legendaris, Napoleon Hill. Buku yang pertama kali diterbitkan tahun 1937 ini sekarang tetap sama ampuhnya—dan akan mengubah kehidupan Anda selamanya. Bisa dibilang mustahil menemukan motivator yang sama sekali tidak terpengaruh oleh karya Hill."));
            addToAllBooks(new Book(4,"Anak Muda Miliarder Saham", "Andika Sutoro Putra", 144, "https://s3-ap-southeast-1.amazonaws.com/ebook-previews/42008/152964/1.jpg", "ini bukunya Andika S", "Apakah Anda sedang mencari panduan step-by-step untuk menjadi full time investor yang sukses? Sudah lama berkecimpung di pasar modal namun belum juga bisa menghasilkan profit yang konsisten? Bagaimana cara membangun passive income dari investasi saham?"));
            addToAllBooks(new Book(5,"Mantappu Jiwa *Buku Latihan Soal", "Jerome Polin", 228, "https://ebooks.gramedia.com/ebook-covers/48730/image_highres/ID_MJ2019MTH08MJ.jpg", "Ini bukunya bang jerome", "Tanggal rilis: 19 August 2019.\n" +
                    "“Jadi ini buku latihan soal matematika ya, Jer?”\n" +
                    "\n" +
                    "Bukan!\n" +
                    "\n" +
                    "Kata orang, selama masih hidup, manusia akan terus menghadapi masalah demi masalah. Dan itulah yang akan kuceritakan dalam buku ini, yaitu bagaimana aku menghadapi setiap persoalan di dalam hidupku. Dimulai dari aku yang lahir dekat dengan hari meletusnya kerusuhan di tahun 1998, bagaimana keluargaku berusaha menyekolahkanku dengan kondisi ekonomi yang terbatas, sampai pada akhirnya aku berhasil mendapatkan beasiswa penuh S1 di Jepang.\n" +
                    "\n" +
                    "Manusia tidak akan pernah lepas dari masalah kehidupan, betul. Tapi buku ini tidak hanya berisi cerita sedih dan keluhan ini-itu. Ini adalah catatan perjuanganku sebagai Jerome Polin Sijabat, pelajar Indonesia di Jepang yang iseng memulai petualangan di YouTube lewat channel Nihongo Mantappu.\n" +
                    "\n" +
                    "Yuk, naik roller coaster di kehidupanku yang penuh dengan kalkulasi seperti matematika.\n" +
                    "\n" +
                    "It may not gonna be super fun, but I promise it would worth the ride.\n" +
                    "\n" +
                    "Minasan, let’s go, MANTAPPU JIWA!"));
            addToAllBooks(new Book(6,"The Subtle Art of Not Giving a F*ck", "Mark Manson", 246, "https://media.karousell.com/media/photos/products/2018/06/27/the_subtle_art_of_not_giving_a_fuck_mark_manson_1530042590_c7549d39_progressive.jpg", "Ini bukunya om mark", "Sebuah Seni untuk Bersikap Bodo Amat: Pendekatan yang Waras Demi Menjalani Hidup yang Baik atau The Subtle Art of Not Giving a F*ck: A Counterintuitive Approach to Living a Good Life adalah buku pertama Mark Manson, seorang narablog kenamaan dengan lebih dari 2 juta pembaca. Dia tinggal di kota New York."));
            addToAllBooks(new Book(7,"The Art of War", "Sun Tzu", 154, "https://ebooks.gramedia.com/ebook-covers/34013/image_highres/ID_GPU2016MTH08TAOWMSTPASZ.jpg", "Ini buku dah lama, bukunya eyang Sun Tzu", "\"The Art Of War\" atau \"Seni Perang Sun Zi\" adalah sebuah buku filsafat militer yang diperkirakan ditulis pada abad ke-6 oleh Sun Zi. Terdiri dari 13 bab di mana setiap bagian membahas strategi dan berbagai metode perang."));
            addToAllBooks(new Book(8,"Dilan 1990", "Pidi Baiq", 333, "https://ebooks.gramedia.com/ebook-covers/31754/big_covers/ID_MIZ2016MTH03DDADT_B.jpg", "Dulu kita masih remaja, kesarang juga masih deng xixixi", "Tanggal rilis: 10 March 2016.\n" +
                    "“Milea, kamu cantik, tapi aku belum mencintaimu.\n" +
                    "\n" +
                    "Enggak tahu kalau sore.Tunggu aja.”\n" +
                    "\n" +
                    "(Dilan 1990)\n" +
                    "\n" +
                    "“Milea, jangan pernah bilang ke aku ada yang menyakitimu, nanti, besoknya, orang itu akan hilang.”\n" +
                    "\n" +
                    "(Dilan 1990)\n" +
                    "\n" +
                    "“Cinta sejati adalah kenyamanan, kepercayaan, dan dukungan.\n" +
                    "\n" +
                    "Kalau kamu tidak setuju, aku tidak peduli.”\n" +
                    "\n" +
                    "(Milea 1990)"));
            addToAllBooks(new Book(9,"Dilan 1991", "Pidi Baiq", 345, "https://ebooks.gramedia.com/ebook-covers/31755/big_covers/ID_MIZ2016MTH03DDADT1_B.jpg", "Lanjutannya Dilan 1990 nih, masih remaja kok", "Tanggal rilis: 10 March 2016.\n" +
                    "Jika aku berkata bahwa aku mencintainya, maka itu adalah sebuah pernyataan yang sudah cukup lengkap.\"\"\n" +
                    "\n" +
                    "-Milea\n" +
                    "\n" +
                    "\"\"Senakal-nakalnya anak geng motor, Lia, mereka shalat pada waktu ujian praktek Agama.\"\"\n" +
                    "\n" +
                    "-Dilan\n" +
                    "\n" +
                    "@Viny_JKT48 \"\"Aku suka Dilan-nya Kak Pidi Baiq. Baru beli, tapi sudah aku baca dua kali lho~ Buku yang menyenangkan, jadi ingin kenal Dilan XD.\"\"\n" +
                    "\n" +
                    "@renindydevris \"\"Kukira cinta hanya sebatas kenal, bilang, dan jadi. Tetapi ternyata cinta itu bisa dibuat jadi seni yang amat menarik.\"\"\n" +
                    "\n" +
                    "@yusuf_imam29 \"\"Terima kasih, Dilan. Dirimu telah mengajarkanku tentang banyak hal. Terutama tentang mengistimewakan wanita.\"\"\n" +
                    "\n" +
                    "@IanisJanuar \"\"Selama hampir 27 tahun hidup, baru pertama kali baca novel sampe tamat. Thank You, Dilan.\"\"\n" +
                    "\n" +
                    "@rudijatjahja \"\"Hatur nuhun Surayah Pidi Baiq, sudah merawat selera tawa yang dibalut kisah bahagia dua sejoli Dilan dan Milea.\"\"\n" +
                    "\n" +
                    "@alirohman21 \"\"Bukan hanya novel tentang cinta remaja biasa, tapi juga cara mengungkapkan rasa sayang di luar kebiasaan.\"\"\n" +
                    "\n" +
                    "@saljuapi \"\"The greatest love story the world has ever known.\"\"\n" +
                    "\n" +
                    "@Tedy_Pensil \"\"Jika buku ini kumpulan rumus Fisika yang akan diujikan maka banyak pelajar yang membakarnya dan mengonsumsi abunya."));
        }

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + ALLBOOKS_TABLE + " (" +
                ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME_COLUMN + " TEXT, " +
                AUTHOR_COLUMN + " TEXT, " +
                PAGES_COLUMN + " INTEGER, " +
                IMAGE_URL_COLUMN + " TEXT, " +
                SHORT_DESC_COLUMN + " TEXT, " +
                LONG_DESC_COLUMN + " TEXT, " +
                EXPANDED_COLUMN + " BOOL)";

        db.execSQL(query);

        query = "CREATE TABLE " + ALREADY_READ_TABLE + " ( " + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BOOK_ID_COLUMN + " INTEGER, FOREIGN KEY ("+BOOK_ID_COLUMN+") " +
                "       REFERENCES " + ALLBOOKS_TABLE + " (" + ID_COLUMN + ") )";
        db.execSQL(query);
        query = "CREATE TABLE " + CURRENTLY_READ_TABLE + " ( " + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BOOK_ID_COLUMN + " INTEGER, FOREIGN KEY ("+BOOK_ID_COLUMN+") " +
                "       REFERENCES " + ALLBOOKS_TABLE + " (" + ID_COLUMN + ") )";
        db.execSQL(query);
        query = "CREATE TABLE " + FAVOURITE_TABLE + " ( " + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BOOK_ID_COLUMN + " INTEGER, FOREIGN KEY ("+BOOK_ID_COLUMN+") " +
                "       REFERENCES " + ALLBOOKS_TABLE + " (" + ID_COLUMN + ") )";
        db.execSQL(query);
        query = "CREATE TABLE " + WISHLIST_TABLE + " ( " + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BOOK_ID_COLUMN + " INTEGER, FOREIGN KEY ("+BOOK_ID_COLUMN+") " +
                "       REFERENCES " + ALLBOOKS_TABLE + " (" + ID_COLUMN + ") )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    private Utils() {
//        allBooks = new ArrayList<>();
//        currentlyReadingBooks = new ArrayList<>();
//        favouriteBooks = new ArrayList<>();
//        wantToReadBooks = new ArrayList<>();
//        alreadyReadBooks = new ArrayList<>();
//        allBooks.add(new Book(1,"kuala kumal", "raditya dika", 134, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
//        allBooks.add(new Book(2,"Rich Dad Poor Dad", "Robert T. Kiosaki", 270, "https://1.bp.blogspot.com/-dOkvNvHwrs4/XW0ydMQdoiI/AAAAAAAANkM/nuB0i5JZKIcDFd3uz8YAcexkM7S6mjpWwCLcBGAs/s1600/Ringkasan%2Bbuku%2Brich%2Bdad%2Bpoor%2Bdad.png", "ini bukunya Om Robert Kiosaki", "Rich Dad Poor Dad adalah buku tahun 1997 karya Robert Kiyosaki dan Sharon Lechter. Rich Dad, Poor Dad adalah buku yang membahas masalah finansial yang dihadapi banyak orang dikarenakan ajaran keliru orang tua mereka mengenai keuangan, yang juga dialaminya semasa kecil dan remaja."));
//        allBooks.add(new Book(3,"Think and Grow Rich", "Napoleon Hill", 134, "https://ebooks.gramedia.com/ebook-covers/47982/image_highres/ID_TGR2019MTH06TGR.jpg", "ini bukunya kakek napoleon hill", "Think and Grow Rich adalah karya fundamental sang penulis buku sukses legendaris, Napoleon Hill. Buku yang pertama kali diterbitkan tahun 1937 ini sekarang tetap sama ampuhnya—dan akan mengubah kehidupan Anda selamanya. Bisa dibilang mustahil menemukan motivator yang sama sekali tidak terpengaruh oleh karya Hill."));
//        allBooks.add(new Book(4,"Anak Muda Miliarder Saham", "Andika Sutoro Putra", 134, "https://s3-ap-southeast-1.amazonaws.com/ebook-previews/42008/152964/1.jpg", "ini bukunya Andika S", "Apakah Anda sedang mencari panduan step-by-step untuk menjadi full time investor yang sukses? Sudah lama berkecimpung di pasar modal namun belum juga bisa menghasilkan profit yang konsisten? Bagaimana cara membangun passive income dari investasi saham?"));
//        allBooks.add(new Book(5,"kuala kumala", "raditya dika", 134, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
//        allBooks.add(new Book(6,"kuala Kalem", "raditya Kemal", 134, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
//        allBooks.add(new Book(7,"kuala Pulkam", "raditya dika", 134, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
//        allBooks.add(new Book(8,"kuala Kelam", "raditya Kemal", 134, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
//        allBooks.add(new Book(9,"kuala Kusam", "raditya dika", 134, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
//        allBooks.add(new Book(10,"kuala Kesal", "raditya Kemal", 134, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
//        allBooks.add(new Book(10,"kuala Kesal", "raditya Kemal", 134, "https://cdn.gramedia.com/uploads/items/9789797807696_kuala_kumal__w600_hauto.jpg", "ini bukunya radit", "Koala Kumal merupakan film komedi romantis Indonesia yang dirilis 5 Juli 2016. Film ini dibintangi oleh Raditya Dika dan Acha Septriasa, serta menjadi film debut bagi penyanyi Sheryl Sheinafia. Diadaptasi dari novel berjudul sama karya Raditya Dika. Film ini menjadi film Raditya Dika dengan jumlah artis cameo terbanyak hingga saat ini."));
//    }

    public static Utils getInstance(Context context){

        if(instance == null){
            instance = new Utils(context);

            return  instance;
        }
        else{
            return  instance;
        }
    }

    public Book getBookById(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM "+ ALLBOOKS_TABLE
                + " WHERE "+ ID_COLUMN + " = " + id;

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            Book b = new Book(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)
            );
            return b;
        }

        return null;
    }

    public ArrayList<Book> getAllBooks() {

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ ALLBOOKS_TABLE;

        Cursor cursor = db.rawQuery(query, null);

        List<Book> allBook = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                Book b = new Book(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                allBook.add(b);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return (ArrayList<Book>) allBook;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ ALLBOOKS_TABLE+
                " INNER JOIN " + ALREADY_READ_TABLE+
                " ON "+ALLBOOKS_TABLE+"."+ID_COLUMN+" = "+ALREADY_READ_TABLE+"."+BOOK_ID_COLUMN;

        Cursor cursor = db.rawQuery(query, null);

        List<Book> alreadyReadBook = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                Book b = new Book(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                alreadyReadBook.add(b);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return (ArrayList<Book>) alreadyReadBook;
    }

    public ArrayList<Book> getCurrentlyReadingBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ ALLBOOKS_TABLE+
                " INNER JOIN " + CURRENTLY_READ_TABLE+
                " ON "+ALLBOOKS_TABLE+"."+ID_COLUMN+" = "+CURRENTLY_READ_TABLE+"."+BOOK_ID_COLUMN;

        Cursor cursor = db.rawQuery(query, null);

        List<Book> currentlyReadBook = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                Book b = new Book(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                currentlyReadBook.add(b);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return (ArrayList<Book>) currentlyReadBook;
    }

    public ArrayList<Book> getFavouriteBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ ALLBOOKS_TABLE+
                " INNER JOIN " + FAVOURITE_TABLE+
                " ON "+ALLBOOKS_TABLE+"."+ID_COLUMN+" = "+FAVOURITE_TABLE+"."+BOOK_ID_COLUMN;

        Cursor cursor = db.rawQuery(query, null);

        List<Book> favouriteBook = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                Book b = new Book(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                favouriteBook.add(b);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return (ArrayList<Book>) favouriteBook;
    }

    public ArrayList<Book> getWantToReadBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ ALLBOOKS_TABLE+
                " INNER JOIN " + WISHLIST_TABLE+
                " ON "+ALLBOOKS_TABLE+"."+ID_COLUMN+" = "+WISHLIST_TABLE+"."+BOOK_ID_COLUMN;

        Cursor cursor = db.rawQuery(query, null);

        List<Book> wishlistBook = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                Book b = new Book(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                wishlistBook.add(b);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return (ArrayList<Book>) wishlistBook;
    }


    public boolean addToAllBooks(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME_COLUMN, b.getName());
        contentValues.put(AUTHOR_COLUMN, b.getAuthor());
        contentValues.put(PAGES_COLUMN, b.getPages());
        contentValues.put(IMAGE_URL_COLUMN, b.getImageUrl());
        contentValues.put(SHORT_DESC_COLUMN, b.getShortDesc());
        contentValues.put(LONG_DESC_COLUMN, b.getLongDesc());
        contentValues.put(EXPANDED_COLUMN, b.getExpanded());

        db.insert(ALLBOOKS_TABLE, null, contentValues);
        return true;
    }

    public boolean addToAlreadyRead(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BOOK_ID_COLUMN, b.getId());

        db.insert(ALREADY_READ_TABLE, null, contentValues);
        return true;
    }
    public boolean addToCurrentlyReadingBooks(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BOOK_ID_COLUMN, b.getId());

        db.insert(CURRENTLY_READ_TABLE, null, contentValues);
        return true;
    }
    public boolean addToFavouriteBooks(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BOOK_ID_COLUMN, b.getId());

        db.insert(FAVOURITE_TABLE, null, contentValues);
        return true;
    }
    public boolean addToWantToReadBooks(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BOOK_ID_COLUMN, b.getId());

        db.insert(WISHLIST_TABLE, null, contentValues);
        return true;
    }

    public boolean removeFromCurrentlyRead(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+ CURRENTLY_READ_TABLE
                + " WHERE " + BOOK_ID_COLUMN + " = " + b.getId();
        db.execSQL(query);

        return true;
    }
    public boolean removeFromAlreadyRead(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+ ALREADY_READ_TABLE
                + " WHERE " + BOOK_ID_COLUMN + " = " + b.getId();
        db.execSQL(query);

        return true;
    }
    public boolean removeFromFavourite(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+ FAVOURITE_TABLE
                + " WHERE " + BOOK_ID_COLUMN + " = " + b.getId();
        db.execSQL(query);

        return true;
    }
    public boolean removeFromWishlist(Book b){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+ WISHLIST_TABLE
                + " WHERE " + BOOK_ID_COLUMN + " = " + b.getId();
        db.execSQL(query);

        return true;
    }

}
