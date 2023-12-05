package com.klesiu.musiclibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    private int id;
    private String title;
    private String artist;

    public String getTitle() {
        return title;
    };
    public String getArtist(){
        return artist;
    }

    public int getId() {
        return id;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
