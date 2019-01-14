package eu.domibus.core.message.fragment;

import eu.domibus.common.model.configuration.LegConfiguration;

import javax.xml.soap.SOAPMessage;

/**
 * @author Cosmin Baciu
 * @since 4.1
 */
public interface SplitAndJoinService {

    boolean mayUseSplitAndJoin(LegConfiguration legConfiguration);

    boolean useSplitAndJoin(LegConfiguration legConfiguration, long payloadSize);

    String generateSourceFileName(String temporaryDirectoryLocation);

    SOAPMessage rejoinSourceMessage(String groupId);

}