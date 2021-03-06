/*******************************************************************************
Copyright ArxanFintech Technology Ltd. 2018 All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

                 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

package com.arxanfintech.common.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * Config is used to configure the creation of a client
 *
 */
public class Client {
	private String keyStorePath;
	private String keyStorePasswd;
	private String trustStorePath;
	private String trustStorePasswd;

    /**
     * new Client, use two keystores store client cert and trust ca cert
     * 
     * @param apiKey
     *            **apikey** is set to the API access key applied on `ChainConsole`
     *            management page
     * @param creator
     *            the enterprise's wallet did
     * @param created
     *            the enterprise's wallet created
     * @param nonce
     *            the enterprise's wallet nonce
     * @param privateKey
     *            the enterprise's wallet private key base64
     * @param address
     *            **Address** is the IP address of the BAAS server entrance.
     * @param keyStorePath
     *            keystore of client cert
     * @param keyStorePasswd
     *            password of client keystore
     * @param trustStorePath
     *            keystore of server root cert
     * @param trustStorePasswd
     *            password of trustKeystore
     */
    public Client(String apiKey, String creator, String created, String nonce, String privateKey,
            String address,  String keyStorePath, String keyStorePasswd, 
            String trustStorePath, String trustStorePasswd) {
        this.initClient(apiKey, "", creator, created, nonce, privateKey, address, false, "wallet-ng",
        		keyStorePath, keyStorePasswd, trustStorePath, trustStorePasswd);
    }

    /**
     * new Client, just use one keystore store all certs
     * 
     * @param apiKey
     *            **apikey** is set to the API access key applied on `ChainConsole`
     *            management page
     * @param creator
     *            the enterprise's wallet did
     * @param created
     *            the enterprise's wallet created
     * @param nonce
     *            the enterprise's wallet nonce
     * @param privateKey
     *            the enterprise's wallet private key base64
     * @param address
     *            **Address** is the IP address of the BAAS server entrance.
     * @param keyStorePath
     *            keystore of client cert
     * @param keyStorePasswd
     *            password of client keystore
     */
    public Client(String apiKey, String creator, String created, String nonce, String privateKey,
            String address,  String keyStorePath, String keyStorePasswd) {
        this.initClient(apiKey, "", creator, created, nonce, privateKey, address, false, "wallet-ng",
        		keyStorePath, keyStorePasswd, keyStorePath, keyStorePasswd);
    }
    /**
     * new Client
     * 
     * @param apiKey
     *            **apikey** is set to the API access key applied on `ChainConsole`
     *            management page
     * @param creator
     *            the enterprise's wallet did
     * @param created
     *            the enterprise's wallet created
     * @param nonce
     *            the enterprise's wallet nonce
     * @param privateKey
     *            the enterprise's wallet private key base64
     * @param address
     *            **Address** is the IP address of the BAAS server entrance.
     *            
     * */
    public Client(String apiKey, String creator, String created, String nonce, String privateKey,
            String address) {
        this.initClient(apiKey, "", creator, created, nonce, privateKey, address, false, "wallet-ng", "", "", "", "");
    }

    private void initClient(String apiKey, String certPath, String creator, String created, String nonce,
            String privateKey, String address, Boolean enableCrypto, String routeTag, 
            String keyStorePath, String keyStorePasswd, String trustStorePath, String trustStorePasswd) {
        this.address = address;
        this.apiKey = apiKey;
        this.routeTag = routeTag;
        this.certPath = certPath;
        this.creator = creator;
        this.created = created;
        this.nonce = nonce;
        this.privateB64 = privateKey;
        this.enableCrypto = enableCrypto; // FIXME delete
        this.keyStorePath = keyStorePath;
        this.keyStorePasswd = keyStorePasswd;
        this.trustStorePath = trustStorePath;
        this.trustStorePasswd = trustStorePasswd;
    }

    // Address is the address of the Rest server
    private String address;

    public String GetAddress() {
        return this.address;
    }

    // ApiKey is the access key for ACL access api
    private String apiKey;

    public String GetApiKey() {
        return this.apiKey;
    }

    // RouteTag of every url
    private String routeTag;

    public String GetRouteTag() {
        return this.routeTag;
    }

    public void SetRouteTag(String routeTag) {
        this.routeTag = routeTag;
    }

    // Cert Path
    private String certPath;

    public String GetCertPath() {
        return this.certPath;
    }

    private String creator;

    public String GetCreator() {
        return this.creator;
    }

    private String created;

    public String GetCreated() {
        return this.created;
    }

    private String nonce;

    public String GetNonce() {
        return this.nonce;
    }

    private String privateB64;

    public String GetPrivateB64() {
        return this.privateB64;
    }

    private Boolean enableCrypto;

    public Boolean GetEnableCrypto() {
        return this.enableCrypto;
    }

    public String GetKeyStorePath() {
    	return this.keyStorePath;
    }

    public String GetKeyStorePasswd() {
    	return this.keyStorePasswd;
    }

    public String GetTrustStorePath() {
    	return this.trustStorePath;
    }

    public String GetTrustStorePasswd() {
    	return this.trustStorePasswd;
    }

    public JSONObject getEntParams() {
        System.out.println(this.creator);
        System.out.println(this.nonce);
        System.out.println(this.privateB64);
        System.out.println(this.created);

        String strSignParams = "{\"creator\":\"" + this.creator + "\",\"nonce\":\"" + this.nonce
                + "\",\"privateB64\":\"" + this.privateB64 + "\",\"created\":\"" + this.created + "\"}";
        System.out.println(strSignParams);
        JSONObject ent_sign_params = JSON.parseObject(strSignParams);

        return ent_sign_params;
    }
}