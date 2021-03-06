package format;

import bagging.feature.FeaturesConsts;

public class NetmateOutput extends FlowOutput {

	public NetmateOutput() {
		super();
		featuresPresent.put(FeaturesConsts.flowSrcIpAddr, 0);
		featuresPresent.put(FeaturesConsts.flowSrcPort, 1);
		featuresPresent.put(FeaturesConsts.flowDstIpAddr, 2);
		featuresPresent.put(FeaturesConsts.flowDstPort, 3);
		featuresPresent.put(FeaturesConsts.flowProtocol, 4);
		featuresPresent.put(FeaturesConsts.flowTotalFwdPkt, 5);
		featuresPresent.put(FeaturesConsts.flowTotalBwdPkt, 6);
		featuresPresent.put(FeaturesConsts.flowTotalFwdSz, 7);
		featuresPresent.put(FeaturesConsts.flowTotalBwdSz, 8);
		featuresPresent.put(FeaturesConsts.flowMinFwdPktSz, 9);
		featuresPresent.put(FeaturesConsts.flowMeanFwdPktSz, 10);
		featuresPresent.put(FeaturesConsts.flowMaxFwdPktSz, 11);
		featuresPresent.put(FeaturesConsts.flowStdFwdPktSz, 12);
		featuresPresent.put(FeaturesConsts.flowMinBwdPktSz, 13);
		featuresPresent.put(FeaturesConsts.flowMeanBwdPktSz, 14);
		featuresPresent.put(FeaturesConsts.flowMaxBwdPktSz, 15);
		featuresPresent.put(FeaturesConsts.flowStdBwdPktSz, 16);
		featuresPresent.put(FeaturesConsts.flowMinFIAT, 17);
		featuresPresent.put(FeaturesConsts.flowMeanFIAT, 18);
		featuresPresent.put(FeaturesConsts.flowMaxFIAT, 19);
		featuresPresent.put(FeaturesConsts.flowStdFIAT, 20);
		featuresPresent.put(FeaturesConsts.flowMinBIAT, 21);
		featuresPresent.put(FeaturesConsts.flowMeanBIAT, 22);
		featuresPresent.put(FeaturesConsts.flowMaxBIAT, 23);
		featuresPresent.put(FeaturesConsts.flowStdBIAT, 24);
		featuresPresent.put(FeaturesConsts.flowDuration, 25);
		featuresPresent.put(FeaturesConsts.flowMinActive, 26);
		featuresPresent.put(FeaturesConsts.flowMeanActive, 27);
		featuresPresent.put(FeaturesConsts.flowMaxActive, 28);
		featuresPresent.put(FeaturesConsts.flowStdActive, 29);
		featuresPresent.put(FeaturesConsts.flowMinIdle, 30);
		featuresPresent.put(FeaturesConsts.flowMaxIdle, 32);
		featuresPresent.put(FeaturesConsts.flowStdIdle, 33);
		featuresPresent.put(FeaturesConsts.flowSubflowNumFwdPkt, 34);
		featuresPresent.put(FeaturesConsts.flowSubFlowFwdSz, 35);
		featuresPresent.put(FeaturesConsts.flowSubflowNumBwdPkt, 36);
		featuresPresent.put(FeaturesConsts.flowSubFlowBwdSz, 37);
		featuresPresent.put(FeaturesConsts.flowHeaderFwdTotalSz, 42);
		featuresPresent.put(FeaturesConsts.flowHeaderBwdTotalSz, 43);
		setUsedFeaturesWithCurrentPresentFeatures();

		// UNUSED FEATURES
		featuresPresent.put(FeaturesConsts.flowPshFwdCount, 38);
		featuresPresent.put(FeaturesConsts.flowPshBwdCount, 39);
		featuresPresent.put(FeaturesConsts.flowUrgFwdCount, 40);
		featuresPresent.put(FeaturesConsts.flowUrgBwdCount, 41);

	}

	@Override
	public String preProcessField(String fieldName, Flow f) {
		Integer flowIndex = featuresPresent.get(fieldName);
		String featureContent = f.get(flowIndex).replaceAll("\\s+","");

		if (fieldName.equals(FeaturesConsts.flowSrcIpAddr)
				|| fieldName.equals(FeaturesConsts.flowDstIpAddr)) {
			// Remove IPV6 and invalid ip address flows 
			if (featureContent.contains(":") || featureContent.contains("0.0.0.0")) {
				return null;
			}

		}
		return featureContent;
	}

	@Override
	public String getSeparator() {
		return ",";
	}


}
