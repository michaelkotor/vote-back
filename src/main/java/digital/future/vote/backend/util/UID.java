package digital.future.vote.backend.util;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.Base58;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Arrays;
@Component
public class UID {
    static SecureRandom rnd = new SecureRandom();
    static int DEFAULT_SIZE = 20; // bytes
    public static class FormatException extends RuntimeException {
        FormatException(String message) {
            super(message);
        }
    }

    byte[] uid;

    public UID(){
        uid = new byte[getSizeBytes()];
        rnd.nextBytes(uid);
    }

    // Validate that the string looks like UID (to avoid manual entering errors) and construct UID.
    public UID(String fromString) {
        // check prefix
        if (!fromString.startsWith(getPrefix())){
            throw new FormatException("Value " + fromString + " is not prefixed with " + getPrefix());
        }
        // drop prefix
        String notPrefixed = fromString.substring(getPrefix().length());
        try {
            byte[] decoded = Base58.decode(notPrefixed);
            if (decoded.length != (getSizeBytes() + 1))
                throw new FormatException("Decoding " + fromString + ": expected " + (getSizeBytes() +1)
                        + " but found " + decoded.length + " bytes");
            if (!validateCrc(decoded))
                throw new FormatException("CRC");
            uid = new byte[getSizeBytes()];
            System.arraycopy(decoded, 0, uid, 0, getSizeBytes());
        } catch (AddressFormatException e) {
            throw new FormatException(e.getMessage());
        }
    }

    // Base58 encoded string consisting of random bytes + 1 crc byte (to avoid manual entering errors).
    @JsonValue
    public String toString() {
        return getPrefix() + Base58.encode(appendCrc(uid));
    }


    static byte[] appendCrc(byte[] bytes) {
        byte crc = 0;
        for (byte b : bytes) {
            crc ^= b;
        }
        byte[] withCrc = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, withCrc, 0, bytes.length);
        withCrc[bytes.length] = crc;
        return withCrc;
    }

    static boolean validateCrc(byte[] array) {
        byte crc = 0;
        for (byte b : array) {
            crc ^= b;
        }
        return crc == 0;
    }

    protected String getPrefix() {
        return "";
    }

    protected int getSizeBytes() {
        return DEFAULT_SIZE;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(uid);
    }

    @Override
    public boolean equals(Object obj) {
        return Arrays.equals(((UID)obj).uid, uid);
    }
}
