package com.example.MedicApp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AnalisAdapter extends RecyclerView.Adapter<AnalisAdapter.ViewHolder>{

    AnalisData[] AnalisData;
    Context context;

    public AnalisAdapter(AnalisData[] AnalisData, TrueMainActivity activity) {
        this.AnalisData = AnalisData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.analis_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AnalisData analisDataList = AnalisData[position];
        holder.AnalisName.setText(analisDataList.getAnalisName());
        holder.AnalisDate.setText(analisDataList.getAnalisDate());
        holder.AnalisPrice.setText(analisDataList.getAnalisPrice());
        holder.AnalisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetStyle);
                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet, (ViewGroup) v.getRootView(), false);

                TextView AnalisName = sheetView.findViewById(R.id.Name);
                TextView AnalisDate = sheetView.findViewById(R.id.Date);
                TextView AnalisDescription = sheetView.findViewById(R.id.Description);
                TextView AnalisPreparation = sheetView.findViewById(R.id.Preparation);
                TextView AnalisBiomaterial = sheetView.findViewById(R.id.Biomaterial);
                Button AnalisButton = sheetView.findViewById(R.id.Button);
                ImageButton CloseButton = sheetView.findViewById(R.id.closeButton);

                AnalisName.setText(analisDataList.getAnalisName());
                AnalisDate.setText(analisDataList.getAnalisDate());
                AnalisDescription.setText("Заглушка");
                AnalisPreparation.setText("Заглушка");
                AnalisBiomaterial.setText("Заглушка");
                String pricy = "Добавить за " + analisDataList.getAnalisPrice();
                AnalisButton.setText(pricy);
                AnalisButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LinearLayout linearLayout2 = ((Activity) context).findViewById(R.id.linearLayout2);
                        linearLayout2.setVisibility(View.VISIBLE);
                        int price = Integer.parseInt(analisDataList.getAnalisPrice().replace(" ₽", ""));
                        ((TrueMainActivity) context).changeSum(price);
                        holder.AnalisButtonDel.setVisibility(View.VISIBLE);
                        holder.AnalisButton.setVisibility(View.GONE);
                        bottomSheetDialog.dismiss();
                    }
                });
                CloseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });
        holder.AnalisButtonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.AnalisButtonDel.setVisibility(View.GONE);
                holder.AnalisButton.setVisibility(View.VISIBLE);
                int price = Integer.parseInt(analisDataList.getAnalisPrice().replace(" ₽", ""));
                ((TrueMainActivity) context).changeSum(-price);
            }
        });
    }

    @Override
    public int getItemCount() {
        return AnalisData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView AnalisName;
        TextView AnalisDate;
        TextView AnalisPrice;
        Button AnalisButton;
        Button AnalisButtonDel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            AnalisName = itemView.findViewById(R.id.analis_name);
            AnalisDate = itemView.findViewById(R.id.analis_date);
            AnalisPrice = itemView.findViewById(R.id.analis_price);
            AnalisButton = itemView.findViewById(R.id.analis_button);
            AnalisButtonDel = itemView.findViewById(R.id.analis_button_delete);
        }

    }

}
