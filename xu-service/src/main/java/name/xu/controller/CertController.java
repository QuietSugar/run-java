package name.xu.controller;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

/**
 * 证书
 *
 * @author Created by HuoXu
 */
@RestController
@RequestMapping(value = "/cert", method = {RequestMethod.POST, RequestMethod.GET})
public class CertController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CertController.class);

    @RequestMapping(value = "/getInfo")
    public String getInfo(@RequestParam("cert") String cert) {
        CertificateFactory certificateFactory = null;
        try {
            certificateFactory = CertificateFactory.getInstance("X509", new BouncyCastleProvider());
            Certificate certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(cert.getBytes(StandardCharsets.UTF_8)));
            return certificate.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }
}
