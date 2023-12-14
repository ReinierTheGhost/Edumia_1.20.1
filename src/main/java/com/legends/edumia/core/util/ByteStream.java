package com.legends.edumia.core.util;

import java.io.*;

public class ByteStream {
    public ByteStream() {
    }

    public static class Output extends ByteArrayOutputStream {
        public Output() {
        }

        public InputStream toInputStream() throws IOException {
            this.flush();
            return new Input(super.buf, super.count);
        }
    }

    public static class Input extends ByteArrayInputStream {
        public Input(byte[] buf, int length) {
            super(buf, 0, length);
        }

        public OutputStream toOutputStream() {
            return new Output();
        }
    }
}
