package format;

import bagging.feature.FeaturesConsts;

public class YafOutput extends FlowOutput {

	public YafOutput() {
		featuresPresent.put(FeaturesConsts.flowDuration, 0);
		featuresPresent.put(FeaturesConsts.flowTotalFwdPkt, 0);
		featuresPresent.put(FeaturesConsts.flowTotalBwdPkt, 0);
		featuresPresent.put(FeaturesConsts.flowTotalFwdSz, 0);
		featuresPresent.put(FeaturesConsts.flowTotalBwdSz, 0);
		featuresPresent.put(FeaturesConsts.flowReverseFlowDeltaMiliseconds, 0);

	}

	@Override
	public String preProcessField(String fieldName) {
		// TODO Auto-generated method stub
		return null;
	}

}
