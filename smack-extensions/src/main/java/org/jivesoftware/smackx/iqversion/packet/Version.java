/**
 *
 * Copyright 2003-2007 Jive Software.
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

package org.jivesoftware.smackx.iqversion.packet;


import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.XmlStringBuilder;

/**
 * A Version IQ packet, which is used by XMPP clients to discover version information
 * about the software running at another entity's JID.<p>
 *
 * An example to discover the version of the server:
 * <pre>
 * // Request the version from the server.
 * Version versionRequest = new Version();
 * timeRequest.setType(IQ.Type.get);
 * timeRequest.setTo("example.com");
 *
 * // Create a packet collector to listen for a response.
 * PacketCollector collector = con.createPacketCollector(
 *                new PacketIDFilter(versionRequest.getPacketID()));
 *
 * con.sendPacket(versionRequest);
 *
 * // Wait up to 5 seconds for a result.
 * IQ result = (IQ)collector.nextResult(5000);
 * if (result != null && result.getType() == IQ.Type.result) {
 *     Version versionResult = (Version)result;
 *     // Do something with result...
 * }</pre><p>
 *
 * @author Gaston Dombiak
 */
public class Version extends IQ {
    public static final String NAMESPACE = "jabber:iq:version";

    private final String name;
    private final String version;
    private String os;

    public Version() {
        name = null;
        version = null;
        setType(Type.get);
    }

    /**
     * Request version IQ
     * 
     * @param to the jid where to request version from
     */
    public Version(String to) {
        this();
        setTo(to);
    }

    public Version(String name, String version) {
        this(name, version, null);
    }

    /**
     * Creates a new Version object with given details.
     *
     * @param name The natural-language name of the software. This element is REQUIRED.
     * @param version The specific version of the software. This element is REQUIRED.
     * @param os The operating system of the queried entity. This element is OPTIONAL.
     */
    public Version(String name, String version, String os) {
        if (name == null)
        {
            throw new IllegalArgumentException("name must not be null");
        }
        if (version == null) {
            throw new IllegalArgumentException("version must not be null");
        }
        this.setType(IQ.Type.result);
        this.name = name;
        this.version = version;
        this.os = os;
    }

    public Version(Version original) {
        this(original.name, original.version, original.os);
    }

    /**
     * Returns the natural-language name of the software. This property will always be
     * present in a result.
     *
     * @return the natural-language name of the software.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the specific version of the software. This property will always be
     * present in a result.
     *
     * @return the specific version of the software.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Returns the operating system of the queried entity. This property will always be
     * present in a result.
     *
     * @return the operating system of the queried entity.
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the operating system of the queried entity. This message should only be
     * invoked when parsing the XML and setting the property to a Version instance.
     *
     * @param os operating system of the queried entity.
     */
    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public XmlStringBuilder getChildElementXML() {
        XmlStringBuilder xml = new XmlStringBuilder();
        xml.halfOpenElement(IQ.QUERY_ELEMENT).xmlnsAttribute(NAMESPACE).rightAngleBracket();
        // Although not really optional elements, 'name' and 'version' are not set when sending a
        // version request. So we must handle the case that those are 'null' here.
        xml.optElement("name", name);
        xml.optElement("version", version);
        xml.optElement("os", os);
        xml.closeElement(IQ.QUERY_ELEMENT);
        return xml;
    }

    public static Version createResultFor(Packet request, Version version) {
        Version result = new Version(version);
        result.setPacketID(request.getPacketID());
        result.setTo(request.getFrom());
        return result;
    }
}
