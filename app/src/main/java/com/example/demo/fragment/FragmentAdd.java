package com.example.demo.fragment;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.adapter.CatAdapter;

public class FragmentAdd extends Fragment {
    private CatAdapter adapter;
    private Spinner spinner;
    private EditText editName, editPrice, editInfor;
    private Button btAdd, btUpdate;
    private RecyclerView recyclerView;
    private int[] imgs = {R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,
                          R.drawable.cat4,R.drawable.cat5,R.drawable.cat6};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }

    private void initView() {
//        spinner=view
    }
}
