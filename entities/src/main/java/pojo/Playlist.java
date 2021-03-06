package pojo;

import java.sql.Timestamp;
import java.util.List;

public class Playlist{

    private int id;
    private Profile profile;
    private String title;
    private String description;
    private Timestamp created;
    private Timestamp updated;
    private List<Integer> songList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public List<Integer> getSongList() {
        return songList;
    }

    public void setSongList(List<Integer> songList) {
        this.songList = songList;
    }
}
