package com.kevinnt.mylibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static com.kevinnt.mylibrary.BookActivity.BOOK_ID_KEY;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Book> books = new ArrayList<>();
    private String activity;

    public BookRecViewAdapter(Context context, String activity) {
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtBookTitle.setText(books.get(position).getName());
        Glide.with(context).asBitmap().load(books.get(position).getImageUrl()).into(holder.ivPicture);

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtShortDesc.setText(books.get(position).getShortDesc());

        if(books.get(position).getExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.arrowDown.setVisibility(View.GONE);
        }
        else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.arrowDown.setVisibility(View.VISIBLE);
        }

        if (activity.equals("allBooks")){
            holder.btnDelete.setVisibility(View.GONE);
        }
        else if(activity.equals("currentlyRead")){
            holder.btnDelete.setVisibility(View.VISIBLE);

            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Apakah kamu yakin ingin menghapus "+ books.get(position).getName()+ "?");
                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(Utils.getInstance(context).removeFromCurrentlyRead(books.get(position))){
                                Toast.makeText(context, "Buku berhasil dihapus", Toast.LENGTH_SHORT).show();
                                books.remove(books.get(position));
                                notifyDataSetChanged();
                            }
                            else{
                                Toast.makeText(context, "Terdapat kesalahan, Coba lagi!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }
            });


        }
        else if(activity.equals("alreadyRead")){

            holder.btnDelete.setVisibility(View.VISIBLE);

            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Apakah kamu yakin ingin menghapus "+ books.get(position).getName()+ "?");
                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(Utils.getInstance(context).removeFromAlreadyRead(books.get(position))){
                                Toast.makeText(context, "Buku berhasil dihapus", Toast.LENGTH_SHORT).show();
                                books.remove(books.get(position));
                                notifyDataSetChanged();
                            }
                            else{
                                Toast.makeText(context, "Terdapat kesalahan, Coba lagi!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }
            });

        }
        else if(activity.equals("favourite")){

            holder.btnDelete.setVisibility(View.VISIBLE);

            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Apakah kamu yakin ingin menghapus "+ books.get(position).getName()+ "?");
                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(Utils.getInstance(context).removeFromFavourite(books.get(position))){
                                Toast.makeText(context, "Buku berhasil dihapus", Toast.LENGTH_SHORT).show();
                                books.remove(books.get(position));
                                notifyDataSetChanged();
                            }
                            else{
                                Toast.makeText(context, "Terdapat kesalahan, Coba lagi!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }
            });

        }
        else if(activity.equals("wishlist")){

            holder.btnDelete.setVisibility(View.VISIBLE);

            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Apakah kamu yakin ingin menghapus "+ books.get(position).getName()+ "?");
                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(Utils.getInstance(context).removeFromWishlist(books.get(position))){
                                Toast.makeText(context, "Buku berhasil dihapus", Toast.LENGTH_SHORT).show();
                                books.remove(books.get(position));
                                notifyDataSetChanged();
                            }
                            else{
                                Toast.makeText(context, "Terdapat kesalahan, Coba lagi!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }
            });

        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookActivity.class);
                intent.putExtra(BOOK_ID_KEY, books.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private TextView txtBookTitle;
        private ImageView ivPicture;

        private ImageView arrowDown, arrowUp;
        private TextView txtAuthor, txtShortDesc;
        private RelativeLayout expandedRelLayout;

        private TextView btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            txtBookTitle = itemView.findViewById(R.id.txtBookTitle);
            ivPicture = itemView.findViewById(R.id.ivPicture);

            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            arrowDown = itemView.findViewById(R.id.ivArrowDown);
            arrowUp = itemView.findViewById(R.id.ivArrowUp);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtShortDesc = itemView.findViewById(R.id.txtShortDesc);

            btnDelete = itemView.findViewById(R.id.btnDelete);

            arrowDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.getExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            arrowUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.getExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
