package com.example.webapi_list;


public class Contact  {
    private int id;
    private int publisher_id;
    private int content_type;
    private int tab;
    private String title;
    private String avatar;
    private int status;
    private int deleted;
    private int user_created;
    private int user_modified;
    private String date_created;
    private String date_modified;
    private int parent_id;
    private int lft;
    private String thumb;

    public Contact(int id, int publisher_id, int content_type, int tab, String title, String avatar, int status, int deleted, int user_created, int user_modified, String date_created, String date_modified, int parent_id, int lft, String thumb) {
        this.id = id;
        this.publisher_id = publisher_id;
        this.content_type = content_type;
        this.tab = tab;
        this.title = title;
        this.avatar = avatar;
        this.status = status;
        this.deleted = deleted;
        this.user_created = user_created;
        this.user_modified = user_modified;
        this.date_created = date_created;
        this.date_modified = date_modified;
        this.parent_id = parent_id;
        this.lft = lft;
        this.thumb = thumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getUser_created() {
        return user_created;
    }

    public void setUser_created(int user_created) {
        this.user_created = user_created;
    }

    public int getUser_modified() {
        return user_modified;
    }

    public void setUser_modified(int user_modified) {
        this.user_modified = user_modified;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
