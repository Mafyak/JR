import java.io.IOException;

public interface PersonScanner {
    static Person read() throws IOException{
        return null;
    }
    void close() throws IOException;
}
