package com.astudio.roomorm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {

    Button deleteBt;
    EditText idEt;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        idEt = (EditText) view.findViewById(R.id.deleteUserEt_id);
        deleteBt = (Button) view.findViewById(R.id.deleteUserBt_id);
        deleteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEt.getText().toString();
                if (id.equals(""))
                    idEt.setError("Required!");
                else {
                    int uid = Integer.parseInt(id);
                    User user = new User();
                    user.setId(uid);
                    MainActivity.myAppDatabase.myDao().delete(user);
                    Toast.makeText(getActivity(), "User Deleted!", Toast.LENGTH_SHORT).show();
                }
                idEt.setText("");
            }
        });

        return view;
    }

}
