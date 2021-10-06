import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public final class MappedFile {
    private static final int SleepTime = 1000;
    private static final File FILE = new File("file.dat");
    private static final Random RANDOM = new Random();
    private static final int BUFFER_SIZE = 16;
    private static final int ITERATION_COUNT = 10;
    private static final int STOP = -1;
    private static final int CONTINUE = 1;
    private final RandomAccessFile _file;
    private final MappedByteBuffer _buffer;

    public MappedFile(File file, OperationMode mode) throws LAB01Exception {
        try {
            if (mode == OperationMode.Write) {
                file.delete();
            } else {
                if (!file.exists() && !file.isFile() && !file.canRead()) {
                    throw new LAB01Exception(
                            "file " + file + " doesn't exist or cannot be read");
                }
            }
            _file = new RandomAccessFile(file, "rw");
            FileChannel channel = _file.getChannel();
            _buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_SIZE);
        } catch (Throwable e) {
            throw new LAB01Exception(e);
        }
    }

    public void write(int iterationCount) {
        boolean runInfinitely = (iterationCount <= 0);
        int iterationsLeftCount = iterationCount;
        while (runInfinitely || iterationsLeftCount > 0) {
            _buffer.rewind();
            _buffer.getInt();
            int lastOperationMark = _buffer.getInt();
            if (lastOperationMark == OperationMode.Read.getMark()) {
                int val1 = RANDOM.nextInt();
                int val2 = RANDOM.nextInt();
                _buffer.rewind();
                _buffer.putInt(CONTINUE).putInt(OperationMode.Write.getMark()).putInt(val1).putInt(val2);
                if (!runInfinitely) {
                    iterationsLeftCount--;
                }
            }
            sleep();
        }
        _buffer.rewind();
        _buffer.putInt(STOP).putInt(OperationMode.Write.getMark());
    }

    public void write() {
        write(ITERATION_COUNT);
    }

    public void read() {
        main:
        while (true) {
            _buffer.rewind();
            int stopOrContinue = _buffer.getInt();
            int lastOperationMark = _buffer.getInt();
            if (stopOrContinue == STOP && lastOperationMark == OperationMode.Write.getMark()) {
                break main;
            } else {
                if (lastOperationMark == OperationMode.Write.getMark()) {
                    int val1 = _buffer.getInt();
                    int val2 = _buffer.getInt();
                    _buffer.rewind();
                    _buffer.putInt(CONTINUE).putInt(OperationMode.Read.getMark());
                    int sum = val1 + val2;
                    System.out.println("sum: " + sum);
                }
            }
            sleep();
        }
    }

    public static void main(String... args) {
        try {
            if (args.length < 1) {
                System.out.println("read or write should be specified as argument");
                return;
            }
            OperationMode mode = OperationMode.getMode(args[0]);
            if (mode != null) {
                MappedFile file = new MappedFile(FILE, mode);
                switch (mode) {
                    case Write:
                        file.write();
                        break;
                    case Read:
                        file.read();
                        break;
                    default:
                        System.out.println("invalid argument: " + args[0]);
                        return;
                }
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(SleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
