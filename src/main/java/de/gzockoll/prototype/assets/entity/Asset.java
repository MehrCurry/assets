package de.gzockoll.prototype.assets.entity;

import com.google.common.io.ByteStreams;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.tika.Tika;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
public class Asset {
    private static final Tika TIKA =new Tika();

    @Id
    private String id;

    @NotNull
    private String mimeType;
    @NotNull
    private byte[] data;

    private String filename;

    public Asset() {}

    public Asset (byte[] data,String filename) {
        this.data=data;
        this.mimeType= TIKA.detect(data);
        this.filename=filename;
    }
    public Asset(InputStream is, String filename) {
        try {
            this.data= ByteStreams.toByteArray(is);
            this.mimeType= TIKA.detect(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Asset(String path) {
        try {
            final Path aPath = Paths.get(path);
            this.data= Files.readAllBytes(aPath);
            this.mimeType= TIKA.detect(data);
            this.filename=aPath.getFileName().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getSize() {
        return data != null ? data.length : 0L;
    }
}
