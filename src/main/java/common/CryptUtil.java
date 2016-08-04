package common;

import java.io.UnsupportedEncodingException;

public class CryptUtil {
    public static String encrypt(String input, String sessionId) throws UnsupportedEncodingException {
        int key = 0;
        int limit = 15;
        while (key == 0) {
            key = sessionId.charAt(0) % limit++;
        }
        StringBuffer output = new StringBuffer("");

        for (char c : input.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                output.append((char) ((c + key) > 90 ? (c + key - 90 + 65) : c + key));
            } else if ('a' <= c && c <= 'z') {
                output.append((char) ((c + key) > 122 ? (c + key - 122 + 97) : c + key));
            } else {
                throw new UnsupportedEncodingException();
            }
        }
        return output.toString();
    }

    public static String decrypt(String input, String sessionId) throws UnsupportedEncodingException {
        return null;
    }
}
