MDAwMFowbTELMAkGA1UEBhMCVVMxEzARBgNVBAgMCkNhbGlmb3JuaWExFjAUBgNVBAcMDU1vdW50YWluIFZpZXcxEzARBgNVBAoMCkdvb2dsZSBJbmMxHDAaBgNVBAMMEyouZy5kb3VibGVjbGljay5uZXQwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCfMcQbW/RHNXto9vvJTZgCohNcerTyFLFgA5kWcOraCxqdHa489751mPRXNnQQpF/U5ykzaoagP2Av7Uz2wYVypZ4vgMnnsw0+SNaSJh/zdB3UV5GUgWiPIZ2feLHGGKhWHjlyFGjUCQo3qLuurteLy6MLc7OS8Ms7NU9EY/mCjhxis8DZvat+gS8HbRP8Lm90F1YKRpVQFv35CLn8qHS7WwLtPM39dSJzbymfwt2aANZragVbRcRFSLk+wneoMPTJ4HUB3rUSd6PjIhiV9p/ohvS8gJgVArJzhkofTiDahwgWn5/YLCEuRuFT31R6pkqqHIxqqXCgicPz8Qkf20WzAgMBAAGjggIYMIICFDAdBgNVHSUEFjAUBggrBgEFBQcDAQYIKwYBBQUHAwIwgeUGA1UdEQSB3TCB2oITKi5nLmRvdWJsZWNsaWNrLm5ldIIWKi5nb29nbGVhZHNlcnZpY2VzLmNvbYIXKi5nb29nbGVzeW5kaWNhdGlvbi5jb22CFyouZ29vZ2xldGFnc2VydmljZXMuY29tghEqLmludml0ZW1lZGlhLmNvbYIRZy5kb3VibGVjbGljay5uZXSCFGdvb2dsZWFkc2VydmljZXMuY29tghVnb29nbGVzeW5kaWNhdGlvbi5jb22CFWdvb2dsZXRhZ3NlcnZpY2VzLmNvbYIPbWVkaWEuYWRtb2IuY29tMGgGCCsGAQUFBwEBBFwwWjArBggrBgEFBQcwAoYfaHR0cDovL3BraS5nb29nbGUuY29tL0dJQUcyLmNydDArBggrBgEFBQcwAYYfaHR0cDovL2NsaWVudHMxLmdvb2dsZS5jb20vb2NzcDAdBgNVHQ4EFgQUCocBkDqtkxui/zCUurT/oofr7vwwDAYDVR0TAQH/BAIwADAfBgNVHSMEGDAWgBRK3QYWG7z2aLV29YG2u2IaulqBLzAhBgNVHSAEGjAYMAwGCisGAQQB1nkCBQEwCAYGZ4EMAQICMDAGA1UdHwQpMCcwJaAjoCGGH2h0dHA6Ly9wa2kuZ29vZ2xlLmNvbS9HSUFHMi5jcmwwDQYJKoZIhvcNAQELBQADggEBACgokbsTKTJCgeFfKraygI7x6G69CT7Mt508vk8Rbn3LhE+uFmKv4x+CAjeYVrAEByjYsDQ5fjTFH/wLYTiewlgtihoocuo1e5B7jnB7YttEBvPWfqQdGEgcQZ3mryXmBssnNVbHbtSu2WCfELpuKZ/TF5CSCbSB6RmPmjvieuqdyqc6D7Ub+u1M3zIulNCOVBjh75MtNyyIJaYyGGPlErDS5SujKcLcb88m8/tHQaVGkA43/4V3lB6ZoaI/p6bF8i1Gv7o1nIbRzMGmDPhLAMKFa3yxueomY6/KMTNIn59WlwJevcSRmszYleO9BUyinYrJjlvbJ21og0Nyyn4AYGEAAACAAAAAgAAAACVUTFNfRUNESEVfUlNBX1dJVEhfQUVTXzEyOF9HQ01fU0hBMjU2AAAAAQA= request-method GET response-head HTTP/1.1 200 OK
P3P: policyref="https://googleads.g.doubleclick.net/pagead/gcn_p3p_.xml", CP="CURa ADMa DEVa TAIo PSAo PSDo OUR IND UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR"
Content-Type: text/html; charset=UTF-8
x-content-type-options: nosniff
Content-Encoding: gzip
Date: Thu, 01 Oct 2015 08:56:45 GMT
Server: cafe
Cache-Control: private
Content-Length: 47721
X-XSS-Protection: 1; mode=block
alternate-protocol: 443:quic,p=1
alt-svc: quic=":443"; p="1"; ma=604800
X-Firefox-Spdy: 3.1
 charset UTF-8   �i                                                                                                                                                                                                                                                                                                     name);
    }

    public boolean isValid(int timeout) throws SQLException {
        synchronized (proxy) {
            return this.getJDBC4Connection().isValid(timeout);
        }
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        this.getJDBC4Connection().setClientInfo(properties);
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        this.getJDBC4Connection().setClientInfo(name, value);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        checkClosed();

        // This works for classes that aren't actually wrapping anything
        return iface.isInstance(this);
    }

    public <T> T unwrap(java.lang.Class<T> iface) throws java.sql.SQLException {
        try {
            // This works for classes that aren't actually wrapping anything
            return iface.cast(this);
        } catch (ClassCastException cce) {
            throw SQLError.createSQLException("Unable to unwrap to " + iface.toString(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
        }
    }

    /**
     * @see java.sql.Connection#createBlob()
     */
    public Blob createBlob() {
        return this.getJDBC4Connection().createBlob();
    }

    /**
     * @see java.sql.Connection#createClob()
     */
    public Clob createClob() {
        return this.getJDBC4Connection().createClob();
    }

    /**
     * @see java.sql.Connection#createNClob()
     */
    public NClob createNClob() {
        return this.getJDBC4Connection().createNClob();
    }

    protected JDBC4ClientInfoProvider getClientInfoProviderImpl() throws SQLException {
        synchronized (proxy) {
            return this.getJDBC4Connection().getClientInfoProviderImpl();
        }
    }
}
