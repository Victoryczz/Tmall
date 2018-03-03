package seu.vczz.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * CREATE by vczz on 2018/3/3
 * 上传图片文件
 */
public class UploadedImageFile {
    //接收上传图片文件的注入
    MultipartFile image;

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public MultipartFile getImage() {

        return image;
    }
}
