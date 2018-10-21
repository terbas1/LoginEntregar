package com.terbas1.loginentregar.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.terbas1.loginentregar.R;
import com.terbas1.loginentregar.adapters.ProductAdapter;
import com.terbas1.loginentregar.models.Product;
import com.terbas1.loginentregar.repository.ProductRepository;

import java.util.List;

public class HomeFragment extends Fragment implements ChasngeNotifier{

    private static final String TAG = HomeFragment.class.getSimpleName();

    private RecyclerView productsList;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        productsList = view.findViewById(R.id.product_list);
        productsList.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Product> products= ProductRepository.list();
        productsList.setAdapter(new ProductAdapter(this, products));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onCreateView");

    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onCreateView");
    }

    @Override
    public void notifyChanges() {
        ProductAdapter pa = (ProductAdapter) productsList.getAdapter();
        pa.setProducts(ProductRepository.list());
        pa.notifyDataSetChanged();
    }
}
