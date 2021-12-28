package com.example.mystaticfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class button_fragment extends Fragment {


    @Override
    // Переопределяем метод onCreateView
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // менеджер компоновки, который позволяет получать доступ к layout с наших ресурсов
        View view = inflater.inflate(R.layout.button_fragment, container, false);

        // теперь можем получить наши элементы, расположенные во фрагменте
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Message from fragment", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
