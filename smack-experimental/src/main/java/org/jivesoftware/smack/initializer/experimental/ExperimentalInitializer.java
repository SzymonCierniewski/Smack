/**
 *
 * Copyright 2014 Florian Schmaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.smack.initializer.experimental;

import java.util.List;
import java.util.ArrayList;

import org.jivesoftware.smack.initializer.UrlInitializer;
import org.jivesoftware.smack.provider.ProviderFileLoader.ProviderDescriptor;

/**
 * Initializes the providers in the experimental code stream.
 * 
 * @author Florian Schmaus
 */
public class ExperimentalInitializer extends UrlInitializer {

    @Override
    protected List<ProviderDescriptor> getProvidersUrl() {
    	List<ProviderDescriptor> providers = new ArrayList<ProviderDescriptor>();

        // XEP-0332 HTTP over XMPP transport
		providers.add(new ProviderDescriptor(true, "req", "urn:xmpp:http", "org.jivesoftware.smackx.hoxt.provider.HttpOverXmppReqProvider"));
		providers.add(new ProviderDescriptor(true, "resp", "urn:xmpp:http", "org.jivesoftware.smackx.hoxt.provider.HttpOverXmppRespProvider"));
		providers.add(new ProviderDescriptor(false, "chunk", "urn:xmpp:http", "org.jivesoftware.smackx.hoxt.provider.Base64BinaryChunkProvider"));
		// XEP-0280 Message Carbons
		providers.add(new ProviderDescriptor(false, "sent", "urn:xmpp:carbons:2", "org.jivesoftware.smackx.carbons.provider.CarbonManagerProvider"));
		providers.add(new ProviderDescriptor(false, "received", "urn:xmpp:carbons:2", "org.jivesoftware.smackx.carbons.provider.CarbonManagerProvider"));

		return providers;
    }

    @Override
    protected String[] getConfigUrl() {
        return new String[]{
         	"org.jivesoftware.smackx.hoxt.HOXTManager"};
    }
}
