package format;

import bagging.feature.FeaturesConsts;

public class YafOutput extends FlowOutput {

	public YafOutput() {
		featuresPresent.put(FeaturesConsts.flowDuration, 2);
		featuresPresent.put(FeaturesConsts.flowProtocol, 4);
		featuresPresent.put(FeaturesConsts.flowSrcIpAddr, 5);
		featuresPresent.put(FeaturesConsts.flowSrcPort, 6);
		featuresPresent.put(FeaturesConsts.flowDstIpAddr, 7);
		featuresPresent.put(FeaturesConsts.flowDstPort, 8);
		featuresPresent.put(FeaturesConsts.flowTotalFwdPkt, 20);
		featuresPresent.put(FeaturesConsts.flowTotalBwdPkt, 22);
		featuresPresent.put(FeaturesConsts.flowTotalFwdSz, 21);
		featuresPresent.put(FeaturesConsts.flowTotalBwdSz, 23);
		//featuresPresent.put(FeaturesConsts.flowReverseFlowDeltaMiliseconds, 0);

	}

	@Override
	public String preProcessField(String fieldName) {
		/*YAF: idle (or active when no duration ) means no
		 * backwards data YAF: (icmp) [x:y] = port numbers YAF: flows that doesn't have
		 * endtime: endtime = 0, duration = 0 Remove ipv6
		 * */
		return null;
	}

	@Override
	public String getSeparator() {
		return "|";
		
	}

}
