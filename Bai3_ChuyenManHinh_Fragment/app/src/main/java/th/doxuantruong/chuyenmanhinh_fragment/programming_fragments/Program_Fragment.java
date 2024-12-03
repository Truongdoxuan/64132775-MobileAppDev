package th.doxuantruong.chuyenmanhinh_fragment.programming_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th.doxuantruong.chuyenmanhinh_fragment.R;

public class Program_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_program, container, false);
    }
}