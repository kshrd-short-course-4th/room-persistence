package com.example.rathana.roomdatabasedemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rathana.roomdatabasedemo.R;
import com.example.rathana.roomdatabasedemo.data.local.room.AppDataBase;
import com.example.rathana.roomdatabasedemo.data.local.room.dao.UserDao;
import com.example.rathana.roomdatabasedemo.entity.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userid)
    EditText userId;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.gender)
    EditText gender;
    @BindView(R.id.phone)
    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onAddUser(View view) {
        User user =new User();
        user.name=username.getText().toString();
        user.gender=gender.getText().toString();
        user.email=email.getText().toString();
        user.phone=phone.getText().toString();

        //add data db
        AppDataBase db=AppDataBase.getInstance(this);
        UserDao dao=db.userDao();
        dao.add(user);
        showMessage("create a user success!");
    }

    private static final String TAG = "MainActivity";
    public void onGetUser(View view) {
        List<User> users=AppDataBase.getInstance(this).userDao().getAll();
        for(User u:users){
            Log.e(TAG, "onGetUser: "+u.toString() );
        }

    }

    public void onDeleteUser(View view) {
        User u=getUserFrom();
        AppDataBase.getInstance(this).userDao().remove(u);
        showMessage("delete success!");
    }

    public void showMessage(String message){
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    public void onUpdateUser(View view) {
        int userId= Integer.parseInt(this.userId.getText().toString());
        User u=AppDataBase.getInstance(this).userDao().getOne(userId);
        this.username.setText(u.name);
        this.gender.setText(u.gender);
        this.email.setText(u.email);
        this.phone.setText(u.phone);
    }

    public void onSaveChangeUser(View view) {
        User u=getUserFrom();
        AppDataBase.getInstance(this).userDao().edit(u);
        showMessage("update  user+ "+u.name + " success !");
    }

    private User getUserFrom(){
        User user =new User();
        user.id=Integer.parseInt(this.userId.getText().toString());
        user.name=username.getText().toString();
        user.gender=gender.getText().toString();
        user.email=email.getText().toString();
        user.phone=phone.getText().toString();
        return user;
    }

}
