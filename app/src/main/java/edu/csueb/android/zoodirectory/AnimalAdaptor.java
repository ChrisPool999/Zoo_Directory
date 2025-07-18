package edu.csueb.android.zoodirectory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdaptor extends RecyclerView.Adapter<AnimalAdaptor.AnimalViewHolder> {
    private List<Animal> animalList;
    private Context context;

    public AnimalAdaptor(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.animal_list_item, parent, false);
        return new AnimalViewHolder(view);
    }

    private void openAnimalDetails(Animal animal) {
        Intent intent = new Intent(context, AnimalDetailActivity.class);
        intent.putExtra("animal_name", animal.getName());
        intent.putExtra("animal_description", animal.getDescription());
        intent.putExtra("animal_image", animal.getImageResId());
        context.startActivity(intent);
    }

    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.nameTextView.setText(animal.getName());
        holder.imageView.setImageResource(animal.getImageResId());


        holder.itemView.setOnClickListener(v -> {
            if (position == animalList.size() - 1) {
                new AlertDialog.Builder(context)
                        .setTitle("Warning")
                        .setMessage("This animal is very scary. Do you want to proceed?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            openAnimalDetails(animal);
                        })
                        .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                        .show();
            } else {
                openAnimalDetails(animal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.animalImageView);
            nameTextView = itemView.findViewById(R.id.animalNameTextView);
        }
    }
}