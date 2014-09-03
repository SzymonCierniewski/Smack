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
package org.jivesoftware.smack.initializer.extensions;

import java.util.List;
import java.util.ArrayList;

import org.jivesoftware.smack.initializer.UrlInitializer;
import org.jivesoftware.smack.provider.ProviderFileLoader.ProviderDescriptor;

/**
 * Initializes the providers in the experimental code stream.
 * 
 * @author Florian Schmaus
 */
public class ExtensionsInitializer extends UrlInitializer {

    @Override
    protected List<ProviderDescriptor> getProvidersUrl() {
        List<ProviderDescriptor> providers = new ArrayList<ProviderDescriptor>();

		// Private Data Storage 
		providers.add(new ProviderDescriptor(true, "query", "jabber:iq:private", "org.jivesoftware.smackx.iqprivate.PrivateDataManager$PrivateDataIQProvider"));
		// Time 
		providers.add(new ProviderDescriptor(true, "time", "urn:xmpp:time", "org.jivesoftware.smackx.time.packet.Time"));
		// Message Events 
		providers.add(new ProviderDescriptor(false, "x", "jabber:x:event", "org.jivesoftware.smackx.xevent.provider.MessageEventProvider"));
		// Chat State 
		providers.add(new ProviderDescriptor(false, "active", "http://jabber.org/protocol/chatstates", "org.jivesoftware.smackx.chatstates.packet.ChatStateExtension$Provider"));
		providers.add(new ProviderDescriptor(false, "composing", "http://jabber.org/protocol/chatstates", "org.jivesoftware.smackx.chatstates.packet.ChatStateExtension$Provider"));
		providers.add(new ProviderDescriptor(false, "paused", "http://jabber.org/protocol/chatstates", "org.jivesoftware.smackx.chatstates.packet.ChatStateExtension$Provider"));
		providers.add(new ProviderDescriptor(false, "inactive", "http://jabber.org/protocol/chatstates", "org.jivesoftware.smackx.chatstates.packet.ChatStateExtension$Provider"));
		providers.add(new ProviderDescriptor(false, "gone", "http://jabber.org/protocol/chatstates", "org.jivesoftware.smackx.chatstates.packet.ChatStateExtension$Provider"));
		// XHTML 
		providers.add(new ProviderDescriptor(false, "html", "http://jabber.org/protocol/xhtml-im", "org.jivesoftware.smackx.xhtmlim.provider.XHTMLExtensionProvider"));
		// Group Chat Invitations 
		providers.add(new ProviderDescriptor(false, "x", "jabber:x:conference", "org.jivesoftware.smackx.muc.packet.GroupChatInvitation$Provider"));	
		// Service Discovery # Items 
		providers.add(new ProviderDescriptor(true, "query", "http://jabber.org/protocol/disco#items", "org.jivesoftware.smackx.disco.provider.DiscoverItemsProvider"));
		// Service Discovery # Info 
		providers.add(new ProviderDescriptor(true, "query", "http://jabber.org/protocol/disco#info", "org.jivesoftware.smackx.disco.provider.DiscoverInfoProvider"));
		// Data Forms
		providers.add(new ProviderDescriptor(false, "x", "jabber:x:data", "org.jivesoftware.smackx.xdata.provider.DataFormProvider"));
		// MUC User 
		providers.add(new ProviderDescriptor(false, "x", "http://jabber.org/protocol/muc#user", "org.jivesoftware.smackx.muc.provider.MUCUserProvider"));
		// MUC Admin 
		providers.add(new ProviderDescriptor(true, "query", "http://jabber.org/protocol/muc#admin", "org.jivesoftware.smackx.muc.provider.MUCAdminProvider"));
		// MUC Owner 
		providers.add(new ProviderDescriptor(true, "query", "http://jabber.org/protocol/muc#owner", "org.jivesoftware.smackx.muc.provider.MUCOwnerProvider"));
		// Delayed Delivery 
		providers.add(new ProviderDescriptor(false, "x", "jabber:x:delay", "org.jivesoftware.smackx.delay.provider.DelayInformationProvider"));
		providers.add(new ProviderDescriptor(false, "delay", "urn:xmpp:delay", "org.jivesoftware.smackx.delay.provider.DelayInfoProvider"));
		// Version 
		providers.add(new ProviderDescriptor(true, "query", "jabber:iq:version", "org.jivesoftware.smackx.iqversion.provider.VersionProvider"));
		// VCard 
		providers.add(new ProviderDescriptor(true, "vCard", "vcard-temp", "org.jivesoftware.smackx.vcardtemp.provider.VCardProvider"));
		// Offline Message Requests 
		providers.add(new ProviderDescriptor(true, "offline", "http://jabber.org/protocol/offline", "org.jivesoftware.smackx.offline.packet.OfflineMessageRequest$Provider"));
		// Offline Message Indicator 
		providers.add(new ProviderDescriptor(false, "offline", "http://jabber.org/protocol/offline", "org.jivesoftware.smackx.offline.packet.OfflineMessageInfo$Provider"));
		// Last Activity 
		providers.add(new ProviderDescriptor(true, "query", "jabber:iq:last", "org.jivesoftware.smackx.iqlast.packet.LastActivity$Provider"));
		// User Search 
		providers.add(new ProviderDescriptor(true, "query", "jabber:iq:search", "org.jivesoftware.smackx.search.UserSearch$Provider"));
		// SharedGroupsInfo 
		providers.add(new ProviderDescriptor(true, "sharedgroup", "http://www.jivesoftware.org/protocol/sharedgroup", "org.jivesoftware.smackx.sharedgroups.packet.SharedGroupsInfo$Provider"));
		// XEP-33: Extended Stanza Addressing 
		providers.add(new ProviderDescriptor(false, "addresses", "http://jabber.org/protocol/address", "org.jivesoftware.smackx.address.provider.MultipleAddressesProvider"));
		// FileTransfer 
		providers.add(new ProviderDescriptor(true, "si", "http://jabber.org/protocol/si", "org.jivesoftware.smackx.si.provider.StreamInitiationProvider"));
		providers.add(new ProviderDescriptor(true, "query", "http://jabber.org/protocol/bytestreams", "org.jivesoftware.smackx.bytestreams.socks5.provider.BytestreamsProvider"));
		providers.add(new ProviderDescriptor(true, "open", "http://jabber.org/protocol/ibb", "org.jivesoftware.smackx.bytestreams.ibb.provider.OpenIQProvider"));
		providers.add(new ProviderDescriptor(true, "data", "http://jabber.org/protocol/ibb", "org.jivesoftware.smackx.bytestreams.ibb.provider.DataPacketProvider"));
		providers.add(new ProviderDescriptor(true, "close", "http://jabber.org/protocol/ibb", "org.jivesoftware.smackx.bytestreams.ibb.provider.CloseIQProvider"));
		providers.add(new ProviderDescriptor(false, "data", "http://jabber.org/protocol/ibb", "org.jivesoftware.smackx.bytestreams.ibb.provider.DataPacketProvider"));
		// Ad-Hoc Command 
		providers.add(new ProviderDescriptor(true, "command", "http://jabber.org/protocol/commands", "org.jivesoftware.smackx.commands.provider.AdHocCommandDataProvider"));
		providers.add(new ProviderDescriptor(false, "bad-action", "http://jabber.org/protocol/commands", "org.jivesoftware.smackx.commands.provider.AdHocCommandDataProvider$BadActionError"));
		providers.add(new ProviderDescriptor(false, "malformed-actionn", "http://jabber.org/protocol/commands", "org.jivesoftware.smackx.commands.provider.AdHocCommandDataProvider$MalformedActionError"));
		providers.add(new ProviderDescriptor(false, "bad-locale", "http://jabber.org/protocol/commands", "org.jivesoftware.smackx.commands.provider.AdHocCommandDataProvider$BadLocaleError"));
		providers.add(new ProviderDescriptor(false, "bad-payload", "http://jabber.org/protocol/commands", "org.jivesoftware.smackx.commands.provider.AdHocCommandDataProvider$BadPayloadError"));
		providers.add(new ProviderDescriptor(false, "bad-sessionid", "http://jabber.org/protocol/commands", "org.jivesoftware.smackx.commands.provider.AdHocCommandDataProvider$BadSessionIDError"));
		providers.add(new ProviderDescriptor(false, "session-expired", "http://jabber.org/protocol/commands", "org.jivesoftware.smackx.commands.provider.AdHocCommandDataProvider$SessionExpiredError"));
		// SHIM 
		providers.add(new ProviderDescriptor(false, "headers", "http://jabber.org/protocol/shim", "org.jivesoftware.smackx.shim.provider.HeadersProvider"));
		providers.add(new ProviderDescriptor(false, "header", "http://jabber.org/protocol/shim", "org.jivesoftware.smackx.shim.provider.HeaderProvider"));
		// XEP-0060 pubsub 
		providers.add(new ProviderDescriptor(true, "pubsub", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.PubSubProvider"));
		providers.add(new ProviderDescriptor(false, "create", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.SimpleNodeProvider"));
		providers.add(new ProviderDescriptor(false, "items", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.ItemsProvider"));
		providers.add(new ProviderDescriptor(false, "item", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.ItemProvider"));
		providers.add(new ProviderDescriptor(false, "subscriptions", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.SubscriptionsProvider"));
		providers.add(new ProviderDescriptor(false, "subscription", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.SubscriptionProvider"));
		providers.add(new ProviderDescriptor(false, "affiliations", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.AffiliationsProvider"));
		providers.add(new ProviderDescriptor(false, "affiliation", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.AffiliationProvider"));
		providers.add(new ProviderDescriptor(false, "options", "http://jabber.org/protocol/pubsub", "org.jivesoftware.smackx.pubsub.provider.FormNodeProvider"));
		// XEP-0060 pubsub#owner 
		providers.add(new ProviderDescriptor(true, "pubsub", "http://jabber.org/protocol/pubsub#owner", "org.jivesoftware.smackx.pubsub.provider.PubSubProvider"));
		providers.add(new ProviderDescriptor(false, "configure", "http://jabber.org/protocol/pubsub#owner", "org.jivesoftware.smackx.pubsub.provider.FormNodeProvider"));
		providers.add(new ProviderDescriptor(false, "default", "http://jabber.org/protocol/pubsub#owner", "org.jivesoftware.smackx.pubsub.provider.FormNodeProvider"));
		// XEP-0060 pubsub#event 
		providers.add(new ProviderDescriptor(false, "event", "http://jabber.org/protocol/pubsub#event", "org.jivesoftware.smackx.pubsub.provider.EventProvider"));
		providers.add(new ProviderDescriptor(false, "configuration", "http://jabber.org/protocol/pubsub#event", "org.jivesoftware.smackx.pubsub.provider.ConfigEventProvider"));
		providers.add(new ProviderDescriptor(false, "delete", "http://jabber.org/protocol/pubsub#event", "org.jivesoftware.smackx.pubsub.provider.SimpleNodeProvider"));
		providers.add(new ProviderDescriptor(false, "options", "http://jabber.org/protocol/pubsub#event", "org.jivesoftware.smackx.pubsub.provider.FormNodeProvider"));
		providers.add(new ProviderDescriptor(false, "items", "http://jabber.org/protocol/pubsub#event", "org.jivesoftware.smackx.pubsub.provider.ItemsProvider"));
		providers.add(new ProviderDescriptor(false, "item", "http://jabber.org/protocol/pubsub#event", "org.jivesoftware.smackx.pubsub.provider.ItemProvider"));
		providers.add(new ProviderDescriptor(false, "retract", "http://jabber.org/protocol/pubsub#event", "org.jivesoftware.smackx.pubsub.provider.RetractEventProvider"));
		providers.add(new ProviderDescriptor(false, "purge", "http://jabber.org/protocol/pubsub#event", "org.jivesoftware.smackx.pubsub.provider.SimpleNodeProvider"));
		// Nick Exchange 
		providers.add(new ProviderDescriptor(false, "nick", "http://jabber.org/protocol/nick", "org.jivesoftware.smackx.nick.packet.Nick$Provider"));
		// Attention 
		providers.add(new ProviderDescriptor(false, "attention", "urn:xmpp:attention:0", "org.jivesoftware.smackx.attention.packet.AttentionExtension$Provider"));
		// XEP-0184 Message Delivery Receipts 
		providers.add(new ProviderDescriptor(false, "received", "urn:xmpp:receipts", "org.jivesoftware.smackx.receipts.DeliveryReceipt$Provider"));
		providers.add(new ProviderDescriptor(false, "request", "urn:xmpp:receipts", "org.jivesoftware.smackx.receipts.DeliveryReceiptRequest$Provider"));
		// XEP-0115 Entity Capabilities 
		providers.add(new ProviderDescriptor(false, "c", "http://jabber.org/protocol/caps", "org.jivesoftware.smackx.caps.provider.CapsExtensionProvider"));
		// XEP-0297 Stanza Forwarding 
		providers.add(new ProviderDescriptor(false, "forwarded", "urn:xmpp:forward:0", "org.jivesoftware.smackx.forward.provider.ForwardedProvider"));
		// Ping (XEP-199) Manager 
		providers.add(new ProviderDescriptor(true, "ping", "urn:xmpp:ping", "org.jivesoftware.smackx.ping.provider.PingProvider"));
		// Privacy 
		providers.add(new ProviderDescriptor(true, "query", "jabber:iq:privacy", "org.jivesoftware.smackx.privacy.provider.PrivacyProvider"));
		// XEP-0079 Advanced Message Processing 
		providers.add(new ProviderDescriptor(false, "amp", "http://jabber.org/protocol/amp", "org.jivesoftware.smackx.amp.provider.AMPExtensionProvider"));
		// JiveProperties 
		providers.add(new ProviderDescriptor(false, "properties", "http://www.jivesoftware.com/xmlns/xmpp/properties", "org.jivesoftware.smackx.jiveproperties.provider.JivePropertiesExtensionProvider"));
    
		return providers;
    }

    @Override
    protected String[] getConfigUrl() {
        return new String[]{
        	"org.jivesoftware.smackx.disco.ServiceDiscoveryManager",
	        "org.jivesoftware.smackx.xhtmlim.XHTMLManager",
	        "org.jivesoftware.smackx.muc.MultiUserChat",
	        "org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager",
	        "org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager",
	        "org.jivesoftware.smackx.filetransfer.FileTransferManager",
	        "org.jivesoftware.smackx.iqlast.LastActivityManager",
	        "org.jivesoftware.smackx.commands.AdHocCommandManager",
	        "org.jivesoftware.smackx.ping.PingManager",
	        "org.jivesoftware.smackx.privacy.PrivacyListManager",
	        "org.jivesoftware.smackx.time.EntityTimeManager",
	        "org.jivesoftware.smackx.vcardtemp.VCardManager"};
    }
}
