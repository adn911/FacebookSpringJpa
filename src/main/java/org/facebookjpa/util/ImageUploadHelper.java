package org.facebookjpa.util;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by bakhtiar.galib on 4/2/15.
 */
@Component
public class ImageUploadHelper {

    static final String UPLOAD_PATH = "resources" + File.separator
            + "uploads" + File.separator + "photoes" + File.separator;


    public static boolean isValidImage(MultipartFile image) {
        return image.getContentType().equals("image/jpeg") || image.isEmpty();
    }

    public static void saveImage(String webAppRoot, String filename, MultipartFile image)
            throws IOException {
        try {
            File file = new File(webAppRoot + File.separator +
                    UPLOAD_PATH + File.separator + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new IOException("Unable to save image", e);
        }
    }

}
