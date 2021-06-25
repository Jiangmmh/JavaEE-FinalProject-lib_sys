package pojo;

import org.springframework.web.multipart.MultipartFile;

public class Picture {
    private MultipartFile picture;

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }
}
