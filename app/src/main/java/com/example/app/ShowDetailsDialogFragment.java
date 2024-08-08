package com.example.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDetailsDialogFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_details_dialog, container, false);


        String showName = getArguments().getString("showName");
        String showDesc = getArguments().getString("description");
        int showPrice = getArguments().getInt("price");

        TextView showNameTextView = view.findViewById(R.id.showName);
        TextView showPriceTextView = view.findViewById(R.id.showPrice);
        TextView showDescTextView = view.findViewById(R.id.showDesc);
        Button bookTicketsButton = view.findViewById(R.id.bookTicketsButton);


        showNameTextView.setText(showName);
        showDescTextView.setText(showDesc + "\nPrice = " + showPrice);



        bookTicketsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Book Tickets");
                builder.setMessage("How many tickets do you want to book?");


                final EditText input = new EditText(getContext());
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String ticketsText = input.getText().toString();
                        int tickets = Integer.parseInt(ticketsText);


                        int Price = showPrice;
                        int totalPrice = tickets * Price;


                        String message = "You have booked " + tickets + " tickets.\nTotal Price: Rs" + totalPrice;
                        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Show the AlertDialog
                builder.show();
            }
        });


        return view;
    }
}
