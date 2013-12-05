package format;

import bagging.feature.FeaturesConsts;

public class YafOutput extends FlowOutput {

	public YafOutput() {
		featuresPresent.put(FeaturesConsts.flowDuration, 2);

		featuresPresent.put(FeaturesConsts.flowRtt, 3);

		featuresPresent.put(FeaturesConsts.flowProtocol, 4);
		featuresPresent.put(FeaturesConsts.flowSrcIpAddr, 5);
		featuresPresent.put(FeaturesConsts.flowSrcPort, 6);
		featuresPresent.put(FeaturesConsts.flowDstIpAddr, 7);
		featuresPresent.put(FeaturesConsts.flowDstPort, 8);
		featuresPresent.put(FeaturesConsts.flowTotalFwdPkt, 19);
		featuresPresent.put(FeaturesConsts.flowTotalBwdPkt, 21);
		featuresPresent.put(FeaturesConsts.flowTotalFwdSz, 20);
		featuresPresent.put(FeaturesConsts.flowTotalBwdSz, 22);
		// featuresPresent.put(FeaturesConsts.flowReverseFlowDeltaMiliseconds,
		// 0);
		setUsedFeaturesWithCurrentPresentFeatures();

		// Not used features

		featuresPresent.put(FeaturesConsts.flowStartTime, 0);
		featuresPresent.put(FeaturesConsts.flowEndTime, 1);
		featuresPresent.put(FeaturesConsts.flowRtt, 3);
		featuresPresent.put(FeaturesConsts.flowSrcMacAddr, 9);
		featuresPresent.put(FeaturesConsts.flowDstMacAddr, 10);
		featuresPresent.put(FeaturesConsts.flowFwdIflags, 11);
		featuresPresent.put(FeaturesConsts.flowFwdUflags, 12);
		featuresPresent.put(FeaturesConsts.flowBwdIflags, 13);
		featuresPresent.put(FeaturesConsts.flowBwdUflags, 14);
		featuresPresent.put(FeaturesConsts.flowFwdIsn, 15);
		featuresPresent.put(FeaturesConsts.flowBwdIsn, 16);
		featuresPresent.put(FeaturesConsts.flowBwdTag, 17);
		featuresPresent.put(FeaturesConsts.flowTotalBwdSz, 18);
		featuresPresent.put(FeaturesConsts.flowAppLabel, 23);
		featuresPresent.put(FeaturesConsts.flowEndReason, 24);

	}

	@Override
	public String preProcessField(String fieldName, Flow f) {

		Integer flowIndex = featuresPresent.get(fieldName);
		String featureContent = f.get(flowIndex).replaceAll("\\s+","");

		if (fieldName.equals(FeaturesConsts.flowSrcIpAddr) || fieldName.equals(FeaturesConsts.flowDstIpAddr)) {
			// Remove IPV6 and invalid ip address flows
			if (featureContent.contains(":") || featureContent.contains("0.0.0.0")) {
				return null;
			}
		}else if (fieldName.equals(FeaturesConsts.flowEndTime)){
			if(featureContent.isEmpty()){
				return "0";
			}
			//If endtime = 0, duration = 0
		}else if (fieldName.equals(FeaturesConsts.flowDuration)){
			if(preProcessField(FeaturesConsts.flowEndTime, f).contentEquals("0")){
				return "0";
			}
		}
		
		/*
		 * YAF: idle (or active when no duration ) means no backwards data 
		 * 
		 * YAF:
		 * (icmp) [x:y] = port numbers 
		 */
		return featureContent;
	}

	@Override
	public String getSeparator() {
		return "|";

	}

}
