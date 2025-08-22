// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package com.quera.android.playlist;

public class ItemModel {

    private String songTitle;
    private String songArtitst;

    ItemModel(String songTitle, String songArtitst) {
        this.songTitle = songTitle;
        this.songArtitst = songArtitst;
    }

    public ItemModel(ItemModel targetUser) {
        this.songTitle = targetUser.getTitleString();
        this.songArtitst = targetUser.getSongArtist();
    }

    public String getTitleString() {
        return songTitle;
    }

    public void setText(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongArtist() {
        return songArtitst;
    }

    public void setSongArtist(String songArtitst) {
        this.songArtitst = songArtitst;
    }
}
