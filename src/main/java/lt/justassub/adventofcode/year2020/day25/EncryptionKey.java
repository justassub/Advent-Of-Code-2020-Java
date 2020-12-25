package lt.justassub.adventofcode.year2020.day25;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;


@RequiredArgsConstructor
public class EncryptionKey {
    private final long doorPublicKey;
    private final long cardPublicKey;

    private final int dividingValue = 20201227;

    private long publicKey = 1;
    @Getter
    private int loop = 0;
    @Getter
    private long encryptionKey = 1;


    public void decryptData() {
        calculateLoopSize();
        calculateEncryptionKey();
    }

    private void calculateLoopSize() {
        while (publicKey != doorPublicKey) {
            publicKey *= 7;
            publicKey %= 20201227;
            loop++;
        }
    }

    private void calculateEncryptionKey() {
        IntStream.range(0, loop)
                .forEach(__ -> {
                    encryptionKey *= cardPublicKey;
                    encryptionKey %= dividingValue;
                });
    }
}
