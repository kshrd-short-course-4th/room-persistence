package com.example.rathana.roomdatabasedemo.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RATHANA on 2/24/2018.
 */
@Entity(tableName = "article")
public class Article implements Parcelable{
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String content;
    @ColumnInfo(name = "category_id")
    public int categoryId;
    @ColumnInfo(name = "author_id")
    public int authorId;

    public Article(){}
    @Ignore
    protected Article(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
        categoryId = in.readInt();
        authorId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeInt(categoryId);
        dest.writeInt(authorId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", categoryId=" + categoryId +
                ", authorId=" + authorId +
                '}';
    }
}
