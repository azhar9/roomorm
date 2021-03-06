package com.astudio.roomorm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {
    EditText userId, userName, userEmail;
    Button saveBt;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);
        userId = (EditText) view.findViewById(R.id.userUpdateId_id);
        userName = (EditText) view.findViewById(R.id.userUpdateName_id);
        userEmail = (EditText) view.findViewById(R.id.userUpdateEmail_id);
        saveBt = (Button) view.findViewById(R.id.updateBtUser_id);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = userId.getText().toString().trim();
                String username = userName.getText().toString();
                String useremail = userEmail.getText().toString();

                if (inputCheck(id, username, useremail)) {
                    User user = new User();
                    user.setId(Integer.parseInt(id));
                    user.setName(username);
                    user.setEmail(useremail);

                    MainActivity.myAppDatabase.myDao().updateUser(user);

                    Toast.makeText(getActivity(), "User updated Successfully", Toast.LENGTH_SHORT).show();

                    userName.setText("");
                    userId.setText("");
                    userEmail.setText("");

                }

            }
        });

        return view;
    }

    private boolean inputCheck(String id, String username, String useremail) {

        if (id.equals("")) {
            userId.setError("Required");
            return false;
        }
        if (username.equals("")) {
            userName.setError("Required");
            return false;
        }
        if (useremail.equals("")) {
            userEmail.setError("Required");
            return false;
        }

        return true;
    }

}
