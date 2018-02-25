package com.example.rathana.roomdatabasedemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rathana.roomdatabasedemo.R;
import com.example.rathana.roomdatabasedemo.data.local.room.AppDataBase;
import com.example.rathana.roomdatabasedemo.entity.Category;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FromCategoryActivity extends AppCompatActivity {

    @BindView(R.id.tvCatId)
    EditText tvCatId;
    @BindView(R.id.tvCatName)
    EditText tvCatName;
    @BindView(R.id.tvCatDesc)
    EditText tvCatDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_category);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSave)
    public void  onSave(){
        Category category =getFormData();
        //insert to table
        AppDataBase.getInstance(this).categoryDao().add(category);
        showMessage("save a category success");
    }

    private Category getFormData(){
        Category category=new Category();
        if(tvCatId.getText().toString().equals(""))
            category.id=0;
        else
            category.id= Integer.parseInt(tvCatId.getText().toString());

        category.name=tvCatName.getText().toString();
        category.description=tvCatDesc.getText().toString();
        return category;
    }
    private void clearFormData(){
        tvCatId.setText("");
        tvCatDesc.setText("");
        tvCatName.setText("");
    }

    private void setFormData(Category category){
        if(category==null || category.name==null
                ||category.description==null){
            showMessage("data not found");
            return;
        }

        tvCatId.setText(category.id+"");
        tvCatDesc.setText(category.description);
        tvCatName.setText(category.name);
    }
    public void showMessage(String message){
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.btnGet)
    public void onGet(){
        Category cat=getFormData();
        clearFormData();
        //get category for table
        Category category = AppDataBase.getInstance(this).categoryDao().getOne(cat.id);
        setFormData(category);

    }

}
