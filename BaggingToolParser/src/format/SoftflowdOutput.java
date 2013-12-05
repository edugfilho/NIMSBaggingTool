package format;

import bagging.feature.FeaturesConsts;

public class SoftflowdOutput extends FlowOutput {

	public SoftflowdOutput() {
		featuresPresent.put(FeaturesConsts.flowSrcIpAddr, 4);
		featuresPresent.put(FeaturesConsts.flowSrcPort, 5);
		featuresPresent.put(FeaturesConsts.flowDstIpAddr, 6);
		featuresPresent.put(FeaturesConsts.flowDstPort, 7);
		featuresPresent.put(FeaturesConsts.flowDuration, 2);
		featuresPresent.put(FeaturesConsts.flowProtocol, 3);
		featuresPresent.put(FeaturesConsts.flowNumPkt, 15);
		featuresPresent.put(FeaturesConsts.flowSz, 18);
		featuresPresent.put(FeaturesConsts.flowTotalFwdPkt, 17);
		featuresPresent.put(FeaturesConsts.flowTotalFwdSz, 20);
		featuresPresent.put(FeaturesConsts.flowTotalBwdPkt, 16);
		featuresPresent.put(FeaturesConsts.flowTotalBwdSz, 19);
		featuresPresent.put(FeaturesConsts.flowPktPerSec, 37);
		featuresPresent.put(FeaturesConsts.flowBytesPerSec, 36);
		featuresPresent.put(FeaturesConsts.flowBytesPerPkt, 38);
		setUsedFeaturesWithCurrentPresentFeatures();

		featuresPresent.put(FeaturesConsts.flowStartTime, 0);
		featuresPresent.put(FeaturesConsts.flowEndTime, 1);
		featuresPresent.put(FeaturesConsts.flowNextHopIp, 8);
		featuresPresent.put(FeaturesConsts.flowBGPNextHopIp, 9);
		featuresPresent.put(FeaturesConsts.flowRouterIp, 10);
		featuresPresent.put(FeaturesConsts.flowSrcAs, 11);
		featuresPresent.put(FeaturesConsts.flowDstAs, 12);
		featuresPresent.put(FeaturesConsts.flowInput, 13);
		featuresPresent.put(FeaturesConsts.flowOutput, 14);
		featuresPresent.put(FeaturesConsts.flowFlows, 21);
		featuresPresent.put(FeaturesConsts.flowTos, 22);
		featuresPresent.put(FeaturesConsts.flowSTos, 23);
		featuresPresent.put(FeaturesConsts.flowDTos, 24);
		featuresPresent.put(FeaturesConsts.flowDir, 25);
		featuresPresent.put(FeaturesConsts.flowSmask, 26);
		featuresPresent.put(FeaturesConsts.flowDmask, 27);
		featuresPresent.put(FeaturesConsts.flowFwd, 28);
		featuresPresent.put(FeaturesConsts.flowSVLan, 29);
		featuresPresent.put(FeaturesConsts.flowDVLan, 30);
		// This below = InSrcMacAddr in file
		featuresPresent.put(FeaturesConsts.flowDstMacAddr, 31);
		// This below = OutDestMacAddr in file
		featuresPresent.put(FeaturesConsts.flowDstMacAddr, 32);
		// This below = InDestMacAddr in file
		featuresPresent.put(FeaturesConsts.flowSrcMacAddr, 33);
		// This below = OutSrcMacAddr in file
		featuresPresent.put(FeaturesConsts.flowSrcMacAddr, 34);
		featuresPresent.put(FeaturesConsts.flowEngine, 35);

	}

	/**
	 * Place some feature values in the correct places inside the flow so they
	 * can be read accordingly later on.
	 */
	@Override
	public Flow beforeProcessingRawFlow(Flow f) {
		/*
		 * As start and end time are separated as follows:
		 * 
		 * [Start date][Start time][End date][End time]
		 * 
		 * And we want to make it:
		 * 
		 * [Start date+Start time][End date + End time]:
		 */

		// Filter out everything that doesn't start with a date
		if (!f.get(0).matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
			return null;
		}
		f.set(0, f.get(0) + f.get(1));
		f.set(1, f.get(2) + f.get(3));

		/* Flow duration and protocol need to be left shifted by 2 spaces */
		f.set(2, f.get(4));
		f.set(3, f.get(5));

		// Ip addr and ports are together. Not good.
		String ipAddrPort = f.get(6);
		String delim = "[:]";
		String[] separatedIpAddrPort = ipAddrPort.split(delim);

		String srcIp = separatedIpAddrPort[0];
		String srcPort = separatedIpAddrPort[1];

		ipAddrPort = f.get(7);
		separatedIpAddrPort = ipAddrPort.split(delim);

		String destIp = separatedIpAddrPort[0];
		String destPort = separatedIpAddrPort[1];

		f.set(4, srcIp);
		f.set(5, srcPort);
		f.set(6, destIp);
		f.set(7, destPort);

		return f;
	}

	@Override
	public String preProcessField(String fieldName, Flow f) {
		Integer flowIndex = featuresPresent.get(fieldName);
		// Remove white spaces from each field
		String featureContent = f.get(flowIndex).replaceAll("\\s+", "");

		if (fieldName.equals(FeaturesConsts.flowSrcIpAddr)
				|| fieldName.equals(FeaturesConsts.flowDstIpAddr)) {
			// Remove IPV6 and invalid ip address flows
			if (featureContent.contains(":")
					|| featureContent.contains("0.0.0.0")) {
				return null;
			}

		}
		// Getting rid of the "a.b M" (e.g. 1.4M)
		if (fieldName.equals(FeaturesConsts.flowBytesPerSec)) {
			if (featureContent.contains("M")) {
				String delim = "[.]";
				String[] numbers = featureContent.split(delim);
				featureContent = numbers[0]
						+ numbers[1].substring(0, numbers[1].indexOf("M"))
						+ "00";
			}
		}
		return featureContent;
	}

	@Override
	public String getSeparator() {

		return " ";
	}

	@Override
	public Integer ignoreLines() {
		return 1;
	}

}
