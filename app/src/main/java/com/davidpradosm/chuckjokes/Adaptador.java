package com.davidpradosm.chuckjokes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by David Prados on 13/11/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.JokeViewHolder> {

    //private View.OnClickListener listener;
    private ArrayList<Joke> datos;

    public Adaptador(ArrayList<Joke> datos) {
        this.datos = datos;
    }

    public static class JokeViewHolder
            extends RecyclerView.ViewHolder {

        private TextView tv_name;

        public JokeViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_recycler);
        }

        public void bindJoke(Joke t, int posicion, ArrayList<Joke>datos) {

            tv_name.setText(t.getValue());
        }
    }




    @Override
    public JokeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);

        //itemView.setOnClickListener(this);
        //android:background="?android:attr/selectableItemBackground"

        JokeViewHolder tvh = new JokeViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(JokeViewHolder viewHolder, int pos) {
        Joke item = datos.get(pos);

        viewHolder.bindJoke(item, pos, datos);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    /*
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
    */
}
