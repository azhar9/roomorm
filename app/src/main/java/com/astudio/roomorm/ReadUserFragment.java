package com.astudio.roomorm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    TextView usersDataView;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        usersDataView = (TextView) view.findViewById(R.id.userDataView_id);

        //show the data on the textview
        List<User> userList = MainActivity.myAppDatabase.myDao().getUsers();
        usersDataView.setText("");
        for(User u:userList)
        {
            usersDataView.append("Id: "+u.getId()+"\n");
            usersDataView.append("Name: "+u.getName()+"\n");
            usersDataView.append("Email: "+u.getEmail()+"\n");
            usersDataView.append("\n\n");

        }
        return view;
    }

}
