package edu.csueb.android.zoodirectory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.nameTextView.setText(animal.getName());
        holder.imageView.setImageResource(animal.getImageResId());
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
