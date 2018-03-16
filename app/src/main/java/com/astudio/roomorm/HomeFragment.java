package com.astudio.roomorm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    Button addUserBt, readUserBt, deleteUserBt, updateUserBt;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        addUserBt = (Button) view.findViewById(R.id.addUser_id);
        addUserBt.setOnClickListener(this);

        readUserBt = (Button) view.findViewById(R.id.viewUser_id);
        readUserBt.setOnClickListener(this);

        deleteUserBt = (Button) view.findViewById(R.id.delUser_id);
        deleteUserBt.setOnClickListener(this);

        updateUserBt = (Button) view.findViewById(R.id.updateUser_id);
        updateUserBt.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addUser_id:
                //display the add user fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer_id, new AddUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.viewUser_id:
                //display the readusers fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer_id, new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.delUser_id:
                //display the deleteUser fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer_id, new DeleteUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.updateUser_id:
                //display the deleteUser fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer_id, new UpdateUserFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
