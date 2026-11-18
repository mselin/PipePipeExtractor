package org.schabi.newpipe.extractor;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/**
 * Initialising the extractor must not change the process-wide TLS behaviour of
 * {@link HttpsURLConnection}: certificate and host-name checks stay as the platform set them.
 */
class NewPipeInitTlsTest {
    @Test
    void initLeavesTheDefaultTlsChecksInPlace() {
        final HostnameVerifier verifier = HttpsURLConnection.getDefaultHostnameVerifier();
        final SSLSocketFactory factory = HttpsURLConnection.getDefaultSSLSocketFactory();

        NewPipe.init(null);

        assertSame(verifier, HttpsURLConnection.getDefaultHostnameVerifier());
        assertSame(factory, HttpsURLConnection.getDefaultSSLSocketFactory());
    }
}
